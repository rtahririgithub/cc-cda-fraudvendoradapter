package com.telus.subsfraudmgmt.springboot;

import java.util.HashSet;
import java.util.Set;

import javax.validation.ConstraintViolation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.beanvalidation.OptionalValidatorFactoryBean;

/**
 * This just disable spring default bean validation based on @Valid annotation, and use our own more complete validation.
 * <p>Only the last method be called for top level object and do nothing, which takes about 10ms, instead of more than 1s before disabling.
 * @author Harry Xu
 *
 */
@Component
@Primary
@ConditionalOnProperty(prefix = "spring.custom.beans", name = "validator-factory-with-disabled-validation")
public class NoopValidatatorFactoryBean extends OptionalValidatorFactoryBean {
	private static final Log LOG = LogFactory.getLog(NoopValidatatorFactoryBean.class.getName());
	@Override
	public <T> Set<ConstraintViolation<T>> validate(final T object, final Class<?>... groups) {
		LOG.info("----validatting object constraint with groups ---");
		return new HashSet<ConstraintViolation<T>>();
	}

	@Override
	public <T> Set<ConstraintViolation<T>> validateProperty(final T object,
			final String propertyName,
			final Class<?>... groups) {
		LOG.info("----validatting object property with groups ---");
		return new HashSet<ConstraintViolation<T>>();
	}

	@Override
	public <T> Set<ConstraintViolation<T>> validateValue(final Class<T> beanType,
			final String propertyName,
			final Object value,
			final Class<?>... groups) {
		LOG.info("----validatting beanType property with groups ---");
		return new HashSet<ConstraintViolation<T>>();
	}

	@Override
	public void validate(final Object target, final Errors errors) {
		LOG.info("----validatting object ---");
	}

	/**
	 * Only this one is invoked for top level object FraudCheckPerform,
	 */
	@Override
	public void validate(final Object target, final Errors errors, final Object... validationHints) {
		LOG.info("----validatting object with optional validationHints ---");
	}


}