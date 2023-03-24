package com.stl.telecom.web.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.stl.telecom.web.application.dao.UserRepository;
import com.stl.telecom.web.application.model.TeleUser;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

   @Transactional
	@Override
	public TeleUser saveUser(TeleUser user) {
	
		return userRepository.save(user);
	}
   
   @Override
   public TeleUser getById(Integer id) {
	   return userRepository.findById(id).get();
   }
}
