package com.telus.subsfraudmgmt.springboot.controller;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.telus.subsfraudmgmt.springboot.RequestId;
import com.telus.subsfraudmgmt.springboot.util.ObjectMapperDecorator;
/**
 * This is called by TelusPubsub with sensitive data being encrypted.
 * <p>Since its only task is to save to db with sensitive data being encrypted, we are saving as it is , and not going to decrypt it.
 * 
 * @author Harry Xu
 *
 */

@RestController
public class FraudCheckTransactionListenerController extends BaseFraudTransactionsListenerController{	
 
	@org.springframework.beans.factory.annotation.Autowired
	public FraudCheckTransactionListenerController(ObjectMapper objectMapper, HttpServletRequest request) {
        super(objectMapper, request);
        
        ObjectMapperDecorator.addAFMFeature(this.objectMapper);
	}
	
	/**
	 * Handle the TelusPubsub framework callback.
	 * 
	 * @param requestId the request parameter indicating original request id
	 * @param payload       the json payload corresponding to {@code Disposition}
	 * @param principal     the principal when client send http authentication info
	 * @return the response as json payload 
	 */

	@RequestMapping(value= {"/fraudCheckCommandSvc/FraudTransactionRecord"}, 
			method = RequestMethod.POST, 
			produces = {"application/json" }, 
			consumes = { "application/json" }
	)
	 
	public ResponseEntity<Object> acceptTFMFraudCheckTransaction(
			@RequestParam(value = "requestId", required = false) String requestId,
			@RequestBody String payload,
			Principal principal) throws Exception {

		// set threadLocal for logging
		String finalRequestId = deriveFinalRequestId(requestId);
		RequestId.set(finalRequestId);
		log.info("Accepting pubsub callback request for requestId: '" + requestId+"'");
		
		log.info("originatingAppId: '" + request.getParameter("originatingAppId") +"'");
		log.info("requestId: '" + request.getParameter("requestId") +"'");
		log.info("transactionType: '" + request.getParameter("transactionType") +"'");
		logPrincipal(principal);
		
		return this.handleTFMFraudCheckTransaction(finalRequestId, payload, principal);
	}

}
