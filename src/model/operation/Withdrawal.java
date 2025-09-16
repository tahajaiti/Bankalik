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
	
	@Override
	public String toString() {
		return "Operation: " +
		           "type=Withdrawal"+
		           ", amount=" + amount +
		           "\n, date=" + date +
		           ", destination=" + destination;
	}
}
