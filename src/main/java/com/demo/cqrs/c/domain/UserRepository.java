package com.demo.cqrs.c.domain;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

	private Map<String, User> mapStore = new HashMap<>();

	public User findById(String id) {
		return mapStore.get(id);
	}

	public void putUser(User user) {
		mapStore.put(user.getId(), user);
	}

	public String deleteUser(String userId) {
		User user = mapStore.remove(userId);
		if (user != null) {
			return user.getId();
		} else {
			return null;
		}
	}

	public Map<String, User> getMapStore() {
		return mapStore;
	}

	public void setMapStore(Map<String, User> mapStore) {
		this.mapStore = mapStore;
	}

}
