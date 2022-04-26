package project1;

import java.util.Scanner; 

public class AppManager {
	
	private AccountOwner currUser;
	private static AccountOwner[] users;
	protected Scanner scanner = new Scanner(System.in); 
	
	
	static {
		users = new AccountOwner [100]; 
	}
	
	public AppManager() {
		System.out.println("Welcome to the bank app! please enter 1 to login, 2 to open an account, 0 to exit");
		int optionInput = scanner.nextInt();
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
				System.out.println("please try again");
		}
	}
	
	public void login() {
		
		System.out.println("--------login to your bank account--------");
		System.out.println("please enter your user name:");
		String userName = scanner.nextLine();
		if(isUserNameExist(userName)) { //TODO
			System.out.println("hello " + userName + ", please enter your password:" );
			String password = scanner.nextLine();
			// checks if password is correct
			if(isPasswordCorrect(password)) {
				currUser = findAccountOwnerByName(userName); //TODO
				handleALoggedInUser(currUser);
			}
			else {
				int passwordMistakes = 1; 
				while(passwordMistakes < 3) {
					System.out.println("invalid password. please try again:");
					password = scanner.nextLine();
					if(isPasswordCorrect(password)) { //TODO
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
		System.out.println("Hello "+ currUser.credentials.getUserName() + " ,you are logged in to your account.");
		System.out.println("Your balance is " + currUser.getAccount().getBalance() + " NIS.");
		System.out.println("what would you like to do now?");
		showMenu(); 
	}
	
	public void openAccount() {
		
//		System.out.println("--------Open a new account--------");
//		String firstName;
//		String lastName;
//		String phoneNumber;
//		int birthDay;
//		int birthMonth;
//		int birthYear;
//		double monthlyIncome;
//		String userName;
//		String password;
//		
//		System.out.println("please enter your first name");
//		System.out.println("please enter your last name");
//		
//		
//		
//		currUser = new AccountOwner(firstName, lastName, phoneNumber, birthDay, birthMonth, birthYear, monthlyIncome, userName, password);
	
	}
	
	public void showMenu() {
		System.out.println("");
	}
	
	public boolean isUserNameExist(String userName) {
		for(int i = 0; i < users.length; i++) {
			if(users[i].getCredentials().getUserName().equals(userName))
				return true; 
		}
		return false;
	}
	
	public boolean isPasswordCorrect(String password) {
		for(int i = 0; i < users.length; i++) {
			if(users[i].credentials.getPassword().equals(password))
				return true; 
		}
		return false;
	}
	
	public AccountOwner findAccountOwnerByName(String userName) {
		for(int i = 0; i < users.length; i++) {
			if(users[i].credentials.getUserName() == userName)
				return users[i]; 
		}
		return null;
	}
	
	public static AccountOwner findAccountOwnerByPhoneNumber(String phoneNumber) {
		for(int i = 0; i < users.length; i++) {
			if(users[i].getPhoneNumber() == phoneNumber)
				return users[i]; 
		}
		return null;
	}


	

}
