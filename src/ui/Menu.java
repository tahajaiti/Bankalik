package ui;

import contract.*;

public class Menu {

	private IAccountService accService;
	private IUIManager ui;
	private AccountMenu accountMenu;
	private AuthMenu authMenu;

	public Menu(IAccountService a, IUIManager u) {
		this.accService = a;
		this.ui = u;
		this.accountMenu = new AccountMenu(a, u);
		this.authMenu = new AuthMenu(a, u);
	}

	public void boot() {
		boolean running = true;
		ui.showL("\n===== Welcome to Bankalik =====");

		while (running) {
			if (accService.getAccount() == null) {
				running = authMenu.show();
			} else {
				running = accountMenu.show();
			}
		}

	}


}
