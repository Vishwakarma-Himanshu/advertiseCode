package com.cg.onlineadvapi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * This class is used to enable Swagger2 and configure info of the api
 * documentation
 * 
 * @author mohdansa
 *
 */
@EnableSwagger2
@Configuration
public class SwaggerConfiguration {
	@Bean
	public Docket productApi() {
		// Configure Swagger and return Docket instace
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.cg.onlineadvapi.web"))
				.paths(PathSelectors.regex("/api.*")).build();
	}

}

