package com.doux.managementspringbootAzureSql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ManagementSpringbootAzureSqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ManagementSpringbootAzureSqlApplication.class, args);
	}

}
