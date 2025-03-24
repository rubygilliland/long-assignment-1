package view;

import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

import model.PasswordUtil;
import model.User;
import model.UserData;
import model.UserDatabase;

public class LoginMenu {



	public static User loginSignUpMenu() {
		/*
		 * This method prompts the user to either login to an existing account or signup
		 * to create a new account.
		 */ 
		UserData.writeSaltString();
		UserDatabase myUserDatabase = new UserDatabase();
		System.out.print("Would you like to login or signup?: ");
		Scanner userInput = new Scanner(System.in);
		String response = userInput.nextLine();
		if (response.toLowerCase().equals("login") || response.toLowerCase().equals("l")) {
			return login(myUserDatabase);
		}
		else {
			return signUp(myUserDatabase);
		}


	}


	public static User signUp(UserDatabase myUserDatabase){
		/*
		 * This method creates a new user and saves their information to a text file.
		 * It prompts the user for a username and password to create an account.
		 */
		System.out.print("Enter in new Username: ");
		Scanner userLogin = new Scanner(System.in);
		String username = userLogin.nextLine();
		while (myUserDatabase.getUsernamePasswords().containsKey(username)) {
			System.out.println("A user with username already exists. Try again or restart to login.");
			System.out.print("Enter in new Username: ");
			userLogin = new Scanner(System.in);
			username = userLogin.nextLine();
		}

		System.out.print("Enter in your Password: ");
		Scanner userPass = new Scanner(System.in);
		String password = userPass.nextLine();
		while(myUserDatabase.getUsernamePasswords().containsValue(password)) {
			System.out.println("A user with password already exists. Try again or restart to login.");
			System.out.print("Enter in your Password: ");
			userPass = new Scanner(System.in);
			password = userPass.nextLine();
		}
		
		String salt = UserData.getSaltString();
		try {
			password = PasswordUtil.hashPassword(password, salt);
		} catch (NoSuchAlgorithmException e) {
			System.out.println("No Hash Found.");		}
		User myUser = new User(username, password);
		UserData.createUser(myUser);

		return myUser;

	}

	public static User login(UserDatabase myUserDatabase) {
		/*
		 * This method prompts the user to enter in their user name and password.
		 * It then retrieves the data associated with their account to load it 
		 * onto the IU.
		 */
		String salt = UserData.getSaltString();
		System.out.print("Enter in your Username: ");
		Scanner userLogin = new Scanner(System.in);
		String username = userLogin.nextLine();
		while (!myUserDatabase.getUsernamePasswords().containsKey(username)) {
			System.out.println("No user found. Try again or restart to signup.");
			System.out.print("Enter in new Username: ");
			userLogin = new Scanner(System.in);
			username = userLogin.nextLine();
		}

		System.out.print("Enter in your Password: ");
		Scanner userPass = new Scanner(System.in);
		try {
			String password = PasswordUtil.hashPassword(userPass.nextLine().strip(), salt);
			while(!myUserDatabase.getUsernamePasswords().get(username).equals(password)) {
				System.out.println("Incorrect Password. Try again or restart to signup.");
				System.out.print("Enter in your Password: ");
				userPass = new Scanner(System.in);
				password = PasswordUtil.hashPassword(userPass.nextLine().strip(), salt);
			}

			User myUser = UserData.getUser(username, password);
			return myUser;
		}
		catch (NoSuchAlgorithmException e) {
			System.out.println("No hash found.");
			return null;
		}

	}

}
