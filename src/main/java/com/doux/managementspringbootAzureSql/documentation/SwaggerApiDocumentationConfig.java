package com.doux.managementspringbootAzureSql.documentation;

import java.lang.annotation.Annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Component
public class SwaggerApiDocumentationConfig {
	
	@Bean
	public Docket getDocumentation() {
		return new Docket(DocumentationType.SWAGGER_2).groupName("PublicApi's").apiInfo(getApiInfo()).select().apis(RequestHandlerSelectors.withClassAnnotation((Class<? extends Annotation>) RestController.class)).build();
	}
	
	private ApiInfo getApiInfo() {
		return new ApiInfoBuilder().title("Student Api's").description("Api's to manage students data of doux systems institute").version("1.0").build();
	}

}
