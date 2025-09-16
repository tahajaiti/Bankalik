package service;

import model.account.*;
import util.AccountValidator;

import java.util.HashMap;
import java.util.Map;

public class AccountService {
	
	private int ID = 0;
	
	private Map<Integer, Account> accounts = new HashMap<>();
	private Account account;
	
	public Account createAccount(String code, String user, int type) {
		if (!AccountValidator.isValidCode(code)) {
			throw new IllegalArgumentException("Invalid code structure, EX: CPT-XXXXX");
		}
		
		if (!AccountValidator.isValidUsername(user)) {
			throw new IllegalArgumentException("Invalid username ");
		}
		
		
		Account acc;
		switch(type) {
		case 1:
			acc = new SavingsAccount(ID,user, code, 0, 0.25);
			break;
		case 2:
			acc = new CurrentAccount(ID, user, code, 0, 500);
			break;
		default:
            throw new IllegalArgumentException("Invalid account type: " + type);
		}
		
		accounts.put(ID, acc);

		ID++;
		
		return acc;
	}
	
	public Account login(Integer id, String code) {
		Account acc = accounts.get(id);
		if (acc == null) throw new IllegalArgumentException("Invalid account id");
		
		if (!acc.getCode().equals(code)) {
	        throw new IllegalArgumentException("Invalid account code");
	    }
		
		this.setAccount(acc);
		
		return acc;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
