package com.vooting.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vooting.Repository.UserRepo;
import com.vooting.model.UserModel;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserModel user = userRepo.findByUsername(username);

		if (user != null) {
			return new CustomUserDetails(user);
		}

		throw new UsernameNotFoundException("user not available");
	}

}
