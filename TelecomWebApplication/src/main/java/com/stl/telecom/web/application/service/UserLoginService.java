package com.stl.telecom.web.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.stl.telecom.web.application.JWT.Securityjwt;
import com.stl.telecom.web.application.JWT.SignupDetails;
import com.stl.telecom.web.application.dao.UserRepository;
import com.stl.telecom.web.application.model.TeleUser;


@Component
@Service
public class UserLoginService {

	
	@Autowired
	UserRepository repo;
	
	@Autowired
	AuthenticationManager authmanager;
	
	@Autowired
	Securityjwt utils;
	
	
	
	public String register(TeleUser user) {
		BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
		user.setPassword(encoder.encode(user.getPassword()));
		repo.save(user);
		return "added";
	}
	
	public String login(TeleUser user) {
		try {
			Authentication auth=authmanager.authenticate(new UsernamePasswordAuthenticationToken(user.getContactNumber(), user.getPassword()));
			
			if(auth.isAuthenticated()) {
				SignupDetails details=new SignupDetails(user);
				
				return utils.generatetoken(details);
			}
			return "User not authenticated";
		}
		catch(BadCredentialsException e) {
			
			return "phone no or password does not match.";
		}
		catch(Exception er) {
			return "there is an error";
		}
	}
	
	
}
