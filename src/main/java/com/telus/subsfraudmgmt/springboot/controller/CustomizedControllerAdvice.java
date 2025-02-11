package com.telus.subsfraudmgmt.springboot.controller;

import javax.validation.ConstraintViolationException;

import org.apache.commons.logging.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.telus.subsfraudmgmt.api.model.Error;
import com.telus.subsfraudmgmt.springboot.logging.CustomizedLog;
import com.telus.subsfraudmgmt.springboot.model.ApplicationNotExistException;
import com.telus.subsfraudmgmt.springboot.model.NoCaseExistException;
import com.telus.subsfraudmgmt.springboot.model.NoLinkedFraudFileException;
import com.telus.subsfraudmgmt.springboot.model.TFMInputValidationException;
import com.telus.subsfraudmgmt.springboot.model.TfmControllerWrapperRuntimeException;
import com.telus.subsfraudmgmt.springboot.util.LogUtil;

/**
 * Exception handlers
 * 
 * @author Harry Xu
 *
 */
@ControllerAdvice
@RequestMapping(produces = "application/json")
public class CustomizedControllerAdvice {

	private static final Log LOG = new CustomizedLog(CustomizedControllerAdvice.class.getName());
	
	/**
	 * Enforced by api operation contract, the api concrete controller can only throw <code>TfmControllerWrapperRuntimeException</code> as
	 * a wrapping runtime exception. 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(TfmControllerWrapperRuntimeException.class)
	@ResponseBody
	public ResponseEntity<Error> handleTfmControllerWrapperRuntimeException(TfmControllerWrapperRuntimeException e) {
		LOG.error("**** in handleTfmControllerWrapperRuntimeException:'" + e.getMessage() + "'");
		if (e.getCause()!=null && e.getCause() instanceof TFMInputValidationException) {
			return this.handleTFMInputValidationException((TFMInputValidationException)e.getCause());
		}
		if (e.getCause()!=null && e.getCause() instanceof ApplicationNotExistException) {
			return this.handleApplicationNotExistException((ApplicationNotExistException)e.getCause());
		}
		if (e.getCause()!=null && e.getCause() instanceof NoLinkedFraudFileException) {
			return this.handleNoLinkedFraudFileException((NoLinkedFraudFileException)e.getCause());
		}
		if (e.getCause()!=null && e.getCause() instanceof NoCaseExistException) {
			return this.handleNoCaseExistException((NoCaseExistException)e.getCause());
		}
		if (e.getCause()!=null && e.getCause() instanceof HttpStatusCodeException) {
			return this.handleHttpStatusCodeException((HttpStatusCodeException)e.getCause());
		}
		return buildErrorResponseEntity (null, e);
	}
	

	/**
	 * By default when the DispatcherServlet can't find a handler for a request it
	 * sends a 404 response. However if its property
	 * "throwExceptionIfNoHandlerFound" is set to {@code true} this exception is
	 * raised and may be handled with a configured HandlerExceptionResolver.
	 * <p>
	 * See <code>HelloWorldApplication.class</code>'s <code>@EnableWebMvc</code> and
	 * the set* statement. 
	 */
	@ExceptionHandler(NoHandlerFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	@ResponseBody
	public ResponseEntity<Error> handleNoHandlerFoundException(NoHandlerFoundException e) {
		LOG.error("**** in handleNoHandlerFoundException:'" + LogUtil.getStackTrace(e) + "'");
		return buildErrorResponseEntity(HttpStatus.NOT_FOUND, e);
	}

	/**
	 * Handle when Http method is not expected.
	 */
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
	@ResponseBody
	public ResponseEntity<Error> handleHttpMethodException(HttpRequestMethodNotSupportedException e) {
		LOG.error("**** in handleHttpMethodException:'" + LogUtil.getStackTrace(e) + "'");
		return buildErrorResponseEntity(HttpStatus.METHOD_NOT_ALLOWED, e);
	}

	/**
	 * Handle when media type is not expected, such as xml payload instead of json
	 * payload.
	 */
	@ExceptionHandler(HttpMediaTypeNotSupportedException.class)
	@ResponseStatus(value = HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	@ResponseBody
	public ResponseEntity<Error> handleMediaTypeException(HttpMediaTypeNotSupportedException e) {
		LOG.error("**** in handleMediaTypeException:'" + LogUtil.getStackTrace(e) + "'");
		return buildErrorResponseEntity(HttpStatus.UNSUPPORTED_MEDIA_TYPE, e);
	}

	/**
	 * Handle wrong request data
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Error> handleBadRequestException(final Exception e) {
		LOG.error("**** in handleBadRequestException:" + LogUtil.getStackTrace(e));
		return buildErrorResponseEntity(HttpStatus.BAD_REQUEST, e);

	}

 
	/**
	 * Handle spring boot's request param validation error
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Error> handleConstraintViolationRequestException(final Exception e) {
		LOG.error("**** in handleConstraintViolationRequestException:" + LogUtil.getStackTrace(e));
		return buildErrorResponseEntity(HttpStatus.BAD_REQUEST, e);

	}
	
	
	/**
	 * Handle handleTFMInputValidationException thrown if TFM input validation detects validation errors
	 */
	@ExceptionHandler(TFMInputValidationException.class)
	public ResponseEntity<Error> handleTFMInputValidationException(final TFMInputValidationException e) {
		LOG.error("**** in handlehandleTFMInputValidationException:" + LogUtil.getStackTrace(e));
		return buildErrorResponseEntity(HttpStatus.BAD_REQUEST, e);

	}
	/**
	 * Handle ApplicationNotExistException thrown with update application disposition, case disposition
	 */
	@ExceptionHandler(ApplicationNotExistException.class)
	public ResponseEntity<Error> handleApplicationNotExistException(final ApplicationNotExistException e) {
		LOG.error("**** in handleApplicationNotExistException:"+ LogUtil.getStackTrace(e));
		return buildErrorResponseEntity(HttpStatus.NOT_FOUND, e);

	}
	
	/**
	 * Handle NoCaseExistException
	 */
	@ExceptionHandler(NoCaseExistException.class)
	public ResponseEntity<Error> handleNoCaseExistException(final NoCaseExistException e) {
		LOG.error("**** in handleNoCaseExistException:" + LogUtil.getStackTrace(e));
		return buildErrorResponseEntity(HttpStatus.NOT_FOUND ,e);

	}
	
	/**
	 * Handle NoLinkedFraudFileException thrown when delete fraudsters for an application that does not have linked fraudsters.
	 */
	@ExceptionHandler(NoLinkedFraudFileException.class)
	public ResponseEntity<Error> handleNoLinkedFraudFileException(final NoLinkedFraudFileException e) {
		LOG.error("**** in handleNoLinkedFraudFileException:"+ LogUtil.getStackTrace(e));
		return buildErrorResponseEntity(HttpStatus.NOT_FOUND, e);

	}


	/**
	 * Handle HttpStatusCodeException which is thrown by the external rest service.
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(HttpStatusCodeException.class)
	public ResponseEntity<Error> handleHttpStatusCodeException(final HttpStatusCodeException e) {
		LOG.error("**** in handleHttpStatusCodeException:" + e.getResponseBodyAsString()+ LogUtil.getStackTrace(e));
		return buildErrorResponseEntity(e.getStatusCode(), e);

	}
	
	/**
	 * Handle other exception
	 * 
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Error> handleOtherException(final Exception e) {
		LOG.error("**** in handleOtherException:" + LogUtil.getStackTrace(e));
		return buildErrorResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR, e);

	}

	private ResponseEntity<Error> buildErrorResponseEntity(HttpStatus httpStatus, Exception e) {
		Error error = new Error();
		
		HttpStatus finalHttpStatus = (httpStatus==null)? HttpStatus.INTERNAL_SERVER_ERROR : httpStatus;

		int code = finalHttpStatus.value();
		error.code(String.valueOf(code));

		error.setReason(finalHttpStatus.name());
        
		if (e instanceof TFMInputValidationException) {
			TFMInputValidationException typedEx = (TFMInputValidationException) e;
			StringBuilder builder = new StringBuilder().append("ValidationException:").append("\n");
			if (typedEx.getValidationErrorMessages() !=null) {
				for (String message: typedEx.getValidationErrorMessages()) {
					builder.append(message).append("\n");
				}
			}
			error.setExceptionText(builder.toString());
		}else if (e instanceof HttpStatusCodeException) {
			HttpStatusCodeException typedEx = (HttpStatusCodeException)e;
			error.setExceptionText(typedEx.getResponseBodyAsString());
		}else {
			error.setExceptionText(e.getMessage());
		}
		return new ResponseEntity<>(error, finalHttpStatus);
	}

}
