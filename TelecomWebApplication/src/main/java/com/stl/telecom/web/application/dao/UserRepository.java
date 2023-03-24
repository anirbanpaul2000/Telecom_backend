package com.stl.telecom.web.application.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.stl.telecom.web.application.model.TeleUser;


public interface UserRepository extends JpaRepository<TeleUser, Serializable>{

	TeleUser findByUsername(String username);
	
	
	@Query(value="select * from teleuser s where contact_number=?1", nativeQuery=true)
	TeleUser findByMobileNo(String contact_number);
}
