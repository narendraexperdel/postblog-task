package com.example.post.repository;

import java.util.List;

import com.example.post.model.Post;

public interface PostCustomRepository {
   
	List<Post> gettopfivePost();
	
	List<Post> postbySearch(String search);
	
	List<Post> findAllPostByuserId(Integer userid);
}
