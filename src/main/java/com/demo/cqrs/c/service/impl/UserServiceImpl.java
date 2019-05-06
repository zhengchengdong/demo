package com.demo.cqrs.c.service.impl;

import com.demo.cqrs.c.domain.User;
import com.demo.cqrs.c.domain.UserRepository;
import com.demo.cqrs.c.service.UserService;

public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Override
	public void createUser(String userId) {
		User user = new User();
		user.setId(userId);
		userRepository.putUser(user);
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public String deleteUser(String userId) {
		return userRepository.deleteUser(userId);
	}

}
