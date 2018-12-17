package com.example.post.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.post.bean.UserBean;
import com.example.post.model.User;

public interface UserRepository extends JpaRepository<User, Integer>, UserCustomRepository{

	User findByEmail(String email);

}
