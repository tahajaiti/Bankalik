package ui;

import contract.IAccountService;
import contract.IOperationService;
import contract.IUIManager;
import model.account.*;
import model.operation.*;
import service.OperationService;

import java.util.List;

public class OperationsMenu {

	private IAccountService accService;
	private IUIManager ui;
	private IOperationService operationService;

	public OperationsMenu(IAccountService a, IUIManager u) {
		this.accService = a;
		this.ui = u;
		this.operationService = new OperationService(a);
	}

	public boolean show() {
		while (true) {
			this.menu();

			String choice = ui.getString("Input: ");

			switch (choice) {
			case "1":
				depositMenu();
				break;
			case "2":
				transferMenu();
				break;
			case "3":
				withdrawMenu();
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
			for (Operation op : ops) {
				ui.showL("------------------------------");
			    ui.showL(op.toString());
			    ui.showL("------------------------------");
			}
		}
		ui.showL("==============================");
	}
	
	private void depositMenu() {
		boolean valid = false;
		Account account = accService.getAccount();

	    while (!valid) {
	        Double amount = ui.getDouble("Enter the deposit amount (0 TO EXIT): ");
	        
	        if (amount == 0) {
	        	break;
	        }
	        
	        String source = ui.getString("Enter source: ");
	        
	        try {
	        	operationService.desposit(account, amount, source);
	        	valid = true;
	        	ui.showL("Operation successful!");
	        } catch (Exception e) {
	        	ui.showL("Error: " + e.getMessage());
			}
	        
	    }
	}
	
	private void withdrawMenu() {
		boolean valid = false;
		Account account = accService.getAccount();

	    while (!valid) {
	        Double amount = ui.getDouble("Enter the withdrawal amount (0 TO EXIT): ");
	        
	        if (amount == 0) {
	        	break;
	        }
	        
	        String dist = ui.getString("Enter destination: ");
	        
	        try {
	        	operationService.withdraw(account, amount, dist);
	        	valid = true;
	        	ui.showL("Operation successful!");
	        } catch (Exception e) {
	        	ui.showL("Error: " + e.getMessage());
			}
	        
	    }
	}
	
	private void transferMenu() {
		boolean valid = false;
		Account account = accService.getAccount();

	    while (!valid) {
	        Double amount = ui.getDouble("Enter the transfer amount (0 TO EXIT): ");
	        
	        if (amount == 0) {
	        	break;
	        }
	        
	        int targetId = ui.getInt("Enter target account id: ");
	        
	        if (targetId == 0) {
	        	break;
	        }
	        
	        String dist = ui.getString("Enter reason: ");
	        
	        try {
	        	operationService.transfer(account, amount, targetId, dist);
	        	valid = true;
	        	ui.showL("Operation successful!");
	        } catch (Exception e) {
	        	ui.showL("Error: " + e.getMessage());
			}
	        
	    }
	}
}
