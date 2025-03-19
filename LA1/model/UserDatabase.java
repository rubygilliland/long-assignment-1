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
