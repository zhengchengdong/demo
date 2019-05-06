package com.demo.cqrs.q.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.cqrs.q.dao.UserDboDao;
import com.demo.cqrs.q.dbo.UserDbo;

@Component
public class UsersQueryService {

	@Autowired
	private UserDboDao userDboDao;

	public void afterCreateUser(String userId, String userName) {
		UserDbo userDbo = new UserDbo();
		userDbo.setId(userId);
		userDbo.setName(userName);
		userDboDao.save(userDbo);
	}

}
