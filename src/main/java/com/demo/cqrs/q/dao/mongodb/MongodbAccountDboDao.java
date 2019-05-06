package com.demo.cqrs.q.dao.mongodb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.cqrs.q.dao.AccountDboDao;
import com.demo.cqrs.q.dao.mongodb.repository.AccountDboRepository;
import com.demo.cqrs.q.dbo.AccountDbo;

@Component
public class MongodbAccountDboDao implements AccountDboDao {

	@Autowired
	private AccountDboRepository repository;

	@Override
	public void save(AccountDbo accountDbo) {
		repository.save(accountDbo);
	}

	@Override
	public AccountDbo findById(String id) {
		return repository.findById(id).get();
	}

}
