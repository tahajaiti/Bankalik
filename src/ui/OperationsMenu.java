package ui;

import contract.IAccountService;
import contract.IUIManager;
import model.account.*;
import model.operation.*;
import java.util.List;

public class OperationsMenu {

	private IAccountService accService;
	private IUIManager ui;

	public OperationsMenu(IAccountService a, IUIManager u) {
		this.accService = a;
		this.ui = u;
	}

	public boolean show() {
		while (true) {
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
				showHistory();
				break;
			case "5":
				return true;
			default:
				ui.showL("Invalid choice \n");
				break;
			}
		}
	}

	private void menu() {
		ui.showL("\n===== Operations =====");

		ui.showL("1. Deposit");
		ui.showL("2. Send Money");
		ui.showL("3. Withdraw");
		ui.showL("4. History");
		ui.showL("5. Return");
	}

	private void showHistory() {
		Account account = accService.getAccount();

		List<Operation> ops = account.getOperations();

		ui.showL("===== Operations History =====");

		if (ops.isEmpty()) {
			ui.showL("No operations.");
		} else {
			account.getOperations().forEach(op -> ui.showL(op.toString()));
		}
		ui.showL("==============================");
	}
}
