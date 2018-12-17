package com.example.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.post.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>, CommentCustomRepository{

}
