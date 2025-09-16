package model.operation;

public class Deposit extends Operation {
	
	private String source;
	
	public Deposit(double amount, String source) {
		super(amount);
		this.setSource((source != null) ? source : "Uknown source");
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}
}
