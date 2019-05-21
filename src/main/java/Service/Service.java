package Service;

import domain.Account;
import repo.AccountManagement;

public class Service {
	
	static public void addAccountToMap(Account newAccount) {
		AccountManagement.accountMap.put(newAccount.getAccountNumber(), newAccount);
	}
	
	static public Account retrieveAccount(int accountNumber) {
		return AccountManagement.accountMap.get(accountNumber);
	}
	
}
