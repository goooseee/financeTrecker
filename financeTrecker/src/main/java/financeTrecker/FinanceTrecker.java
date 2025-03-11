package financeTrecker;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

import financeTrecker.controller.Stations;
import financeTrecker.entity.User;

public class FinanceTrecker {
	
	static HashSet<User> users = new HashSet<>();
	
	public static void main(String[] argc) {
		User user = new User("admin","admin","admin",null,null,null);
		users.add(user);
		Stations stations = new Stations();
		//stations.setSet( users );
		stations.start();
	}
	
	public HashSet<User> getSet(){
		return users;
	}
}
