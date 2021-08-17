package com.bedir.securitydemo;

import com.bedir.securitydemo.service.Dto.UserDto;
import com.bedir.securitydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityDemoApplication implements CommandLineRunner {

	@Autowired
	private UserService service;

	public static void main(String[] args) {
		SpringApplication.run(SecurityDemoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		UserDto user = new UserDto(5L,"bedir","bedir");
		service.save(user);
	}
}
