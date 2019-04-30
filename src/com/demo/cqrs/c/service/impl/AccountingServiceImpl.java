package com.demo.cqrs.c.service.impl;

import com.demo.cqrs.c.domain.Account;
import com.demo.cqrs.c.domain.AccountRepository;
import com.demo.cqrs.c.service.AccountingService;
import com.demo.cqrs.c.service.exception.AccountNotFoundException;
import com.demo.cqrs.c.service.result.TransferResult;

public class AccountingServiceImpl implements AccountingService {

	private AccountRepository accountRepository;

	@Override
	public TransferResult transfer(String fromAccountId, String toAccountId, Integer amount) throws Exception {
		Account fromAccount = accountRepository.findById(fromAccountId);
		if (fromAccount == null) {
			throw new AccountNotFoundException();
		}
		Account toAccount = accountRepository.findById(fromAccountId);
		if (toAccount == null) {
			throw new AccountNotFoundException();
		}

		if (fromAccount.ifBalanceLessThan(amount)) {
			return TransferResult.unSuccess();
		}

		fromAccount.withdraw(amount);
		toAccount.deposit(amount);
		return TransferResult.success(fromAccount, toAccount, amount);

	}

}
