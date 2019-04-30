package com.demo.cqrs.c.domain;

public class Account {
	private String id;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public boolean ifBalanceLessThan(int value) {
		return balance < value;
	}

}
