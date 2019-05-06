package com.demo.cqrs.q.dbo;

import com.demo.cqrs.c.service.result.TransferResult;

public class AccountLogDbo {
	private String id;
	private String accountId;
	private int transactionNumber;
	private int balanceAfter;
	private int amount;
	private long logTime;
	private String summary;

	public void fillByTransferResultAsFromAccountLog(TransferResult transferResult, String summary) {
		id = transferResult.getFromAccountId() + "-" + transferResult.getTransactionNumberForFromAccount();// 幂等
		accountId = transferResult.getFromAccountId();
		transactionNumber = transferResult.getTransactionNumberForFromAccount();
		balanceAfter = transferResult.getBalanceAfterForFromAccount();
		amount = transferResult.getAmount() * (-1);
		logTime = transferResult.getTime();
		this.summary = summary;
	}

	public void fillByTransferResultAsToAccountLog(TransferResult transferResult, String summary) {
		id = transferResult.getToAccountId() + "-" + transferResult.getTransactionNumberForToAccount();// 幂等
		accountId = transferResult.getToAccountId();
		transactionNumber = transferResult.getTransactionNumberForToAccount();
		balanceAfter = transferResult.getBalanceAfterForToAccount();
		amount = transferResult.getAmount();
		logTime = transferResult.getTime();
		this.summary = summary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public int getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

	public int getBalanceAfter() {
		return balanceAfter;
	}

	public void setBalanceAfter(int balanceAfter) {
		this.balanceAfter = balanceAfter;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public long getLogTime() {
		return logTime;
	}

	public void setLogTime(long logTime) {
		this.logTime = logTime;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

}
