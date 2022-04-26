package project1;

import java.util.Scanner; 

public class Utils {
	
	public static Scanner scanner = new Scanner(System.in);
	
	public static void showMenu() {
		
		System.out.println("press 3 to check balance.");
		System.out.println("press 4 to produce activity report.");
		System.out.println("press 5 to make a deposit.");
		System.out.println("press 6 to Withdraw cash.");
		System.out.println("press 7 to transfer funds to another account.");
		System.out.println("press 8 to pay bill.");
		System.out.println("press 9 to get a loan.");
		System.out.println("press 0 to go back.");
		System.out.println("");
		System.out.println("press here:");
	}
	
	public static AccountOwner createNewAccountOwner() {
		System.out.println("enter your first name:");
		String firstName = scanner.nextLine();
		
		System.out.println("enter your last name:");
		String lastName = scanner.nextLine();
		
		System.out.println("enter your phone number:");
		String phoneNumber = scanner.nextLine();
		
		System.out.println("enter a user name:");
		String userName= scanner.nextLine();
		
		
		System.out.println("enter a password:");
		String password = scanner.nextLine();
		
		System.out.println("enter your birth year:");
		int birthYear = Integer.parseInt(scanner.nextLine());
		
		System.out.println("enter your birth month:");
		int birthMonth = Integer.parseInt(scanner.nextLine());
		
		System.out.println("enter your birth day:");
		int birthDay = Integer.parseInt(scanner.nextLine());
		
		System.out.println("enter your monthly income:");
		double monthlyIncome = scanner.nextDouble();
		
		System.out.println("enter 'true' if you are a bank manager, 'false' if you are not.");
		boolean isManager = scanner.nextBoolean();
		

		AccountOwner newAccountOwner = new AccountOwner(firstName, lastName, phoneNumber, 
				 birthDay, birthMonth, birthYear, monthlyIncome,
				 userName,  password,  isManager);
		return newAccountOwner; 
	}
	


}
