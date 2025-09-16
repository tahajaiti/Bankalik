package service;

import contract.IAccountService;
import contract.IOperationService;
import model.account.Account;
import model.operation.*;

public class OperationService implements IOperationService {

	private IAccountService accountService;
	
	public OperationService(IAccountService accountService) {
		this.accountService = accountService;
	}
	
	public void desposit(Account acc, double amount, String source) {
		Operation operation = new Deposit(amount,source);
		acc.deposit(operation);
	}
	
	public void withdraw(Account acc, double amount, String dest) {
		Operation operation = new Withdrawal(amount, dest);

		acc.withdraw(operation);
	}
	
	public void transfer(Account acc,double amount,int targetId, String reason) {
		Operation opOne = new Withdrawal(amount,reason);
		Operation opTwo = new Deposit(amount, reason);
		
		Account targetAccount = accountService.getAccount(targetId);
		
		if (targetAccount == null) {
			throw new IllegalArgumentException("Error: Invalid target account");
		}
		
		acc.withdraw(opOne);
		
		targetAccount.deposit(opTwo);
	}

}
