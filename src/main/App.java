package main;

import contract.IAccountService;
import contract.IDIContainer;
import contract.IUIManager;
import service.AccountService;
import ui.ConsoleUIManager;
import ui.Menu;
import util.DI;

public class App {
	
	public static void main(String[] args) {
		IDIContainer container = new DI();
		
		container.register(IAccountService.class, new AccountService());
		container.register(IUIManager.class, new ConsoleUIManager());
		
		Menu menu = new Menu(
				container.resolve(IAccountService.class),
				container.resolve(IUIManager.class)
				);
		menu.boot();
	}
}
