package com.stl.telecom.web.application.JWT;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.stl.telecom.web.application.model.TeleUser;

@Component
public class SignupDetails implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	TeleUser tu;
	
	public SignupDetails(TeleUser tu) {
		super();
		this.tu=tu;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		return Collections.singleton(new SimpleGrantedAuthority("teleuser"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return tu.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return tu.getContactNumber();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
