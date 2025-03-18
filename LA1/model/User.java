package model;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;
import java.util.HashMap;

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
	
//	public static String generateSalt() {
//        SecureRandom randomNums = new SecureRandom();
//        byte[] salt = new byte[16];
//        randomNums.nextBytes(salt);
//        return salt;
//        //String saltToAdd = Base64.getEncoder().encodeToString(salt);
//        //return saltToAdd;
//    }
//	
//	public static String hashPassword(String password, byte[] salt) {
//			try {
//				MessageDigest md = MessageDigest.getInstance("SHA-256");
//				//String passWithSalt = salt + password;
//	            byte[] hashBytes = md.digest(salt);
//	            return Base64.getEncoder().encodeToString(hashBytes);
//			} catch (NoSuchAlgorithmException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				return null;
//			}
//            
//	}
	}
