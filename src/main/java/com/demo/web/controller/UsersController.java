package com.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.cqrs.c.service.UserService;
import com.demo.cqrs.q.service.UsersQueryService;
import com.matrix.view.CommonVO;

@RestController
@RequestMapping("/users")
public class UsersController {

	@Autowired
	private UserService userService;

	@Autowired
	private UsersQueryService usersQueryService;

	@RequestMapping("/createuser")
	@ResponseBody
	public CommonVO createuser(String userId, String userName) {
		CommonVO vo = new CommonVO();
		userService.createUser(userId);
		usersQueryService.afterCreateUser(userId, userName);
		return vo;
	}

}
