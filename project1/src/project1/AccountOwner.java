package project1;

public class AccountOwner extends Person {
	
	private double monthlyIncome;
	private Account account;
	Person person;
	Credentials credentials;
	private BankManager bankManager;
	

	public AccountOwner(String firstName, String lastName, String phoneNumber, int birthDay, int birthMonth,int birthYear, double monthlyIncome,
						String userName, String password) {
		super(firstName, lastName, phoneNumber, birthDay, birthMonth, birthYear);
		setMonthlyIncome(monthlyIncome);
		credentials = new Credentials(userName, password);
	}
	
	private void setMonthlyIncome(double monthlyIncome) {
		
		if(monthlyIncome < 0)
			System.out.println("invalid income");
		else 
			this.monthlyIncome = monthlyIncome; 
	}
	
	public Account getAccount() {
		return account;
	}
	
	public Credentials getCredentials() {
		return credentials;
	}
	

	
	
	
	

}
