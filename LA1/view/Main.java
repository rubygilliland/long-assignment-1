package view;
import java.util.ArrayList;
import java.util.Scanner;

import model.Album;
import model.MusicStore;
import model.User;
import model.UserData;
import model.UserLibrary;

public class Main {

	public static final String WELCOME_MESSAGE = "Welcome to Jammify, the number one fake music app!\n\n"
			+ "Get ready to discover, stream, and vibe to your favorite music like never before! " +
			"Whether you're in the mood for chill beats, \nhigh-energy anthems, or fresh new sounds, " +
			"Jammify brings the best music straight to you!\n";

	public static final String LIST_OF_COMMANDS = "List of Commands:\n1. Search Songs\n2. Search Albums\n3. Browse \n4. Create Playlist" +
	"\n5. View Playlists\n6. Add Songs\n7. Add Albums\n8. Edit Playlist\n9. Rate Songs\n10. Get Favorites\n11. Get Songs\n12. Get Albums\n13. Get Artists" +
	"\n14. Play Song\n15. Remove Songs/Albums\n16. Shuffle\n17. Play Random Song";


	public static void main(String[] args) {
		User myUser = LoginMenu.loginSignUpMenu();


		System.out.println(WELCOME_MESSAGE);
		MusicStore musicStore = new MusicStore();
		UserLibrary userLibrary = myUser.getUserLibrary();

		while (true) { 
			System.out.println(LIST_OF_COMMANDS);
			System.out.print("Enter a command (1-17): ");
			Scanner userInput = new Scanner(System.in);
			String inputString = userInput.nextLine().strip().toLowerCase();

			switch(inputString) {
				case "search songs":
					songSearchLibraryStore(userLibrary, musicStore);
					break;
				case "1":
					songSearchLibraryStore(userLibrary, musicStore);
					
					break;
				case "search albums":
					System.out.println("\n" + albumSearchLibraryStore(userLibrary, musicStore) + "\n");
					break;
				case "2":
					System.out.println("\n" + albumSearchLibraryStore(userLibrary, musicStore) + "\n");
					break;
				case "browse":
					System.out.println("\n" + browseMenu(userLibrary, musicStore) + "\n");
					break;
				case "3":
					System.out.println("\n" + browseMenu(userLibrary, musicStore) + "\n");
					break;
				case "create playlist":
					createPlaylist(userLibrary);
					break;
				case "4":
					createPlaylist(userLibrary);
					break;
				case "view playlists":
					System.out.println("\n" + userLibrary.getPlaylists() + "\n");
					viewPlaylist(userLibrary);
					break;
				case "5":
					System.out.println("\n" + userLibrary.getPlaylists() + "\n");
					viewPlaylist(userLibrary);
					break;
				case "6":
					 addSong(userLibrary, musicStore);
					 break;
				case "add songs":
					addSong(userLibrary, musicStore);
					break;
				case "7":
					addAlbum(userLibrary, musicStore);
					break;
				case "add albums":
					addAlbum(userLibrary, musicStore);
					break;
				case "8":
					editPlaylist(userLibrary, musicStore);
					break;
				case "edit playlist":
					editPlaylist(userLibrary, musicStore);
					break;
				case "9":
					rateSong(userLibrary);
					break;
				case "rate songs":
					rateSong(userLibrary);
					break;
				case "10":
					System.out.print("\n" + userLibrary.getFavoriteSongs() + "\n");
					break;
				case "get favorites":
					System.out.print("\n" + userLibrary.getFavoriteSongs() + "\n");
					break;
				case "11":
					getSongs(userLibrary);
					break;
				case "get songs":
					getSongs(userLibrary);
					break;
				case "12":
					System.out.print("\n" + userLibrary.getAlbumTitles() + "\n");
					break;
				case "get albums":
					System.out.print("\n" + userLibrary.getAlbumTitles() + "\n");
					break;
				case "13":
					System.out.print("\n" + userLibrary.getSortedArtist() + "\n");
					break;
				case "get artists":
					System.out.print("\n" + userLibrary.getSortedArtist() + "\n");
					break;
				case "14":
					System.out.print("\n" + userLibrary.getSongInfo() + "\n");
					playSong(userLibrary);
					break;
				case "play song":
					System.out.print("\n" + userLibrary.getSongInfo() + "\n");
					playSong(userLibrary);
					break;
				case "15":
					System.out.print("\n" + userLibrary.toString() + "\n");
					removeFromLibrary(userLibrary, userInput);
					break;
				case "16":
					shuffle(userLibrary);
					break;
				case "shuffle":
					shuffle(userLibrary);
					break;
				case "17":
					playRandom(userLibrary);
					break;
				case "play random song":
					playRandom(userLibrary);
					break;
				default:
					System.out.println("Sorry command not found. Please try again!\n");
					break;
			}

			UserData.saveUser(myUser);

			// added buffer to see results of the command before listing commands again
			System.out.println("Hit Enter to Return to the List of Commands: ");
			Scanner responseWait = new Scanner(System.in);
			String wait = responseWait.nextLine();
		}
	}
	
