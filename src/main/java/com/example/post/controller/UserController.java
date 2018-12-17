package com.example.post.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.post.bean.UserBean;
import com.example.post.model.User;
import com.example.post.repository.UserRepository;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	Map<String,Object> response = new HashMap<>();
	
	@PostMapping("user")
	public ResponseEntity<Object> saveUser(@RequestBody UserBean userBean) {
		
		User checkuser = userRepository.findByEmail(userBean.getEmail());
		if(checkuser != null) {
			response.put("code", HttpStatus.CONFLICT);
			response.put("msg", "User with this EmailId is already exists. please sign up with another EmailId");
			response.put("data", userBean);
			
			return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
		}else {
			if(userBean.getPassword().equals(userBean.getConfirmPass())) {
				User user = userRepository.prepareUserModel(userBean);
				User newuser = userRepository.save(user);
				response.put("code", HttpStatus.CREATED);
				response.put("msg", "User Registration successfully");
				response.put("data", newuser);
				return ResponseEntity.status(HttpStatus.CREATED).body(response);
			}else {
				response.put("code", HttpStatus.BAD_REQUEST);
				response.put("msg", "Password and Confirm Password Not Matched");
				response.put("data",userBean);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}

		}
		
	}
	
	@GetMapping("user/{id}")
	public ResponseEntity<Object> getUserbyId(@PathVariable Integer id){
		
		Optional<User> user = userRepository.findById(id);
		
		response.put("code", HttpStatus.OK);
		response.put("msg", "User detail by Id");	
		response.put("data", user);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
