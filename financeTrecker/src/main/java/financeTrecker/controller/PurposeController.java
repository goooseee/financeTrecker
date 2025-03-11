package financeTrecker.controller;

import java.util.Scanner;

import financeTrecker.entity.Purpose;
import financeTrecker.entity.User;

public class PurposeController {
	
	Scanner in = new Scanner(System.in);
	
	public void creatPurpose(User user) {
		Stations stations = new Stations();
		Purpose purpose = new Purpose();
		String name;
		int amount;
		int savings = 0;
		System.out.println("Напишите название цели");
		name = in.next();
		System.out.println("Укажите сумму для цели");
		amount = in.nextInt();
		purpose = new Purpose( name, amount, savings );
		user.setPurpose( purpose );
		stations.setUser( user );
		stations.afterLogin();
	}
	public void seePurpose(User user) {
		Stations stations = new Stations();
		Purpose purpose = new Purpose();
		if(user.getPurpose()==null) {
			System.out.println("У вас пока не создана цель для накоплений");
			stations.setUser( user );
			stations.afterLogin();
		}else {
			purpose = user.getPurpose();
			System.out.println("Название цели: "+ purpose.getName() +" прогресс по цели: "+ purpose.getSavings() +"/"+ purpose.getAmount());
			stations.setUser( user );
			stations.afterLogin();
		}
	}
}
