package com.example.post.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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

import com.example.post.model.Post;
import com.example.post.repository.PostRepository;
import com.example.post.repository.UserRepository;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {
	
	@Autowired
	PostRepository postRepository;
	
	@Autowired
	UserRepository userRepository;
	
	Map<String,Object> response = new HashMap<>();
	
	@PostMapping("post")
	public ResponseEntity<Object> savePost(@RequestBody Post post){
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		post.setPostdatetime(dateFormat.format(date));
		post.setPoststatus(2);
		
		
		Post newpost = postRepository.save(post);
		response.put("code", HttpStatus.CREATED);
		response.put("msg", "Post created Successfully");
		response.put("data", newpost);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("post")
	public ResponseEntity<Object> getAllPost(){
		
		List<Post> posts =postRepository.findAll();
		
		response.put("code", HttpStatus.OK);
		response.put("msg", " All Post list");
		response.put("data", posts);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("post/{id}")
	public ResponseEntity<Object> getAllPost(@PathVariable Integer id){
		
		Optional<Post> post = postRepository.findById(id);
		
		response.put("code", HttpStatus.OK);
		response.put("msg", "Post detail by Id");
		response.put("data", post);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@GetMapping("topfivepost")
	public ResponseEntity<Object> getTopfivePost(){
		
		List<Post> latestpost = postRepository.gettopfivePost();
		response.put("code", HttpStatus.OK);
		response.put("msg", "Top 5 Post");
		response.put("data", latestpost);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PostMapping("searchpost")
	public ResponseEntity<Object> getpostonSearch(@RequestBody String search){
		
		List<Post> posts = postRepository.postbySearch(search);
		response.put("code", HttpStatus.OK);
		response.put("msg", "Post By Searching");
		response.put("data", posts);
		return ResponseEntity.status(HttpStatus.OK).body(response);
		
	}
	
	@GetMapping("post/user/{userid}")
	public ResponseEntity<Object> getAllPostbyId(@PathVariable Integer userid){
		 
		List<Post> posts = postRepository.findAllPostByuserId(userid);
		
		response.put("code", HttpStatus.OK);
		response.put("msg", "PostList By Userid");
		response.put("data", posts);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	
	
	
}
