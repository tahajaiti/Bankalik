package model.operation;

import java.time.LocalDateTime;
import java.util.UUID;

public abstract class Operation {

	protected UUID id;
	protected LocalDateTime date;
	protected double amount;

	protected Operation(double amount) {
		this.setId(UUID.randomUUID());
		this.setDate(LocalDateTime.now());
		this.setAmount(amount);
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

}
