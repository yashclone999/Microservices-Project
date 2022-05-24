package com.serverless.functionApp.handeler;


import org.springframework.cloud.function.adapter.azure.FunctionInvoker;

import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.annotation.AccessRights;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.ServiceBusQueueTrigger;


public class MailBooking extends FunctionInvoker<String,String>{
	
	@FunctionName("mail")
	public String sendMail(
			@ServiceBusQueueTrigger(name="mail", queueName="bookingnotifications", access = AccessRights.LISTEN, connection="MyBindingConnection")
			String booking, 
			ExecutionContext context) throws Exception{
		return handleRequest(booking,context);
	}
}



