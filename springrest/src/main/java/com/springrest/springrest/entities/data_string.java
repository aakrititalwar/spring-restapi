package com.springrest.springrest.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.http.HttpStatus;

public class data_string {
	private String data;

	public data_string(String data) {
		super();
		this.data = data;
	}

	public data_string() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public boolean strvalid(PostResponse resobj, String[] tokens) {
		
		//System.out.println(tokens[2]);
		if(tokens.length != 4) {
			//System.out.println("1st");
			resobj.setStatus_code(HttpStatus.BAD_REQUEST.value());
			resobj.setProb_det(new ProblemDetails("error", "bad request"));
			return false;
		}
		if(!("\'Temperature\'".equals(tokens[2]))) {
			resobj.setStatus_code(HttpStatus.BAD_REQUEST.value());
			resobj.setProb_det(new ProblemDetails("error", "bad request"));
			return false;
		}
		
		Integer dev_id;
		Long epoch;
		Float temp;
		
		try {
			dev_id = Integer.parseInt(tokens[0]);
			System.out.println("2nd");
			epoch = Long.parseLong(tokens[1]);
			System.out.println("3rd");
			temp = Float.parseFloat(tokens[3]);
			System.out.println("4th");
		}
		catch(Exception e) {
			resobj.setStatus_code(HttpStatus.BAD_REQUEST.value());
			resobj.setProb_det(new ProblemDetails("error", "bad request"));
			return false;
		}
		
		if(temp < 90) {
			resobj.setStatus_code(HttpStatus.OK.value());
			resobj.setProb_det(new ProblemDetails("overtemp", "false"));
		}
		else {
			
			resobj.setStatus_code(HttpStatus.OK.value());
			resobj.setProb_det(new ProblemDetails("overtemp", "true"));
			resobj.setDevice_id(dev_id);
			Date date = new Date(epoch);
	        DateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	        String formatted = format.format(date);
			resobj.setFormatted_time(formatted);
		}
		
		return true;
	}

	@Override
	public String toString() {
		return "data_string [data=" + data + "]";
	}
	

}
