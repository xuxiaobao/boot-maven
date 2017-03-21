package com.spring.user.dao;

import org.apache.ibatis.annotations.*;

import com.spring.user.pojo.User;

import java.util.List;

@Mapper
public interface UserMapper {

	@Select("select * from user where id=#{userId}")
	public User getById(long userId);

	@SelectProvider(type = UserSql.class, method = "getUserSql")
	@Results({
			@Result(column = "id", property = "userId")
	})
	public List<User> findUserByCondition(User user);

	@Update("update user set username = #{userName} where id = #{userId}")
	public int updateById(User user);
}
