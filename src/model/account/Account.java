package model.account;

import java.util.ArrayList;
import java.util.List;

import model.operation.Operation;

public abstract class Account {

	private Integer id;
	protected String username;
	protected String code;
	protected Double balance;
	protected List<Operation> operations;

	protected Account(Integer id, String name, String code, double amount) {
		this.setId(id);
		this.username = name;
		this.code = code;
		this.balance = amount;
		this.operations = new ArrayList<>();
	}

	public abstract void deposit(Operation op);

	public abstract void withdraw(Operation op);

	public abstract double calculateInterest();

	public abstract void showDetails();

	public void addOperation(Operation op) {
		operations.add(op);
	}

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

	public Double getBalance() {
		return balance;
	}

	public List<Operation> getOperations() {
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
