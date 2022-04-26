package project1;



public class Credentials {
	
	private String userName; 
	private String password;
	
	public Credentials(String userName, String password) {
		setUserName(userName);
		setPassword(password);
	}
	
	public String getUserName() {
		return userName; 
	}
	
	public String getPassword() {
		return password; 
	} 
	
	private void setUserName(String userName) {
		if(isUserNameValid(userName))
			this.userName = userName; 
		else 
			System.out.println("Illegal user name. try again."); 
	}
	
	private void setPassword(String password) {
//		if(isPasswordValid(password)) {
//			this.password = password; 
//		}
//		else 
//			System.out.println("Illegal password. try again."); 
		this.password = password; 
	}
	
	private boolean isUserNameValid(String userName) {
		for(int i = 0; i < userName.length(); i++) {
			if(!Character.isLetterOrDigit(userName.charAt(i)))
				return false;	
		}
		return true; 
	}
	
	private boolean isPasswordValid(String password) {
		if(password.length() < 4 || password.length() > 8)
			return false; 
		boolean isThereADigit = false, isThereALetter = false;
		for(int i = 0; i < password.length(); i++) {
			if(Character.isLetter(password.charAt(i))) 
				isThereALetter = true; 
			if(Character.isDigit(password.charAt(i)))
				isThereADigit = true; 				
		}
		return(isThereADigit && isThereALetter);
	}
}
