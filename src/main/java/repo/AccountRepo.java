package repo;

import domain.Account;

import java.util.HashMap;
import java.util.Map;

public class AccountRepo {
	private Map<Integer, Account> accountMap = new HashMap<>();
	
	private AccountRepo() {
		
	}
	
	static private AccountRepo repo = new AccountRepo();
	
	public Map<Integer, Account> getAccounts(){
		return accountMap;
	}
	
	public static AccountRepo getInstance() {
		return repo;
	}
}
