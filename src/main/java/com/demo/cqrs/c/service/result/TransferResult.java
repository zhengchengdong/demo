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
		r.success = true;
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

	public String getFromAccountId() {
		return fromAccountId;
	}

	public void setFromAccountId(String fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	public String getToAccountId() {
		return toAccountId;
	}

	public void setToAccountId(String toAccountId) {
		this.toAccountId = toAccountId;
	}

	public int getTransactionNumberForFromAccount() {
		return transactionNumberForFromAccount;
	}

	public void setTransactionNumberForFromAccount(int transactionNumberForFromAccount) {
		this.transactionNumberForFromAccount = transactionNumberForFromAccount;
	}

	public int getTransactionNumberForToAccount() {
		return transactionNumberForToAccount;
	}

	public void setTransactionNumberForToAccount(int transactionNumberForToAccount) {
		this.transactionNumberForToAccount = transactionNumberForToAccount;
	}

	public int getBalanceAfterForFromAccount() {
		return balanceAfterForFromAccount;
	}

	public void setBalanceAfterForFromAccount(int balanceAfterForFromAccount) {
		this.balanceAfterForFromAccount = balanceAfterForFromAccount;
	}

	public int getBalanceAfterForToAccount() {
		return balanceAfterForToAccount;
	}

	public void setBalanceAfterForToAccount(int balanceAfterForToAccount) {
		this.balanceAfterForToAccount = balanceAfterForToAccount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

}
