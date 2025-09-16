package ui;

import java.util.Scanner;
import service.*;
import model.account.*;

public class Menu {

	private AccountService accService = new AccountService();
	private Scanner scanner = new Scanner(System.in);
	
	
	public void boot() {
		boolean running = true;
		
		
        System.out.println("\n===== Welcome to Bankalik =====");
		
        
        while(running) {
        	System.out.println("1. Create Account");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choice: ");
            
            String choice = scanner.nextLine();
            
            switch(choice) {
            
            case "1":
            	createAccount();
            	break;
            case "2":
            	
            	break;
            case "3":
            	running = false;
            	break;
            default:
            	System.out.println("Invalid choice \n");
            	break;
            }
        }
             
	}
	
	private void createAccount() {
		boolean valid = false;

	    while (!valid) {
	        System.out.print("Enter account name: ");
	        String username = scanner.nextLine();

	        System.out.print("Enter account code (format CPT-XXXXX): ");
	        String code = scanner.nextLine();

	        System.out.print("Enter account type (1. Savings, 2. Current): ");
	        int type;
	        try {
	            type = Integer.parseInt(scanner.nextLine());
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid type, must be 1 or 2.\n");
	            continue;
	        }

	        try {
	            Account acc = accService.createAccount(code, username, type);
	            System.out.println("Account created with ID: " + acc.getId() + "\n");
	            valid = true;
	        } catch (IllegalArgumentException e) {
	            System.out.println("Error: " + e.getMessage() + "\nPlease try again.\n");
	        }
	    }
	}
	
}
