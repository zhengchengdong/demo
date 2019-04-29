package com.demo.cqrs.c.domain;

import java.util.HashMap;
import java.util.Map;

public class AccountRepository {

	private Map<String, Account> mapStore = new HashMap<>();

	public Account findById(String id) {
		return mapStore.get(id);
	}

}
