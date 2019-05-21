package accountapplication;

import Service.Service;
import domain.Account;
import repo.AccountRepo;

public class App {
	public void printHello() {
		System.out.println("Hello world to the standard out");
	}
	
	public static void main(String[] args) {
		Service serv = Service.getInstance();
		serv.addAccountToMap(new Account("John", "Smith", 1));
		serv.addAccountToMap(new Account("John", "Gordon", 2));
		serv.addAccountToMap(new Account("Jordan", "Smith", 3));
		serv.addAccountToMap(new Account("John", "Peters", 4));
		System.out.println(serv.returnAccounts());
		System.out.println(serv.countAccounts("John"));
	}
}
