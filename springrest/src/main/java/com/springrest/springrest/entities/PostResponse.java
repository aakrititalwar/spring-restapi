package com.springrest.springrest.entities;

import java.util.Date;

public class PostResponse {
	
	private Integer status_code;
	private ProblemDetails prob_det;
	private Integer device_id;
	private String formatted_time;
	public Integer getDevice_id() {
		return device_id;
	}
	public void setDevice_id(Integer device_id) {
		this.device_id = device_id;
	}
	public String getFormatted_time() {
		return formatted_time;
	}
	public void setFormatted_time(String formatted) {
		this.formatted_time = formatted;
	}
	public Integer getStatus_code() {
		return status_code;
	}
	public void setStatus_code(Integer status_code) {
		this.status_code = status_code;
	}
	public ProblemDetails getProb_det() {
		return prob_det;
	}
	public void setProb_det(ProblemDetails prob_det) {
		this.prob_det = prob_det;
	}
	public PostResponse(Integer status_code, ProblemDetails prob_det) {
		super();
		this.status_code = status_code;
		this.prob_det = prob_det;
	}
	public PostResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

}
