package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.PostResponse;
//import com.springrest.springrest.controller.Strings;
import com.springrest.springrest.entities.data_record;
import com.springrest.springrest.entities.data_string;



public interface ApiServiceInt {
	
	public List<data_record> getRecords();
	public List<String> getinvalid();
	public PostResponse addRecord(data_string datastr);
	public void deleteinvalid();

}
