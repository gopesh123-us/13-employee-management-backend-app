package live.learnjava.employeemanagement.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import live.learnjava.employeemanagement.exceptions.ResourceNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleResourceNotFoundException(ResourceNotFoundException ex) {
		ErrorResponse errorResponse = new ErrorResponse(ex.getMessage(), ex.getErrorCode(),
				HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleAllExceptions(Exception ex) {
		ErrorResponse error = new ErrorResponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
