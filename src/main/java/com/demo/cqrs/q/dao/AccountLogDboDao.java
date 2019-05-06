package com.demo.cqrs.q.dao;

import java.util.List;

import com.demo.cqrs.q.dbo.AccountLogDbo;

public interface AccountLogDboDao {

	void save(AccountLogDbo accountLogDbo);

	List<AccountLogDbo> findAllByAccountId(String accountId);

}
