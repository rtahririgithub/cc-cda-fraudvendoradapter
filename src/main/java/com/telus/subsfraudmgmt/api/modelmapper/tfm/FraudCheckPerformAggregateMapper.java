package com.telus.subsfraudmgmt.api.modelmapper.tfm;

import org.apache.commons.logging.Log;
import org.mapstruct.Mapper;
import org.mapstruct.MapperConfig;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;
import com.fico.afm.model.application.ApplicationRequest;
import com.fico.afm.model.application.BureauReports;
import com.telus.subsfraudmgmt.api.model.Attachment;
import com.telus.subsfraudmgmt.api.model.Customer;
import com.telus.subsfraudmgmt.api.model.FraudCheckPerform;
import com.telus.subsfraudmgmt.api.model.TelusCreditProfile;
import com.telus.subsfraudmgmt.api.model.watson.Error;
import com.telus.subsfraudmgmt.api.model.watson.Prediction;
import com.telus.subsfraudmgmt.api.model.watsonsimulator.WatsonResponseModel;
import com.telus.subsfraudmgmt.api.modelmapper.tfm.bureau.TfmBureauReports;
import com.telus.subsfraudmgmt.api.modelmapper.tfm.bureau.TfmBureauReportsToAfmEfuMapper;
import com.telus.subsfraudmgmt.api.modelmapper.tfm.bureau.TfmBureauReportsToAfmTuMapper;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;
import com.telus.subsfraudmgmt.springboot.util.JsonUtil;
/**
 * Aggregate mapper to include main info and bureau reports as well.
 * <p>It uses TfmBureauReportsToAfmEfuMapper, TfmBureauReportsToAfmTuMapper, FraudCheckPerformWorkerMapper and should be used at controller level.
 *
 * @author Harry Xu
 *
 */
