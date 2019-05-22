package repo;

import domain.Account;
import util.JSONUtil;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

public class AccountRepoMap implements AccountRepo {
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
	
	@Override
	public Account getAccount(int id) {
		return accountMap.get(id);
	}
	
	
	public int countAccounts(String name) {
		return (int) accountMap.values().stream().filter(a -> a.getFirstName().equals(name)).count();
	}

	@Override
	public String addAccount(String account) {
		Account newAccount = json.fromJSON(account, Account.class);
		accountMap.put(newAccount.getAccountNumber(), newAccount);
		return "{\"message\": \"The account has been successfully added\"}";
	}

	@Override
	public String deleteAccount(int id) {
		this.accountMap.remove(id);
		return "{\"message\": \"The account has been successfully deleted\"}";
	}

	@Override
	public Account updateAccount(Account account) {
		this.accountMap.put(account.getAccountNumber(), account);
		return this.accountMap.get(account.getAccountNumber());
	}

	@Override
	public String getAllAccounts() {
		return json.toJSON(this.accountMap.values());
	}
}
