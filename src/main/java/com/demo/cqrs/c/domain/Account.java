package com.demo.cqrs.c.domain;

public class Account {
	private String id;
	private String userId;
	private int balance;
	private int transactionNumber;

	public void withdraw(int amount) {
		balance -= amount;
		transactionNumber++;
	}

	public void deposit(int amount) {
		balance += amount;
		transactionNumber++;
	}

	public boolean ifBalanceLessThan(int value) {
		return balance < value;
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
