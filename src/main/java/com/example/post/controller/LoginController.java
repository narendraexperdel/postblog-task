package com.example.post.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.post.model.User;
import com.example.post.repository.UserRepository;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200")
public class LoginController {
	
	@Autowired
	UserRepository userRepository;
	
	Map<String, Object> response = new HashMap<>();
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public  ResponseEntity login(@RequestBody User user){
		
		User validateuser = userRepository.findByEmail(user.getEmail());
		if( validateuser != null ) {
			if(user.getPassword().equals(validateuser.getPassword())) {
				response.put("code", HttpStatus.OK);
				response.put("msg", "Login Successful.");
				response.put("data", validateuser);
				
				return ResponseEntity.status(HttpStatus.OK).body(response);
			}else {
				response.put("code", HttpStatus.BAD_REQUEST);
				response.put("msg", "Username OR Password is Incorrect. please try again");
				response.put("data", user);
				
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
		}else {
			response.put("code", HttpStatus.BAD_REQUEST);
			response.put("msg", "You are not Registered User.");
			response.put("data", user);
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
		}
	}

}
