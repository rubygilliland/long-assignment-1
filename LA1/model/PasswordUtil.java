/*
 * This class defines utility that is used to securely store passwords
 * for a user database. It has methods to create a salt and hash a password.
 */
package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

public class PasswordUtil {

    public static String generateSalt() {
    	/*
    	 * This method generates a random salt for a password to 
    	 * enhance password security.
    	 */
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        return Base64.getEncoder().encodeToString(salt);
    }

    public static String hashPassword(String password, String salt) throws NoSuchAlgorithmException {
    	/*
    	 * This method fully hashes a password given a password String and a salt
    	 * String.
    	 */
    	MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(Base64.getDecoder().decode(salt));
        byte[] hashedPassword = md.digest(password.getBytes());
        
        return Base64.getEncoder().encodeToString(hashedPassword);
    }
    

}
