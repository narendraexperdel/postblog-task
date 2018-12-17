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

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "PostDetail")
public class Post  implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "Id")
	private Integer id;
	
	@Column(name = "PostTitle", unique = true)
	private String posttitle;
	
	@Column(name = "PostDesc")
	private String postdesc;
	
	@Column(name = "PostDateTime")
	private String postdatetime;
	
	@Column(name = "PostStatus")
	private int poststatus;
	
	@ManyToOne
	@JoinColumn(name = "PostUserId")
	private User postuserid;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPosttitle() {
		return posttitle;
	}

	public void setPostitle(String posttitle) {
		this.posttitle = posttitle;
	}

	public String getPostdesc() {
		return postdesc;
	}

	public void setPostdesc(String postdesc) {
		this.postdesc = postdesc;
	}

	public String getPostdatetime() {
		return postdatetime;
	}

	public void setPostdatetime(String postdatetime) {
		this.postdatetime = postdatetime;
	}

	public int getPoststatus() {
		return poststatus;
	}

	public void setPoststatus(int poststatus) {
		this.poststatus = poststatus;
	}

	public User getPostuserid() {
		return postuserid;
	}

	public void setPostuserid(User postuserid) {
		this.postuserid = postuserid;
	}	

}
