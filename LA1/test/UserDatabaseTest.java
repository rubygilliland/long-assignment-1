package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import model.UserDatabase;

class UserDatabaseTest {

	@Test
	void testUsernameInUsernames() {
		UserDatabase myData = new UserDatabase();
		HashMap<String, String> usernamePasswords = myData.getUsernamePasswords();
		assertTrue(usernamePasswords.containsKey("colin"));
	}

}
