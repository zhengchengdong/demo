package com.demo.cqrs.c.service.disruptor;

import com.demo.cqrs.c.service.AccountingService;
import com.demo.cqrs.c.service.impl.AccountingServiceImpl;
import com.demo.cqrs.c.service.result.TransferResult;

public class DisruptorAccountingService implements AccountingService {

	private AccountingServiceImpl accountingServiceImpl;

	@Override
	public TransferResult transfer(String fromAccountId, String toAccountId, Integer amount) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
