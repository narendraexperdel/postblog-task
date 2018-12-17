package com.example.post.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import com.example.post.bean.UserBean;
import com.example.post.model.User;

public class UserRepositoryImpl implements UserCustomRepository {

	@Override
	public User prepareUserModel(UserBean userBean) {
		User user = new User();
		if(userBean != null) {
			user.setFirstname(userBean.getFirstname());
			user.setLastname(userBean.getLastname());
			user.setEmail(userBean.getEmail());
			user.setPassword(userBean.getPassword());
			user.setCity(userBean.getCity());
		}
		return user;
	}

}
