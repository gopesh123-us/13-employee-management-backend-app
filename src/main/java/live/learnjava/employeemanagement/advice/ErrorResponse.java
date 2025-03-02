package live.learnjava.employeemanagement.advice;

//implemented builder pattern
public class ErrorResponse {

	private String message;
	private String errorCode;
	private int status;

	private ErrorResponse(Builder builder) {
		this.message = builder.message;
		this.errorCode = builder.errorCode;
		this.status = builder.status;
	}

	public static class Builder {

		private String message;
		private String errorCode;
		private int status;

		public Builder setMessage(String theMessage) {
			this.message = theMessage;
			return this;
		}

		public Builder setErrorCode(String theErrorCode) {
			this.errorCode = theErrorCode;
			return this;
		}

		public Builder setStatus(int theStatus) {
			this.status = theStatus;
			return this;
		}

		public ErrorResponse build() {
			return new ErrorResponse(this);
		}

	}

	@Override
	public String toString() {
		return """
				ErrorResponse{message=%s, errorCode=%s, status=%s}
				""".formatted(this.message, this.errorCode, this.status);
	}

}
