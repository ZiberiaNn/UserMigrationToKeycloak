package com.lotrading.usersmigration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.lotrading.usersmigration.service.UserService;

@SpringBootApplication
public class UsersMigrationApplication implements CommandLineRunner {
	@Autowired
	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(UsersMigrationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		userService.createAllUsersInKeycloak();
	}
}
