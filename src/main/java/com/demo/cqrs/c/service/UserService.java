package com.demo.cqrs.c.service;

public interface UserService {
	void createUser(String userId);

	String deleteUser(String userId);
}
