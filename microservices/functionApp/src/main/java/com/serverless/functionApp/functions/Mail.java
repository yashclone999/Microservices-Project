package com.serverless.functionApp.functions;


import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.serverless.functionApp.service.MailService;

@Component
public class Mail implements Function<String,String>{

	@Autowired
	MailService mailService;
	
	@Override
	public String apply(String data) {
		
		try {
			if(data != null && !data.equals("")) mailService.sendMail(data);
		} catch (Exception e) {
			e.printStackTrace();
			return "FAIL";
		}
		return "SUCCESS";
	}
	
}
