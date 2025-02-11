package com.telus.subsfraudmgmt.api.modelmapper.common;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.commons.logging.Log;
import org.mapstruct.Named;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import java.time.OffsetDateTime;

import com.fico.afm.model.application.types.AliasableNameValuePair;
import com.fico.afm.model.application.types.ApplicationMethod;
import com.telus.subsfraudmgmt.api.model.AccountRefOrValue;
import com.telus.subsfraudmgmt.api.model.Customer;
import com.telus.subsfraudmgmt.api.model.FraudCheckPerform;
import com.telus.subsfraudmgmt.api.model.TelusBillingAccount;
import com.telus.subsfraudmgmt.api.modelmapper.tfm.ApplicantUserData.RelationShipOpenAccount;
import com.telus.subsfraudmgmt.api.modelmapper.tfm.ApplicantUserData.RelationShipTentativeAccount;
import com.telus.subsfraudmgmt.api.modelmapper.tfm.ApplicationSectionTelcoUserData.Warning;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLogFactory;

public interface MapperCommon {
	public static final Log LOG = CustomizedLogFactory.getLog(MapperCommon.class);
	
	default String getTodayAsMMddYYYY() {
		String pattern = "MMddyyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		return simpleDateFormat.format(new Date());
	}
	
	default String bigDecimalToString(BigDecimal bigDecimal) {
		if (bigDecimal ==null) {
			return null;
		}
		return bigDecimal.toString();
	}
	
