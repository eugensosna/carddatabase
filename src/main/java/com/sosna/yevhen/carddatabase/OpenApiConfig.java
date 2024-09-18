package com.sosna.yevhen.carddatabase;
import java.awt.Component;
import java.awt.Container;

import javax.swing.InternalFrameFocusTraversalPolicy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
@Configuration
public class OpenApiConfig {
	
	@Bean
	public OpenAPI carDatabaseOpenAPI() {
		return new OpenAPI()
.info(new Info().title("Cars REST ").version("1.0.8"));		
	}

}
