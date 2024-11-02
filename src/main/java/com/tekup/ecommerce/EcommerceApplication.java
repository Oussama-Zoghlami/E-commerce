package com.tekup.ecommerce;

import com.tekup.ecommerce.entities.Role;
import com.tekup.ecommerce.entities.User;
import com.tekup.ecommerce.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@SpringBootApplication
public class EcommerceApplication implements CommandLineRunner {
	@Autowired
	private UserRepo userRepo;

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApplication.class, args);
	}


	public void run(String... args) {
		List<User> adminAccount = userRepo.findByRole(Role.ADMIN);
		if (adminAccount.isEmpty()) {
			User user = new User();

			user.setEmail("admin@gmail.com");
			user.setFirstname("admin");
			user.setLastname("admin");
			user.setRole(Role.ADMIN);
			user.setPassword(new BCryptPasswordEncoder().encode("admin"));
			userRepo.save(user);

		}

	}
}