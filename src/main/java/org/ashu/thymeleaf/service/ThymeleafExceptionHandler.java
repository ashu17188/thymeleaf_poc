package org.ashu.thymeleaf.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.ashu.exception.BadRequest;
import org.ashu.exception.BadRequestException;
import org.ashu.exception.InternalServerErrorException;
import org.ashu.exception.ResourceNotFoundException;
import org.ashu.exception.ServiceUnavailableException;
import org.generated.models.Error;
import org.generated.models.InternalServerError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ThymeleafExceptionHandler {

	private String errorLog = "{}. {}";

	private void logError(Exception exception, Integer code, String message, List<String> entities) {
		Map<String, Object> details = getDetails(code, message, entities);
		if (exception.getCause() != null) {
			details.put("cause", exception.getCause().getMessage());
			log.error(errorLog, exception.getMessage(), details.toString());
		} else {
			log.error(errorLog, exception.getMessage(), details.toString());
		}
	}

	private void logWarning(Exception exception, Integer code, List<String> entities) {
		Map<String, Object> details = getDetails(code, errorLog, entities);
		log.warn(errorLog, exception.getMessage(), entities.toString());
	}

	private org.generated.models.Error createApplicationError(int code, String message) {
		org.generated.models.Error error = new org.generated.models.Error();
		error.code(code);
		error.message(message);
		return error;
	}

	private org.generated.models.Error createApplicationError(int code, String message, List<String> entities) {
		org.generated.models.Error error = new org.generated.models.Error();
		error.code(code);
		error.message(message);
		error.setEntities(entities);
		return error;
	}

	private Map<String, Object> getDetails(Integer code, String message, List<String> entities) {
		Map<String, Object> errorResp = new HashMap<>();
		errorResp.put("code", code);
		errorResp.put("message", message);
		errorResp.put("entities", entities);
		return errorResp;
	}

	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<BadRequest> handleBadRequestException(BadRequestException badRequestException) {
//		logWarning(badRequestException, badRequestException.getBadRequest().getCode(), new ArrayList<String>());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(badRequestException.getBadRequest());
	}

	@ExceptionHandler(ServiceUnavailableException.class)
	public ResponseEntity<Error> handleServiceUnavailableException(
			ServiceUnavailableException serviceUnavailableException) {
//	logError(serviceUnavailableException, serviceUnavailableException.getError().getCode(), serviceUnavailableException.getError().getEntities());
		Error error = createApplicationError(serviceUnavailableException.getError().getCode(),
				serviceUnavailableException.getError().getMessage());
		return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(error);
	}

	@ExceptionHandler(InternalServerErrorException.class)
	public ResponseEntity<Error> handleInternalServerErrorException(InternalServerError ex) {
		Error error = createApplicationError(ex.getCode(), ex.getMessage(), ex.getEntities());
//		logError();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Error> handleResourceNotFoundException(ResourceNotFoundException resourceNotFoundException) {
		Error error = resourceNotFoundException.getError();
		// logError();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

}
