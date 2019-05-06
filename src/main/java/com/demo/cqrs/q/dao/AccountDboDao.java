package com.demo.cqrs.q.dao;

import com.demo.cqrs.q.dbo.AccountDbo;

public interface AccountDboDao {

	void save(AccountDbo accountDbo);

	AccountDbo findById(String id);

}