	public static void songSearchLibraryStore(UserLibrary userLibrary, MusicStore musicStore) {
		Scanner responseWait = new Scanner(System.in);
		System.out.print("Search My Library or Music Store? (1-2): ");
		String wait = responseWait.nextLine().toLowerCase();
		
		switch (wait) {
		case "my library":
			String songResult = searchSongs(userLibrary);
			System.out.println("\n" + "Song(s):\n" + songResult + "\n" + getAlbumInfo(userLibrary, songResult) + "\n");
			break;
			
		case "1":
			String songResult1 = searchSongs(userLibrary);
			System.out.println("\n" + "Song(s):\n" + songResult1 + "\n" + getAlbumInfo(userLibrary, songResult1) + "\n");
			break;
		case "music store":
			System.out.print("\n" + searchSongs(musicStore) + "\n");
			break;
		case "2":
			System.out.print("\n" + searchSongs(musicStore) + "\n");
			break;
		default:
			System.out.print("\nCan not reach this library. Please try again!\n");
	}
	}

	public static String searchSongs(MusicStore musicStore) {
		/*
		 * This method searches the user library for a song by title, artist, or
		 * genre depending on the user's input. The method returns a string to be
		 * printed in main so the user can view the song or songs that were
		 * found in the music store. If no song is found, the method will
		 * return a string that tells the user.
		 */

		System.out.print("Are you searching for a song by title, genre, or artist? ");
		Scanner searchInput = new Scanner(System.in);
		String songSearch = searchInput.nextLine().strip();
		String songFound = "";
		switch(songSearch.toLowerCase()) {
		case "title":
			System.out.print("Enter song title: ");
			String titleGiven = searchInput.nextLine().strip();
			songFound = musicStore.getSongByTitle(titleGiven);
			break;
		
		case "genre":
			System.out.print("Enter song genre: ");
			String genreGiven = searchInput.nextLine().strip();
			songFound = musicStore.getSongByGenre(genreGiven);
			break;
			
		case "artist":
			System.out.print("Enter song artist: ");
			String artistGiven = searchInput.nextLine().strip();
			songFound = musicStore.getSongByArtist(artistGiven);
			break;
		}
		return songFound;
	}
	
	public static String searchSongs(UserLibrary userLibrary) {
		/*
		 * This method searches the user library for a song by title, artist, or
		 * genre depending on the user's input. The method returns a string to be
		 * printed in main so the user can view the song or songs that were
		 * found in their library. If no song is found, the method will
		 * return a string that tells the user.
		 */

		System.out.print("Are you searching for a song by title, genre, or artist? ");
		Scanner searchInput = new Scanner(System.in);
		String songSearch = searchInput.nextLine().strip();
		String songFound = "";
		switch(songSearch.toLowerCase()) {
		case "title":
			System.out.print("Enter song title: ");
			String titleGiven = searchInput.nextLine().strip();
			songFound = userLibrary.getSongByTitle(titleGiven);
			break;
		
		case "genre":
			System.out.print("Enter song genre: ");
			String genreGiven = searchInput.nextLine().strip();
			songFound = userLibrary.getSongsByGenre(genreGiven);
			break;
			
		case "artist":
			System.out.print("Enter song artist: ");
			String artistGiven = searchInput.nextLine().strip();
			songFound = userLibrary.getSongByArtist(artistGiven);
			break;
		}
		return songFound;
	}
	
	public static String getAlbumInfo(UserLibrary userLibrary, String song) {
		String albumInfo = "";
		if (!(song.equals("Songs by this artist cannot be found.") || song.equals("Songs of this genre cannot be found.") 
				|| song.equals("This song cannot be found."))) {
		System.out.print("Would you like to get the album info for this song? (Y/N): " );
		Scanner response = new Scanner(System.in);
		
		if (response.nextLine().trim().equalsIgnoreCase("Y")) {
			
			// Extract artist and title from "Title - by: Artist (Album)" format
            String artist = song.split(" - by: ")[1].split(" \\(")[0];
            String title = song.split(" - by: ")[0];
            albumInfo = "Album: \n" + userLibrary.getAlbumInfo(title, artist);
		}
		}
		return albumInfo;
	}
	public static String albumSearchLibraryStore(UserLibrary userLibrary, MusicStore musicStore) {
		Scanner responseWait = new Scanner(System.in);
		System.out.print("Search My Library or Music Store? (1-2): ");
		String wait = responseWait.nextLine().toLowerCase();
		
		switch (wait) {
		case "my library":
			return searchAlbum(userLibrary);
		case "1":
			return searchAlbum(userLibrary);
		case "music store":
			return searchAlbum(musicStore);
		case "2":
			return searchAlbum(musicStore);
		default:
			return "Can not reach this library. Please try again!";
	}
	}
	
