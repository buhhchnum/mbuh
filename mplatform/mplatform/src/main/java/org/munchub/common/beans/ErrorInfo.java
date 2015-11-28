package org.munchub.common.beans;

import java.io.Serializable;

import org.munchub.common.exception.UncheckedException;

public class ErrorInfo implements Serializable{
	
	private String errorCode;
    private String className;
    private String description;
    
    public ErrorInfo() {
        super();
    }

    public ErrorInfo(UncheckedException exception) {
        super();
        this.errorCode = exception.getErrorCode();
        this.className = exception.getClass().getName();
        this.description = exception.getLocalizedMessage();

    }
    
    public ErrorInfo(RuntimeException exception) {
        super();
        // TODO Set Proper Error Code for Generic Error
        //this.errorCode = CommonErrorCode.DATA_ACCESS_ERROR;
        this.className = exception.getClass().getName();
        this.description = exception.getLocalizedMessage();

    }

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
