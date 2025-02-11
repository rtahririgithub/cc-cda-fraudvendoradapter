package com.telus.subsfraudmgmt.springboot.aop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.telus.subsfraudmgmt.api.model.TelusIndividualIdentification;
import com.telus.subsfraudmgmt.springboot.aop.helper.TFMModelDataIntegrityHelper;

@Aspect
public class TFMModelDataIntegrityAspect {

	@Around(value = "execution(* com.telus.subsfraudmgmt.api.model.TelusBillingAccount.toString())")
	public String aroundTelusBillingAccountToString(ProceedingJoinPoint  joinPoint) throws Throwable{
		String result = (String)joinPoint.proceed();
		return TFMModelDataIntegrityHelper.maskPin(result);
	}
	@Around(value = "execution(* com.telus.subsfraudmgmt.api.model.TelusIndividualIdentification.toString())")
	public String aroundTelusIndividualIdentificationToString(ProceedingJoinPoint  joinPoint) throws Throwable{
		
		TelusIndividualIdentification o = (TelusIndividualIdentification)joinPoint.getThis();
	    if (o==null) {
	    	return null;
	    }
	    if ("SIN".equalsIgnoreCase(o.getIdentificationType()) ||
	    		"CC".equalsIgnoreCase(o.getIdentificationType()) ||
	    		"PASSPORT".equalsIgnoreCase(o.getIdentificationType()) ||
	    		"DL".equalsIgnoreCase(o.getIdentificationType()) ) {
	    	
			return TFMModelDataIntegrityHelper.maskIdentificationNumber(o);
		}
		return (String)joinPoint.proceed(); 
	}
	
	@Around(value = "execution(* com.telus.subsfraudmgmt.api.model.FraudCheckPerform.toString())")
	public String aroundFraudCheckPerformToString(ProceedingJoinPoint  joinPoint) throws Throwable{
	    String result = (String)joinPoint.proceed();
	    result = TFMModelDataIntegrityHelper.maskSocialInsurance(result);
	    result = TFMModelDataIntegrityHelper.maskSubjectSin(result);
	    return result;
	}
	
}
