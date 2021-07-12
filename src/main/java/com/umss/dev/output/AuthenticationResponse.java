package com.umss.dev.output;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;

public class AuthenticationResponse {

	private String jwt;
	Collection<? extends GrantedAuthority> roles;

	public AuthenticationResponse(String jwt) {
		this.jwt = jwt;
	}

	
	public AuthenticationResponse(String jwt, Collection<? extends GrantedAuthority> roles) {
		super();
		this.jwt = jwt;
		this.roles = roles;
	}



	public Collection<? extends GrantedAuthority> getRoles() {
		return roles;
	}



	public void setRoles(Collection<? extends GrantedAuthority> roles) {
		this.roles = roles;
	}



	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
}