	/**
	 * No need Named if only method has such name
	 * 
	 */
	@Named("offsetDateTimeToCalendar")
	default Calendar offsetDateTimeToCalender(OffsetDateTime offsetDateTime) {
		//no need with NullValueStrategy.ALWAYS, just in case if there is a change in strategy 
		if (offsetDateTime == null) {
			return null;
		}
		 
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
		cal.setTimeInMillis(offsetDateTime.toInstant().toEpochMilli());
		return cal;
	}
	@Named("offsetDateTimeToString")
	default String offsetDateTimeToString(OffsetDateTime offsetDateTime) {
		//no need with NullValueStrategy.ALWAYS, just in case if there is a change in strategy
		if (offsetDateTime == null) {
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
	    sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
		String result= sdf.format(new Date(offsetDateTime.toInstant().toEpochMilli())); 
		if (result.endsWith("+0000")) {
			//Swagger generated io.swagger.configuration.CustomInstantDeserializer is doing this as well
			result = result.substring(0, result.length() - 5) + "Z";
		}
		return result;
		 
		 
	}
	
	default OffsetDateTime extractAccountCreditBureauResultCreationDate(FraudCheckPerform fraudCheckPerform) {
		OffsetDateTime creditBureauResultCreationDate = null;
		try {
			if (fraudCheckPerform != null) {
				Customer customer = fraudCheckPerform.getCustomer().getValue();
				if (customer.getAccount()!=null && !customer.getAccount().isEmpty() && customer.getAccount().get(0).getValue()!=null) {
					TelusBillingAccount account = (TelusBillingAccount)customer.getAccount().get(0).getValue();
					if (account!=null && account.getCreditBureauResult()!=null) {
						creditBureauResultCreationDate = account.getCreditBureauResult().getCreationDate();
					}
				}
			}
		} catch (RuntimeException e) {
			LOG.warn("account.getCreditBureauResult().getCreationDate() encountered exception: " , e);
		}
		return creditBureauResultCreationDate;
	}
	@Named("addToAliasableNameKVListIfNotNull")
	default void addToAliasableNameKVListIfNotNull(String name, String value, List<AliasableNameValuePair> list) {
		if (value != null && !value.trim().isEmpty()) {
			AliasableNameValuePair kv = new AliasableNameValuePair();
			kv.setName(name);
			kv.setValue(value);
			list.add(kv);
		}

	}
	
	@Named("getFirstAccountBrandCd")
	default String getFirstAccountBrandCd(List<AccountRefOrValue> accountRefOrValue) {
		if (accountRefOrValue ==null || accountRefOrValue.isEmpty() || accountRefOrValue.get(0).getValue()==null) {
			return null;
		}
		TelusBillingAccount oAccount = (TelusBillingAccount)accountRefOrValue.get(0).getValue();
		return oAccount.getBrandCd();
	}
	@Named("getFirstAccountDealderCd")
	default String getFirstAccountDealderCd(List<AccountRefOrValue> accountRefOrValue) {
		if (accountRefOrValue ==null || accountRefOrValue.isEmpty() || accountRefOrValue.get(0).getValue()==null) {
			return null;
		}
		TelusBillingAccount oAccount = (TelusBillingAccount)accountRefOrValue.get(0).getValue();
		return oAccount.getDealerRepCode();
	}
	
	/**
	 * It handles ApplicationSectionTelcoUserData, ApplicantUserData, and other simple user data. 
	 * @param bean a top level bean
	 * @return the AliasableNameValuePair list
	 */
	default List<AliasableNameValuePair> toAFMUserDataList(Object bean) {

		//for all properties in ApplicantUserData, add to applicant's the userData list if not null
		List<AliasableNameValuePair> list = new ArrayList<>();
		final BeanWrapper src = new BeanWrapperImpl(bean);
		java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
		for(java.beans.PropertyDescriptor pd : pds) {
			
			Object val =   src.getPropertyValue(pd.getName());
			if (val ==null) {
				continue;
			}
			if (val instanceof List<?>) {
				boolean isWarningList = false;
				boolean isRelationshipTentativeAccountList = false;
				boolean isRelationShipOpenAccountList = false;
				
				for (Object aItem: (List)val)  {
					if (aItem instanceof Warning) {
						isWarningList =true;
					}
					else if (aItem instanceof RelationShipTentativeAccount) {
						isRelationshipTentativeAccountList =true;
					}
					else if (aItem instanceof RelationShipOpenAccount) {
						isRelationShipOpenAccountList =true;
					}
					break;
				}
				if (isWarningList) {
					//for ApplicationTelco
					list.addAll(warningsToAFMUserDataList((List)val));
				}
				else if (isRelationshipTentativeAccountList) {
					//For Applicant tab in mapping doc - tentative account
					list.addAll(relationshipTentativeAccountsToAFMUserDataList((List)val));
				}
				else if (isRelationShipOpenAccountList) {
					//For Applicant tab in mapping doc - open account
					list.addAll(relationshipOpenAccountsToAFMUserDataList((List)val));
				}
				 
			}
			if (! (val instanceof String)) {
				continue;
			}
			addToAliasableNameKVListIfNotNull (pd.getName(),(String) val, list);
		}
		return list;
	}
	
	/**
	 * key is appened with list index to differentiate in AFM user data name value list
	 * @param warnings list of warnings
	 * @return the list of AFM aliseable name value pair list
	 */
	default List<AliasableNameValuePair> warningsToAFMUserDataList(List<Warning> warnings) {
		
       List<AliasableNameValuePair> list = new ArrayList<>();

		for (int i=0; i<warnings.size(); i++) {
			if (i >=10) {
				//0-9
				break;
			}
			Warning warning = warnings.get(i);
			BeanWrapper src = new BeanWrapperImpl(warning);
			java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
			for(java.beans.PropertyDescriptor pd : pds) {
				Object val =   src.getPropertyValue(pd.getName());
				//notice class could be a property name, so need to check string value type
				if (! (val instanceof String)) {
					continue;
				}
				addToAliasableNameKVListIfNotNull (pd.getName() + i,(String) val, list);
			}
		}				 

		return list;
	}
	
 
	default List<AliasableNameValuePair> relationshipTentativeAccountsToAFMUserDataList(
			List<RelationShipTentativeAccount> relationShipTentativeAccountList) {
		
       List<AliasableNameValuePair> list = new ArrayList<>();

		for (int i=0; i<relationShipTentativeAccountList.size(); i++) {
			if (i >=5) {
				//0-4 maximum
				break;
			}
			RelationShipTentativeAccount tentativeAccount = relationShipTentativeAccountList.get(i);
			BeanWrapper src = new BeanWrapperImpl(tentativeAccount);
			java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
			 
			for(java.beans.PropertyDescriptor pd : pds) {
				Object val =   src.getPropertyValue(pd.getName());
				//notice class could be a property name, so need to check string value type
				if (! (val instanceof String)) {
					continue;
				}
				addToAliasableNameKVListIfNotNull (RelationShipTentativeAccount.toAFMKeyName(pd.getName(), i),(String) val, list);
			}
		}				 

		return list;
	}
	
	default List<AliasableNameValuePair> relationshipOpenAccountsToAFMUserDataList(
			List<RelationShipOpenAccount> relationShipOpenAccountList) {
		
       List<AliasableNameValuePair> list = new ArrayList<>();

		for (int i=0; i<relationShipOpenAccountList.size(); i++) {
			if (i >=10) {
				//0-9
				break;
			}
			RelationShipOpenAccount openAccount = relationShipOpenAccountList.get(i);
			BeanWrapper src = new BeanWrapperImpl(openAccount);
			java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
			 
			for(java.beans.PropertyDescriptor pd : pds) {
				Object val =   src.getPropertyValue(pd.getName());
				//notice class could be a property name, so need to check string value type
				if (! (val instanceof String)) {
					continue;
				}
				addToAliasableNameKVListIfNotNull (RelationShipOpenAccount.toAFMKeyName(pd.getName(), i),(String) val, list);
			}
		}				 

		return list;
	}

	/**
	 * channel(TelusChannel).channelTypeCd TFM to map channelTypeCd to AFM values
	 * 
	 * <pre>
	map channelTypeCd to afm value as below 
	RETAILER --> RETAIL_SCORE (enumeration is misspelled)(July 14: should be RETAIL, not RETAILER)
	WEB --> WEB_INTERNET (July 14: should add all other WEB codes as below)
	DEALER --> DEALER
	CORPORATE_STORE --> BANK_BRANCH_TELLER
	CALL_CENTRE --> TELEPHONE
	missing --> null (missing value)
	any other value (e.g. DEFAULT) --> OTHERS
	
	(July 14) Note the following WEB related channelTypeCd:
	- WEB
	- WEBCON
	- WEBEPP
	- WEBKOODO
	- WEBSBS
	- WEBTWA
	
	Refer to CREDIT_CHANNEL_TYPE table in REFPDS for list of valid channelTypeCd
	 * </pre>
	 * 
	 * @param source
	 * @return
	 */
	@Named("toApplicationMethod")
	default ApplicationMethod toApplicationMethod(String source) {
	        if (source==null) {
	        	return null;
	        }
	        if (source.toLowerCase().contains("Retail".toLowerCase())) {
	        	return ApplicationMethod.RETAIL_STORE;
	        }
	        if (source.toLowerCase().contains("Web".toLowerCase())) {
	        	return ApplicationMethod.WEB_INTERNET;
	        }
	        if (source.toLowerCase().contains("Corporate".toLowerCase())) {
		    	//Corporate_Store
		    	return ApplicationMethod.BANK_BRANCH_TELLER;
		    }
	        if (source.toLowerCase().contains("Dealer".toLowerCase())) {
		    	//Corporate_Store
		    	return ApplicationMethod.DEALER;
		    }
		    if (source.toLowerCase().contains("Call".toLowerCase())) {
		    	//CALL_CENTRE or call centre
		    	return ApplicationMethod.TELEPHONE;
		    }
		    return ApplicationMethod.OTHERS;
		 
	}
	
	@Named("toApplicationMethodString")
	default String toApplicationMethodString(String source) {
		ApplicationMethod result= toApplicationMethod(source);
		return  (result==null)? null : result.toString();

	}
	
	@Named("fromBooleanToYN")
	default String fromBooleanToYN(Boolean source) {	
		if (source==null) {
			return null;
		}
		return  source.booleanValue()? "Y":"N";

	}

}