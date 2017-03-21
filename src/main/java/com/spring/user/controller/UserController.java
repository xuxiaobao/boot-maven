package com.spring.user.controller;

import com.spring.user.pojo.User;
import com.spring.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	@ResponseBody
    public Object greeting() {
		User u = userService.getById(1);
		
		System.out.println(u.getPassword());
        return u;
    }

    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public Object updateUserById(@RequestBody User user) {
		Map<String, Object> map = new HashMap<String, Object>();
		int i = userService.updateUserById(user);
		if (i > 0) {
			map.put("s", "s");
		} else {
			map.put("s", "f");
		}
		return map;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public Object findUserByCondition(@RequestBody User user) {
		List<User> li = userService.findUserByCondition(user);
		return li;
	}
}
