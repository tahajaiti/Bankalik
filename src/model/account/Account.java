package model.account;

import java.util.*;
import model.operation.*;


public abstract class Account {

	protected String username;
	protected String code;
	protected Double balance;
	protected List<Operation> operations;
	
	protected Account(String name, double amount) {
		this.username = name;
		this.balance = amount;
	}
	
	public abstract void deposit(double amount);
	
	public abstract double calculateInterest();
	
	public abstract void showDetails();
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setBalance(double amount) {
		this.balance = amount;
	}
	
	public Double getBalanace() {
		return balance;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}
}
