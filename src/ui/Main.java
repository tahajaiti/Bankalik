package ui;

import contract.*;
import util.*;
import service.*;

public class Main {
	
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
