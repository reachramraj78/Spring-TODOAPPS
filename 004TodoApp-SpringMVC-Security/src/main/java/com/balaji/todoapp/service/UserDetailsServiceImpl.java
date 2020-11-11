package com.balaji.todoapp.service;

import java.util.Arrays;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.println("Getting access details from employee dao !!");
		UserDetails user = new User(username, "balaji", true, true, true, true,
				Arrays.asList(new GrantedAuthority[] { new SimpleGrantedAuthority("ROLE_USER") }));
		return user;
	}

}