	public static String searchAlbum(MusicStore musicStore) {
		/*
		 * This method searches the music store for an album by genre,
		 * title, or artist depending on the user's input. The method returns
		 * a string to be printed in main so the user can view the album or
		 * albums that were found in the music store. If no album is found,
		 * the method will return a string that tells the user
		 */
		System.out.print("Are you searching for an album by title, genre, or artist? ");
		Scanner searchInput = new Scanner(System.in);
		String albumSearch = searchInput.nextLine().strip();
		String albumFound = "";
		switch(albumSearch.toLowerCase()) {
		case "title":
			System.out.print("Enter album title: ");
			String titleGiven = searchInput.nextLine().strip();
			albumFound = musicStore.getAlbumByTitle(titleGiven);
			break;
		
		case "genre":
			System.out.print("Enter album genre: ");
			String genreGiven = searchInput.nextLine().strip();
			albumFound = musicStore.getAlbumByGenre(genreGiven);
			break;
			
		case "artist":
			System.out.print("Enter album artist: ");
			String artistGiven = searchInput.nextLine().strip();
			albumFound = musicStore.getAlbumByArtist(artistGiven);
			break;
		}
		return albumFound;
	}
	
	public static String searchAlbum(UserLibrary userLibrary) {
		/*
		 * This method searches the user library for an album by genre,
		 * title, or artist depending on the user's input. The method returns
		 * a string to be printed in main so the user can view the album or
		 * albums that were found in the users library. If no album is found,
		 * the method will return a string that tells the user
		 */
		System.out.print("Are you searching for an album by title, genre, or artist? ");
		Scanner searchInput = new Scanner(System.in);
		String albumSearch = searchInput.nextLine().strip();
		String albumFound = "";
		switch(albumSearch.toLowerCase()) {
		case "title":
			System.out.print("Enter album title: ");
			String titleGiven = searchInput.nextLine().strip();
			albumFound = userLibrary.getAlbumByTitle(titleGiven);
			break;
		
		case "genre":
			System.out.print("Enter album genre: ");
			String genreGiven = searchInput.nextLine().strip();
			albumFound = userLibrary.getAlbumByGenre(genreGiven);
			break;
			
		case "artist":
			System.out.print("Enter album artist: ");
			String artistGiven = searchInput.nextLine().strip();
			albumFound = userLibrary.getAlbumByArtist(artistGiven);
			break;
		}
		return albumFound;
	}
	
	public static void getSongs(UserLibrary userLibrary) {
		Scanner responseWait = new Scanner(System.in);
		System.out.print("Do you want songs listed by title, artist, or rating? (1-3): ");
		String wait = responseWait.nextLine().toLowerCase().strip();
		
		switch(wait) {
		case "1":
			System.out.println("\n" + userLibrary.getSortedTitles() + "\n");
			break;
		case "title":
			System.out.println("\n" + userLibrary.getSortedTitles() + "\n");
			break;
		case "2":
			System.out.println("\n" + userLibrary.getSortedArtist() + "\n");
			break;
		case "artist":
			System.out.println("\n" + userLibrary.getSortedArtist() + "\n");
			break;
		case "3":
			System.out.println("\n" + userLibrary.getSortedRating() + "\n");
			break;
		case "rating":
			System.out.println("\n" + userLibrary.getSortedRating() + "\n");
			break;
		default:
			System.out.println("Command not found. Please try again!");
			break;
		}
	}
	

	public static String browseMenu(UserLibrary userLibrary, MusicStore musicStore) {
		/*
		 * This method first prompts the user to browse either the user library or the music
		 * store and returns a string representation of the albums, songs, and playlists in
		 * the chosen library. If the user enters in a library that does not exist, the method will
		 * return a string telling the user that the command was unsuccessful.
		 */
		Scanner responseWait = new Scanner(System.in);
		System.out.print("Browse My Library or Music Store? (1-2): ");
		String wait = responseWait.nextLine().toLowerCase();

		switch (wait) {
			case "my library":
				return userLibrary.toString();
			case "1":
				return userLibrary.toString();
			case "music store":
				return musicStore.toString();
			case "2":
				return musicStore.toString();
			default:
				return "Can not reach this library. Please try again!";
		}
	}
 
	public static void createPlaylist(UserLibrary userLibrary) {
		/*
		 * This method creates a playlist in the user library based on the user's input. The
		 * method prompts the user for a name and then creates a playlist in user library with that
		 * same name. The method then prints out to the user that the command was successful, and recommends
		 * further commands to fill the playlist with songs. If the user does not want to create a playlist,
		 * they can cancel the command by writing 'cancel' and then a message will be printed showing the
		 * cancellation.
		 */
		Scanner response = new Scanner(System.in);
		System.out.print("What do you want to call this playlist? (Enter cancel to cancel): ");
		String playlistName = response.nextLine().toLowerCase();

		if (!playlistName.equals("cancel")) {
			userLibrary.createPlaylist(playlistName);
			System.out.println("\nPlaylist: " + playlistName + " created!");
			System.out.println("Go to the Edit Playlist command to add to this playlist!\n");
		}
		else {
			System.out.println("\nCreate playlist canceled\n");
		}

	}
	
