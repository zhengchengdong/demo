package com.demo.cqrs.q.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.demo.cqrs.c.service.result.TransferResult;
import com.demo.cqrs.q.dao.AccountDboDao;
import com.demo.cqrs.q.dao.AccountLogDboDao;
import com.demo.cqrs.q.dao.UserDboDao;
import com.demo.cqrs.q.dbo.AccountDbo;
import com.demo.cqrs.q.dbo.AccountLogDbo;
import com.demo.cqrs.q.dbo.UserDbo;

@Component
public class AccountingQueryService {

	@Autowired
	private AccountLogDboDao accountLogDboDao;

	@Autowired
	private AccountDboDao accountDboDao;

	@Autowired
	private UserDboDao userDboDao;

	public void afterTransfer(TransferResult transferResult) {
		if (transferResult.isSuccess()) {
			AccountDbo fromAccountDbo = accountDboDao.findById(transferResult.getFromAccountId());
			fromAccountDbo.updateByTransferResultAsFromAccount(transferResult);
			AccountDbo toAccountDbo = accountDboDao.findById(transferResult.getToAccountId());
			toAccountDbo.updateByTransferResultAsToAccount(transferResult);
			accountDboDao.save(fromAccountDbo);
			accountDboDao.save(toAccountDbo);

			AccountLogDbo logForFromAccount = new AccountLogDbo();
			logForFromAccount.fillByTransferResultAsFromAccountLog(transferResult,
					"转金币给好友'" + toAccountDbo.getUserName() + "'");
			AccountLogDbo logForToAccount = new AccountLogDbo();
			logForToAccount.fillByTransferResultAsToAccountLog(transferResult,
					"收到好友'" + fromAccountDbo.getUserName() + "'转入金币");
			accountLogDboDao.save(logForFromAccount);
			accountLogDboDao.save(logForToAccount);
		}
	}

	public void afterCreateAccount(String accountId, String userId, int balance) {
		UserDbo userDbo = userDboDao.findById(userId);
		AccountDbo accountDbo = new AccountDbo();
		accountDbo.setId(accountId);
		accountDbo.setBalance(balance);
		accountDbo.setUserId(userId);
		accountDbo.setUserName(userDbo.getName());
		accountDboDao.save(accountDbo);
	}

	public List<AccountLogDbo> findLogsForAccount(String accountId) {
		return accountLogDboDao.findAllByAccountId(accountId);
	}

}
