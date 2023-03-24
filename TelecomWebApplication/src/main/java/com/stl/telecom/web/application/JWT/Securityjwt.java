package com.stl.telecom.web.application.JWT;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class Securityjwt implements Serializable{
	private static final long serialVersionUID = 1L;
	final  String  key="9z$C&F)J@NcQfTjWnZr4u7x!A%D*G-KaPdSgUkXp2s5v8y/B?E(H+MbQeThWmYq3";
     final  long exptime= 1000 * 60 * 60 * 10;
	
	public String generatetoken(SignupDetails details) {
		Map<String, Object> claims=new HashMap<>();
		
		return Jwts.builder().setClaims(claims)
				.setSubject(details.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis()+exptime))
				.signWith(SignatureAlgorithm.HS512, key)
				.compact();
	}
	
	
	public String getUsername(String token) {
		return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();
	}
	
	
	public Boolean ValidToken(String token, SignupDetails details) {
		Boolean validation=Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody()
				.getExpiration().before(new Date(System.currentTimeMillis()));
	
		return ((details.getUsername()).equals(getUsername(token))
				&& !validation);
	}
}
