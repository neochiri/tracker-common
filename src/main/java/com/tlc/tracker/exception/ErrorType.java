package com.tlc.tracker.exception;

public enum ErrorType {
	SERVER_ERROR("SERVER_ERROR", 500),
	BUSINESS_ERROR("BUSINESS_ERROR", 400);


	private String codeError;
	private int status;

	ErrorType(String codeError, int status) {
		this.codeError = codeError;
		this.status = status;
	}

	public String getCodeError() {
		return codeError;
	}

	public void setCodeError(String codeError) {
		this.codeError = codeError;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
