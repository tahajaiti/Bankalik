package test;

import contract.IAccountService;
import contract.IOperationService;
import model.account.Account;
import service.AccountService;
import service.OperationService;
import util.Config;

public class OperationServiceTest extends TestBase {

    public static final String CODE = "CPT-12345";

    public void testSavingDeposit() {
        IAccountService accountService = new AccountService();
        IOperationService operationService = new OperationService(accountService);

        Account account = accountService.createAccount(CODE, "user1", 1);
        accountService.login(account.getId(), CODE);

        operationService.desposit(account, 1000, "Test");

        double expected = 1000 + (Config.DEFAULT_INTEREST * 1000);

        this.assertEquals(expected, account.getBalance(), "testSavingDeposit");
    }

    public void testCurrentDeposit() {
    	IAccountService accountService = new AccountService();
        IOperationService operationService = new OperationService(accountService);

        Account account = accountService.createAccount(CODE, "user2", 2);
        accountService.login(account.getId(), CODE);

        operationService.desposit(account, 1000, "Test");

        this.assertEquals(1000.0, account.getBalance(), "testCurrentDeposit");
    }
    
    public void testAccountWithdraw() {
        IAccountService accountService = new AccountService();
        IOperationService operationService = new OperationService(accountService);

        Account account = accountService.createAccount(CODE, "user3", 1);
        accountService.login(1, CODE);

        operationService.desposit(account, 1000, "Test");
        double expected = 1000 + (Config.DEFAULT_INTEREST * 1000);

        operationService.withdraw(account, 100, "Test");

        this.assertEquals(expected - 100, account.getBalance(), "testSavingWithdraw");
    }

    public void testAccountTransfer() {
    	IAccountService accountService = new AccountService();
        IOperationService operationService = new OperationService(accountService);

        Account account = accountService.createAccount(CODE, "user4", 2);
        Account accountTwo = accountService.createAccount(CODE, "user5", 2);
        accountService.login(account.getId(), CODE);
        
        operationService.desposit(account, 1000, "Test");
        operationService.transfer(account, 500, accountTwo.getId(), "Test");
        
        this.assertEquals(500.0, account.getBalance(), "testAccountTransferSender");
        this.assertEquals(500.0, accountTwo.getBalance(), "testAccountTransferReciever");
    }
    
    public void testInvalidDeposit() {
    	IAccountService accountService = new AccountService();
        IOperationService operationService = new OperationService(accountService);

        Account account = accountService.createAccount(CODE, "user6", 2);
        accountService.login(account.getId(), CODE);
        
        this.assertThrows(() -> operationService.desposit(account, -1000, "Test"),
        		IllegalArgumentException.class, "testInvalidDeposit");
        
//        this.assertEquals(0, account.getBalance(), "testInvalidDeposit");
    }
    
    public void testCurrentOverdraft() {
    	IAccountService accountService = new AccountService();
        IOperationService operationService = new OperationService(accountService);

        Account account = accountService.createAccount(CODE, "user6", 2);
        accountService.login(account.getId(), CODE);
        
        this.assertThrows(() -> operationService.withdraw(account, 10000, "Test"),
        		IllegalArgumentException.class, "testCurrentOverdraft");
    }
    
    public static void main(String[] args) {
        OperationServiceTest test = new OperationServiceTest();
        test.testSavingDeposit();
        test.testAccountWithdraw();
        test.testCurrentDeposit();
        test.testAccountTransfer();
        test.testInvalidDeposit();
        test.testCurrentOverdraft();

        test.printResult();
    }
}
