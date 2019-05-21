package accountapplication;

import java.util.Map;

public class Service {
	
	static public void addAccountToMap(Map<Integer, Account> map, Account newAccount) {
		map.put(newAccount.getAccountNumber(), newAccount);
	}
	
	static public Account retrieveAccount(Map<Integer, Account> map, int accountNumber) {
		return map.get(accountNumber);
	}
	
}
