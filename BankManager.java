package project1;

public class BankManager extends Person {
	
	private Account [] accountsToApprove;
	private Account [] managedAccounts;
	int accountsToApproveIndex;
	int managedAccountsIndex;
	
	
	
	public BankManager(String firstName, String lastName, String phoneNumber, int birthDay, int birthMonth, int birthYear) {
		super(firstName, lastName, phoneNumber, birthDay, birthMonth, birthYear); 
		accountsToApprove = new Account[100]; 
		managedAccounts =  new Account[100];
		accountsToApproveIndex = 0; 
		managedAccountsIndex = 0; 
	}
	
	public void askForApproval() {
		accountsToApprove[accountsToApproveIndex] = 
	}

}
