/*
 * Description: This class is responsible for parsing the text files containing the albums and songs, and
 * creating all the albums in the MusicStore. This class has two static methods and no instance variables
 * and is to be used without creating an instance.
 */

package model;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Parser {
	
	public static ArrayList<Album> makeAlbumList(String fileName){
		/*
		 * This method reads in a text file containing album names and the artist and calls upon
		 * makeAlbum() method to make an album of each album name/artist. The album file name
		 * is found by the name of the album and the name of the artist. The method finally returns
		 * an ArrayList of all the albums.
		 */
		 
		ArrayList<Album> myAlbumList = new ArrayList<>();
		File myFile = new File(fileName);
		
		try (Scanner fileScanner = new Scanner(myFile)){
			
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				
				// file path to all the individual album text files
				String albumFileName  = "LA1/";
				albumFileName += line.strip().replace(",", "_");
				albumFileName += ".txt";
				
				Album myAlbum = makeAlbum(albumFileName);
				myAlbumList.add(myAlbum);
			}
			
			return myAlbumList;
		}
		catch (FileNotFoundException exception) {
			System.out.println("File not found.");
			return null; 
		}
	}
	
	public static Album makeAlbum(String fileName){
		/*
		 * This method reads in a text file containing information about an album and constructs
		 * an album object based on the text file. It also creates song objects from the text file
		 * and adds those songs to the album object.
		 */
		File myFile = new File(fileName);
		try (Scanner fileScanner = new Scanner(myFile)){
			String firstLine = fileScanner.nextLine();
			String[] albumDetails = firstLine.strip().split(",");
			
			// [0] is name of album, [1] is artist, [2] is genre, [3] is year
			Album myAlbum = new Album(albumDetails[0], albumDetails[1], albumDetails[2], albumDetails[3]);
			
			// creates song objects for every line after the 1st line
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				line = line.strip();
				
				Song newSong = new Song(line, albumDetails[1], myAlbum);
				myAlbum.addSong(newSong);
			}
			return myAlbum;
		}
		catch (FileNotFoundException exception) {
			System.out.println("File not found.");
			return null;
		}
	}
		
		
		public static UserLibrary loadUserLibrary(String userLibraryString) {
			UserLibrary userLibrary = new UserLibrary(new MusicStore());
			String[] userLibraryArray = userLibraryString.split("\n");
			int addAttribute = 0;
			String currPlaylist = "";
			
			for (String line : userLibraryArray) {
				if (line.strip().equals("Albums:")) {
					addAttribute = 1;
					continue;
				}
				else if (line.strip().equals("Songs:")){
					addAttribute = 2;
					continue;
				}
				else if (line.strip().equals("Playlists:")) {
					addAttribute = 3;
					continue;
				}
				else if (line.strip().equals("")) {
					continue;
				}
				currPlaylist = changeUserLibrary(addAttribute, line, userLibrary, currPlaylist);
		}
		
			return userLibrary;
	}
	
		private static String changeUserLibrary(int addAttribute, String line, UserLibrary userLibrary, String currPlaylist) {
			line = line.strip();
			line = line.replace(".", ":").replace("-", ":").replace("(", ":");
			String[] lineArray = line.split(":");
			switch (addAttribute) {
				case 1:
					// add album
					ArrayList<Album> userAlbums = userLibrary.getAlbumList();
					for (Album a : userAlbums) {
						if (a.getTitle().equals(lineArray[1].strip())) {
							return currPlaylist;
						}
					}
					userLibrary.addAlbum(lineArray[1].strip());
					return currPlaylist;
				case 2:
					// add song
					userLibrary.addSong(lineArray[1].strip(), lineArray[3].strip(), lineArray[5].strip());
					return currPlaylist;
				case 3:
					// checks if first element consists of only digits
				    if (lineArray[0].strip().matches("\\d+")) {
				      userLibrary.createPlaylist(lineArray[1].strip());
				      currPlaylist = lineArray[1].strip();
				      return currPlaylist;
				    } else {
				        userLibrary.addSongToPlaylist(lineArray[0].strip(), lineArray[2].strip(), currPlaylist);
				        return currPlaylist;
				    }
				default:
					return currPlaylist;
			}
			
		}

}
