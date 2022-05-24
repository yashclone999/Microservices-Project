package com.microservices.application.producer;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusSenderClient;

@Configuration
public class SBClient {

	@Value("${service-bus.namespace.connection-string}")
	private String serviceBusNamespace;
	
	@Value("${queue.name}")
	private String queueName;
	
	@Bean
	@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
	public ServiceBusSenderClient getSBClient(){
		ServiceBusSenderClient sender = new ServiceBusClientBuilder()
			    .connectionString(serviceBusNamespace)
			    .sender()
			    .queueName(queueName)
			    .buildClient();
		return sender;
	}
	
}


