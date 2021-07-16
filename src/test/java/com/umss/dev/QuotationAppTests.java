package com.umss.dev;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.umss.dev.entity.UserSis;
import com.umss.dev.repository.UserRepository;

@SpringBootTest
class QuotationAppTests {

	@Autowired
	private BCryptPasswordEncoder encoder;
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void createUser() {
		UserSis newUser=new UserSis();
		newUser.setName("Mathias");
		newUser.setUserName("Admin");
		newUser.setEmail("admin@gmail.com");
		newUser.setPassword(encoder.encode("123qwe"));
        System.out.println("The password's user is "+ newUser.getPassword());
		newUser.setRegistrationDate(LocalDate.now());
		UserSis saveUser=userRepository.save(newUser);
		assertTrue(saveUser.getPassword().equalsIgnoreCase(newUser.getPassword()));
	}

}
