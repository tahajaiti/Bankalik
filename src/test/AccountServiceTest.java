package test;

import service.AccountService;
import contract.IAccountService;
import model.account.Account;

public class AccountServiceTest extends TestBase {

	public static final String CODE = "CPT-12345";
	
	public void testCreateSavingsAccount() {
		IAccountService accountService = new AccountService();
		Account account = accountService.createAccount(CODE, "TEST", 1);
		this.assertEquals("SavingsAccount", account.getClass().getSimpleName(), "testCreateSavingsAccount");
	}
	
	public void testCreateCurrentAccount() {
		IAccountService accountService = new AccountService();
		Account account = accountService.createAccount(CODE, "TEST", 2);
		this.assertEquals("CurrentAccount", account.getClass().getSimpleName(), "testCreateCurrentAccount");
	}
	
	public void testInvalidAccountCode() {
		IAccountService accountService = new AccountService();
		this.assertThrows(() -> accountService.createAccount("CPT-2", "user", testsFailed)
				, IllegalArgumentException.class, "testInvalidAccountCode");
	}
	
	public void testAccountLogin() {
		IAccountService accountService = new AccountService();
		Account account = accountService.createAccount(CODE, "TEST", 2);
		this.assertEquals(account, accountService.login(1, CODE), "testAccountLogin");
	}
	
	public void testAccountLogout() {
		IAccountService accountService = new AccountService();
		Account account = accountService.createAccount(CODE, "TEST", 2);
		accountService.login(account.getId(), account.getCode());
		accountService.logout();
		this.assertEquals(null, accountService.getAccount(), "testAccountLogout");
	}
	
	public static void main(String[] args) {
		AccountServiceTest test = new AccountServiceTest();
        test.testCreateSavingsAccount();
        test.testCreateCurrentAccount();
        test.testInvalidAccountCode();
        test.testAccountLogin();
        
        test.printResult();
	}
	
}
