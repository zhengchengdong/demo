package com.demo.cqrs.c.service.result;

import com.demo.cqrs.c.domain.Account;

public class TransferResult {

	public static TransferResult unSuccess() {
		TransferResult r = new TransferResult();
		r.success = false;
		return r;
	}

	public static TransferResult success(Account fromAccount, Account toAccount, int amount) {
		TransferResult r = new TransferResult();
		r.fromAccountId = fromAccount.getId();
		r.toAccountId = toAccount.getId();
		r.transactionNumberForFromAccount = fromAccount.getTransactionNumber();
		r.transactionNumberForToAccount = toAccount.getTransactionNumber();
		r.balanceAfterForFromAccount = fromAccount.getBalance();
		r.balanceAfterForToAccount = toAccount.getBalance();
		r.amount = amount;
		r.time = System.currentTimeMillis();
		r.success = false;
		return r;
	}

	private String fromAccountId;
	private String toAccountId;
	private int transactionNumberForFromAccount;
	private int transactionNumberForToAccount;
	private int balanceAfterForFromAccount;
	private int balanceAfterForToAccount;
	private int amount;
	private long time;
	private boolean success;

}
