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

import com.sun.el.stream.Optional;
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
		roles.add(new SimpleGrantedAuthority(us.getUserRole().get(0).getRole().getRoleName()));
		System.out.println("-------------------> "+us.getUserRole().get(0).getRole().getRoleName());
		UserDetails userDetails=new User(us.getUserName(),us.getPassword(),roles);
		return userDetails;
	}
	
	public int getIdUser(String name) {
		return userRepository.findByUserName(name).getIdUser();
	}
}
