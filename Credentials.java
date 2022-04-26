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
	
	private int setUserName(String userName) {
		if(isUserNameValid(userName)) {
			this.userName = userName; 
			return 0;
		}
		else 
			return 1; 
	}
	
	private int setPassword(String password) {
		if(isPasswordValid(password)) {
			this.password = password; 
			return 0;
		}
		else 
			return 1; 
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
		for(int i = 0; i < userName.length() && (! isThereADigit || ! isThereALetter ); i++) {
			if(!Character.isLetter(userName.charAt(i)))
				isThereALetter = true; 
			if(!Character.isDigit(userName.charAt(i)))
				isThereADigit = true; 				
		}
		
		return(isThereADigit && isThereALetter);
	}

}
