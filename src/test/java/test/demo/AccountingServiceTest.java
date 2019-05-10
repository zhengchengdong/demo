package test.demo;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.demo.cqrs.c.domain.AccountRepository;
import com.demo.cqrs.c.service.impl.AccountingServiceImpl;
import com.demo.cqrs.c.service.result.TransferResult;

public class AccountingServiceTest {

	@Test
	public void test() {
		AccountingServiceImpl accountingService = new AccountingServiceImpl();
		accountingService.setAccountRepository(new AccountRepository());

		accountingService.createAccount("1", "neo1", 100);
		accountingService.createAccount("2", "neo2", 100);

		try {
			TransferResult transferResult = accountingService.transfer("1", "2", 10);
			assertNotNull(transferResult);
			assertEquals(90, transferResult.getBalanceAfterForFromAccount());
			assertEquals(110, transferResult.getBalanceAfterForToAccount());
		} catch (Exception e) {
			assertTrue(false);
		}

	}

}
