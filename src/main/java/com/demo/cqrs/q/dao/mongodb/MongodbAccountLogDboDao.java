package com.demo.cqrs.q.dao.mongodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.cqrs.q.dao.AccountLogDboDao;
import com.demo.cqrs.q.dao.mongodb.repository.AccountLogDboRepository;
import com.demo.cqrs.q.dbo.AccountLogDbo;

@Component
public class MongodbAccountLogDboDao implements AccountLogDboDao {

	@Autowired
	private AccountLogDboRepository repository;

	@Override
	public void save(AccountLogDbo accountLogDbo) {
		repository.save(accountLogDbo);
	}

	@Override
	public List<AccountLogDbo> findAllByAccountId(String accountId) {
		return repository.findAllByAccountId(accountId);
	}

}
