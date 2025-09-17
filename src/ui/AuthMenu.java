package ui;

import contract.IAccountService;
import contract.IUIManager;
import model.account.Account;

public class AuthMenu {

	private IAccountService accService;
	private IUIManager ui;

	public AuthMenu(IAccountService a, IUIManager u) {
		this.accService = a;
		this.ui = u;
	}

	public boolean show() {
		this.menu();

		String choice = ui.getString("Input: ");

		switch (choice) {

		case "1":
			this.createAccount();
			break;
		case "2":
			this.loginMenu();
			break;
		case "3":
			return false;
		default:
			ui.showL("Invalid choice \n");
			break;
		}

		return true;
	}

	private void menu() {
		ui.showL("1. Create Account");
		ui.showL("2. Login");
		ui.showL("3. Exit");
	}

	private void createAccount() {
		boolean valid = false;

		while (!valid) {
			String username = ui.getString("Enter account name: ");
			String code = ui.getString("Enter account code (format CPT-XXXXX): ");

			int type = ui.getInt("Enter account type (1. Savings, 2. Current): ");

			try {
				Account acc = accService.createAccount(code, username, type);
				ui.showL("Account created with ID: " + acc.getId() + "\n");
				valid = true;
			} catch (IllegalArgumentException e) {
				ui.showL("Error: " + e.getMessage() + "\nPlease try again.\n");
			}
		}
	}

	private void loginMenu() {
		boolean valid = false;

		while (!valid) {
			int id = ui.getInt("Enter account id: ");

			String code = ui.getString("Enter account code (format CPT-XXXXX): ");
			try {
				Account acc = accService.login(id, code);
				ui.showL("Logged in! User: " + acc.getUsername() + "\n");
				valid = true;
			} catch (IllegalArgumentException e) {
				ui.showL("Error: " + e.getMessage() + "\nPlease try again.\n");
			}
		}
	}
}
