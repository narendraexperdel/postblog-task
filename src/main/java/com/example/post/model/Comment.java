package com.example.post.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PostComments")
public class Comment  implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "PostComments")
	private String postcomments;
	
	@ManyToOne
	@JoinColumn(name = "CommentUserId")
	private User commentuserid;
	
	@ManyToOne
	@JoinColumn(name = "PostId")
	private Post postid;
	
	@Column(name = "CommentDateTime")
	private String commentdatetime;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPostcomments() {
		return postcomments;
	}

	public void setPostcomments(String postcomments) {
		this.postcomments = postcomments;
	}

	public User getCommentuserid() {
		return commentuserid;
	}

	public void setCommentuserid(User commentuserid) {
		this.commentuserid = commentuserid;
	}

	public Post getPostid() {
		return postid;
	}

	public void setPostid(Post postid) {
		this.postid = postid;
	}

	public String getCommentdatetime() {
		return commentdatetime;
	}

	public void setCommentdatetime(String commentdatetime) {
		this.commentdatetime = commentdatetime;
	}

}
