package com.vooting.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.vooting.Repository.UserRepo;
import com.vooting.model.UserModel;

@Service
public class vootservice {

	@Autowired
	private UserRepo repo;

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	public UserModel saveData(UserModel userm) {
		userm.setPasscode(passwordEncoder.encode(userm.getPasscode()));
		userm.setRole("ROLE_USER");
		return repo.save(userm);
	}

	public boolean checkEmail(String email) {
		return repo.existsByEmail(email);
	}

}