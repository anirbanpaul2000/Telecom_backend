package com.stl.telecom.web.application.JWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.stl.telecom.web.application.dao.UserRepository;
import com.stl.telecom.web.application.model.TeleUser;

@Service 
public class SignupDetailsService implements UserDetailsService{

	
	@Autowired
	UserRepository repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		TeleUser model=repo.findByMobileNo(username);
		return new SignupDetails(model);
	}

}
