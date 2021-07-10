package com.umss.dev.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.umss.dev.entity.UserSis;
import com.umss.dev.repository.UserRepository;

@Service
public class PruebaUserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserSis us= userRepository.findByUserName(username);
		
		List <GrantedAuthority> roles=new ArrayList<>();
		roles.add(new SimpleGrantedAuthority("ADMIN"));
		UserDetails userDetails=new User(us.getUserName(),us.getPassword(),roles);
		return userDetails;
	}

}
