package project1;

import java.time.LocalDate;
import java.util.Scanner;

public class AppManager {
	
	private static AccountOwner currUser;
	private static AccountOwner[] users;
	private static int usersIndex; 
	
	static {
		users = new AccountOwner [100]; 
		usersIndex = 0; 
	}

	public AppManager() {
		users[0] = new AccountOwner("Shelly", "Foran", "0525319556", 
				 4, 11, 1991, 100,
				 "Shelly",  "a1a1a1");
		users[1] = new AccountOwner("Eran", "Krivine", "0548166630", 
				 22, 7, 1986, 100,
				 "Eran",  "a2a2a2");
		users[2] = new AccountOwner("Karin", "Blum", "0524248724", 
				 26, 5, 1987, 200,
				 "Karin",  "a3a3a3");
		usersIndex = 3;

	}
	
	public static int getUsersIndex() {
		return usersIndex;
	}
	
	public static void openApp() {
		int optionInput = -1;
		
		while(optionInput != 0) {
			System.out.println("Welcome to the bank app! please enter 1 to login, 2 to open an account, 0 to exit.");
			optionInput= Integer.parseInt(Utils.scanner.nextLine());
			switch(optionInput) {
			case 1:
				login();
				break; 
			case 2: 
				openAccount();
				break; 
			case 0: 
				System.out.println("Goodbye!");
				break;
			default: 
				System.out.println("please try again.");
			}
			System.out.println("");
		}
	}
	
	public static void login() {
		System.out.println("--------login to your bank account--------");
		System.out.println("please enter your user name:");
		String userName = Utils.scanner.nextLine();
		//checks if user name exists
		if(isUserNameExist(userName)) { 
			System.out.println("hello " + userName + ", please enter your password:" );
			String password = Utils.scanner.nextLine();
			// checks if password is correct
			if(isPasswordCorrect(userName, password)) {
				currUser = findAccountOwnerByName(userName); 
				//if everything is correct
				handleALoggedInUser(currUser);
			}
			else {
				// try password again 2 more times 
				int passwordMistakes = 1; 
				while(passwordMistakes < 3) {
					System.out.println("invalid password. please try again:");
					password = Utils.scanner.nextLine();
					if(isPasswordCorrect(userName, password)) { 
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

	
	public static void handleALoggedInUser(AccountOwner currUser) {
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

	public static void openAccount() {
		System.out.println("--------Open a new account--------");
		currUser = Utils.createNewAccountOwner();
		if(isUserNameExist(currUser.credentials.getUserName())) {
			currUser = null;
			System.out.println("user name alreay exist, please try again.");
		}
		else {
			currUser.askForNewAccount();
			System.out.println("you have submitted succesfully. Your account will be approved soon.");
			users[usersIndex] = currUser;
			usersIndex++;
		}	
	}
	
	public static void printUsers(){
		System.out.println("users:");
		for(int i = 0; i < usersIndex; i++)
			System.out.println(users[i].getFirstName());
		
	}
	
	// searching 
	public static boolean isUserNameExist(String userName) {
		for(int i = 0; i < usersIndex || users[i] != null; i++) {
			if(users[i].getCredentials().getUserName().equals(userName))
				return true; 
		}
		return false;
	}
	
	public static boolean isPasswordCorrect(String userName, String password) {
		return findAccountOwnerByName(userName).getCredentials().getPassword() == password; 
	}
	
	public static AccountOwner findAccountOwnerByName(String userName) {
		for(int i = 0; i < usersIndex || users[i] != null; i++) {
			if(users[i].getCredentials().getUserName() == userName)
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
