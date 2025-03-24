/*
 * This class defines an object that stores all usernames and passwords as they are mapped together.
 * The class stores them in a hashmap to ensure no duplicated usernames or passwords.
 */
package model;

import java.util.HashMap;
import java.util.HashSet;

public class UserDatabase {

	private final HashMap<String, String> usernamePasswords;

	public UserDatabase() {
		usernamePasswords = UserData.getData();
	}

	public HashMap<String, String> getUsernamePasswords(){
		return usernamePasswords;
	}

}
