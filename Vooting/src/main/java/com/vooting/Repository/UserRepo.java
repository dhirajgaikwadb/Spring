package com.vooting.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

import com.vooting.model.UserModel;

public interface UserRepo extends JpaRepository<UserModel, Integer> {

	public boolean existsByEmail(String email);

	public UserModel findByUsername(String username);

}