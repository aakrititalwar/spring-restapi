package com.springrest.springrest.entities;

public class ProblemDetails {
	
	private String Key;
	
	private String error_message;

	public ProblemDetails(String key, String error_message) {
		super();
		Key = key;
		this.error_message = error_message;
	}

	public String getKey() {
		return Key;
	}

	public void setKey(String key) {
		Key = key;
	}

	public String getError_message() {
		return error_message;
	}

	public void setError_message(String error_message) {
		this.error_message = error_message;
	}

	public ProblemDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
