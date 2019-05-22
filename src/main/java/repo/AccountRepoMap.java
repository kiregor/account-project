package repo;

import domain.Account;
import util.JSONUtil;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

public class AccountRepoMap {
	private Map<Integer, Account> accountMap = new HashMap<>();
	
	@Inject
	JSONUtil json;
	
	private AccountRepoMap() {
		
	}
	
	static private AccountRepoMap repo = new AccountRepoMap();
	
	public String getAccounts(){
		return json.toJSON(accountMap);
	}
	
	public static AccountRepoMap getInstance() {
		return repo;
	}
	
	public void addAccount(Account newAccount) {
		accountMap.put(newAccount.getAccountNumber(), newAccount);
	}
	
	public Account getAccount(int id) {
		return accountMap.get(id);
	}
	
	
	public int countAccounts(String name) {
		return (int) accountMap.values().stream().filter(a -> a.getFirstName().equals(name)).count();
	}
}
