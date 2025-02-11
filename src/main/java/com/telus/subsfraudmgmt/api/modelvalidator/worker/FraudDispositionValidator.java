package com.telus.subsfraudmgmt.api.modelvalidator.worker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.telus.subsfraudmgmt.api.model.FraudDisposition;
import com.telus.subsfraudmgmt.api.modelvalidator.TfmValidator;

/**
 * Validate the FraudDisposition portion  
 * <p>Based on Disposition tab in mapping document
 * @author Harry Xu
 *
 */
public class FraudDispositionValidator implements TfmValidator<FraudDisposition> {

	public static final FraudDispositionValidator INSTANCE = new FraudDispositionValidator();

	private FraudDispositionValidator() {

	}
	/**
	 * *<pre>
	 *                        <xs:documentation>Fraud disposition status:
                                CONFIRMED_FRAUD_VICTIM = Confirmed fraud victim (a person or
                                entity identified on an
                                application is confirmed to be a victim
                                of a fraud)

                                CONFIRMED_FRAUD_PERPETRATOR = Confirmed fraud
                                perpetrator (a
                                person or an entity
                                identified on an application is
                                confirmed
                                to be committing fraud ). For example, applying for the
                                phone with
                                no intention of
                                paying bills.

                                UNCONFIRMED_FRAUD =
                                Unconfirmed fraud (a person or an entity that is believed to
                                be
                                fraudulent)

                                NOT_FRAUD = Non-fraud
                              </xs:documentation>
                                 
                              <xs:documentation>Fraud type:
                                FIRST_PARTY_FICTITIOUS_ID – FIRST
                                PARTY - FICTITIOUS IDENTITY (No victim)
                                FIRST_PARTY_TRUE_NAME –
                                FIRST PARTY – TRUE NAME FRAUD (No
                                modifications done, correct
                                ID)
                                FIRST_PARTY_ALTERED_NAME – FIRST PARTY – ALTERED NAME FRAUD
                                (Mutated to distance from
                                Credit Pull)
                                THIRD_PARTY_IDENTITY_THEFT
                                – THIRD PARTY – IDENTITY THEFT (New Customer Relationship)
                                THIRD_PARTY_ACCOUNT_TAKEOVER – THIRD PARTY – ACCOUNT TAKEOVER
                                (Existing customer
                                relationship)
                                FIRST_PARTY_SUSPECTED - FIRST
                                PARTY – SUSPECTED
                                THIRD_PARTY_SUSPECTED – THIRD PARTY - SUSPECTED
                                OTHER – OTHER
                                UNKNOWN – Unknown
                            </xs:documentation>
     *</pre>
	 */

	@Override
	public List<String> validate(FraudDisposition fraudDisposition) {
		List<String> list = new ArrayList<>();

        if (fraudDisposition.getDispositionDateTime()==null) {
        	list.add("fraudDisposition.dispositionDateTime null!");
        }
        if (fraudDisposition.isManuallyReviewedInd()==null) {
        	list.add("fraudDisposition.manuallyReviewedInd null!");
        }
        
        //not required as in Mapping doc
        //if (fraudDisposition.isProductActivatedInd()==null) {
        //	list.add("CreditDecisioningResult.fraudDisposition.productActivatedInd null!");
        //}
         
        if (fraudDisposition.getFraudStatusCode()==null) {
        	list.add("fraudDisposition.fraudStatusCode null!");
        }
        else {
        	try {
        		FraudDispostionStatus.valueOf(fraudDisposition.getFraudStatusCode());
        	}catch (RuntimeException e) {
        		list.add("fraudDisposition.fraudStatusCode has to be one of " 
        				+ Arrays.asList(FraudDispostionStatus.values()) +"!");
        	}
        }
        if (fraudDisposition.getFraudTypeCode()==null) {
        	list.add("fraudDisposition.fraudTypeCode null!");
        }
        else {
        	try {
        		FraudType.valueOf(fraudDisposition.getFraudTypeCode());
        	}catch (RuntimeException e) {
        		list.add("fraudDisposition.fraudTypeCode has to be one of " 
        				+ Arrays.asList(FraudType.values()) +"!");
        	}
        }
		return list;
	}
	
	private static enum FraudDispostionStatus {
		CONFIRMED_FRAUD_VICTIM,
		CONFIRMED_FRAUD_PERPETRATOR,
		UNCONFIRMED_FRAUD,
		NOT_FRAUD;
	}
	
	private static enum FraudType {
		FIRST_PARTY_FICTITIOUS_ID,
		FIRST_PARTY_TRUE_NAME,
		FIRST_PARTY_ALTERED_NAME,
		THIRD_PARTY_IDENTITY_THEFT,
		THIRD_PARTY_ACCOUNT_TAKEOVER,
		FIRST_PARTY_SUSPECTED,
		THIRD_PARTY_SUSPECTED,
		OTHER,
		UNKONWN;
		
	}
}
