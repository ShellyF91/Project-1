package project1;

import java.time.LocalDate;

public abstract class Person {
	private String firstName;
	private String lastName;
	private String phoneNumber; 
	private LocalDate birthDate;
	
	
	public Person(String firstName, String lastName, String phoneNumber, int birthDay, int birthMonth, int birthYear) {
		setFirstName(firstName);
		setLastName(lastName);
		setPhoneNumber(phoneNumber);
		setBirthDate(birthDay, birthMonth, birthYear);
	}
	
	private void setFirstName(String firstName) {
		this.firstName = firstName;
		
	}
	
	private void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	private void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	private void setBirthDate(int day, int month, int year) {
		birthDate = LocalDate.of(year, month, day);
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public LocalDate getBirthDate() {
		return birthDate;
	}
	
	
	@Override
	public String toString() {
		LocalDate currentDate = LocalDate.now();
		int age = currentDate.getYear()-1 - birthDate.getYear();
		String msg = String.format("full name: %s %s, phone number: %s, age: %d", firstName, lastName, phoneNumber, age);
		return msg; 
	}
	
	

}
