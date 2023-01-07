package com.springrest.springrest.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.services.ApiServiceInt;
import com.springrest.springrest.entities.PostResponse;
import com.springrest.springrest.entities.ResponseBody;
import com.springrest.springrest.entities.data_record;
import com.springrest.springrest.entities.data_string;

@RestController
public class ApiController {
	
	@Autowired
	private ApiServiceInt ApiServiceInt;
	
	@GetMapping("/home")
	public String home() {	
		return "This is home page for Rest API for Tesla assessment";
	}
	
	@GetMapping("/data_records")
	public List<data_record> getRecords(){
		
		return this.ApiServiceInt.getRecords();
		
	}
	
	@GetMapping("/errors")
	public Map<String,List<String>> getinvalid(){
		HashMap<String,List<String>> map = new HashMap<>();
		map.put("errors", this.ApiServiceInt.getinvalid());
		return map;
	}
	
	@PostMapping(path="/temp", consumes="application/json",produces="application/json")
	public ResponseEntity<ResponseBody> addRecord(@RequestBody data_string datastr) {
		//System.out.println("hi");
		//System.out.println(datarec.getData());
		PostResponse pr_obj = new PostResponse();
		pr_obj = this.ApiServiceInt.addRecord(datastr);
		ResponseBody repbodyobj = new ResponseBody();
		if(pr_obj.getStatus_code() == 400) {
			repbodyobj.setError("bad request");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(repbodyobj);
		}
		else {
			if(pr_obj.getProb_det().getError_message() == "false") {
				repbodyobj.setOvertemp(false);
			}
			else {
				repbodyobj.setOvertemp(true);
				repbodyobj.setDevice_id(pr_obj.getDevice_id());
				repbodyobj.setFormatted_time(pr_obj.getFormatted_time());
			}
			
			return ResponseEntity.status(HttpStatus.OK).body(repbodyobj);
		}
	     
	}
	
	@DeleteMapping("/errors")
	public ResponseEntity<HttpStatus> deleteinvalid(){
		try {
			this.ApiServiceInt.deleteinvalid();
			return ( new ResponseEntity<>(HttpStatus.OK));
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
