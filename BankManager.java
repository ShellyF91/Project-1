package project1;

public class BankManager extends AccountOwner {
	
	private AccountOwner [] accountsToApprove;
	private AccountOwner [] managedAccounts;
	private int accountsToApproveIndex;
	private int managedAccountsIndex;
	private double bankTotalBalance;
	
	
	
	public BankManager(String firstName, String lastName, String phoneNumber, int birthDay, int birthMonth,int birthYear, double monthlyIncome,
			          String userName, String password, boolean isManager) {
		super(firstName, lastName, phoneNumber, birthDay, birthMonth, birthYear, monthlyIncome, userName, password, isManager); 
		accountsToApprove = new AccountOwner[100]; 
		managedAccounts =  new AccountOwner[100];
		accountsToApproveIndex = 0; 
		managedAccountsIndex = 0; 
		bankTotalBalance = 0; 
	}
	
	public void addToAccountsToApprove(AccountOwner accountOwner) {
		accountsToApprove[accountsToApproveIndex] = accountOwner;
		accountsToApproveIndex++;
	}
	
	private void approveAccounts() {
		Account temp;
		for(int i = 0; i < accountsToApproveIndex; i++) {
			if((accountsToApprove[i].getMonthlyIncome() <= 0)) {
				temp = new Account("BRONZE"); 
				accountsToApprove[i].account = temp;
			}
			else if(accountsToApprove[i].getMonthlyIncome() > 0 && accountsToApprove[i].getMonthlyIncome() < 10000) {
				temp = new Account("SILVER"); 
				accountsToApprove[i].account = temp;
			}
			else if(accountsToApprove[i].getMonthlyIncome() > 10000 && accountsToApprove[i].getMonthlyIncome() < 30000) {
				temp = new Account("GOLD"); 
				accountsToApprove[i].account = temp;
			}
			else {
				temp = new Account("TITANIUM"); 
				accountsToApprove[i].account = temp;
			}
			
			accountsToApprove[i] = null;
		}
		accountsToApproveIndex = 0; 
	}
	
	public void addToBankTotalBalance(double amount) {
		bankTotalBalance += amount;
	}
	
}
