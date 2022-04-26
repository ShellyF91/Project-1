package project1;

import java.time.LocalDate;
import java.util.Scanner;

public class AppManager {
	
	private AccountOwner currUser;
	private static AccountOwner[] users;
	private static int usersIndex; 
	
	static {
		users = new AccountOwner [100]; 
		usersIndex = 0; 
	}
	
	public AppManager() {
		
	}
	
	public int getUsersIndex() {
		return usersIndex;
	}
	
	public void openApp() {
		int optionInput;
		System.out.println("Welcome to the bank app! please enter 1 to login, 2 to open an account, 0 to exit");
		optionInput= Integer.parseInt(Utils.scanner.nextLine());
		switch(optionInput) {
			case 1:
				login();
				Utils.scanner.close();
				break; 
			case 2: 
				openAccount();
				Utils.scanner.close();
				break; 
			case 0: 
				Utils.scanner.close();
				System.out.println("Goodbye!");
				break;
			default: 
				System.out.println("please try again");
			}
	}
	
	public void login() {
		System.out.println("--------login to your bank account--------");
		System.out.println("please enter your user name:");
		String userName = Utils.scanner.nextLine();
		//checks if user name exists
		if(isUserNameExist(userName)) { 
			System.out.println("hello " + userName + ", please enter your password:" );
			String password = Utils.scanner.nextLine();
			// checks if password is correct
			if(isPasswordCorrect(password)) {
				currUser = findAccountOwnerByName(userName); 
				//everything is correct
				handleALoggedInUser(currUser);
			}
			else {
				// try password again 2 more times 
				int passwordMistakes = 1; 
				while(passwordMistakes < 3) {
					System.out.println("invalid password. please try again:");
					password = Utils.scanner.nextLine();
					if(isPasswordCorrect(password)) { 
						currUser = findAccountOwnerByName(userName);
						handleALoggedInUser(currUser);
						break;
					}
					else {
						passwordMistakes++;
					}
				}
				if(passwordMistakes == 3)
					System.out.println("entry failed. please try again in 30 minutes.");
			}	
		}
		
		else {
			System.out.println("no such user name. please try again.");
			}
		}

	
	public void handleALoggedInUser(AccountOwner currUser) {
		//presenting the login options
		System.out.println("Hello "+ currUser.credentials.getUserName() + " ,you are logged in to your account.");
		System.out.println("Your balance is " + currUser.getAccount().getBalance() + " NIS.");
		System.out.println("what would you like to do now?");
		Utils.showMenu();
		int optionInput = -1;
		//variables for handling option input
		LocalDate today; 
		double amount = 0;
		String phoneNumber; 
		String payee; 
		boolean isPaymentForTheBank = false;
		int numOfpayments = 0;
		// managing the selected use cases 
		while(optionInput != 0) {
			optionInput = Integer.parseInt(Utils.scanner.nextLine());
			switch(optionInput) {
			case 3:
				currUser.checkBalance();
				break;
			case 4:
				today = LocalDate.now();
				currUser.produceActivityReport(today);
				break;
			case 5:
				System.out.println("please enter the amount you want to deposit:");
				amount = Integer.parseInt(Utils.scanner.nextLine());
				currUser.makeADeposit(amount);
				break;
			case 6:
				System.out.println("please enter the amount you want to withdraw:");
				amount = Integer.parseInt(Utils.scanner.nextLine());
				currUser.makeAWithdrawal(amount);
				break;
			case 7:
				System.out.println("please enter the phone number of the acoount owner you want to transfer funds to:");
				phoneNumber = Utils.scanner.nextLine();
				System.out.println("please enter the amount you want to transfer:");
				amount = Integer.parseInt(Utils.scanner.nextLine());
				currUser.transferFunds(amount, phoneNumber);
				break;
			case 8:
				System.out.println("please enter the amount of the bill:");
				amount = Integer.parseInt(Utils.scanner.nextLine());
				System.out.println("please enter a payee - 'bank' (for loan return), 'phone', 'water', 'electric company'.");
				payee = Utils.scanner.nextLine();
				if(payee == "bank")
					isPaymentForTheBank = true; 
				currUser.payBill(isPaymentForTheBank, amount);
				break;
			case 9:
				System.out.println("please enter the amount of the loan you wish to get:");
				amount = Integer.parseInt(Utils.scanner.nextLine());
				System.out.println("please enter a prefered number of monthly payments:");
				numOfpayments = Integer.parseInt(Utils.scanner.nextLine());
				currUser.askForLoan(amount, numOfpayments);
				break;
			default:
				System.out.println("invalid input, try again.");
			}
		}		
	}
	
	public void openAccount() {
		System.out.println("--------Open a new account--------");
		currUser = Utils.createNewAccountOwner();
		if(isUserNameExist(currUser.credentials.getUserName())) {
			System.out.println("user name alreay exist, please try again.");
			currUser = null; 
		}
		else {
			currUser.askForNewAccount();
			System.out.println("you have submitted succesfully. Your account will be approved soon.");
			users[usersIndex] = currUser;
			usersIndex++;
		}	
	}
	
	
	public boolean isUserNameExist(String userName) {
		for(int i = 0; i < usersIndex || users[i] != null; i++) {
			if(users[i].getCredentials().getUserName().equals(userName))
				return true; 
		}
		return false;
	}
	
	public boolean isPasswordCorrect(String password) {
		for(int i = 0; i < usersIndex || users[i] != null; i++) {
			if(users[i].credentials.getPassword().equals(password))
				return true; 
		}
		return false;
	}
	
	public AccountOwner findAccountOwnerByName(String userName) {
		for(int i = 0; i < usersIndex || users[i] != null; i++) {
			if(users[i].credentials.getUserName() == userName)
				return users[i]; 
		}
		return null;
	}
	
	public static AccountOwner findAccountOwnerByPhoneNumber(String phoneNumber) {
		for(int i = 0; i < usersIndex || users[i] != null; i++) {
			if(users[i].getPhoneNumber() == phoneNumber)
				return users[i]; 
		}
		return null;
	}

}
