package io.cskript.model;

public class Status {

	private String code;
	private String error;
	private String message;
	public Status(String code, String error, String message) {
		this.code = code;
		this.error = error;
		this.message = message;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
