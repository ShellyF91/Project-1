package project1;

import java.time.LocalDate;

public class ActivityData {
	
	private LocalDate timeStamp; 
	private double balanceChange;
	private String info;
	enum ActivityName{
		DEPOSIT, 
		WITHDRAWAL,
		GET_LOAN, 
		MAKE_PAYMENT,
		TRANSFER,
		FEE_COLLECTION,
		PAY_BILL;
	}
	ActivityName activityName;	
	
	public ActivityData(LocalDate timeStamp, double balanceChange, String info, String activityName) {
		setTimeStamp(timeStamp);
		setBalanceChange(balanceChange);
		setInfo(info);
		setActivityName(activityName);
	}
	
	private void setTimeStamp(LocalDate timeStamp) {
		this.timeStamp = timeStamp;
	}
	
	private void setBalanceChange(double balanceChange) {
		this.balanceChange = balanceChange;
	}
	
	private void setInfo(String info) {
		this.info = info;
	}
	
	private void setActivityName(String activityName) {
		this.activityName = ActivityName.valueOf(activityName);
	}
	
	public LocalDate getTimeStamp() {
		return timeStamp;
	}
	
	public double getBalanceChangee() {
		return balanceChange;
	}
	
	public String getInfo() {
		return info;
	}
	
	public String getActivityName() {
		return activityName.toString(); //TODO Override toString() 
	}
	
	public String toString() {
		String msg = String.format("--------Activity--------\nactivity information: %s\nbalance change: %f\nactivity name: %s", 
				                    getInfo(),getBalanceChangee(),getActivityName());
		msg += "activity date: " + getTimeStamp();
		return msg;
	}

	
	
}
