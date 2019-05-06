package com.demo.cqrs.c.domain;

import java.util.HashMap;
import java.util.Map;

public class AccountRepository {

	private Map<String, Account> mapStore = new HashMap<>();

	public Account findById(String id) {
		return mapStore.get(id);
	}

	public void putAccount(Account account) {
		mapStore.put(account.getId(), account);
	}

	public Map<String, Account> getMapStore() {
		return mapStore;
	}

	public void setMapStore(Map<String, Account> mapStore) {
		this.mapStore = mapStore;
	}

}
