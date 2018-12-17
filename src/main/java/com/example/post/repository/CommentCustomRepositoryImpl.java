package com.example.post.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import com.example.post.model.Comment;

public class CommentCustomRepositoryImpl implements CommentCustomRepository{
    
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Comment> allCommentbyPost(Integer postid) {
		Criteria criteria = entityManager.unwrap(Session.class).createCriteria(Comment.class);
		criteria.add(Restrictions.eq("postid.id", postid));
		return criteria.list();
	}

}
