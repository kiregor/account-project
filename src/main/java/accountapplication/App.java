package accountapplication;

import Service.AccountService;

public class App {
	public void printHello() {
		System.out.println("Hello world to the standard out");
	}
	
	public static void main(String[] args) {
		AccountService serv = AccountService.getInstance();
	}
}
