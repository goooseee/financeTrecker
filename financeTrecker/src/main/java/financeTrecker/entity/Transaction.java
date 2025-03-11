package financeTrecker.entity;

import java.time.LocalDate;
import java.util.Date;

import financeTrecker.util.Category;
import financeTrecker.util.Operation;

public class Transaction {
	
	private Operation type;
	
	private Category category;
	
	private String discription;
	
	private int amount;
	
	private LocalDate date;
	
	public Transaction() {}
	
	public Transaction(Operation type, Category category, String discription, int amount, LocalDate date) {
		this.amount = amount;
		this.category = category;
		this.date = date;
		this.discription = discription;
		this.type = type;
	}
	
	public Operation getType() {
		return type;
	}

	public void setType(Operation type) {
		this.type = type;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
