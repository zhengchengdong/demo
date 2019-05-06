package com.demo.cqrs.q.dao.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.demo.cqrs.q.dbo.UserDbo;

public interface UserDboRepository extends MongoRepository<UserDbo, String> {

}
