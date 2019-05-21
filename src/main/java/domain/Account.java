package domain;

import com.google.gson.Gson;

public class Account {
	private String firstName;
	private String lastName;
	private int accountNumber;
	
	public Account(String inputFirstName, String inputLastNAme, int inputAccountNumber) {
		firstName = inputFirstName;
		lastName = inputLastNAme;
		accountNumber = inputAccountNumber;
	}
	
	public String getFirstName(){
		return firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}
	
	public String convertToJSON() {
		return new Gson().toJson(this);
	}
}
