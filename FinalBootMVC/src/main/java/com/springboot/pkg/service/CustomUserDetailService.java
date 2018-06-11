package com.springboot.pkg.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.springboot.pkg.model.User;
import com.springboot.pkg.repository.UserRepository;
import com.springboot.pkg.repository.UserRoleRepository;

public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserRoleRepository userRoleRepository;

	@Override
	public UserDetails loadUserByUsername(String arg0) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(arg0);
		if (user == null) {
			throw new UsernameNotFoundException("Utilisateur inconnu");
		}

		return new CustomUserDetails(user, userRoleRepository.findCustomRoleByUsername(arg0));
	}
}