package view;

import java.util.Scanner;
import model.User;
import model.UserData;

public class LoginMenu {
	
	
	
	public static User loginSignUpMenu() {
		System.out.print("Would you like to login or signup?: ");
		Scanner userInput = new Scanner(System.in);
		String response = userInput.nextLine();		
		if (response.toLowerCase() == "login" || response.toLowerCase() == "l") {
			return new User("nada", "nada");
		}
		else {
			return signUp();
		}
		
		
	}
	
	
	public static User signUp() {
		System.out.print("Enter in new Username: ");
		Scanner userLogin = new Scanner(System.in);
		String username = userLogin.nextLine();
		
		System.out.print("Enter in your Password: ");
		Scanner userPass = new Scanner(System.in);
		String password = userPass.nextLine();
		
		User myUser = new User(username, password);
		UserData.createUser(myUser);

		return myUser;
		
	}
	
	/*
	public static User login() {
		System.out.print("Enter in your Username: ");
		Scanner userLogin = new Scanner(System.in);
		String username = userLogin.nextLine();
		userLogin.close();
		System.out.println(username);
		
		System.out.print("Enter in your Password: ");
		Scanner userPass = new Scanner(System.in);
		String password = userPass.nextLine();
		
		return UserData.getUser(username, password);
	}
	*/
}
