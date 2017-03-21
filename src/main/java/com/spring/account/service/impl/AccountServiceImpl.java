package com.spring.account.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.spring.account.dao.AccountMapper;
import com.spring.account.pojo.Account;
import com.spring.account.service.AccountService;

@Service("accountService")
public class AccountServiceImpl implements AccountService {

	@Resource
	private AccountMapper accountMapper;
	
	public Account getAccountById(Integer id) {
		
		return accountMapper.getAccountById(id);
	}

}
