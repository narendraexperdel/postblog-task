package com.example.post.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

import com.example.post.model.Comment;
import com.example.post.repository.CommentRepository;

@RestController
@RequestMapping("/api/")
@CrossOrigin(origins = "http://localhost:4200")
public class CommentController {
	
	@Autowired
	CommentRepository commentRepository;
	
	Map<String, Object> response = new HashMap<>();

	@PostMapping("comment")
	public ResponseEntity<Object> saveComment(@RequestBody Comment comment){
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		comment.setCommentdatetime(dateFormat.format(date));
		Comment newcomment = commentRepository.save(comment);
		
		response.put("code", HttpStatus.CREATED);
		response.put("msg", "Comment created successfully");
		response.put("data", newcomment);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	@GetMapping("comment/post/{postid}")
	public ResponseEntity<Object> commentslistbyPost(@PathVariable Integer postid){
		
		List<Comment> commentlist =commentRepository.allCommentbyPost(postid);
		
		response.put("code", HttpStatus.OK);
		response.put("msg", "All Comment List");
		response.put("data", commentlist);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
