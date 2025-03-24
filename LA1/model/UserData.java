/*
 * This class defines utility to read and write to a users.txt file in order to 
 * store and retrieve user information upon each rerun of the program.
 */
package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class UserData {
	private final static String FILE_PATH = "LA1\\users.txt";

	public static void createUser(User user) {
		/*
		 * This method writes to the text file after a user has been created to 
		 * store a new user in the text file.
		 */
		try{
			
			// creates a new User and properly stores their username and password
			ArrayList<String> fileContents = getFileContents();
			String salt = fileContents.get(0);
			FileWriter userFile = new FileWriter(FILE_PATH);
			userFile.write(salt + "\n");
			fileContents.remove(0);
			for (String line : fileContents) {
				userFile.write(line + "\n");
			}
			userFile.write(user.getUsername() + " " + user.getPassword() + "\n");
			userFile.write("//\n");
			userFile.close();
			System.out.println("Successfully Created User.\n");
		}
		catch (FileNotFoundException e){
			System.out.println("File not found.");
			return;
		}
		catch (IOException e){
			System.out.println("File not found.");
			return;
		}
	} 

	public static void saveUser(User user) {
		/*
		 * This method rewrites all the data from all the users in the database to a text file so that
		 * all users can be reloaded.
		 */
		try{
			
			// saves data for new user
			ArrayList<String> fileContents = getFileContents();
			String salt = fileContents.get(0);
			FileWriter userFile = new FileWriter(FILE_PATH);
			userFile.write(salt + "\n");
			fileContents.remove(0);
			boolean ignoreNext = false;
			for (String line : fileContents) {
				if (ignoreNext) {
					if (line.equals("//")){
						ignoreNext = false;
					}
				}
				else {
					
					// saves data for existing user
					String[] fileLine = line.split(" ");
					userFile.write(line + "\n");
					if (fileLine[0].equals(user.getUsername()) && fileLine[1].equals(user.getPassword())) {
						userFile.write(user.getUserLibrary().toStringFile());
						userFile.write("//\n");
						ignoreNext = true;
					}
				}
			}

			userFile.close();
		}
		catch (FileNotFoundException e){
			System.out.println("File not found.");
			return;
		}
		catch (IOException e){
			System.out.println("File not found.");
			return;
		}

	}



	private static ArrayList<String> getFileContents() throws FileNotFoundException {
		/*
		 * This helper method gets all the content within the user.txt file that includes
		 * the information of all the users, stored in an iterable arraylist.
		 */
		ArrayList<String> fileContents = new ArrayList<>();
		File myFile = new File(FILE_PATH);
		
		Scanner myScanner = new Scanner(myFile);
		while (myScanner.hasNext()) {
			fileContents.add(myScanner.nextLine());
		}

		myScanner.close();

		return fileContents;
	}

	public static HashMap<String, String> getData(){
		/*
		 * This method gets the usernames and passwords of all the users within the text file
		 * and returns that information as a hashmap that maps username to its specific password.
		 */
		try {
			ArrayList<String>fileContents = getFileContents();
			fileContents.remove(0);
			HashMap<String, String> usernames = new HashMap<>();
			boolean ignoreNext = false;
			for (String line : fileContents) {
				if (ignoreNext) {
					if (line.equals("//")){
						ignoreNext = false;
					}
				}
				else {
					String[] fileLine = line.split(" ");
					if (fileLine.length > 1) {
						usernames.put(fileLine[0].strip(), fileLine[1].strip());
						ignoreNext = true;
					}
				}
			}

			return usernames;
		}
		catch (FileNotFoundException e) {
			System.out.println("File not found.");
			return null;
		}
	}

	public static User getUser(String username, String password) {
		/*
		 * This method retrieves and recreates a user instance for a specified user
		 * in the text file. It restores all playlists, all plays, all ratings, and everything
		 * else stored initially in the user library.
		 */
		try {
			ArrayList<String> fileContents = getFileContents();
			fileContents.remove(0);
			boolean ignoreNext = false;
			for (int i = 0; i < fileContents.size(); i++) {
				String line = fileContents.get(i);
				if (ignoreNext) {
					if (line.equals("//")){
						ignoreNext = false;
					}
				}
				else {
					String[] fileLine = line.split(" ");
					if (fileLine[0].equals(username) && fileLine[1].equals(password)) {
						String userLibraryString = "";
						for (int j = i; j < fileContents.size(); j++) {
							line = fileContents.get(j);
							if (line.equals("//")) {
								UserLibrary userLibrary = Parser.loadUserLibrary(userLibraryString);
								return new User(fileLine[0], fileLine[1], userLibrary);
							}
							userLibraryString += line + "\n";
						}
					}
					ignoreNext = true;
				}
			}
			System.out.println("Sorry, User not Found.");
			return null;
		}
		catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
			return null;
		}
	}
	
	public static String getSaltString() {
		/*
		 * This method retrieves the salt string written in the text file
		 * in order to encode and check the password when logging in.
		 */
		try {
			File myFile = new File(FILE_PATH);
			Scanner myScanner = new Scanner(myFile);
			return myScanner.nextLine().strip();
		}
		catch (FileNotFoundException e) {
			System.out.println("File Not Found.");
			return null;
		}
	}
	
	public static String writeSaltString() {
		/*
		 * This method writes the salt string to the text file so that
		 * each password can be encoded when entered in.
		 */
		
		try {
			ArrayList<String> fileContents = getFileContents();
			FileWriter userFile = new FileWriter(FILE_PATH);
			if (fileContents.isEmpty()) {
				String salt = PasswordUtil.generateSalt();
				userFile.write(salt + "\n");
			}
			else {
				for (String line : fileContents) {
					userFile.write(line + "\n");
				}
			}
			
			userFile.close();
			return fileContents.get(0).strip();
		}
		catch (IOException e) {
			System.out.println("File Not Found.");
			return null;
		}
		
	}
}
