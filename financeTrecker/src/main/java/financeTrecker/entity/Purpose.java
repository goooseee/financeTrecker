package financeTrecker.entity;


public class Purpose {
	
	private String name;
	
	private int amount;
	
	private int savings;

	public Purpose(){}
	
	public Purpose(String name, int amount, int savings){
		this.amount = amount;
		this.name = name;
		this.savings = savings;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getSavings() {
		return savings;
	}

	public void setSavings(int savings) {
		this.savings = savings;
	}
}
