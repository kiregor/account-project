package accountapplication;

public class Account {
	private String firstName;
	private String lastName;
	private int accountNumber;
	
	public Account(String inputFirstName, String inpurLastNAme, int inputAccountNumber) {
		firstName = inputFirstName;
		lastName = inpurLastNAme;
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
}
