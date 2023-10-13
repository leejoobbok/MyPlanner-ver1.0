package com.springboot.project.myplanner1;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@MapperScan("com.springboot.project.myplanner1.dao")
public class Myplanner1Application {

	public static void main(String[] args) {
		SpringApplication.run(Myplanner1Application.class, args);
	}

}
