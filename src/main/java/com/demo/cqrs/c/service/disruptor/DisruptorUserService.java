package com.demo.cqrs.c.service.disruptor;

import com.demo.cqrs.c.service.UserService;
import com.demo.cqrs.c.service.impl.UserServiceImpl;
import com.matrix.dddsupport.disruptor.DisruptorRepository;
import com.matrix.dddsupport.disruptor.DisruptorServiceBase;

public class DisruptorUserService extends DisruptorServiceBase implements UserService {

	private UserServiceImpl userServiceImpl;

	public DisruptorUserService(UserServiceImpl userServiceImpl, DisruptorRepository disruptorRepository) {
		super(userServiceImpl, disruptorRepository);
		this.userServiceImpl = userServiceImpl;
	}

	@Override
	public void createUser(String userId) {
		try {
			executeProcess(DisruptorNames.users.name(), () -> {
				userServiceImpl.createUser(userId);
			});
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
