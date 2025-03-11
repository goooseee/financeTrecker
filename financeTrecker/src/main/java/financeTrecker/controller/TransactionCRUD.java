package financeTrecker.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import financeTrecker.entity.Budget;
import financeTrecker.entity.Transaction;
import financeTrecker.entity.User;
import financeTrecker.util.Category;
import financeTrecker.util.Operation;

public class TransactionCRUD {
	
	Scanner in = new Scanner( System.in );
	
	public void creatTransaction(User user) {
		Stations stations = new Stations();
		List<Transaction> transactions = new ArrayList<>();
		Budget budget;
		if(user.getTransactions()!=null) {
			transactions = user.getTransactions();
		}
		if(user.getBudget()!=null) {
			budget = user.getBudget();
		}else {
			budget = new Budget(0,0,false);
		}
		int balance = budget.getAmount();
		int expenditure = budget.getMounthBudget();
		Transaction transaction = new Transaction();
		String description;
		int amount;
		Operation type = null;
		Category category = null;
		String dateString;
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-mm-dd");
		System.out.println("Напишите описание");
		description = in.next();
		System.out.println("Напишите сумму");
		amount = in.nextInt();
		System.out.println("Выберете тип операции: 1)Доход 2)Расход");
		int i = in.nextInt();
		if(i==1) {
			type = Operation.income;
			balance = balance + amount;
			budget.setAmount(balance);
		}if(i==2) {
			type = Operation.expenditure;
			balance = balance - amount;
			expenditure = expenditure - amount;
			budget.setMounthBudget(expenditure);
			budget.setAmount(balance);
		}
		System.out.println("Выберете категорию: 1)Покупка 2)Перевод 3)Зарплата 4)Сбережения");
		i = in.nextInt();
		if(i==1) {
			category = Category.purchase;
		}if(i==2) {
			category = Category.transfer;
		}if(i==3) {
			category = Category.salary;
		}if(i==4) {
			category = Category.savings;
		}
		System.out.println("Укажите дату в таком формате: yyyy-MM-dd");
		dateString = in.next();
		LocalDate Date = LocalDate.parse(dateString);
		transaction = new Transaction( type, category, description, amount, Date );
		transactions.add( transaction );
		user.setTransactions(transactions);
		user.setBudget( budget );
		stations.setUser( user );
		stations.afterLogin();
	}
	public void seeAllTransaction(User user){
		Stations stations = new Stations();
		for(Transaction transaction : user.getTransactions()) {
			System.out.println("Тип: "+transaction.getType()+" Категория "+transaction.getCategory()+" Описание: "+transaction.getDiscription()+
					" Сумма: "+transaction.getAmount()+" Дата: "+transaction.getDate());
		}
		stations.setUser( user );
		stations.afterLogin();
	}
	public void deleteTransaction(User user) {
		Stations stations = new Stations();
		List<Transaction> transactions = new ArrayList<>();
		if(user.getTransactions()==null) {
			System.out.println("Вами пока не было совершено ни одной транзакции");
			stations.setUser( user );
			stations.afterLogin();
		}else {
			transactions = user.getTransactions();
			Transaction transaction = new Transaction();
			String description;
			int amount;
			Budget budget = user.getBudget();
			int balance = budget.getAmount();
			int expenditure = budget.getMounthBudget();
			Operation type = null;
			Category category = null;
			String dateString;
			System.out.println("Укажите описание");
			description = in.next();
			System.out.println("Укажите сумму");
			amount = in.nextInt();
			System.out.println("Выберете тип операции: 1)Доход 2)Расход");
			int i = in.nextInt();
			if(i==1) {
				type = Operation.income;
				balance = balance - amount;
				budget.setAmount(balance);
			}if(i==2) {
				type = Operation.expenditure;
				expenditure = expenditure + amount;
				balance = balance + amount;
				budget.setMounthBudget(expenditure);
				budget.setAmount(balance);
			}
			System.out.println("Выберете категорию: 1)Покупка 2)Перевод 3)Зарплата 4)Сбережения");
			i = in.nextInt();
			if(i==1) {
				category = Category.purchase;
			}if(i==2) {
				category = Category.transfer;
			}if(i==3) {
				category = Category.salary;
			}if(i==4) {
				category = Category.savings;
			}
			System.out.println("Укажите дату в таком формате: yyyy-MM-dd");
			dateString = in.next();
			LocalDate Date = LocalDate.parse(dateString);
			transaction = new Transaction( type, category, description, amount, Date );
			transactions.remove(transaction);
			user.setBudget( budget );
			stations.setUser( user );
			stations.afterLogin();
		}
		
	}
	public void redactTransaction(User user) {
		Stations stations = new Stations();
		List<Transaction> transactions = new ArrayList<>();
		if(user.getTransactions()==null) {
			System.out.println("Вами пока не было совершено ни одной транзакции");
			stations.setUser( user );
			stations.afterLogin();
		}else {
			transactions = user.getTransactions();
			Transaction transaction = new Transaction();
			String description;
			int amount;
			Budget budget = user.getBudget();
			int balance = budget.getAmount();
			int expenditure = budget.getMounthBudget();
			Operation type = null;
			Category category = null;
			String dateString;
			System.out.println("Укажите описание");
			description = in.next();
			System.out.println("Укажите сумму");
			amount = in.nextInt();
			System.out.println("Выберете тип операции: 1)Доход 2)Расход");
			int i = in.nextInt();
			if(i==1) {
				type = Operation.income;
			}if(i==2) {
				type = Operation.expenditure;
//				expenditure = expenditure + amount;
//				budget.setMounthBudget(expenditure);
			}
			System.out.println("Выберете категорию: 1)Покупка 2)Перевод 3)Зарплата 4)Сбережения");
			i = in.nextInt();
			if(i==1) {
				category = Category.purchase;
			}if(i==2) {
				category = Category.transfer;
			}if(i==3) {
				category = Category.salary;
			}if(i==4) {
				category = Category.savings;
			}
			System.out.println("Укажите дату в таком формате: yyyy-MM-dd");
			dateString = in.next();
			LocalDate Date = LocalDate.parse(dateString);
			transaction = new Transaction( type, category, description, amount, Date );
			if(transactions.contains(transaction)) {
				if(transaction.getType() == Operation.expenditure) {
					expenditure = expenditure + amount;
					balance = balance + amount;
					budget.setAmount(balance);
					budget.setMounthBudget(expenditure);
				}if(transaction.getType() == Operation.income) {
					balance = balance - amount;
					budget.setAmount(balance);
				}
				user.setBudget( budget );
				transactions.remove(transaction);
				Transaction transaction1 = new Transaction();
				String description1;
				int amount1;
				Budget budget1 = user.getBudget();
				int expenditure1 = budget1.getMounthBudget();
				Operation type1 = null;
				Category category1 = null;
				String dateString1;
				System.out.println("Укажите описание");
				description1 = in.next();
				System.out.println("Укажите сумму");
				amount1 = in.nextInt();
				System.out.println("Выберете тип операции: 1)Доход 2)Расход");
				int i1 = in.nextInt();
				if(i1==1) {
					type = Operation.income;
				}if(i1==2) {
					type = Operation.expenditure;
					expenditure1 = expenditure1 + amount - amount1;
					budget.setMounthBudget(expenditure);
				}
				System.out.println("Выберете категорию: 1)Покупка 2)Перевод 3)Зарплата 4)Сбережения");
				i1 = in.nextInt();
				if(i1==1) {
					category = Category.purchase;
				}if(i1==2) {
					category = Category.transfer;
				}if(i1==3) {
					category = Category.salary;
				}if(i1==4) {
					category = Category.savings;
				}
				System.out.println("Укажите дату в таком формате: yyyy-MM-dd");
				dateString1 = in.next();
				LocalDate Date1 = LocalDate.parse(dateString1);
				transaction1 = new Transaction( type1, category1, description1, amount1, Date1 );
				transactions.add( transaction1 );
				stations.setUser( user );
				stations.afterLogin();
			}else {
				System.out.println("Такой транзакции не существует");
				stations.setUser( user );
				stations.transactions();
				
				}
		}
	}
}
