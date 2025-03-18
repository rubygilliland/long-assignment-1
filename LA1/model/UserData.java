package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UserData {
	private final static String FILE_PATH = "C:\\Users\\colin\\eclipse-workspace\\long-assignment-1\\LA1\\users.txt";
	//private static HashMap
	
	public static void createUser(User user) {
		
		try{ 
			ArrayList<String> fileContents = getFileContents();
			FileWriter userFile = new FileWriter(FILE_PATH);
			for (String line : fileContents) {
				userFile.write(line + "\n");
			}
			userFile.write(user.getUsername() + " " + user.getPassword() + "\n");
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
		
		try{ 
			ArrayList<String> fileContents = getFileContents();
			FileWriter userFile = new FileWriter(FILE_PATH);
			boolean ignoreNext = false;
			for (String line : fileContents) {
				if (ignoreNext) {
					if (line.equals("//")){
						ignoreNext = false;
					}
				}
				else {
					String[] fileLine = line.split(" ");
					userFile.write(line + "\n");
					if (fileLine[0].equals(user.getUsername()) && fileLine[1].equals(user.getPassword())) {
						userFile.write(user.getUserLibrary().toString());
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
		ArrayList<String> fileContents = new ArrayList<>();
		File myFile = new File(FILE_PATH);
		
		Scanner myScanner = new Scanner(myFile);
		while (myScanner.hasNext()) {
			fileContents.add(myScanner.nextLine());
		}
		
		myScanner.close();
		
		return fileContents;
	}
	
	
	
	/*
	public static User getUser(String username, String password) {
		File userFile = new File(FILE_PATH);
		try (Scanner userScanner = new Scanner(userFile)){
			while (userScanner.hasNextLine()) {
				String line = userScanner.nextLine();
				String[] userInfo = line.strip().split(" ");
				if (userInfo[0].equals(username) && userInfo[1].equals(password)) {
					return
				}
			}
		}
		catch (FileNotFoundException e) {
			
		}
	}
	*/
}
