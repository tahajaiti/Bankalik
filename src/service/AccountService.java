package service;

import java.util.HashMap;
import java.util.Map;

import contract.IAccountService;
import model.account.Account;
import model.account.CurrentAccount;
import model.account.SavingsAccount;
import util.AccountValidator;
import util.Config;

public class AccountService implements IAccountService {

	private int id = 1;

	private Map<Integer, Account> accounts = new HashMap<>();
	private Account account;

	@Override
	public Account createAccount(String code, String user, int type) {
		if (!AccountValidator.isValidCode(code)) {
			throw new IllegalArgumentException("Invalid code structure, EX: CPT-XXXXX");
		}

		if (!AccountValidator.isValidUsername(user)) {
			throw new IllegalArgumentException("Invalid username ");
		}

		Account acc;
		switch (type) {
		case 1:
			acc = new SavingsAccount(id, user, code, Config.DEFAULT_AMOUNT, Config.DEFAULT_INTEREST);
			break;
		case 2:
			acc = new CurrentAccount(id, user, code, Config.DEFAULT_AMOUNT, Config.DEFAULT_OVERDRAFT);
			break;
		default:
			throw new IllegalArgumentException("Invalid account type: " + type);
		}

		accounts.put(id, acc);

		id++;

		return acc;
	}

	@Override
	public Account login(Integer id, String code) {
		Account acc = accounts.get(id);
		if (acc == null)
			throw new IllegalArgumentException("Invalid account id");

		if (!acc.getCode().equals(code)) {
			throw new IllegalArgumentException("Invalid account code");
		}

		this.setAccount(acc);

		return acc;
	}

	@Override
	public void logout() {
		this.setAccount(null);
	}

	public Account getAccount() {
		return account;
	}

	public Account getAccount(int id) {
		return this.accounts.get(id);
	}

	public void setAccount(Account account) {
		this.account = account;
	}
}
