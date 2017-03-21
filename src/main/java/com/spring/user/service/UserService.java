package com.spring.user.service;

import com.spring.user.pojo.User;

import java.util.List;

public interface UserService {

	public User getById(long userId);

	public int updateUserById(User user);

	public List<User> findUserByCondition(User user);
}
