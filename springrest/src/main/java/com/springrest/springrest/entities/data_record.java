package com.springrest.springrest.entities;

public class data_record {
	private String data;
	private boolean valid;
	
	public data_record(String data, boolean valid) {
		super();
		this.data = data;
		this.valid = valid;
	}

	public data_record() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

	@Override
	public String toString() {
		return "data_record [data=" + data + ", valid=" + valid + "]";
	} 
	
	
	
}
