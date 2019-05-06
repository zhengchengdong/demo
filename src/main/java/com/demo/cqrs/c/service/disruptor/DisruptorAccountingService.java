package com.demo.cqrs.c.service.disruptor;

import com.demo.cqrs.c.service.AccountingService;
import com.demo.cqrs.c.service.impl.AccountingServiceImpl;
import com.demo.cqrs.c.service.result.TransferResult;
import com.matrix.disruptor.DisruptorRepository;
import com.matrix.disruptor.DisruptorServiceBase;

public class DisruptorAccountingService extends DisruptorServiceBase implements AccountingService {

	private AccountingServiceImpl accountingServiceImpl;

	public DisruptorAccountingService(AccountingServiceImpl accountingServiceImpl,
			DisruptorRepository disruptorRepository) {
		super(accountingServiceImpl, disruptorRepository);
		this.accountingServiceImpl = accountingServiceImpl;
	}

	@Override
	public TransferResult transfer(String fromAccountId, String toAccountId, Integer amount) throws Exception {
		return executeFunction(DisruptorNames.accounting.name(), () -> {
			return accountingServiceImpl.transfer(fromAccountId, toAccountId, amount);
		});
	}

	@Override
	public void createAccount(String accountId, String userId, Integer balance) {
		try {
			executeProcess(DisruptorNames.accounting.name(), () -> {
				accountingServiceImpl.createAccount(accountId, userId, balance);
			});
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