	public static void viewPlaylist(UserLibrary userLibrary) {
		String[] playlists = userLibrary.getPlaylists().split("\n");
		
		Scanner responseWait = new Scanner(System.in);
		System.out.print("Enter the NUMBER of playlist you would like to view: ");
		String wait = responseWait.nextLine().toLowerCase().strip();
		
		int choice;
        try {
            choice = Integer.parseInt(wait);

            if (choice < 1 || choice > playlists.length - 1) {
				throw new NumberFormatException();
			}
            
        } catch (NumberFormatException e) {
            System.out.println("Invalid selection. Please try again.\n");
            return;
        }
        
        String playlistName = playlists[choice].replace(".", ":").split(":")[1].strip();
        String playlistString;
        if (playlistName.equals("Frequently Played")) {
        	playlistString = userLibrary.getPlays().getFrequentlyPlayed().toString(userLibrary.getPlays());
        }
        else {
        	playlistString = userLibrary.getPlaylist(playlistName).toString();
        }
        System.out.println("\n" + playlistString + "\n");
        
        
	}
	
	
	// allows user to add Songs to their library using input get a Song by title or artist
	// Used AI to help generate this function
	public static void addSong(UserLibrary userLibrary, MusicStore musicStore) {
	    Scanner response = new Scanner(System.in);

	    while (true) {

	        // searches for Song in music store by title, genre, or artist
	        String songSearch = searchSongs(musicStore);

	        // if Song not found, return message
	        if (songSearch.equals("This song cannot be found.") || songSearch.equals("Songs by this artist cannot be found.")
	        		|| songSearch.equals("Songs of this genre cannot be found.")) {
	        	System.out.println("\nThis song cannot be found.\n");
	        	break;
	        }

	        	// Splitting multiple results of Song search
	            String[] songs = songSearch.strip().split("\n");

	            String selectedSong;

	            // if multiple Songs found, print a numbered list of all results
	            if (songs.length > 1) {
	                System.out.println("\nMultiple songs found:");
	                for (int i = 0; i < songs.length; i++) {
	                    System.out.println((i + 1) + ". " + songs[i]);
	                }
	                System.out.print("Enter the NUMBER of the song you want to add: ");

	                // gets and validates user input of number of the Song they want to add
	                int choice;
	                try {
	                    choice = Integer.parseInt(response.nextLine().strip());

	                    if (choice < 1 || choice > songs.length) {
							throw new NumberFormatException();
						}
	                } catch (NumberFormatException e) {
	                    System.out.println("Invalid selection. Please try again.\n");
	                    continue;
	                }
	                selectedSong = songs[choice - 1];
	            } else {
	                selectedSong = songs[0];
	            }

	            // Extract artist and title from "Title - by: Artist (Album)" format
	            String artist = selectedSong.split(" - by: ")[1].split(" \\(")[0];
	            String title = selectedSong.split(" - by: ")[0];

	            userLibrary.addSong(title, artist);
	            System.out.println("\n" + title + " by " + artist + " has been added to your library!\n");
	        

	        // allows user to keep adding Songs to library if they'd like
	        System.out.print("Would you like to add another song? (Y/N): ");
	        if (!response.nextLine().trim().equalsIgnoreCase("Y")) {
				break;
			}
	}
	    }
	

	// allows user to add Albums to their library using input get an Album by title or artist
	// Used AI to help generate this function
	public static void addAlbum(UserLibrary userLibrary, MusicStore musicStore) {
		Scanner response = new Scanner(System.in);
		String albumInfo;
		while(true) {

			// searches for Album in music store by title, genre, or artist
			String albumSearch = searchAlbum(musicStore);

			// if Album not found by title, return message
			if (albumSearch.equals("This album cannot be found.") || albumSearch.equals("Albums by this artist cannot be found.")
					|| albumSearch.equals("Albums of this genre cannot be found.")) {
				System.out.println("\nAlbum by this title/artist cannot be found.\n");
				break;

			} else {

				// Splitting multiple results of Album search and organizing Strings of Albums into ArrayLists
				String[] lines = albumSearch.strip().split("\n");
	            ArrayList<String> albums = new ArrayList<>();
	            ArrayList<Integer> albumIndices = new ArrayList<>();

	            // Identify Songs in Album String
	            for (int i = 0; i < lines.length; i++) {
	                if (!lines[i].startsWith("\t")) {
	                    albums.add(lines[i]);
	                    albumIndices.add(i);
	                }
	            }

	            // if multiple Albums found, print a numbered list of the results
	            if (albums.size() > 1) {
	                System.out.println("\nMultiple albums found:");
	                for (int i = 0; i < albums.size(); i++) {
	                    System.out.println((i + 1) + ". " + albums.get(i));
	                }
	                System.out.print("Enter the NUMBER of the album you want to add: ");

	             // gets and validates user input of number of the Album they want to add
	                int albumChoice;
	                try {
	                    albumChoice = Integer.parseInt(response.nextLine().strip());
	                    if (albumChoice < 1 || albumChoice > albums.size()) {
							throw new NumberFormatException();
						}
	                } catch (NumberFormatException e) {
	                    System.out.println("Invalid selection. Please try again.\n");
	                    continue;
	                }

	                int startIndex = albumIndices.get(albumChoice - 1);
	                int endIndex = (albumChoice < albums.size()) ? albumIndices.get(albumChoice) : lines.length;

	                albumInfo = lines[startIndex];

	            } else {
	                albumInfo = albums.get(0);
	                }

	            // Extract artist and title from "Title - by: Artist (Genre) Year" format
				String albumTitle = albumInfo.split(" - by: ")[0];
	            String artist = albumInfo.split(" - by: ")[1].split(" \\(")[0];
	            userLibrary.addAlbum(albumTitle);
	            System.out.println("\n" + albumTitle + " by " + artist + " has been added to your library!\n");

	            // allows user to keep adding Albums to library if they'd like
	            System.out.print("Would you like to add another album? (Y/N): ");
		        if (!response.nextLine().trim().equalsIgnoreCase("Y")) {
					break;
				}
	        }
	    }
	}

