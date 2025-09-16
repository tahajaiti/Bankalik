package model.account;

import model.operation.*;

public final class CurrentAccount extends Account {
	private double overdraft;
	
	public CurrentAccount(Integer id,String name, String code, double amount, double overdraft) {
		super(id,name, code, amount);
		this.setOverdraft(overdraft);
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
        if (balance - op.getAmount() < -overdraft) {
            throw new IllegalArgumentException("Withdrawal denied. Reached overdraft limit");
        }
        balance -= op.getAmount();
        addOperation(op);
	}
	
	@Override
	public double calculateInterest() {
		return 0;
	}

	@Override
	public void showDetails() {
		System.out.println("=== Account Details ===");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getUsername());
        System.out.println("Code: " + getCode());
        System.out.println("Balance: " + getBalance());
        System.out.println("Overdraft: -" + overdraft);
	}

	public double getOverdraft() {
		return overdraft;
	}

	public void setOverdraft(double overdraft) {
		this.overdraft = overdraft;
	}

}
