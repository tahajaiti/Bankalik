package model.operation;

public class Withdrawal extends Operation{
	private String destination;
	
	public Withdrawal(double amount, String destination) {
		super(amount);
		this.setDestination((destination != null) ? destination : "Uknown destination");
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}
}
