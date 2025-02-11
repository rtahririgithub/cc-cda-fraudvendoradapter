package com.telus.subsfraudmgmt.springboot.aop;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import com.fico.afm.model.application.Applicant;
import com.fico.afm.model.application.Person;


@Aspect
public class AfmApplicantAndPersonAspect {

	@Around(value = "execution(* Applicant.getPrimaryIdentificationType())")
	public Object overideApplicantPrimaryIdentificationType(ProceedingJoinPoint  joinPoint) throws Throwable{
		
		Applicant o = (Applicant)joinPoint.getThis();
	    if (o==null) {
	    	return null;
	    }
	    
	    //if (isAllNullOrEmpty(new String[] {o.getPrimaryIdentificationNumber(), o.getPrimaryIdentificationSupplemental()} )) {
	    if (isAllNullOrEmpty(new String[] {o.getPrimaryIdentificationNumber()} )) {
	    	return null;
	    }
		return joinPoint.proceed();
		 
	}
	@Around(value = "execution(* Applicant.getSecondaryIdentificationType())")
	public Object overideApplicantSecondaryType(ProceedingJoinPoint  joinPoint) throws Throwable{
		
		Applicant o = (Applicant)joinPoint.getThis();
	    if (o==null) {
	    	return null;
	    }
	    //if (isAllNullOrEmpty(new String[] {o.getSecondaryIdentificationNumber(), o.getSecondaryIdentificationSupplemental()} )) {
	    if (isAllNullOrEmpty(new String[] {o.getSecondaryIdentificationNumber()} )) {
	    	return null;
	    }
		return joinPoint.proceed();
		 
	}
	
	/**
	 *  for Person's PrimaryIdentificationType and SecondaryIdentificationType
	 */
	@Around(value = "execution(* Person.getPrimaryIdentificationType())")
	public Object overidePersonPrimaryIdentificationType(ProceedingJoinPoint  joinPoint) throws Throwable{
		
		Person o = (Person)joinPoint.getThis();
	    if (o==null) {
	    	return null;
	    }
	    //if (isAllNullOrEmpty(new String[] {o.getPrimaryIdentificationNumber(), o.getPrimaryIdentificationSupplemental()} )) {
	    if (isAllNullOrEmpty(new String[] {o.getPrimaryIdentificationNumber()} )) {
	    	return null;
	    }
	     
		return joinPoint.proceed();
		 
	}
	@Around(value = "execution(* Person.getSecondaryIdentificationType())")
	public Object overidePersonSecondaryType(ProceedingJoinPoint  joinPoint) throws Throwable{
	
		Person o = (Person)joinPoint.getThis();
	    if (o==null) {
	    	return null;
	    }
	    //if (isAllNullOrEmpty(new String[] {o.getSecondaryIdentificationNumber(), o.getSecondaryIdentificationSupplemental()} )) {
	    if (isAllNullOrEmpty(new String[] {o.getSecondaryIdentificationNumber()} )) {
	    	return null;
	    }
		return joinPoint.proceed();
		 
	}
	 
	private static boolean isAllNullOrEmpty(String[] values) {
		for (String value: values) {
			if (value !=null && !value.trim().isEmpty()) {
				return false;
			}
		}
		return true;
	}
	
}
