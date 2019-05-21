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
	
	static public void printAccounts() {
		AccountManagement.accountMap.values().stream().map(a -> a.convertToJSON()).forEach(System.out::println);
	}
}
