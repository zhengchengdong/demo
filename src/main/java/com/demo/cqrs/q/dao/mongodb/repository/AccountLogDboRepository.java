package com.demo.cqrs.q.dao.mongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.cqrs.q.dbo.AccountLogDbo;

public interface AccountLogDboRepository extends MongoRepository<AccountLogDbo, String> {

	List<AccountLogDbo> findAllByAccountId(String accountId);

}
