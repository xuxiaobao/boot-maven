package com.spring.user.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.user.dao.UserMapper;
import com.spring.user.pojo.User;
import com.spring.user.service.UserService;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Resource
	private UserMapper userMapper;
	public User getById(long userId) {
		/*User user = new User();
		user.setPassword("111111");
		user.setUserId(1L);
		user.setUserName("abc");*/
		User user = userMapper.getById(userId);
		return user;
	}

	public int updateUserById(User user) {
		return userMapper.updateById(user);
	}

	public List<User> findUserByCondition(User user) {
		return userMapper.findUserByCondition(user);
	}
}
