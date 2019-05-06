package com.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import com.demo.conf.FilePathConfig;
import com.demo.cqrs.c.domain.AccountRepository;
import com.demo.cqrs.c.domain.UserRepository;
import com.demo.cqrs.c.service.disruptor.DisruptorAccountingService;
import com.demo.cqrs.c.service.disruptor.DisruptorNames;
import com.demo.cqrs.c.service.disruptor.DisruptorUserService;
import com.demo.cqrs.c.service.impl.AccountingServiceImpl;
import com.demo.cqrs.c.service.impl.UserServiceImpl;
import com.matrix.disruptor.AggregateRootRepository;
import com.matrix.disruptor.AggregateRootRepositorySnapshotRecoverer;
import com.matrix.disruptor.CommandReplayer;
import com.matrix.disruptor.DisruptorRepository;
import com.matrix.disruptor.SnapshotService;

@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(DemoApplication.class);
	}

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private FilePathConfig filePathConfig;

	@Bean
	public AggregateRootRepository accountingAggregateRootRepository() throws Exception {
		return AggregateRootRepositorySnapshotRecoverer.recover(filePathConfig.getSnapshotFileBasePath(),
				DisruptorNames.accounting.name());
	}

	@Bean
	public AggregateRootRepository usersAggregateRootRepository() throws Exception {
		return AggregateRootRepositorySnapshotRecoverer.recover(filePathConfig.getSnapshotFileBasePath(),
				DisruptorNames.users.name());
	}

	@Bean
	public DisruptorRepository disruptorRepository(AggregateRootRepository accountingAggregateRootRepository,
			AggregateRootRepository usersAggregateRootRepository) {
		DisruptorRepository disruptorRepository = new DisruptorRepository();
		disruptorRepository.createDisruptor(DisruptorNames.accounting.name(), accountingAggregateRootRepository,
				filePathConfig.getSnapshotFileBasePath(), filePathConfig.getjFileBasePath());
		disruptorRepository.createDisruptor(DisruptorNames.users.name(), usersAggregateRootRepository,
				filePathConfig.getSnapshotFileBasePath(), filePathConfig.getjFileBasePath());
		return disruptorRepository;
	}

	@Bean
	public AccountingServiceImpl accountingServiceImpl(AggregateRootRepository accountingAggregateRootRepository) {
		AccountingServiceImpl accountingServiceImpl = new AccountingServiceImpl();
		AccountRepository accountRepository = accountingAggregateRootRepository.getAggregateRoot("accountRepository");
		if (accountRepository == null) {
			accountRepository = new AccountRepository();
			accountingAggregateRootRepository.putAggregateRoot("accountRepository", accountRepository);
		}
		accountingServiceImpl.setAccountRepository(accountRepository);
		return accountingServiceImpl;
	}

	@Bean
	public UserServiceImpl userServiceImpl(AggregateRootRepository usersAggregateRootRepository) {
		UserServiceImpl usersServiceImpl = new UserServiceImpl();
		UserRepository userRepository = usersAggregateRootRepository.getAggregateRoot("userRepository");
		if (userRepository == null) {
			userRepository = new UserRepository();
			usersAggregateRootRepository.putAggregateRoot("userRepository", userRepository);
		}
		usersServiceImpl.setUserRepository(userRepository);
		return usersServiceImpl;
	}

	@Bean
	public DisruptorAccountingService accountingService(AccountingServiceImpl accountingServiceImpl,
			DisruptorRepository disruptorRepository) {
		return new DisruptorAccountingService(accountingServiceImpl, disruptorRepository);
	}

	@Bean
	public DisruptorUserService userService(UserServiceImpl userServiceImpl, DisruptorRepository disruptorRepository) {
		return new DisruptorUserService(userServiceImpl, disruptorRepository);
	}

	@Bean
	public SnapshotService snapshotService(DisruptorRepository disruptorRepository) {
		return new SnapshotService(disruptorRepository);
	}

	@Bean
	public Object journalRecovererHelper(AccountingServiceImpl accountingServiceImpl, UserServiceImpl userServiceImpl)
			throws Exception {
		CommandReplayer.replay(filePathConfig.getjFileBasePath(), DisruptorNames.accounting.name(),
				accountingServiceImpl);
		CommandReplayer.replay(filePathConfig.getjFileBasePath(), DisruptorNames.users.name(), userServiceImpl);
		return new Object();
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}