package com.spring.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.account.pojo.Account;
import com.spring.account.service.AccountService;

@Controller
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private AccountService accountService;
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ModelAndView greeting(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("account/index"); 
		Account a = accountService.getAccountById(id);
		mv.addObject("account", a);
        return mv;
    }
}
