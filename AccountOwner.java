package project1;

import java.time.LocalDate;

public class AccountOwner extends Person {
	 
	private double monthlyIncome; //input from user
	public Account account; //needs to be created
	Credentials credentials;//input from user
	private BankManager bankManager; 
	

	public AccountOwner(String firstName, String lastName, String phoneNumber, int birthDay, int birthMonth,int birthYear, double monthlyIncome,
						String userName, String password) {
		super(firstName, lastName, phoneNumber, birthDay, birthMonth, birthYear);
		setMonthlyIncome(monthlyIncome);
		credentials = new Credentials(userName, password);
	}
	
	public void askForNewAccount() {
		bankManager.addToAccountsToApprove(this);
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
	
	public double getMonthlyIncome() {
		return monthlyIncome;
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
		//TODO the 4 digit authentication thing
		account.deposit(amountToDeposit);
	}
	
	//Use Case 6
	public void makeAWithdrawal(double amountToWithdraw) {
		account.withdrawal(amountToWithdraw);
	}
	//Use case 7 
	public void transferFunds(double amountToTransfer, String phoneNumber) {
		AccountOwner receivingAccount;
		if(amountToTransfer >= 2000) {
			System.out.println("Failed to transfer the money.");
		}
		else {
			receivingAccount = AppManager.findAccountOwnerByPhoneNumber(phoneNumber);
			receivingAccount.makeADeposit(amountToTransfer);
			account.withdrawal(amountToTransfer);
		}	
	}
	
	//Use case 8
	public void payBill(boolean isPaymentForTheBank, double billAmount) {
		if(billAmount > 5000) {
			System.out.println("Failed to pay bill.");
		}
		else {
			account.withdrawal(billAmount);
			if(isPaymentForTheBank)
				bankManager.addToBankTotalBalance(billAmount);
		}
		
	}
	
	//Use case 9
	public void askForLoan(double loanAmount) {
		//TODO check who to pay to 
		if(loanAmount > account.accountProperties.getMaxLoanAmount() || numOfpayments > 60) {
			System.out.println("The loan request was denied");
		}
		else {
			account.takeLoan(loanAmount,numOfpayments);
		}
	}
	
	


	
	
	
	
	
			
		
}

	
	
	
	