	// allows user to edit a Playlist in their library using input get a playlist by name
	// Used AI to help generate this function
	public static void editPlaylist(UserLibrary userLibrary, MusicStore musicStore) {
		Scanner response = new Scanner(System.in);
		System.out.print("\nWhat playlist would you like to edit? ");
		String playlistName = response.nextLine();

		// searches user library to get playlist with title from user input
		String playlist = userLibrary.getPlaylist(playlistName);

		// if playlist of given name does not exist in user library, allows user to create a playlist
		if (playlist.equals("Playlist by this name cannot be found.")) {
			System.out.print(playlist + ", would you like to create it? (Y/N) ");
			if (response.nextLine().trim().equalsIgnoreCase("Y")) {
				createPlaylist(userLibrary);
			}
		} else {

		// prompts user to choose how they want to edit the playlist and calls function associated with that operation
		System.out.print("\n" + playlist);
		System.out.print("Would you like to ADD (1) or REMOVE (2) from this playlist? ");
		String choice = response.nextLine().toLowerCase();

		if (choice.equals("1") || choice.equals("add")) {
			addToPlaylist(userLibrary, musicStore, playlistName, response);
		} else if (choice.equals("2") || choice.equals("remove")) {
			removeFromPlaylist(userLibrary, musicStore, playlistName, response);
		} else {
			System.out.println("Invalid selection. Please try again\n");
		}
		}
	}

	// helper method to add a song to a playlist from user input
	// Used AI to help generate this function
	private static void addToPlaylist(UserLibrary userLibrary, MusicStore musicStore, String playlistName, Scanner response) {
		while (true) {

	        // searches for Song in music store by title, genre, or artist
	        String songSearch = searchSongs(musicStore);

	        // if Song not found, return message
	        if (songSearch.equals("This song cannot be found.") || songSearch.equals("Songs by this artist cannot be found.")
	        		|| songSearch.equals("Songs of this genre cannot be found.")) {
	        	System.out.println("\nThis song cannot be found.\n");
	        	break;
	        	
	        } else {

	        	// Splitting multiple results of Song search
	            String[] songs = songSearch.strip().split("\n");

	            String selectedSong;

	            // if multiple Songs found, prints a numbered list of all results
	            if (songs.length > 1) {
	                System.out.println("\nMultiple songs found:");
	                for (int i = 0; i < songs.length; i++) {
	                    System.out.println((i + 1) + ". " + songs[i]);
	                }
	                System.out.print("Enter the NUMBER of the song you want to add: ");

	                // gets and validates user input of number of the Song they want to add
	                int choice;
	                try {
	                    choice = Integer.parseInt(response.nextLine().strip());
	                    if (choice < 1 || choice > songs.length) {
							throw new NumberFormatException();
						}
	                } catch (NumberFormatException e) {
	                    System.out.println("Invalid selection. Please try again.\n");
	                    continue;
	                }
	                selectedSong = songs[choice - 1];
	            } else {
	                selectedSong = songs[0];
	            }

	            // Extract artist and title from "Title - by: Artist (Album)" format
	            String artist = selectedSong.split(" - by: ")[1].split(" \\(")[0];
	            String title = selectedSong.split(" - by: ")[0];

	            userLibrary.addSongToPlaylist(title, artist, playlistName);
	            System.out.println("\n" + title + " by " + artist + " has been added to " + playlistName + "!\n");
	        }

	        // allows user to keep adding Songs to playlist if they'd like
	        System.out.print("Would you like to add another song? (Y/N): ");
	        if (!response.nextLine().trim().equalsIgnoreCase("Y")) {
				break;
			}
	    }
	}

