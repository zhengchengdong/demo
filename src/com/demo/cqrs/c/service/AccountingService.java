package com.demo.cqrs.c.service;

import com.demo.cqrs.c.service.result.TransferResult;

public interface AccountingService {
	TransferResult transfer(String fromAccountId, String toAccountId, Integer amount) throws Exception;
}
