/*
 * This class defines methods and instance variables for a User object.
 * A User object holds all the information for a user of the music app,
 * including username, password, and their library.
 */
package model;


public class User {
	private String username;
	private String password; // this is temporary
	private UserLibrary userLibrary;


	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.userLibrary = new UserLibrary(new MusicStore());
	}

	// copy constructor -- to reload a User
	public User(String username, String password, UserLibrary userLibrary) {
		this.username = username;
		this.password = password;
		this.userLibrary = userLibrary;
	}

	public UserLibrary getUserLibrary() {
		return userLibrary;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

}
