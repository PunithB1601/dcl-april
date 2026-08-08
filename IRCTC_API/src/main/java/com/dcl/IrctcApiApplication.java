package com.dcl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class IrctcApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(IrctcApiApplication.class, args);
	}

}
