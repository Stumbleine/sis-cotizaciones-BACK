package com.umss.dev.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.umss.dev.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
}
