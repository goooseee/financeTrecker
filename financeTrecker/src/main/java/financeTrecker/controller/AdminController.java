package financeTrecker.controller;

import java.util.HashSet;
import java.util.Scanner;

import financeTrecker.entity.Transaction;
import financeTrecker.entity.User;

public class AdminController {
	
	Scanner in = new Scanner(System.in);
	
	public void allUsers(HashSet<User> users) {
		Stations stations = new Stations();
		System.out.println("Список пользователей");
		for(User user : users) {
			System.out.println("Имя пользователя:"+ user.getName() +" Email пользователя: "+ user.getLogin() +" Пароль пользователя: "+ user.getPassword());
		}
		stations.adminPanel();
	}
	public void transactionsOfUser(HashSet<User> users) {
		Stations stations = new Stations();
		System.out.println("Напишите email пользователя у которого хотите посмотреть транзакции: ");
		String email = in.next();
		User user1 = new User();
		user1.setLogin(email);
		for(User user : users) {
			if(user.getLogin().equals( user1.getLogin() )) {
				user1 = user;
			}
		}
		System.out.println( email );
		System.out.println( user1.getName() );
		for(Transaction transaction : user1.getTransactions()) {
			System.out.println("Тип: "+transaction.getType()+" Категория "+transaction.getCategory()+" Описание: "+transaction.getDiscription()+
					" Сумма: "+transaction.getAmount()+" Дата: "+transaction.getDate());
			stations.adminPanel();
		}
	}
	public void deleteUser(HashSet<User> users) {
		Stations stations = new Stations();
		System.out.println("Напишите email пользователя у которого хотите удалить: ");
		String email = in.next();
		User user1 = new User();
		user1.setLogin(email);
		for(User user : users) {
			if(user.getLogin().equals( user1.getLogin() )) {
				user1 = user;
			}
		}
		users.remove(user1);
		stations.adminPanel();
	}
}
