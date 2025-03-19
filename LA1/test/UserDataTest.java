package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.UserData;

class UserDataTest {
	
	
	
	@Test
	void testCreateAndGetSaltString() {
		assertEquals(UserData.writeSaltString(), UserData.getSaltString());
	}

}
