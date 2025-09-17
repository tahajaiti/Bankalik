package model.operation;

import java.time.format.DateTimeFormatter;

public class Deposit extends Operation {
	
	private String source;
	
	public Deposit(double amount, String source) {
		super(amount);
		this.setSource(source.chars().allMatch(Character::isWhitespace) ? "Uknown" : source);
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
	
	@Override
	public String toString() {
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		return "Operation: " +
		           "type=Deposit |" +
		           " amount=" + getAmount() +
		           " | date=" + getDate().format(formatter) +
		           " | source=" + getSource();
	}
}