	// helper method to help remove Song from playlist given user input
	// Used AI to help generate this function
	private static void removeFromPlaylist(UserLibrary userLibrary, MusicStore musicStore, String playlistName, Scanner response) {
		while (true) {
			
			// searches for Song in user library by title, genre, or artist
			String songSearch = searchSongs(userLibrary);

			if (songSearch.equals("This song cannot be found.") || songSearch.equals("Songs by this artist cannot be found.")
	        		|| songSearch.equals("Songs of this genre cannot be found.")) {
	        	System.out.println("\nThis song cannot be found in your library.\n");
	        	break;
	        } else {

	        	// Splitting multiple results of Song search
	            String[] songs = songSearch.strip().split("\n");

	            String selectedSong;

	            // if multiple Songs found, prints a numbered list of all results
	            if (songs.length > 1) {
	                System.out.println("\nMultiple songs found:");
	                for (int i = 0; i < songs.length; i++) {
	                    System.out.println((i + 1) + ". " + songs[i]);
	                }
	                System.out.print("Enter the NUMBER of the song you want to remove: ");

	                // gets and validates user input of number of the Song they want to add
	                int choice;
	                try {
	                    choice = Integer.parseInt(response.nextLine().strip());
	                    if (choice < 1 || choice > songs.length) {
							throw new NumberFormatException();
						}
	                } catch (NumberFormatException e) {
	                    System.out.println("Invalid selection. Please try again.\n");
	                    continue;
	                }
	                selectedSong = songs[choice - 1];
	            } else {
	                selectedSong = songs[0];
	            }

	            // Extract title and artist from "Title - by: Artist (Album)" format
	            String artist = selectedSong.split(" - by: ")[1].split(" \\(")[0];
	            String title = selectedSong.split(" - by: ")[0];

	            // if given song found in given playlist, remove it from the playlist
	            if (userLibrary.songInPlaylist(playlistName, title, artist)) {
	            	userLibrary.removeSongFromPlaylist(title, artist, playlistName);
		            System.out.println("\n" + title + " by " + artist + " has been removed from " + playlistName + "!\n");
	            }

	            // if given song not found in given playlist, print message
	            else {
	            	System.out.println("\n" + title + " by " + artist + " is not in " + playlistName + "\n");
	            }
	        }

	        // allows user to keep removing Songs to playlist if they'd like
	        System.out.print("Would you like to remove another song? (Y/N): ");
	        if (!response.nextLine().trim().equalsIgnoreCase("Y")) {
				break;
			}
	    }
	}

	// allows user to rate a Song in their library using input get a Song by title or artist
	// Used AI to help generate this function
	public static void rateSong(UserLibrary userLibrary) {
		Scanner response = new Scanner(System.in);

		while (true) {

		// searches for Song in user library by title, genre, or artist
		String songSearch = searchSongs(userLibrary);

		if (songSearch.equals("This song cannot be found.") || songSearch.equals("Songs by this artist cannot be found.")
        		|| songSearch.equals("Songs of this genre cannot be found.")) {
        	System.out.println("\nSong by this title/artist cannot be found in your library, go to the Add Song command to add it!\n");
        	break;
        } else {

        	// Splitting multiple results of Song search
            String[] songs = songSearch.strip().split("\n"); // Splitting multiple results

            String selectedSong;

            // if multiple Songs found, prints a numbered list of all results
            if (songs.length > 1) {
                System.out.println("\nMultiple songs found:");
                for (int i = 0; i < songs.length; i++) {
                    System.out.println((i + 1) + ". " + songs[i]);
                }
                System.out.print("Enter the NUMBER of the song you want to rate: ");

                // gets and validates user input of number of the Song they want to add
                int choice;
                try {
                    choice = Integer.parseInt(response.nextLine().strip());
                    if (choice < 1 || choice > songs.length) {
						throw new NumberFormatException();
					}
                } catch (NumberFormatException e) {
                    System.out.println("Invalid selection. Please try again.\n");
                    continue;
                }
                selectedSong = songs[choice - 1];
            } else {
                selectedSong = songs[0];
            }

            // Extract artist and title from "Title - by: Artist (Album)" format
            String artist = selectedSong.split(" - by: ")[1].split(" \\(")[0];
            String title = selectedSong.split(" - by: ")[0];
            System.out.print("\nEnter your rating for " + title + " by " + artist + ": ");

            // rates the given Song
            int rating = Integer.parseInt(response.nextLine().strip());
            userLibrary.rateSong(title, artist, rating);

            // if the rating given is a 5, notifies user that the song has automatically been favorited
            if (rating == 5) {
            	System.out.print("\n" + title + " by " + artist + " has been favorited!\n");
            }
        }

        // allows user to keep rating Songs in their library if they'd like
        System.out.print("Would you like to rate another song? (Y/N): ");
        if (!response.nextLine().trim().equalsIgnoreCase("Y")) {
			break;
		}
    }
	}
	
