/**
 * 
 */
package com.winwallet.exception;


import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * @author Emmanuel Afonrinwo
 *
 */
@ControllerAdvice
public class MainExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundError.class)
	 public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundError ex, WebRequest request) {
	  ErrorDetail errorDetail = new ErrorDetail(new Date(), ex.getMessage(), request.getDescription(false));
	  return new ResponseEntity<>(errorDetail, HttpStatus.NOT_FOUND);
	 }
	
	 @ExceptionHandler(Exception.class)
	 public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
		 ErrorDetail errorDetail = new ErrorDetail(new Date(), ex.getMessage(), request.getDescription(false));
	  return new ResponseEntity<>(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
	 }
}
