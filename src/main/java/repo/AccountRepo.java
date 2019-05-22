package repo;

import domain.Account;

public interface AccountRepo {
	public String addAccount(String account);
	
	public Account getAccount(int id);
	
	public String deleteAccount(int id);
	
	public Account updateAccount(Account account);
	
	String getAllAccounts();
}
