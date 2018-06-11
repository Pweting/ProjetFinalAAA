package com.springboot.pkg.configuration;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.springboot.pkg.service.CustomUserDetailService;

public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	DataSource dataSource;
	
	@Autowired
	CustomUserDetailService customUserDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/hello", "/sec/welcome").permitAll().antMatchers("/sec/secure")
				.authenticated().and().httpBasic();
		http.csrf().disable();
		http.headers().frameOptions().disable();
	}
}