	public static void playSong(UserLibrary userLibrary) {
		Scanner myScanner = new Scanner(System.in);
		
		String[] songs = userLibrary.getSongInfo().split("\n");
		
		if (songs.length - 1 == 0) {
			System.out.println("No songs in library. Please add a song and try again!\n");
			return;
		}
		
		while (true) {
			System.out.print("Enter the NUMBER of the song you wish to play: ");
		
			int songNum;
			try {
				songNum = Integer.valueOf(myScanner.nextLine());
				if (songNum < 1 || songNum > songs.length - 1) {
					System.out.println("Invalid selection. Please try again.\n");
					continue;
				}
				String songString = songs[songNum].strip().replace(".", ":").replace("-", ":").replace("(", ":");
				String[] songList = songString.split(":");
				userLibrary.play(songList[1].strip(), songList[3].strip());
				System.out.println("\nNow playing: " + songList[1].strip() + " - by: " + songList[3].strip() + "!\n");
				return;
			}	
			catch (NumberFormatException e) {
				System.out.println("Invalid selection. Please try again.\n");
				continue;
			}
		}
	}

	
	public static void removeFromLibrary(UserLibrary userLibrary, Scanner myScanner) { 
	    System.out.print("What would you like to remove? (Song/Album): ");
	    while (true) {
	        String response = myScanner.nextLine();
	        if (response.toLowerCase().equals("song")) {
	            String[] songs = userLibrary.getSongInfo().split("\n");
	            if (songs.length - 1 == 0) {
	                System.out.println("\nNo songs in library to remove.\n");
	                return;
	            }
	            System.out.println(userLibrary.getSongInfo());
	            System.out.print("Enter the NUMBER of the song you would like to remove: ");
	            
	            int songNum;
	            try {
	                songNum = Integer.parseInt(myScanner.nextLine()); // Reuse the same Scanner
	                
	                if (songNum < 1 || songNum > songs.length - 1) {
	                    System.out.println("Invalid selection. Please try again.\n");
	                    continue;
	                }
	                
	                String songString = songs[songNum].strip().replace(".", ":").replace("-", ":").replace("(", ":");
	                String[] songList = songString.split(":");
	                userLibrary.removeSongFromLibrary(songList[1].strip(), songList[3].strip());
	                System.out.println("\nSong: " + songList[1].strip() + " - by: " + songList[3].strip() + " successfully removed!\n");
	                return;
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid selection. Please try again.\n");
	                continue;
	            }
	        } else if (response.toLowerCase().equals("album")) {
	            ArrayList<Album> albums = userLibrary.getAlbumList();
	            if (albums.isEmpty()) {
	                System.out.println("\nNo albums in library to remove.\n");
	                return;
	            }
	            
	            System.out.println(userLibrary.getAlbumTitles());
	            System.out.print("Enter the NUMBER of the album you would like to remove: ");
	            
	            int albumNum;
	            try {
	                albumNum = Integer.parseInt(myScanner.nextLine()); // Reuse the same Scanner
	                
	                if (albumNum < 1 || albumNum > albums.size()) {
	                    System.out.println("Invalid selection. Please try again.\n");
	                    continue;
	                }
	                String albumTitle = albums.get(albumNum - 1).getTitle();
	                String albumArtist = albums.get(albumNum - 1).getArtist();
	                userLibrary.removeAlbumFromLibrary(albumTitle, albumArtist);
	                System.out.println("\nAlbum: " + albumTitle + " - by: " + albumArtist + " successfully removed!\n");
	                return;
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid selection. Please try again.\n");
	                continue;
	            }
	        } else {
	            System.out.println("Invalid selection. Please try again.\n");
	        }
	    }
	}

