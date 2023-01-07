package com.springrest.springrest.entities;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseBody {
	
	
	private Integer device_id;
	private String formatted_time;
	private Boolean overtemp;
	private String error;
	public ResponseBody(Integer device_id, String formatted_time, boolean overtemp, String error) {
		super();
		this.device_id = device_id;
		this.formatted_time = formatted_time;
		this.overtemp = overtemp;
		this.error = error;
	}
	public ResponseBody() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public Integer getDevice_id() {
		return device_id;
	}
	public void setDevice_id(Integer device_id) {
		this.device_id = device_id;
	}
	public String getFormatted_time() {
		return formatted_time;
	}
	public void setFormatted_time(String formatted_time) {
		this.formatted_time = formatted_time;
	}
	public Boolean isOvertemp() {
		return overtemp;
	}
	public void setOvertemp(Boolean overtemp) {
		this.overtemp = overtemp;
	}
	

}
