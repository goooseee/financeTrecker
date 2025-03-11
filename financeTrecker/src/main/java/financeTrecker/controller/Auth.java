package financeTrecker.controller;

import java.util.HashSet;
import java.util.Scanner;

import financeTrecker.entity.User;

public class Auth {
	
	Scanner in = new Scanner( System.in );
	
	public void register(HashSet<User> users) {
		Stations stations = new Stations();
		ProfileController profileController = new ProfileController();
		String name;
		String login;
		String password;
		String passwordConf;
		System.out.println("Введите ваше имя");
		name = in.nextLine();
		System.out.println("Введите ваш email");
		login = in.nextLine();
		System.out.println("Введите ваш пароль");
		password = in.nextLine();
		System.out.println("Повторите ваш пароль");
		passwordConf = in.nextLine();
		User user = new User();
		user.setName( name );
		user.setLogin( login );
		user.setPassword( password );
		if(profileController.findEmail( users, user)) {
		if(password.equals( passwordConf )) {
			users.add( user );
			stations.setUser( user );
			stations.afterLogin();
		}else {
			System.out.println("Пароли не совпадают");
			register(users);
			}
		}else { 
			System.out.println("Этот email занят");
			register(users);
		}
	}
	
	public void login(HashSet<User> users) {
		Stations stations = new Stations();
		ProfileController profileController = new ProfileController();
		String login;
		String password;
		System.out.println("Введите ваш email");
		login = in.nextLine();
		System.out.println("Введите ваш пароль");
		password = in.nextLine();
		User user = new User();
		user.setLogin(login);
		user.setPassword(password);
		if(profileController.findUserByEmailPassword(users, user)!=null) {
			if(profileController.findUserByEmailPassword( users, user ).getLogin()=="admin") {
				stations.adminPanel();
			}else {
			stations.setUser(profileController.findUserByEmailPassword( users, user ));
			stations.afterLogin();
			}
		}else {
			System.out.println("Неправельный логин или пароль");
			login(users);
		}
	}
	
}
