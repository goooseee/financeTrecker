package financeTrecker.controller;

import java.util.HashSet;
import java.util.Scanner;

import financeTrecker.entity.User;

public class ProfileController {
	
	Scanner in = new Scanner( System.in );
	
	public void changeName(User user) {
		Stations stations = new Stations();
		System.out.println("Напишите имя на которое хотите сменить");
		String name = in.next();
		user.setName(name);
		stations.setUser( user );
		stations.afterLogin();
	}
	public void changeEmail(User user) {
		Stations stations = new Stations();
		System.out.println("Напишите email на которое хотите сменить");
		String email = in.next();
		user.setLogin(email);
		stations.setUser( user );
		stations.afterLogin();
	}
	public void changePassword(User user) {
		Stations stations = new Stations();
		System.out.println("Напишите пароль на которое хотите сменить");
		String password = in.next();
		user.setPassword(password);
		stations.setUser( user );
		stations.afterLogin();
	}
	public void deleteUser() {
		
	}
	public User findUserByEmailPassword(HashSet<User> users, User user) {
		for(User user1 : users) {
			if(user1.getLogin().equals( user.getLogin()) && user1.getPassword().equals( user.getPassword())) {
				return user1;
			}
		}
		return null;
	}
	public boolean findEmail(HashSet<User> users, User user) {
		for(User user1 : users) {
			if(user1.getLogin().equals( user.getLogin() )) {
				return false;
			}
		}
		return true;
	}
//	public User findEmailA(HashSet<User> users, User user) {
//		for(User user1 : users) {
//			if(user1.getLogin().equals( user.getLogin() )) {
//				return ;
//			}
//		}
//		return ;
//	}
}
