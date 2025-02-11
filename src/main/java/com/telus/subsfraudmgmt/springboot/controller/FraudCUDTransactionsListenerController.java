package com.telus.subsfraudmgmt.springboot.controller;

import java.security.Principal;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.telus.subsfraudmgmt.springboot.RequestId;
import com.telus.subsfraudmgmt.springboot.model.transaction.TransactionType;

@RestController
public class FraudCUDTransactionsListenerController extends BaseFraudTransactionsListenerController {
	
	@org.springframework.beans.factory.annotation.Autowired
	public FraudCUDTransactionsListenerController(ObjectMapper objectMapper, HttpServletRequest request) {
        super(objectMapper, request);
	}
	
	/**
	 * Handle the TelusPubsub framework callback.
	 * 
	 * @param payload       the json payload corresponding to {@code Disposition}
	 * @param principal     the principal when client send http authentication info
	 * @return the response as json payload 
	 */

	@RequestMapping(value= {"/fraudVendorAdapterSvc/VendorFraudTransaction","/tfmTransactionListener"}, 
			method = RequestMethod.POST, 
			produces = {"application/json" }, 
			consumes = { "application/json" }
	)
	 
	public ResponseEntity<Object> acceptTFMCUDTransaction(
			@RequestParam(value = "requestId", required = false) String requestId,
			@RequestBody String payload,
			Principal principal) throws Exception {

		// set threadLocal for logging
		String finalRequestId = deriveFinalRequestId(requestId);
		RequestId.set(finalRequestId);
		
		log.info("Accepting request for requestId: '" + requestId+"'");
		log.info("originatingAppId: '" + request.getParameter("originatingAppId") +"', transactionType: '" + request.getParameter("transactionType") +"'");
		logPrincipal(principal);
	
		
		if (TransactionType.isCreateFraudFileTransaction(request.getParameter("transactionType"))) {
			return this.createFraudFile(finalRequestId, payload, principal);
		}
		if (TransactionType.isDeleteFraudFileTransaction(request.getParameter("transactionType"))) {
			return this.deleteFraudFile(finalRequestId, payload, principal);
		}
		//only updateApplicationDispositon tnx shall be published to pubsub 
		if (TransactionType.isUpdateAppDispositionTransaction(request.getParameter("transactionType"))) {
			//return this.updateApplicationDispositon(finalRequestId, payload, principal);
			return this.updateApplicationDispositonListener(payload);
		}
		if (TransactionType.isUpdateCaseDispositionTransaction(request.getParameter("transactionType"))) {
			return this.updateCaseDisposition(finalRequestId, payload, principal);
		}
		
		return new ResponseEntity<Object>(HttpStatus.OK);

	}
}
