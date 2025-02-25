package live.learnjava.employeemanagement.advice;

public class ErrorResponse {
	private String message;
	private String errorCode;
	private int status;

	public ErrorResponse(String message, String errorCode, int status) {
		super();
		this.message = message;
		this.errorCode = errorCode;
		this.status = status;
	}

	public ErrorResponse(String message, int status) {
		super();
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public int getStatus() {
		return status;
	}

}
