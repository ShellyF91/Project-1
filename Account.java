package project1;

import java.time.LocalDate;
import java.util.UUID;


public class Account {
	
	private double balance; 
	private final UUID accountNumber; 
	private ActivityData [] history; 
	private int historyIndex;

	enum AccountProperties{
		BRONZE(4.5,6,5,7.5,10000,2500),
		SILVER(3,4.5,3.8,5,20000, 4000),
		GOLD(1.5,3,1.75,3.8,50000,6000),
		TITANIUM(0,0,0,0,0,0);
		
		private final double minInterestRate; 
		private final double maxInterestRate;
		private final double minOperationFee;
		private final double maxOperationFee;
		private final int maxLoanAmount; 
		private final int maxWithdrawalAmount;
		
		private AccountProperties(double minInterestRate, double maxInterestRate, double minOperationFee, double maxOperationFee, 
							int maxLoanAmount, int maxWithdrawalAmount){
			this.minInterestRate = minInterestRate;
			this.maxInterestRate = maxInterestRate; 
			this.minOperationFee = minOperationFee;
			this.maxOperationFee = maxOperationFee;
			this.maxLoanAmount = maxLoanAmount;
			this.maxWithdrawalAmount = maxWithdrawalAmount;
		}
		
		public double getMinInterestRate() {
			return minInterestRate;
		}
		
		public double getMaxInterestRate() {
			return maxInterestRate;
		}
		
		public double getMinOperationFee() {
			return minOperationFee;
		}
		
		public double getMaxOperationFee() {
			return maxOperationFee;
		}
		
		public int getMaxLoanAmount() {
			return maxLoanAmount;
		}
		
		public int getMaxWithdrawalAmount() {
			return maxWithdrawalAmount;
		}	
	}

	AccountProperties accountProperties;
	
	
	public Account() {
		accountNumber = UUID.randomUUID();
		history = new ActivityData[100]; 
		historyIndex = 0; 
	}
	
	
	public double getBalance() {
		return balance;
	}
	
	public int getHistoryIndex() {
		return historyIndex;
	}
	
	
	public ActivityData getHistoryInIndex(int i) {
		return history[i];
	}
	
	public void addActivityToHistory(LocalDate timeStamp, double balanceChange, String info, String activityName) {
		history[historyIndex] = new ActivityData(timeStamp, balanceChange, info, activityName);
		historyIndex++;
	}
	
	public void deposit(double depositAmount) {
		balance += depositAmount;
		
		LocalDate timeStamp = LocalDate.now(); 
		String info = String.format("a deposit of %f NIS.", depositAmount);
		addActivityToHistory(timeStamp, depositAmount, info, "DEPOSIT");
	}
	
	
	

	
	
	
	
	
	
}
