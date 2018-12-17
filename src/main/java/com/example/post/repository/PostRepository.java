package com.example.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.post.model.Post;

public interface PostRepository extends JpaRepository<Post, Integer>, PostCustomRepository{
	
	
}
