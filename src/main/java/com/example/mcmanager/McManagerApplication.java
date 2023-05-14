package com.example.mcmanager;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.mcmanager.mapper")
public class McManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(McManagerApplication.class, args);
	}

}
