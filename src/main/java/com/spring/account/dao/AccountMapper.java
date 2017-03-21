package com.spring.account.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.spring.account.pojo.Account;

@Mapper
public interface AccountMapper {

	@Select("select * from account where id=#{id}")
	public Account getAccountById(Integer id);
}
