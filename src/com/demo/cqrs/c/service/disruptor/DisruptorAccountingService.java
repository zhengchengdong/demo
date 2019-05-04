package com.demo.cqrs.c.service.disruptor;

import com.demo.cqrs.c.service.AccountingService;
import com.demo.cqrs.c.service.impl.AccountingServiceImpl;
import com.demo.cqrs.c.service.result.TransferResult;
import com.matrix.disruptor.DisruptorServiceBase;

public class DisruptorAccountingService extends DisruptorServiceBase implements AccountingService {

	DisruptorAccountingService(AccountingServiceImpl accountingServiceImpl) {
		super(accountingServiceImpl);
		this.accountingServiceImpl = accountingServiceImpl;
	}

	private AccountingServiceImpl accountingServiceImpl;

	@Override
	public TransferResult transfer(String fromAccountId, String toAccountId, Integer amount) throws Exception {
		return executeFunction(DisruptorNames.accounting.name(), () -> {
			return accountingServiceImpl.transfer(fromAccountId, toAccountId, amount);
		});
	}

}
