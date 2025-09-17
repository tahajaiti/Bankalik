package model.operation;

import java.time.format.DateTimeFormatter;

public class Withdrawal extends Operation{
	private String destination;
	
	public Withdrawal(double amount, String destination) {
		super(amount);
		this.setDestination(destination.chars().allMatch(Character::isWhitespace) ? "Uknown" : destination);
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	@Override
	public String toString() {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return "Operation: " +
		           "type=Deposit |" +
		           " amount=" + getAmount() +
		           " | date=" + getDate().format(formatter) +
		           " | dest=" + getDestination();
	}
}
