package accountapplication;

import Service.AccountService;
import domain.Account;
import repo.AccountRepoMap;

public class App {
	public void printHello() {
		System.out.println("Hello world to the standard out");
	}
	
	public static void main(String[] args) {
		AccountService serv = AccountService.getInstance();
	}
}
