package com.telus.subsfraudmgmt.springboot.service; 

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.telus.subsfraudmgmt.api.model.watson.PredictionPerform;
import com.telus.subsfraudmgmt.springboot.RequestId;
import com.telus.subsfraudmgmt.springboot.config.AppCtx;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;
import com.telus.subsfraudmgmt.springboot.model.request.TApplicationRequest;
import com.telus.subsfraudmgmt.springboot.model.request.TCreateFraudFileRequest;
import com.telus.subsfraudmgmt.springboot.model.request.TDeleteFraudFileRequest;
import com.telus.subsfraudmgmt.springboot.model.request.TUpdateAppDispositionRequest;
import com.telus.subsfraudmgmt.springboot.model.request.TUpdateCaseDispositionRequest;
import com.telus.subsfraudmgmt.springboot.model.request.TUpdateFraudFileRequest;
import com.telus.subsfraudmgmt.springboot.model.response.TApplicationResponse;
import com.telus.subsfraudmgmt.springboot.model.response.TFraudFileResponse;
import com.telus.subsfraudmgmt.springboot.model.response.TPredictionResponse;
import com.telus.subsfraudmgmt.springboot.model.response.TUpdateAppDispositionResponse;
import com.telus.subsfraudmgmt.springboot.model.response.TUpdateCaseDispositionResponse;
import com.telus.subsfraudmgmt.springboot.model.transaction.BaseTransaction;
import com.telus.subsfraudmgmt.springboot.model.transaction.FraudCheckTransaction;
import com.telus.subsfraudmgmt.springboot.model.transaction.TransactionType;
import com.telus.subsfraudmgmt.springboot.model.transaction.UpdateAppDispositionTransaction;
//import com.telus.subsfraudmgmt.springboot.mybatis.FraudTransactionMapper;
//import com.telus.subsfraudmgmt.springboot.mybatis.FraudTransactionMapper.FraudTranEntity;
//import com.telus.subsfraudmgmt.springboot.mybatis.FraudTransactionMapper.LastFraudTranEntity;
import com.telus.subsfraudmgmt.springboot.service.command.CommandFactory;
import com.telus.subsfraudmgmt.springboot.service.command.CreateFraudFileCommand;
import com.telus.subsfraudmgmt.springboot.service.command.DeleteFraudFileCommand;
import com.telus.subsfraudmgmt.springboot.service.command.FraudCheckCommand;
import com.telus.subsfraudmgmt.springboot.service.command.FraudPredictionCommand;
import com.telus.subsfraudmgmt.springboot.service.command.TelusPubCommand;
import com.telus.subsfraudmgmt.springboot.service.command.UpdateAppDispositionCommand;
import com.telus.subsfraudmgmt.springboot.service.command.UpdateCaseDispositionCommand;
import com.telus.subsfraudmgmt.springboot.service.command.UpdateFraudFileCommand;
import com.telus.subsfraudmgmt.springboot.util.GeneralUtil;
/**
 * Implementation of <code>ExternalServicesFacade</code> 
 * @author Harry Xu 
 *
 */
@Service
public class ExternalServicesFacadeImpl implements ExternalServicesFacade {

	private static final Log LOG = CustomizedLogFactory.getLog(ExternalServicesFacadeImpl.class);
	
	@Autowired
	AppCtx appCtx;
	
	@Autowired
	private CommandFactory commandFactory;
	
	//@Autowired
	//private FraudTransactionMapper fraudCheckTransactionMapper;

	public CommandFactory getCommandFactory() {
		return commandFactory;
	}

	public void setCommandFactory(CommandFactory commandFactory) {
		this.commandFactory = commandFactory;
	}
	
	@Override
	public TPredictionResponse performFraudPrediction(PredictionPerform predictionPerform) throws Exception{
		FraudPredictionCommand command = commandFactory.getCommand(FraudPredictionCommand.class);
		LOG.info("FraudPredictionCommand executing...");
		return (TPredictionResponse) command.execute(predictionPerform);
	}

	@Override
	public TUpdateAppDispositionResponse updateAppDisposition(
			TUpdateAppDispositionRequest tUpdateAppDispositionRequest) throws Exception{

		UpdateAppDispositionCommand command = commandFactory.getCommand(UpdateAppDispositionCommand.class);
		return command.execute(tUpdateAppDispositionRequest);

	}
	
	@Override
	public TApplicationResponse performFraudCheck(TApplicationRequest tApplicationRequest) throws Exception{
		FraudCheckCommand command = commandFactory.getCommand(FraudCheckCommand.class);
		return command.execute(tApplicationRequest);
	}

	@Override
	public TFraudFileResponse createFraudFile(TCreateFraudFileRequest tCreateFraudFileRequest) throws Exception{
		CreateFraudFileCommand command = commandFactory.getCommand(CreateFraudFileCommand.class);
		return command.execute(tCreateFraudFileRequest);
	}

	@Override
	public TFraudFileResponse updateFraudFile(TUpdateFraudFileRequest tUpdateFraudFileRequest) throws Exception{
		UpdateFraudFileCommand command = commandFactory.getCommand(UpdateFraudFileCommand.class);
		return command.execute(tUpdateFraudFileRequest);
	}

