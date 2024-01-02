package com.example.demo.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityService {
	
	@Autowired
	private UserDetailsService userdetailservice;
	
	
	@Bean
	public SecurityFilterChain securityFilterChain() {
		return
	}

}
