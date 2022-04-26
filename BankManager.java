package project1;

public class BankManager extends AccountOwner {
	
	private AccountOwner [] accountsToApprove;
	private AccountOwner [] managedAccounts;
	private int accountsToApproveIndex;
	private int managedAccountsIndex;

	
	public BankManager(String firstName, String lastName, String phoneNumber, int birthDay, int birthMonth,int birthYear, double monthlyIncome,
			          String userName, String password) {
		super(firstName, lastName, phoneNumber, birthDay, birthMonth, birthYear, monthlyIncome, userName, password); 
		accountsToApprove = new AccountOwner[100]; 
		managedAccounts =  new AccountOwner[100];
		accountsToApproveIndex = 0; 
		managedAccountsIndex = 0; 
	}

	
	public void addToAccountsToApprove(AccountOwner accountOwner) {
		accountsToApprove[accountsToApproveIndex] = accountOwner;
		accountsToApproveIndex++;
	}
	
	private void approveAccounts() {
		
		Account temp;
		String type;
		for(int i = 0; i < accountsToApproveIndex; i++) {
			if((accountsToApprove[i].getMonthlyIncome() <= 0)) {
				type = "BRONZE"; 
			}
			else if(accountsToApprove[i].getMonthlyIncome() > 0 && accountsToApprove[i].getMonthlyIncome() < 10000) {; 
				type = "SILVER"; 
			}
			else if(accountsToApprove[i].getMonthlyIncome() > 10000 && accountsToApprove[i].getMonthlyIncome() < 30000) {
				type = "GOLD"; 
			}
			else {
				type = "TITANIUM"; 
			}
			
			temp = new Account(type); 
			accountsToApprove[i].account = temp;
			accountsToApprove[i] = null;
		}
		accountsToApproveIndex = 0; 
	}
	
}
