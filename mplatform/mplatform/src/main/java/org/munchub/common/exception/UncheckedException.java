package org.munchub.common.exception;

public class UncheckedException extends RuntimeException{

	private final String errorCode;

	private final String message;

	public UncheckedException(String errorCode, String messageArgs)
	{
		this.errorCode = errorCode;
		this.message = messageArgs;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public String getMessage() {
		return message;
	}


}
