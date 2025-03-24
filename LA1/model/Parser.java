/*
 * Description: This class is responsible for parsing the text files containing the albums and songs, and
 * creating all the albums in the MusicStore. This class has two static methods and no instance variables
 * and is to be used without creating an instance.
 */

package model;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

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
			/*
			 * This method parses a String representation of a UserLibrary that was stored under a user
			 * and creates a new UserLibrary that has all the same information that was stored in the
			 * original user library.
			 */
			UserLibrary userLibrary = new UserLibrary(new MusicStore());
			String[] userLibraryArray = userLibraryString.split("\n");
			int addAttribute = 0;
			String currPlaylist = "";
			
			// sets command for changeUserLibrary method to make changes
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
			
			userLibrary.setRecentlyPlayed(userLibrary.getPlaylistObj("real recently played"));
			userLibrary.removePlaylistFromLibrary("real recently played");
			return userLibrary;
	}

		private static String changeUserLibrary(int addAttribute, String line, UserLibrary userLibrary, String currPlaylist) {
			/*
			 * This method helps the loadUserLibrary by adding attributes of the original UserLibrary to
			 * the new user library. This method is called on for each line of the original UserLibrary's
			 * String representation. This method returns a String representing the currPlaylist so that when adding to a Playlist,
			 * the name of which Playlist to add to can be retrieved.
			 */
			HashSet<String> skipPlaylists = autoPlaylists();
			line = line.strip();
			
			// replaces certain characters to make splitting easier
			line = line.replace(".", ":").replace("-", ":").replace("(", ":");
			String[] lineArray = line.split(":");
			
			switch (addAttribute) {
				case 1:
					// add album
					ArrayList<Album> userAlbums = userLibrary.getAlbumList();
					for (Album a : userAlbums) {
						// if album is already in UserLibrary, don't add it again
						if (a.getTitle().equals(lineArray[1].strip())) {
							return currPlaylist;
						}
					}
					// add new album to UserLibrary
					userLibrary.addAlbum(lineArray[1].strip());
					return currPlaylist;
					
				case 2:
					// add song
					String songname = lineArray[1].strip();
					String artist = lineArray[3].strip(); 
					userLibrary.addSong(songname, artist);
					userLibrary.rateSong(songname, artist, lineArray[5].strip());
					
					// restores the amount of plays for each song
					int plays = Integer.valueOf(lineArray[6].strip());
					for (int i = 0; i < plays; i++) {
						userLibrary.play(songname, artist);
					}
					return currPlaylist;
					
				case 3:
					// add to/create playlists
					
					// checks if first element consists of only digits
				    if (lineArray[0].strip().matches("\\d+")) {
				    	
				    	currPlaylist = lineArray[1].strip();
				    	
				    	// if playlist is recently played, make a unique name for it
				    	if (currPlaylist.toLowerCase().equals("recently played")) {
				    		userLibrary.createPlaylist("real recently played");
				    		currPlaylist = "real recently played";
				    	}
				    	// if playlist is one of the auto created playlists, don't add twice
				    	else if (!skipPlaylists.contains(currPlaylist.toLowerCase())) {
				    		userLibrary.createPlaylist(lineArray[1].strip());
				    	}
				    	else {
				    		currPlaylist = "";
				    	}
				     return currPlaylist;
				    	} 
				    else {
				        userLibrary.addSongToPlaylist(lineArray[0].strip(), lineArray[2].strip(), currPlaylist);
				        return currPlaylist;
				    }
				default:
					return currPlaylist;
			}

		}
		
		private static HashSet<String> autoPlaylists(){
			/*
			 * This method is a helper method for creating a HashSet of all the automatically
			 * created playlists. This is used in changeUserLibrary to ensure the playlists isn't
			 * added twice to UserLibrary.
			 */
			HashSet<String> playlists = new HashSet<>();
			playlists.add("favorites");
			playlists.add("top rated");
			playlists.add("pop");
			playlists.add("alternative");
			playlists.add("latin");
			playlists.add("rock");
			playlists.add("traditional_country");
			playlists.add("singer_songwriter");
			playlists.add("frequently played");
			return playlists;
		}

}
