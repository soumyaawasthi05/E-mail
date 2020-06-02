package emailapp;

import java.util.Scanner;

public class Email {
	private String firstname;
	private String lastname;
	private String password;
	private String department;
	private String email;
	private int mailboxcapacity = 500;
	private int defaultPasswordLength = 10;
	private String alternateEmail;
	private String companySuffix = "sacompany.com";
	
	//constructor to receive first name and last name
	public Email(String firstname, String lastname){
		this.firstname = firstname;
		this.lastname = lastname;
		//System.out.println("Email creating "+this.firstname +" "+ this.lastname);;
		
		//call a method asking for departments return the department
		this.department = setDepartment();
		//System.out.println("Department : "+ this.department);
		
		//call a method that returns a random password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Your password is : " + this.password);
		
		//combine elements to generate email
		email = firstname.toLowerCase() + "." +lastname.toLowerCase() + "@" +department +"."+ companySuffix;
		//System.out.println("Your email is: "+email);
	}
	
	//ask for the department 
	
	private String setDepartment() {
		System.out.println("DEPARTMENTS \n1 For sales\n2 For Development\n3 For Accounting\n0 For none\n Enter your department code ");
		Scanner in = new Scanner(System.in);
		int depchoice = in.nextInt();
		if (depchoice == 1){
			return "Sales";
		}
		else if (depchoice == 2){
			return "Development";
		}
		else if (depchoice == 3){
			return "Accounting";
		}
		else {return " "; 
		}
		
	}
	//generate random password
	private String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";
		char[] password = new char[length];
		for(int i = 0; i<length; i++){
			int rand = (int) (Math.random() * passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	//set the mailbox capacity
	public void setMailboxCapacity(int capacity){
		this.mailboxcapacity = capacity;
	}
	//set the alternate email
	public void setAlternateEmail(String altEmail){
		this.alternateEmail = altEmail;
	}
	//change the password
	public void changePassword(String password){
		this.password = password;
	}
	public int getMailboxCapacity(){
		return mailboxcapacity;
	}
	public String getAlternateEmail(){
		return alternateEmail;
	}
	public String getPassword(){
		return password;
	}
	public String showInfo(){
		return "DISPLAY NAME: " +firstname +" "+lastname +
				"\nCOMPANY EMAIL: "+ email+
				"\nMAILBOX CAPACITY: " + mailboxcapacity + "mb";
	}
}
