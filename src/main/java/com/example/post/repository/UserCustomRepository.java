package com.example.post.repository;

import com.example.post.bean.UserBean;
import com.example.post.model.User;

public interface UserCustomRepository {

	User prepareUserModel(UserBean userBean);
}
