package Service;

import com.google.gson.Gson;

import domain.Account;
import repo.AccountRepo;

public class Service {
	
	private AccountRepo repo;
	
	private Service() {
		repo = AccountRepo.getInstance();
	}
	
	private static Service serv = new Service();
	
	public static Service getInstance() {
		return serv;
	}
	
	public void addAccountToMap(Account newAccount) {
		repo.getAccounts().put(newAccount.getAccountNumber(), newAccount);
	}
	
	public Account retrieveAccount(int accountNumber) {
		return repo.getAccounts().get(accountNumber);
	}
	
	public String returnAccounts() {
		return new Gson().toJson(repo.getAccounts());
	}
	
	public int countAccounts(String name) {
		return (int) repo.getAccounts().values().stream().filter(a -> a.getFirstName().equals(name)).count();
	}
}
