package live.learnjava.employeemanagement.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	String errorCode;
	private static final long serialVersionUID = 1L;

	ResourceNotFoundException(String message) {
		super(message);
	}

	public ResourceNotFoundException(String theErrorMessage, String theErrorCode) {
		super(theErrorMessage);

		this.errorCode = theErrorCode;
	}

	public String getErrorCode() {
		return this.errorCode;
	}

}
