package com.stl.telecom.web.application.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stl.telecom.web.application.JWT.Securityjwt;
import com.stl.telecom.web.application.dao.UserRepository;
import com.stl.telecom.web.application.model.TeleUser;
import com.stl.telecom.web.application.service.UserLoginService;



@RestController
@RequestMapping("/user")
@CrossOrigin(origins="http://localhost:4200")
public class TeleUserController {

	@Autowired
	private UserLoginService userLoginService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private Securityjwt jwtUtil;
	
	@PostMapping("/register")
	public String createUser(@RequestBody TeleUser userLogin) {
		userLoginService.register(userLogin);
		return "Registered Successfully";
		
	}
	
	@PostMapping("/login")
	public ResponseEntity<String> loginUser(@RequestBody TeleUser userLogin) throws Exception {
		String Add=userLoginService.login(userLogin);
		return  ResponseEntity.ok(Add);

	}
	
	@GetMapping("/all")
	public List<TeleUser> getAllUsers(){
		return userRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<TeleUser> getUserById(@PathVariable("id") String id) {
		TeleUser user=userRepository.findByMobileNo(jwtUtil.getUsername(id));
		return ResponseEntity.ok().body(user);
	}
}

