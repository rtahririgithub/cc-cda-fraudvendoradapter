package com.telus.subsfraudmgmt.springboot.service.command;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;
import com.telus.subsfraudmgmt.springboot.model.NoLinkedFraudFileException;
import com.telus.subsfraudmgmt.springboot.model.request.TDeleteFraudFileRequest;
import com.telus.subsfraudmgmt.springboot.model.response.TFraudFileResponse;
import com.telus.subsfraudmgmt.springboot.service.RestServiceClientBase;
import com.telus.subsfraudmgmt.springboot.util.ObjectMapperConfigurer;
import com.telus.subsfraudmgmt.springboot.util.ObjectMapperConfigurer.ObjectMapperType;

/**
 * Handle delete fraud file by application id.
 * <p>It will search all fraud file ids and then delete each fraud file in loop. Error messages will be gathered and logged without stopping.
 * @author Harry Xu
 *
 */
@Component
public class DeleteFraudFileCommand extends RestServiceClientBase implements Command {

	private static final Log LOG = CustomizedLogFactory.getLog(DeleteFraudFileCommand.class);
		
	@Autowired
	private SearchFraudsterIdByAppIdCommand searchFraudsterIdByAppIdCommand;
	@Autowired
	private DeleteFraudFileByIdCommand deleteFraudFileByIdCommand;
	
	@Override
	protected ObjectMapper resolvebjectMapper() {
		//serialize date as -08:00
		return ObjectMapperConfigurer.getConfiguredObjectMapper(ObjectMapperType.HONOR_XXX_DATE_TIME);
	}
	/**
	 * Execute  <code>TDeleteFraudFileRequest</code> request.
	 * 
	 * <pre>
	 * AFM Return Status Codes include: 
	 *   200 OK
	 *   400 Bad Request
	 *   403 Forbidden
	 * </pre>
	 */
	@Override
	public TFraudFileResponse execute(Object tDeleteFraudFileRequest) throws Exception {

		TDeleteFraudFileRequest oRequest = (TDeleteFraudFileRequest) tDeleteFraudFileRequest;

		String applicationId = oRequest.getBody().getExternalApplicationId();
		LOG.info("AFM searchFraudsterIdByAppIdCommand execute: ");
		List<String> fraudFileIdList = searchFraudsterIdByAppIdCommand.execute(applicationId);
		if (fraudFileIdList==null || fraudFileIdList.isEmpty()) {
			throw new NoLinkedFraudFileException("No fraud files linked for applicationId: '" + applicationId + "'" );
		}
		//error list
		List<Exception> listExceptions = new ArrayList<>();
		//last success response for delete fraud files
		TFraudFileResponse deleteFraudFileResponse = null;

		for (String fraudFileId: fraudFileIdList) {
			try {
				deleteFraudFileResponse = deleteFraudFileByIdCommand.execute(fraudFileId);
				LOG.info("successfullyed deleted fraud file with id: '" + fraudFileId +"' linked to  application '" + applicationId + "'");
			}catch (Exception e) {
				LOG.warn("failed to delete fraud file with id: '" + fraudFileId +"' linked to  application '" + applicationId + "'", e);
				listExceptions.add(e);
			}
		}
		if (!listExceptions.isEmpty() || deleteFraudFileResponse ==null) {
			throw listExceptions.get(0);
		}
		return deleteFraudFileResponse;
		

	}

}