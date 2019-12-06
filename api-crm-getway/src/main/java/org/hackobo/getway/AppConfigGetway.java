package org.hackobo.getway;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfigGetway {
	
	@Bean
	public RestTemplate registerRestTemplate() {
		return new RestTemplate();
	}
	
}
