package com.demo.cqrs.q.dao.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.cqrs.q.dbo.AccountDbo;

public interface AccountDboRepository extends MongoRepository<AccountDbo, String> {

}
