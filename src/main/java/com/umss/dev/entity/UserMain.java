package com.umss.dev.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserMain implements UserDetails {
	private String name;
	private String UserName;
	private String email;
	private String password;
	private Collection<? extends GrantedAuthority> authority;
	
	
	
	public UserMain(String name, String userName, String email, String password,
			Collection<? extends GrantedAuthority> authority) {
		super();
		this.name = name;
		UserName = userName;
		this.email = email;
		this.password = password;
		this.authority = authority;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authority;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return UserName;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public static UserMain build(UserSis user) {
		List grantList = new ArrayList();
		 GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getUserRole().get(0).getRole().getRoleName());
         grantList.add(grantedAuthority);
		return new UserMain(user.getName(), user.getUserName(), user.getEmail(),user.getPassword(), grantList);
		
	} 
}
