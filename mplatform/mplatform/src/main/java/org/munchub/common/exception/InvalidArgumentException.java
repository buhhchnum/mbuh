package org.munchub.common.exception;

public class InvalidArgumentException extends UncheckedException{
	
	public InvalidArgumentException() 
	{
		this("message", "message1");
		//this(CommonErrorCode.INVALID_ARGUMENT);
	}
	
	public InvalidArgumentException(String errorCode, String messageArgs) 
	{
		super(errorCode, messageArgs);
	}

}
