package com.max.xml.exception;

public class CustomException extends Exception {
	
	private Integer code;
	
	public CustomException(Integer code, String message) {
		super(message);
		this.code = code ;
	}
	
	public CustomException(Integer code, String message, String appendix) {
		super(message + " #" + appendix);
		this.code = code ;
	}
	
	public CustomException(Errors error) {
		super(error.getMessage());
		this.code = error.getCode();
	}
	
	public CustomException(Errors error, String appendix) {
		super(error.getMessage() + " #" + appendix);
		this.code = error.getCode();
	}

	public CustomException(String message, Throwable e) {
		super(Errors.ERR_9999.getMessage() + " #" + message, e);
		this.code = Errors.ERR_9999.getCode();
	}
	
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}
	
	
}
