package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.MusicStore;
import model.User;
import model.UserLibrary;

class UserTest {

	@Test
	void testGetUsernamePassword() {
		User myUser = new User("username", "password");
		assertEquals(myUser.getUsername(), "username");
		assertEquals(myUser.getPassword(), "password");
	}
	
	@Test
	void testConstructors() {
		User myUser1 = new User("username", "password");
		User myUser2 = new User("username", "password", new UserLibrary(new MusicStore()));
		assertFalse(myUser1.equals(myUser2));
	}
}
