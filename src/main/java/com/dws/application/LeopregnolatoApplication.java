package com.dws.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
@EnableCaching
public class LeopregnolatoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LeopregnolatoApplication.class, args);
	}

}
