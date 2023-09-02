package com.cydercode.oracledemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
public class OracleDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(OracleDemoApplication.class, args);
	}

}
