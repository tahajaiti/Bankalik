package contract;

import model.account.Account;

public interface IOperationService {

	void desposit(Account acc, double amount, String source);

	void withdraw(Account acc, double amount, String dest);

	void transfer(Account acc, double amount, int targetId, String reason);

}