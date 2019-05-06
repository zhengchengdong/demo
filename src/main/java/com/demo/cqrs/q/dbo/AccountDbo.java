package com.demo.cqrs.q.dbo;

import com.demo.cqrs.c.service.result.TransferResult;

public class AccountDbo {
	private String id;
	private String userId;
	private String userName;
	private int balance;
	private int transactionNumber;

	public void updateByTransferResultAsFromAccount(TransferResult transferResult) {
		balance = transferResult.getBalanceAfterForFromAccount();
		transactionNumber = transferResult.getTransactionNumberForFromAccount();
	}

	public void updateByTransferResultAsToAccount(TransferResult transferResult) {
		balance = transferResult.getBalanceAfterForToAccount();
		transactionNumber = transferResult.getTransactionNumberForToAccount();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getTransactionNumber() {
		return transactionNumber;
	}

	public void setTransactionNumber(int transactionNumber) {
		this.transactionNumber = transactionNumber;
	}

}
