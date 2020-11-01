package com.tlc.tracker.security.service;

import com.tlc.tracker.security.model.UserSecurity;
import com.tlc.tracker.security.repository.UserRepositorySecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.Optional;

public class UserServiceSecurity implements UserDetailsService {

	@Autowired
	private UserRepositorySecurity userRepositorySecurity;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<UserSecurity> userSecurity = userRepositorySecurity.findByEmail(email);

		if(userSecurity.isPresent()) throw new UsernameNotFoundException("Wrong credentials");

		return new User(userSecurity.get().getEmail(), userSecurity.get().getPassword(), new ArrayList<>());
	}
}
