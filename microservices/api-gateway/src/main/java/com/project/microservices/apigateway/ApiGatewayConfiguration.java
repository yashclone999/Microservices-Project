package com.project.microservices.apigateway;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



@Configuration
@ConditionalOnProperty(name = "spring.cloud.gateway.globalcors.addToSimpleUrlHanderMapping", matchIfMissing = true)
public class ApiGatewayConfiguration {

	
	
	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		
		return builder.routes()
				//////////////////////////////////////
				.route(p -> p.path("/booking/book/**")
						.filters(
									f -> f
									.setResponseHeader("Access-Control-Allow-Origin", "http://localhost:4200")//allow white listed origin is 4200, can change to *
			                    )
						.uri("lb://booking-service") )
				//////////////////////////////////////
				.route(p -> p.path("/payments/success**")
						.filters(
									f -> f
									.setResponseHeader("Access-Control-Allow-Origin", "http://localhost:4200")//allow white listed origin is 4200, can change to *
			                    )
						.uri("lb://booking-service") )
				//////////////////////////////////////
				.route(p -> p.path("/rooms/search/**")
						.filters(f -> f.setResponseHeader("Access-Control-Allow-Origin", "http://localhost:4200")
			                    )
						.uri("lb://search-service") )
				///////////////////////////////////////
				.route(p -> p.path("/rooms/locations")
						.filters(f -> f.setResponseHeader("Access-Control-Allow-Origin", "http://localhost:4200")
			                    )
						.uri("lb://search-service") )
				///////////////////////////////////////
				.build();
	}
}