	public static void removeFromLibrary(UserLibrary userLibrary) {
		System.out.print("What would you like to remove? (Song/Album): ");
		while (true) {
			Scanner myScanner = new Scanner(System.in);
			String response = myScanner.nextLine();
			myScanner.close();
			if (response.toLowerCase().equals("song")) {
				String[] songs = userLibrary.getSongInfo().split("\n");
				if (songs.length - 1 == 0) {
					System.out.println("No songs in library found.\n");
					return;
				}
				
				System.out.println(userLibrary.getSongInfo());
				System.out.print("Enter the NUMBER of the song you would like to remove: ");
				Scanner songScanner = new Scanner(System.in);
				
				int songNum;
				try {
					songNum = Integer.valueOf(songScanner.nextLine());
					if (songNum < 1 || songNum > songs.length - 1) {
						System.out.println("Invalid selection. Please try again.\n");
						continue;
					}
					String songString = songs[songNum].strip().replace(".", ":").replace("-", ":").replace("(", ":");
					String[] songList = songString.split(":");
					userLibrary.removeSongFromLibrary(songList[1].strip(), songList[3].strip());
					System.out.println("\nSong: " + songList[1].strip() + " - by: " + songList[3].strip() + " successfully removed!\n");
					return;
				}	
				catch (NumberFormatException e) {
					System.out.println("Invalid selection. Please try again.\n");
					continue;
				}
			}
			else if (response.toLowerCase().equals("album")) {
				ArrayList<Album> albums = userLibrary.getAlbumList();
				if (albums.size() == 0) {
					System.out.println("No albums in library found.\n");
					return;
				}
				
				System.out.println(userLibrary.getAlbumTitles());
				System.out.print("Enter the NUMBER of the album you would like to remove: ");
				Scanner songScanner = new Scanner(System.in);
				

				
				int songNum;
				try {
					songNum = Integer.valueOf(songScanner.nextLine());
					if (songNum < 1 || songNum > albums.size()) {
						System.out.println("Invalid selection. Please try again.\n");
						continue;
					}
					String albumTitle = albums.get(songNum - 1).getTitle();
					String albumArtist = albums.get(songNum - 1).getArtist();
					userLibrary.removeAlbumFromLibrary(albumTitle, albumArtist);
					System.out.println("\nAlbum: " + albumTitle + " - by: " + albumArtist + " successfully removed!\n");
					return;
				}	
				catch (NumberFormatException e) {
					System.out.println("Invalid selection. Please try again.\n");
					continue;
				}
			}
			else {
				System.out.println("Invalid selection. Please try again.\n");
				continue;
			}
		}
		
	}
	
	public static void shuffle(UserLibrary userLibrary) {
		Scanner responseWait = new Scanner(System.in);
		System.out.print("What would you like to shuffle? (Library/Playlist): ");
		String response = responseWait.nextLine().toLowerCase().strip();
		
		switch(response) {
		case "library":
			userLibrary.shuffleLibrary();
			System.out.println("Library has been shuffled!\n");
			System.out.println("\n" + userLibrary.toStringShuffled() + "\n");
			break;
		case "playlist":
			String[] playlists = userLibrary.getPlaylists().split("\n");
			
			Scanner enterPlaylist = new Scanner(System.in);
			System.out.println("\n" + userLibrary.getPlaylists() + "\n");
			System.out.print("Enter the NUMBER of the playlist you would like to shuffle: ");
			String playlist = enterPlaylist.nextLine().strip();
			
			int choice;
	        try {
	            choice = Integer.parseInt(playlist);

	            if (choice < 1 || choice > playlists.length - 1) {
					throw new NumberFormatException();
				}
	            
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid selection. Please try again.\n");
	            return;
	        }
	        
	        String playlistName = playlists[choice].replace(".", ":").split(":")[1].strip();
	        if (playlistName.equals("Frequently Played") || playlistName.equals("Recently Played")) {
	        	System.out.println("Sorry, this playlist can not be shuffled.\n");
	        	return;
	        }
	        
	        userLibrary.shufflePlaylist(playlistName);
	        String playlistString = userLibrary.getPlaylistObj(playlistName).toStringShuffled();
	        System.out.println("\n" + playlistString + "\n");
	        break;
		default:
			System.out.println("Invalid response. Please Try again!\n");
			
	        
		}
	}
	
	public static void playRandom(UserLibrary userLibrary) {
		Scanner responseWait = new Scanner(System.in);
		System.out.print("Where do you want to play a song from? (Library/Playlist): ");
		String response = responseWait.nextLine().toLowerCase().strip();
		
		String songString;
		String[] songList;
		switch(response) {
		case "library":
			songString = userLibrary.playRandomSong();
			songString = songString.strip().replace(".", ":").replace("-", ":").replace("(", ":");
			songList = songString.split(":");
			System.out.println("\nNow playing: " + songList[0].strip() + " - by: " + songList[2].strip() + "!\n");
			break;
		case "playlist":
			String[] playlists = userLibrary.getPlaylists().split("\n");
			
			Scanner enterPlaylist = new Scanner(System.in);
			System.out.println("\n" + userLibrary.getPlaylists() + "\n");
			System.out.print("Enter the NUMBER of the playlist you would like to shuffle: ");
			String playlist = enterPlaylist.nextLine().strip();
			
			int choice;
	        try {
	            choice = Integer.parseInt(playlist);

	            if (choice < 1 || choice > playlists.length - 1) {
					throw new NumberFormatException();
				}
	            
	        } catch (NumberFormatException e) {
	            System.out.println("Invalid selection. Please try again.\n");
	            return;
	        }
	        
	        String playlistName = playlists[choice].replace(".", ":").split(":")[1].strip();
	        
	        songString = userLibrary.playRandomSong(playlistName);
	        songString = songString.strip().replace("-", ":").replace("(", ":");
			songList = songString.split(":");
			System.out.println("\nNow playing: " + songList[0].strip() + " - by: " + songList[2].strip() + "!\n");
	        break;
		default:
			System.out.println("Invalid response. Please Try again!\n");
			break;
		}
	}
}







