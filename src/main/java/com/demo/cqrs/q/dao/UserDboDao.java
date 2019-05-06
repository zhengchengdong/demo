package com.demo.cqrs.q.dao;

import com.demo.cqrs.q.dbo.UserDbo;

public interface UserDboDao {

	void save(UserDbo userDbo);

	UserDbo findById(String id);

}
