package contract;

import model.account.Account;

public interface IAccountService {

	Account createAccount(String code, String user, int type);

	Account login(Integer id, String code);

	void logout();
	
	Account getAccount();
	Account getAccount(int id);
	void setAccount(Account account);

}