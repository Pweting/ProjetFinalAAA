package com.springboot.pkg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.pkg.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {

	@Query("select ur from UserRole ur where ur.user.username=:var")
	List<String> findCustomRoleByUsername(@Param("var") String username);
}