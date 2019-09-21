package com.cmcoding.cmcodingbackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.cmcoding")
public class CmCodingBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CmCodingBackendApplication.class, args);
	}

}
