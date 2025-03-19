package test;

import static org.junit.jupiter.api.Assertions.*;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import org.junit.jupiter.api.Test;

import model.PasswordUtil;

class PasswordUtilTest {

	@Test
	void testGenerateSaltAndHash() throws NoSuchAlgorithmException {
		String salt = PasswordUtil.generateSalt();
		String password = "hello";
		MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(Base64.getDecoder().decode(salt));
        byte[] hashedPassword = md.digest(password.getBytes());
        String hashPassword = Base64.getEncoder().encodeToString(hashedPassword);
        
        assertEquals(hashPassword, PasswordUtil.hashPassword(password, salt));
	}
}
