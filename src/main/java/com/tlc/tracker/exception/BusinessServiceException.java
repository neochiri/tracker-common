package com.tlc.tracker.exception;

public class BusinessServiceException extends RuntimeException{

	private ErrorType errorType;

	public BusinessServiceException(String message, ErrorType errorType) {
		super(message);
		this.errorType = errorType;
	}

	public ErrorType getErrorType() {
		return errorType;
	}

	public void setErrorType(ErrorType errorType) {
		this.errorType = errorType;
	}
}
