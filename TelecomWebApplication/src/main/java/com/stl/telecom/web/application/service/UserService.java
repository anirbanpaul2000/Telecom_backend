package com.stl.telecom.web.application.service;
import com.stl.telecom.web.application.model.TeleUser;


public interface UserService {

	public TeleUser saveUser(TeleUser user);
		
	public TeleUser getById(Integer id);

}