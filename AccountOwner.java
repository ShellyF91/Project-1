package project1;

import java.time.LocalDate;

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
	
	//Use Case 3
	public void checkBalance() {
		System.out.println("your account balance is: " + account.getBalance());
	}
	
	//Use Case 4
	public void  produceActivityReport(LocalDate startDate) {
		LocalDate currDate = LocalDate.now();
		System.out.println("Your activity report from " + startDate + " to " + currDate);
		int i = 0; 
		LocalDate temp;
		while(i <= account.getHistoryIndex()) {
			temp = LocalDate.parse(account.getHistoryInIndex(i).getTimeStamp().toString());
			if(startDate.isAfter(temp)){
				System.out.println(account.getHistoryInIndex(i).toString());
			}
		System.out.println("***** your account balance is: " + account.getBalance() + " *****");
		}
	}
	//Use Case 5
	public void makeADeposit(double amountToDeposit) {
		account.deposit(amountToDeposit);
		
	}
	
	
			
		
}

	
	
	
	


