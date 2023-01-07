package com.springrest.springrest.services;



import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.springrest.springrest.entities.PostResponse;
import com.springrest.springrest.entities.ProblemDetails;
import com.springrest.springrest.entities.data_record;
import com.springrest.springrest.entities.data_string;

@Service
public class ApiServiceimpl implements ApiServiceInt {
	
	static List<data_record> list;
	
	public ApiServiceimpl() {
		
		list = new ArrayList<>();
//		list.add(new data_record("365951380:1640995229697:'Temperature':58.48256793121914", true));
//		list.add(new data_record("365951380:1640987554326:'Temperature':65.48256788121914", true));
//		list.add(new data_record("365951380:164shtyiu4326:'Temperature':65.48256788121914", false));
	}
	

	@Override
	public List<data_record> getRecords(){
		return list;
	}
	
	@Override
	public List<String> getinvalid(){
		List<String>  l = new ArrayList<>();
		for(data_record dr : list) {
			if(!dr.isValid()) {
				l.add(dr.getData());
			}
		}
		
		return l;
		
	}


	@Override
	public PostResponse addRecord(data_string datastr) {
		data_record dr ;
		PostResponse resobj = new PostResponse();
		if(datastr.getData() == "") {
			resobj.setStatus_code(HttpStatus.BAD_REQUEST.value());
			resobj.setProb_det(new ProblemDetails("error", "bad request"));
			dr = new data_record(datastr.getData(),false);
		}
		else {
		String[] tokens = datastr.getData().split(":");
		
		if(datastr.strvalid(resobj, tokens)) {
			dr = new data_record(datastr.getData(),true);
		}
		else {			
			dr = new data_record(datastr.getData(),false);
		}
		}
		list.add(dr);
		return resobj;
	}


	@Override
	public void deleteinvalid() {
		list = this.list.stream().filter(e->e.isValid()).collect(Collectors.toList());
		
	}

}
