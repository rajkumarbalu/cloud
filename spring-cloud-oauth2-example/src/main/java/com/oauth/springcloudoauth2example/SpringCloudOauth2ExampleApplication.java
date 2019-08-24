package com.oauth.springcloudoauth2example;

import java.security.Principal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableOAuth2Sso
@RestController
public class SpringCloudOauth2ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudOauth2ExampleApplication.class, args);
	}
	
	@GetMapping("/")
	public String message(Principal principal) {
		return "<h4>Hi "+principal.getName()+", Welcome to oauth 2 integration with github </h4>";
	}

}
