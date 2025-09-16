package ui;

import contract.IAccountService;
import contract.IUIManager;

public class OperationsMenu {

	private IAccountService accService;
	private IUIManager ui;

	public OperationsMenu(IAccountService a, IUIManager u) {
		this.accService = a;
		this.ui = u;
	}

	public boolean show() {
		this.menu();

		String choice = ui.getString("Input: ");

		switch (choice) {
			case "1":
	
				break;
			case "2":
	
				break;
			case "3":
				break;
			case "4":
				break;
			case "5":
				return true;
			default:
				ui.showL("Invalid choice \n");
				break;
		}

		return true;
	}

	private void menu() {
		ui.showL("\n===== Operations =====");

		ui.showL("1. Deposit");
		ui.showL("2. Send Money");
		ui.showL("3. Withdraw");
		ui.showL("4. History");
		ui.showL("5. Return");
	}
}
