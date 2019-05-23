package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.gson.Gson;

@Entity
public class Account {
	private String firstName;
	private String lastName;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int accountNumber;
	
	public Account() {
		
	}
	
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
	
	public boolean updateAccount(Account update) {
		this.firstName = update.getFirstName();
		this.lastName = update.getLastName();
		
		return true;
	}
}
