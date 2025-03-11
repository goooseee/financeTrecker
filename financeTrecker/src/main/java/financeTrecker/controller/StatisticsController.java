package financeTrecker.controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import financeTrecker.entity.Transaction;
import financeTrecker.entity.User;
import financeTrecker.util.Category;
import financeTrecker.util.Operation;

public class StatisticsController {
	
	Scanner in = new Scanner(System.in);
	
	public void balance(User user) {
		Stations stations = new Stations();
		int balance;
		if(user.getBudget()==null) {
			balance = 0;
		}else {
			balance = user.getBudget().getAmount();
		}
		System.out.println("Ваш текущий баланс: " + balance);
		stations.setUser( user );
		stations.afterLogin();
	}
	public void incomeDate(User user) {
		Stations stations = new Stations();
		List<Transaction> transactions = new ArrayList<>();
		String dateBeg;
		String dateEnd;
		System.out.println("Укажите дату в таком формате: yyyy-MM-dd");
		dateBeg = in.next();
		LocalDate DateBeg = LocalDate.parse(dateBeg);
		System.out.println("Укажите дату в таком формате: yyyy-MM-dd");
		dateEnd = in.next();
		LocalDate DateEnd = LocalDate.parse(dateEnd);
		if(user.getTransactions()==null) {
			
		}else {
			transactions = user.getTransactions();
			for(Transaction transaction : transactions) {
				if(transaction.getType()==Operation.income && (transaction.getDate().isBefore(DateEnd) && transaction.getDate().isAfter( DateBeg )) 
						|| (transaction.getDate().isEqual(DateEnd)) || transaction.getDate().isEqual(DateBeg)) {
					System.out.println("Тип: "+transaction.getType()+" Категория "+transaction.getCategory()+" Описание: "+transaction.getDiscription()+
							" Сумма: "+transaction.getAmount()+" Дата: "+transaction.getDate());
				}
			}
		}
		stations.setUser( user );
		stations.afterLogin();
	}
	public void expenditureDate(User user) {
		Stations stations = new Stations();
		List<Transaction> transactions = new ArrayList<>();
		String dateBeg;
		String dateEnd;
		System.out.println("Укажите дату в таком формате: yyyy-MM-dd");
		dateBeg = in.next();
		LocalDate DateBeg = LocalDate.parse(dateBeg);
		System.out.println("Укажите дату в таком формате: yyyy-MM-dd");
		dateEnd = in.next();
		LocalDate DateEnd = LocalDate.parse(dateEnd);
		if(user.getTransactions()==null) {
			
		}else {
			transactions = user.getTransactions();
			for(Transaction transaction : transactions) {
				if(transaction.getType()==Operation.expenditure && (transaction.getDate().isBefore(DateEnd) && transaction.getDate().isAfter( DateBeg )) 
						|| (transaction.getDate().isEqual(DateEnd)) || transaction.getDate().isEqual(DateBeg)) {
					System.out.println("Тип: "+transaction.getType()+" Категория "+transaction.getCategory()+" Описание: "+transaction.getDiscription()+
							" Сумма: "+transaction.getAmount()+" Дата: "+transaction.getDate());
				}
			}
		}
		stations.setUser( user );
		stations.afterLogin();
	}
	public void expenditureCategory(User user) {
		Stations stations = new Stations();
		int caty;
		
		if(user.getTransactions()!=null) {
			System.out.println("Выберете категорию: 1)Покупка 2)Перевод 3)Зарплата 4)Сбережения");
			caty = in.nextInt();
			for(Transaction transaction : user.getTransactions()) {
				switch(caty) {
					case 1:
						if(transaction.getCategory()==Category.purchase) {
							System.out.println("Тип: "+transaction.getType()+" Категория "+transaction.getCategory()+" Описание: "+transaction.getDiscription()+
									" Сумма: "+transaction.getAmount()+" Дата: "+transaction.getDate());
						}
					case 2:
						if(transaction.getCategory()==Category.transfer) {
							System.out.println("Тип: "+transaction.getType()+" Категория "+transaction.getCategory()+" Описание: "+transaction.getDiscription()+
									" Сумма: "+transaction.getAmount()+" Дата: "+transaction.getDate());
						}
					case 3:
						if(transaction.getCategory()==Category.salary) {
							System.out.println("Тип: "+transaction.getType()+" Категория "+transaction.getCategory()+" Описание: "+transaction.getDiscription()+
									" Сумма: "+transaction.getAmount()+" Дата: "+transaction.getDate());
						}
					case 4:
						if(transaction.getCategory()==Category.savings) {
							System.out.println("Тип: "+transaction.getType()+" Категория "+transaction.getCategory()+" Описание: "+transaction.getDiscription()+
									" Сумма: "+transaction.getAmount()+" Дата: "+transaction.getDate());
						}
				}
			}
		}else {
			System.out.println("Вами пока не было совершено ни одной транзакции");
		}
		stations.setUser( user );
		stations.afterLogin();
	}
}
