package ui;


import contract.*;
import model.account.*;

public class AccountMenu {

	private IAccountService accService;
	private IUIManager ui;
	private OperationsMenu operationsMenu;
	
	public AccountMenu(IAccountService a, IUIManager u) {
        this.accService = a;
        this.ui = u;
        this.operationsMenu = new OperationsMenu(a, u);
    }
	
	public boolean show() {
        while (true) {
        	Account acc = accService.getAccount();
        	
        	if (acc == null) {
        		return true;
        	}
        	
            ui.showL("\n===== Account Menu (Logged in as: " + acc.getUsername() + ") =====");
        	
            this.menu();
            String choice = ui.getString("Choice: ");

            switch (choice) {
                case "1":
                    acc.showDetails();
                    break;
                case "2":
                    return operationsMenu.show();
                case "3":
                    accService.logout();
                    ui.showL("You have been logged out.\n");
                    return true;
                case "4":
                    return false;
                default:
                    ui.showL("Invalid choice\n");
            }
        }
    }
	
	private void menu() {
		
        ui.showL("1. Account Details");
        ui.showL("2. Operations");
        ui.showL("3. Logout");
        ui.showL("4. Exit");
	}

}