@Mapper(componentModel="spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
@MapperConfig(unmappedTargetPolicy=ReportingPolicy.WARN)

public interface FraudCheckPerformAggregateMapper {
	
	public static final Log LOG = CustomizedLogFactory.getLog(FraudCheckPerformAggregateMapper.class);
	
	FraudCheckPerformAggregateMapper INSTANCE = Mappers.getMapper( FraudCheckPerformAggregateMapper.class );
	
	
    default ApplicationRequest fromFraudCheckPerformToApplicationRequest(FraudCheckPerform fraudCheckPerform, com.telus.subsfraudmgmt.api.model.watson.Prediction watsonSimulatorResponse, com.telus.subsfraudmgmt.api.model.watson.Error watsonErrorResponse) throws Exception{
    	
    	
    	TelusCreditProfile creditProfile = null;
    	Attachment attachment = null;
    	
    	Customer customer = fraudCheckPerform.getCustomer().getValue();

    	if (customer.getCreditProfile()!=null && !customer.getCreditProfile().isEmpty() && 
    			customer.getCreditProfile().get(0)!=null && customer.getCreditProfile().get(0).getValue()!=null) {

    		creditProfile = (TelusCreditProfile)customer.getCreditProfile().get(0).getValue();
    		 
    	}
    	if (creditProfile !=null && creditProfile.getBureauReportAttachment()!=null && 
    			creditProfile.getBureauReportAttachment().getValue()!=null) {
    		attachment = creditProfile.getBureauReportAttachment().getValue();
    	}
    	
    	TfmBureauReports tfmBureauReports = null;
		BureauReports afmBureauReports =null;
		
    	//source of attachment content( for instance credit bureua report source( TRANSUNION or EQUIFAX) )
    	if (attachment != null && attachment.getContentSourceCode()!=null) {
    		if (!attachment.getContentSourceCode().equalsIgnoreCase("EQUIFAX") && 
    				!attachment.getContentSourceCode().equalsIgnoreCase("TRANSUNION")) {
    			//LOG.info("CreditProfile's attachment content source code is not one of EQUIFAX, TRANSUNION: '" + attachment.getContentSourceCode() +"', treat as no BureauReport..");
    			afmBureauReports = new BureauReports(); //to make it empty
    		}
    		else {
    			if (attachment.getContentSourceCode().equalsIgnoreCase("EQUIFAX")) {
    				//BureauReports bureauReports = applicationRequest.getApplication().getApplicant().get(0).getBureauReports();
    				tfmBureauReports = TfmBureauReports.parseTfmBureauReport(attachment.getContent(), true);
    				afmBureauReports = TfmBureauReportsToAfmEfuMapper.INSTANCE.mapReports(tfmBureauReports, fraudCheckPerform);

    			}
    			else if (attachment.getContentSourceCode().equalsIgnoreCase("TRANSUNION")) {

    				//BureauReports bureauReports = applicationRequest.getApplication().getApplicant().get(0).getBureauReports();
    				tfmBureauReports = TfmBureauReports.parseTfmBureauReport(attachment.getContent(), false);

    				afmBureauReports = TfmBureauReportsToAfmTuMapper.INSTANCE.mapReports(tfmBureauReports, fraudCheckPerform); 

    			}
    		}
    		
    	}	
    	
    	ApplicationRequest applicationRequest = FraudCheckPerformWorkerMapper.INSTANCE.
    			jointMapToApplicationRequest(fraudCheckPerform, tfmBureauReports, watsonSimulatorResponse, watsonErrorResponse);
    	
    	applicationRequest.getApplication().getApplicant().get(0).setBureauReports(afmBureauReports);

    	
    	return applicationRequest;
    	 
    }
	
    default ApplicationRequest fromFraudCheckPerformToApplicationRequest(FraudCheckPerform fraudCheckPerform) throws Exception{
    	
    	
    	TelusCreditProfile creditProfile = null;
    	Attachment attachment = null;
    	
    	Customer customer = fraudCheckPerform.getCustomer().getValue();

    	if (customer.getCreditProfile()!=null && !customer.getCreditProfile().isEmpty() && 
    			customer.getCreditProfile().get(0)!=null && customer.getCreditProfile().get(0).getValue()!=null) {

    		creditProfile = (TelusCreditProfile)customer.getCreditProfile().get(0).getValue();
    		 
    	}
    	if (creditProfile !=null && creditProfile.getBureauReportAttachment()!=null && 
    			creditProfile.getBureauReportAttachment().getValue()!=null) {
    		attachment = creditProfile.getBureauReportAttachment().getValue();
    	}
    	
    	TfmBureauReports tfmBureauReports = null;
		BureauReports afmBureauReports =null;
		
    	//source of attachment content( for instance credit bureua report source( TRANSUNION or EQUIFAX) )
    	if (attachment != null && attachment.getContentSourceCode()!=null) {
    		if (!attachment.getContentSourceCode().equalsIgnoreCase("EQUIFAX") && 
    				!attachment.getContentSourceCode().equalsIgnoreCase("TRANSUNION")) {
    			LOG.info("CreditProfile's attachment content source code is not one of EQUIFAX, TRANSUNION: '" + attachment.getContentSourceCode() +"', treat as no BureauReport..");
    			afmBureauReports = new BureauReports(); //to make it empty
    		}
    		else {
    			if (attachment.getContentSourceCode().equalsIgnoreCase("EQUIFAX")) {
    				//BureauReports bureauReports = applicationRequest.getApplication().getApplicant().get(0).getBureauReports();
    				tfmBureauReports = TfmBureauReports.parseTfmBureauReport(attachment.getContent(), true);
    				afmBureauReports = TfmBureauReportsToAfmEfuMapper.INSTANCE.mapReports(tfmBureauReports, fraudCheckPerform);

    			}
    			else if (attachment.getContentSourceCode().equalsIgnoreCase("TRANSUNION")) {

    				//BureauReports bureauReports = applicationRequest.getApplication().getApplicant().get(0).getBureauReports();
    				tfmBureauReports = TfmBureauReports.parseTfmBureauReport(attachment.getContent(), false);

    				afmBureauReports = TfmBureauReportsToAfmTuMapper.INSTANCE.mapReports(tfmBureauReports, fraudCheckPerform); 

    			}
    		}
    		
    	}	
    	
    	ApplicationRequest applicationRequest = FraudCheckPerformWorkerMapper.INSTANCE.
    			jointMapToApplicationRequest(fraudCheckPerform, tfmBureauReports);
    	
    	applicationRequest.getApplication().getApplicant().get(0).setBureauReports(afmBureauReports);

    	
    	return applicationRequest;
    	 
    }

}