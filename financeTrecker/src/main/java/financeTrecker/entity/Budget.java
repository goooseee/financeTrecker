package financeTrecker.entity;


public class Budget {
	
	private int amount;
	
	private int mounthBudget;
	
	private boolean budgetOverruns;
	
	
	public Budget() {}
	
	public Budget(int amount, int mounthBudget, boolean budgetOverruns) {
		this.amount = amount;
		this.budgetOverruns = budgetOverruns;
		this.mounthBudget = mounthBudget;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getMounthBudget() {
		return mounthBudget;
	}

	public void setMounthBudget(int mounthBudget) {
		this.mounthBudget = mounthBudget;
	}

	public boolean isBudgetOverruns() {
		return budgetOverruns;
	}

	public void setBudgetOverruns(boolean budgetOverruns) {
		this.budgetOverruns = budgetOverruns;
	}
}
