package model.account;

import model.operation.*;

public final class SavingsAccount extends Account {
	private double taxInterest;

	public SavingsAccount(Integer id,String name,String code, double amount, double interest) {
		super(id, name,code, amount);
		this.taxInterest = interest;
	}

	@Override
	public void deposit(Operation op) {
		if (op.getAmount() < 0) 
			throw new IllegalArgumentException("Deposit amount must be positive");
		
		this.balance += op.getAmount();
		this.addOperation(op);
	}
	
	@Override
	public void withdraw(Operation op) {
		if (op.getAmount() <= 0) 
			throw new IllegalArgumentException("Withdrawal amount must be positive");
        if (balance < op.getAmount()) 
        	throw new IllegalArgumentException("No balance for withdrawal");
        
        balance -= op.getAmount();
        addOperation(op);
	}

	@Override
	public double calculateInterest() {
		return this.balance * taxInterest;
	}

	@Override
	public void showDetails() {
		System.out.println("Savings Account: " + username);
        System.out.println("Code: " + code);
        System.out.println("Balance: " + balance);
        System.out.println("Interest Rate: " + (taxInterest * 100) + "%");
	}

	public double getTaxInterest() {
		return taxInterest;
	}

	public void setTaxInterest(double taxInterest) {
		this.taxInterest = taxInterest;
	}

}
