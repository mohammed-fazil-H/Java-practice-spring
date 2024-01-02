package com.example.demo.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder password()
	{
		return new BCryptPasswordEncoder();
	}
	@Bean
	public UserDetailsService userCreditial()
	{
		UserDetails adminCreditials = User.withUsername("Admin").password(password().encode("reset@123")).roles("ADMIN").build();
		UserDetails customerCreditials = User.withUsername("Customer").password(password().encode("reset@123")).roles("CUSTOMER").build();
		InMemoryUserDetailsManager myUserDetails = new InMemoryUserDetailsManager(adminCreditials,customerCreditials);
		return myUserDetails;
	}
	
	@Bean
	public SecurityFilterChain mySecurityConfig(HttpSecurity hs) throws Exception
	{
		hs.csrf().disable()
		.authorizeHttpRequests()
//		.requestMatchers("/admin")
//		.hasRole("ADMIN")
//		.requestMatchers("/customer")
//		.hasRole("CUSTOMER")
//		.requestMatchers("/public")
//		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin();
		return hs.build();		
	}

}
