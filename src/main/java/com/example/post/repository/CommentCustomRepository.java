package com.example.post.repository;

import java.util.List;

import com.example.post.model.Comment;

public interface CommentCustomRepository {
	
	List<Comment> allCommentbyPost(Integer postid);
}
