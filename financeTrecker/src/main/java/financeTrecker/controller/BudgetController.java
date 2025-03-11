package financeTrecker.controller;

import java.util.Scanner;

import financeTrecker.entity.Budget;
import financeTrecker.entity.User;

public class BudgetController {
	
	Scanner in = new Scanner( System.in );

	
	public void createMounthBudget(User user) {
		Stations stations = new Stations();
		Budget budget = new Budget();
		if(user.getBudget()!=null) {
			budget = user.getBudget();
		}
		System.out.println("Напишите сумму для вашего месечного бюджета");
		budget.setMounthBudget(in.nextInt());
		user.setBudget( budget );
		stations.setUser( user );
		stations.afterLogin();
	}
	public void seeMounthBudget(User user) {
		Stations stations = new Stations();
		if(user.getBudget()!=null) {
		System.out.println("Ваш оставшийся месячный бюджет: "+user.getBudget().getMounthBudget());
		stations.setUser( user );
		stations.afterLogin();
		}else {
			System.out.println("Вы пока не создали месячный бюджет");
			stations.setUser( user );
			stations.afterLogin();
		}
	}
}
