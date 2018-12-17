package com.example.post.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
  
  /* App Testing*/

@RestController
public class AppTestController {

	 @GetMapping("/")
	public String checkingApp() {
		return "Post Blog is Running";
	}
}
