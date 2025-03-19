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
