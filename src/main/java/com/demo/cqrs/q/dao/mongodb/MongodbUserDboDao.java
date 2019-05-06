package com.demo.cqrs.q.dao.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.cqrs.q.dao.UserDboDao;
import com.demo.cqrs.q.dao.mongodb.repository.UserDboRepository;
import com.demo.cqrs.q.dbo.UserDbo;

@Component
public class MongodbUserDboDao implements UserDboDao {

	@Autowired
	private UserDboRepository repository;

	@Override
	public void save(UserDbo userDbo) {
		repository.save(userDbo);
	}

	@Override
	public UserDbo findById(String id) {
		return repository.findById(id).get();
	}

}
