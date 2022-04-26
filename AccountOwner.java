package project1;

public class AccountOwner extends Person {
	 
	private double monthlyIncome; //input from user
	private Account account; //needs to be created
	Person person;//input from user
	Credentials credentials;//input from user
	private BankManager bankManager; 
	

	public AccountOwner(String firstName, String lastName, String phoneNumber, int birthDay, int birthMonth,int birthYear, double monthlyIncome,
						String userName, String password) {
		super(firstName, lastName, phoneNumber, birthDay, birthMonth, birthYear);
		setMonthlyIncome(monthlyIncome);
		credentials = new Credentials(userName, password);
		account = new Account(); //TODO - change to approve by manager
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
