package com.springboot.pkg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.pkg.model.User;

public interface UserRepository extends JpaRepository<User, String> {
	User findByUsername(String username);
}
