package financeTrecker.entity;

import java.util.List;

public class User {
	
	private String name;
	
	private String login;
	
	private String password;
	
	private Budget budget;
	
	private List<Transaction> transactions;
	
	private Purpose purpose;
	
	public User() {}
	
	public User(String name, String login, String password, Budget budget, List<Transaction> transactions, Purpose purpose) {
		this.budget = budget;
		this.login = login;
		this.name = name;
		this.password = password;
		this.purpose = purpose;
		this.transactions = transactions;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Purpose getPurpose() {
		return purpose;
	}

	public void setPurpose(Purpose purpose) {
		this.purpose = purpose;
	}

	public List<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

	public Budget getBudget() {
		return budget;
	}

	public void setBudget(Budget budget) {
		this.budget = budget;
	}
}
