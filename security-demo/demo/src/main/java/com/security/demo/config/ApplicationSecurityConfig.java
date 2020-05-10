package com.security.demo.config;

import static com.security.demo.config.ApplicationUserRole.ADMIN;
import static com.security.demo.config.ApplicationUserRole.ADMINTRAINEE;
import static com.security.demo.config.ApplicationUserRole.STUDENT;
import static com.security.demo.config.ApplicationUserPermission.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/","index","/css/*","/js/*").permitAll()
			.antMatchers("/api/**").hasRole(STUDENT.name())
			.antMatchers(HttpMethod.DELETE, "/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
			.antMatchers(HttpMethod.POST, "/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
			.antMatchers(HttpMethod.PUT, "/management/api/**").hasAuthority(COURSE_WRITE.getPermission())
			.antMatchers("/management/api/**").hasAnyRole(ADMIN.name(), ADMINTRAINEE.name())
			.anyRequest()
			.authenticated()
			.and()
			.httpBasic();
	}

	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		
		UserDetails sathyaUser = User.builder()
				.username("sathya")
				.password(passwordEncoder.encode("sathya"))
				//.roles(ADMINTRAINEE.name())
				.authorities(ADMINTRAINEE.getGrantedAuthorities())
				.build();
		
		UserDetails rajUser = User.builder()
				.username("raj")
				.password(passwordEncoder.encode("raj"))
				//.roles(ApplicationUserRole.ADMIN.name())
				.authorities(ADMIN.getGrantedAuthorities())
				.build();
		
		
		
		UserDetails sanjUser = User.builder()
				.username("sanj")
				.password(passwordEncoder.encode("sanj"))
				//.roles(ApplicationUserRole.STUDENT.name())
				.authorities(STUDENT.getGrantedAuthorities())
				.build();
		
		return new InMemoryUserDetailsManager(rajUser,sathyaUser,sanjUser);
	}
}
