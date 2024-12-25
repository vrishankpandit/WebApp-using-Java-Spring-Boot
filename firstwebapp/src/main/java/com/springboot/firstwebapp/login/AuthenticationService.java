package com.springboot.firstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	public boolean auth(String username,String password) {
		boolean isUsername=username.equalsIgnoreCase("Vrishank");
		boolean isPassword=password.equalsIgnoreCase("Vrishank");
		
		return isUsername && isPassword;
	}
}
