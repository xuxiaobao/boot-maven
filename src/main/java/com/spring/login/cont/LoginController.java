package com.spring.login.cont;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.user.pojo.User;
import com.spring.user.service.UserService;

@RestController
public class LoginController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
    public Object login(HttpServletRequest request) {
		User u = userService.getById(1);
		
		HttpSession session = request.getSession();
		session.setAttribute("admin", u);
		session.setMaxInactiveInterval(28800);
		return new ModelAndView("redirect:/account/1");
    }
}
