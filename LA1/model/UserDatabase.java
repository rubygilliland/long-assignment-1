package model;

import java.util.HashMap;
import java.util.HashSet;

public class UserDatabase {
	
	private final HashMap<String, String> usernamePasswords;
	private final HashSet<String> usernames;
	private final HashSet<String> passwords;
	
	public UserDatabase() {
		usernamePasswords = UserData.getData();
		usernames = UserData.getUsernames();
		passwords = UserData.getPasswords();
	}
	
	public HashMap<String, String> getUsernamePasswords(){
		return usernamePasswords;
	}
	
	public HashSet<String> getUsernames(){
		return usernames;
	}
	
	public HashSet<String> getPasswords(){
		return passwords;
	}

}