	@Override
	public TFraudFileResponse deleteFraudFile(TDeleteFraudFileRequest tDeleteFraudFileRequest) throws Exception{
		DeleteFraudFileCommand command = commandFactory.getCommand(DeleteFraudFileCommand.class);
		return command.execute(tDeleteFraudFileRequest);
	}
	
	@Override
	public TUpdateCaseDispositionResponse updateCaseDisposition(TUpdateCaseDispositionRequest tUpdateCaseDispositionRequest) throws Exception{
		UpdateCaseDispositionCommand command = commandFactory.getCommand(UpdateCaseDispositionCommand.class);
		return command.execute(tUpdateCaseDispositionRequest);
		
	}
	
	/**
	 * Asynchronous execution using configured teluspubTaskExecutor - pooled executor.
	 */
	@Override
	@Async("teluspubTaskExecutor")
	public void publishTransaction(BaseTransaction aTransaction) throws Exception{
		//set ThreadLocal variable value in the new thread from thread pool
	    RequestId.set(aTransaction.getRequestId());
		TelusPubCommand command = commandFactory.getCommand(TelusPubCommand.class);
		command.execute(aTransaction);

	}
	/*
	@Override
	@Transactional
	public void insertFraudCheckTransaction(FraudCheckTransaction fraudCheckTransaction){
		LOG.info("insertFraudCheckTransaction ..."); 
		FraudTranEntity fraudTranEntity = buildFraudTranEntity(fraudCheckTransaction);
		fraudTranEntity.setAccountId(fraudCheckTransaction.getAccountId());
		
		this.fraudCheckTransactionMapper.insertFraudTran(fraudTranEntity);
	
		fraudTranEntity = this.fraudCheckTransactionMapper.getFraudTranById(fraudTranEntity.getId());
		LOG.info("check json (FraudCheckTransaction) in fraud_trn for fraud_trn_id " + fraudTranEntity.getId() + ": '" + new String(fraudTranEntity.getFraudTransactionDoc(), Charset.forName("UTF-8"))+"'");
		LastFraudTranEntity lastFraudTranEntity = buildLastFraudTran(fraudTranEntity);
		this.fraudCheckTransactionMapper.insertLastFraudTran(lastFraudTranEntity);
		 
	}
	*/
	/*	
	@Override
	@Transactional
	public void insertUpdateAppDispositionTransaction(UpdateAppDispositionTransaction updateAppDispositionTransaction){
		LOG.info("insertUpdateAppDispositionTransaction ..."); 
		FraudTranEntity fraudTranEntity = buildFraudTranEntity(updateAppDispositionTransaction);
		fraudTranEntity.setAccountId(updateAppDispositionTransaction.getAccountId());
		
		this.fraudCheckTransactionMapper.insertFraudTran(fraudTranEntity);

		fraudTranEntity = this.fraudCheckTransactionMapper.getFraudTranById(fraudTranEntity.getId());

		byte[] jsonBytes = fraudTranEntity.getFraudTransactionDoc();
		LOG.info("check json (UpdateAppDispositionTransaction) in fraud_trn for fraud_trn_id " + fraudTranEntity.getId() + ": '" + new String(jsonBytes, Charset.forName("UTF-8"))+"'");

		LastFraudTranEntity lastFraudTranEntity = buildLastFraudTran(fraudTranEntity);
		this.fraudCheckTransactionMapper.insertLastFraudTran(lastFraudTranEntity);
	}
	*/

	/*
	private LastFraudTranEntity buildLastFraudTran(FraudTranEntity fraudTranEntity) {
		LastFraudTranEntity lastFraudTranEntity = new LastFraudTranEntity();
		lastFraudTranEntity.setFraundTranId(fraudTranEntity.getId());
		lastFraudTranEntity.setAccountId(fraudTranEntity.getAccountId());
		lastFraudTranEntity.setFraudTransactionType(fraudTranEntity.getFraudTransactionType());
		lastFraudTranEntity.setFraudTranTs(fraudTranEntity.getCreateTs());
		lastFraudTranEntity.setCreateUser(appCtx.getAppId());
		lastFraudTranEntity.setDataSourceId(GeneralUtil.safeStringToLong(appCtx.getCmdbAppID()));
		return lastFraudTranEntity;
	}
*/
	/*
	private FraudTranEntity buildFraudTranEntity(BaseTransaction fraudCheckTransaction) {
		FraudTranEntity fraudTranEntity = new FraudTranEntity();
		
		fraudTranEntity.setFraudTransactionType(fraudCheckTransaction.getType().toString());
		fraudTranEntity.setCreditAssementRequestId(GeneralUtil.safeStringToLong(fraudCheckTransaction.getRequestId()));
		fraudTranEntity.setCreateUser(appCtx.getAppId());
		fraudTranEntity.setDataSourceId(GeneralUtil.safeStringToLong(appCtx.getCmdbAppID()));
		try { 
			//to handle french accented characters using utf-8
			byte[] jsonUtf8Bytes =  fraudCheckTransaction.getObjectMapper().writeValueAsBytes(fraudCheckTransaction);
			fraudTranEntity.setFraudTransactionDoc(jsonUtf8Bytes);
		}catch (Exception e) {
			LOG.warn("write json utf8 bytes exception:", e);
			throw new RuntimeException(e);
		}
		return fraudTranEntity;
	}
	*/
	
	
}
