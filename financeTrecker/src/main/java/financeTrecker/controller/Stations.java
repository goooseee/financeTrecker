package financeTrecker.controller;

import java.util.HashSet;
import java.util.Scanner;

import financeTrecker.FinanceTrecker;
import financeTrecker.entity.User;

public class Stations {
	
	AdminController adminController = new AdminController();
	StatisticsController statisticsController = new StatisticsController();
	PurposeController purposeController = new PurposeController();
	BudgetController budgetController = new BudgetController();
	FinanceTrecker financeTrecker = new FinanceTrecker();
	Scanner in = new Scanner( System.in );
	Auth auth = new Auth();
	ProfileController profileController = new ProfileController();
	User user = new User();
	HashSet<User> users = financeTrecker.getSet();
	TransactionCRUD transactionCRUD = new TransactionCRUD();
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public int kill() {
		return 0;
	}
	
	public void start() {
		System.out.println("Введите число соответсвуещее следуещему списку");
		System.out.println("1 Регистрация");
		System.out.println("2 Вход");
		System.out.println("3 Закрыть программу");
		int i = in.nextInt();
		switch(i) {
			case 1:
				auth.register(users);
				break;
			case 2:
				auth.login(users);
				break;
			case 3:
				kill();
		}
	}
	public void afterLogin() {
		System.out.println("Введите число соответсвуещее следуещему списку");
		System.out.println("1 Профиль");
		System.out.println("2 Транзакции");
		System.out.println("3 Бюджет");
		System.out.println("4 Цель");
		System.out.println("5 Статистика и аналитика");
		System.out.println("6 Выход из аккаунта");
		System.out.println("7 Закрыть программу");
		int i = in.nextInt();
		switch(i) {
			case 1:
				profile();
			case 2:
				transactions();
			case 3:
				budget();
			case 4:
				purpose();
			case 5:
				statistics();
			case 6:
				start();
				break;
			case 7:
				kill();
		}
	}
	public void profile() {
		System.out.println("Введите число соответсвуещее следуещему списку");
		System.out.println("1 Редактирование профиля");
		System.out.println("2 Удаление аккаунта");
		System.out.println("3 Вернуться обратно");
		System.out.println("4 Закрыть программу");
		int i = in.nextInt();
		switch(i) {
			case 1:
				redactProfile();
				break;
			case 2:
				start();
				break;
				//метод на удаление данных из мапы
			case 3:
				afterLogin();
				break;
			case 4:
				kill();
		}
	}
	public void redactProfile() {
		System.out.println("Введите число соответсвуещее следуещему списку");
		System.out.println("1 Изменить имя");
		System.out.println("2 Изменить email");
		System.out.println("3 Изменить пароль");
		System.out.println("4 Вернуться обратно");
		System.out.println("5 Закрыть программу");
		int i = in.nextInt();
		switch(i) {
			case 1:
				profileController.changeName(user);
				break;
			case 2:
				profileController.changeEmail( user );
				break;
			case 3:
				profileController.changePassword( user );
				break;
			case 4:
				afterLogin();
				break;
			case 5:
				kill();
		}
	}
	public void transactions() {
		System.out.println("Введите число соответсвуещее следуещему списку");
		System.out.println("1 Создать транзакцию");
		System.out.println("2 Удалить транзакцию");
		System.out.println("3 Изменить транзакцию");
		System.out.println("4 Посмотреть список транзакций");
		System.out.println("5 Вернуться обратно");
		System.out.println("6 Закрыть программу");
		int i = in.nextInt();
		switch(i) {
			case 1:
				transactionCRUD.creatTransaction(user);
				break;
			case 2:
				transactionCRUD.deleteTransaction( user );
				break;
			case 3:
				transactionCRUD.redactTransaction( user );
				break;
			case 4:
				transactionCRUD.seeAllTransaction(user);
				break;
			case 5:
				afterLogin();
				break;
			case 6:
				kill();
		}
	}
	public void budget() {
		System.out.println("Введите число соответсвуещее следуещему списку");
		System.out.println("1 Создать месячный бюджет");
		System.out.println("2 Узнать о превышение бюджета");
		System.out.println("3 Вернуться обратно");
		System.out.println("4 Закрыть программу");
		int i = in.nextInt();
		switch(i) {
			case 1:
				budgetController.createMounthBudget( user );
				break;
			case 2:
				budgetController.seeMounthBudget( user );
				break;
			case 3:
				afterLogin();
				break;
			case 4:
				kill();
		}
	}
	public void statistics() {
		System.out.println("Введите число соответсвуещее следуещему списку");
		System.out.println("1 Баланс");
		System.out.println("2 Сумма доходов за период");
		System.out.println("3 Сумма расходов за период");
		System.out.println("4 Расходы по категориям");
		System.out.println("5 Вернуться обратно");
		System.out.println("6 Закрыть программу");
		int i = in.nextInt();
		switch(i) {
			case 1:
				statisticsController.balance(user);
				break;
			case 2:
				statisticsController.incomeDate(user);
				break;
			case 3:
				statisticsController.expenditureDate(user);
				break;
			case 4:
				statisticsController.expenditureCategory(user);
				break;
			case 5:
				afterLogin();
				break;
			case 6:
				kill();
		}
	}
	public void purpose() {
		System.out.println("Введите число соответсвуещее следуещему списку");
		System.out.println("1 Создание цели");
		System.out.println("2 Просмотр прогресса");
		System.out.println("3 Вернуться обратно");
		System.out.println("4 Закрыть программу");
		int i = in.nextInt();
		switch(i) {
			case 1:
				purposeController.creatPurpose( user );
				break;
			case 2:
				purposeController.seePurpose( user );
				break;
			case 3:
				afterLogin();
				break;
			case 4:
				kill();
		}
	}
	public void adminPanel() {
		System.out.println("Введите число соответсвуещее следуещему списку");
		System.out.println("1 Список пользователей");
		System.out.println("2 Список транзакций пользователя");
		System.out.println("3 Удалить пользователя");
		System.out.println("4 Закрыть программу");
		int i = in.nextInt();
		switch(i) {
			case 1:
				adminController.allUsers(users);
				break;
			case 2:
				adminController.transactionsOfUser(users);
				break;
			case 3:
				adminController.deleteUser(users);
				break;
			case 4:
				kill();
		}
	}
}
