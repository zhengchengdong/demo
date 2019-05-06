package com.demo.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.cqrs.c.service.AccountingService;
import com.demo.cqrs.c.service.result.TransferResult;
import com.demo.cqrs.q.dbo.AccountLogDbo;
import com.demo.cqrs.q.service.AccountingQueryService;
import com.matrix.view.CommonVO;

@RestController
@RequestMapping("/accounting")
public class AccountingController {

	@Autowired
	private AccountingService accountingService;

	@Autowired
	private AccountingQueryService accountingQueryService;

	@RequestMapping("/transfer")
	@ResponseBody
	public CommonVO transfer(String fromAccountId, String toAccountId, int amount) {
		CommonVO vo = new CommonVO();
		try {
			TransferResult transferResult = accountingService.transfer(fromAccountId, toAccountId, amount);
			accountingQueryService.afterTransfer(transferResult);
		} catch (Exception e) {
			vo.setSuccess(false);
			vo.setMsg(e.getMessage());
		}
		return vo;
	}

	@RequestMapping("/createaccount")
	@ResponseBody
	public CommonVO createaccount(String accountId, String userId, int balance) {
		CommonVO vo = new CommonVO();
		accountingService.createAccount(accountId, userId, balance);
		accountingQueryService.afterCreateAccount(accountId, userId, balance);
		return vo;
	}

	@RequestMapping("/logs")
	@ResponseBody
	public CommonVO logs(String accountId) {
		CommonVO vo = new CommonVO();
		List<AccountLogDbo> logs = accountingQueryService.findLogsForAccount(accountId);
		vo.setData(logs);
		return vo;
	}

}
