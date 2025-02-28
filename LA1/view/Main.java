package view;
import model.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static final String WELCOME_MESSAGE = "Welcome to VibeStream, the number one fake music app!\n\n"
			+ "Get ready to discover, stream, and vibe to your favorite music like never before! " +
			"Whether you're in the mood for chill beats, \nhigh-energy anthems, or fresh new sounds, " + 
			"VibeStream brings the best music straight to you!\n";
	
	public static final String LIST_OF_COMMANDS = "List of Commands:\n1. Search Songs\n2. Search Albums\n3. Browse \n4. Create Playlist" + 
	"\n5. View Playlists\n6. Add Songs\n7. Add Albums\n8. Edit Playlist\n9. Rate Songs\n10. Get Favorites";
	
	
	public static void main(String[] args) {
		System.out.println(WELCOME_MESSAGE);
		MusicStore musicStore = new MusicStore();
		UserLibrary userLibrary = new UserLibrary(musicStore);
		
		while (true) {
			System.out.println(LIST_OF_COMMANDS);
			System.out.print("Enter a command (1-10): ");
			Scanner userInput = new Scanner(System.in);
			String inputString = userInput.nextLine().strip().toLowerCase();
			
			switch(inputString) {
				case "search songs":
					System.out.println("\n" + searchSongs(musicStore) + "\n");
					break;
				case "1":
					System.out.println("\n" + searchSongs(musicStore) + "\n");
					break;
				case "search albums":
					System.out.println("\n" + searchAlbum(musicStore) + "\n");
					break;
				case "2":
					System.out.println("\n" + searchAlbum(musicStore) + "\n");
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
					break;
				case "5":
					System.out.println("\n" + userLibrary.getPlaylists() + "\n");
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
				case "get favorites":
					System.out.print("\n" + userLibrary.getFavoriteSongs() + "\n");
				default:
					System.out.println("Sorry command not found. Please try again!\n");	
					break;
			}
			
			
			Scanner responseWait = new Scanner(System.in);
			System.out.println("Hit Enter to Return to the List of Commands: ");
			String wait = responseWait.nextLine();
				
			
		}
		
		//System.out.print(musicStore);
		
		/*
		 * Search music, browse, create playlist, view playlist, liked songs library, add albums, rate songs
		 */
		
	}
	
	public static String searchSongs(MusicStore musicStore) {
		System.out.print("Search for a song by title or artist: ");
		Scanner searchInput = new Scanner(System.in);
		String songSearch = searchInput.nextLine().strip();
		String songFound = musicStore.getSongByTitle(songSearch);
		if (songFound.equals("This song cannot be found.")) {
			songFound = musicStore.getSongByArtist(songSearch);
		}
		
		songFound = songFound.replace("artist", "title/artist");
		return songFound;
	}
	
	public static String searchAlbum(MusicStore musicStore) {
		System.out.print("Search for a album by title or artist: ");
		Scanner searchInput = new Scanner(System.in);
		String albumSearch = searchInput.nextLine().strip();
		String songFound = musicStore.getAlbumByTitle(albumSearch);
		if (songFound.equals("This album cannot be found.")) {
			songFound = musicStore.getAlbumByArtist(albumSearch);
		}
		
		songFound = songFound.replace("artist", "title/artist");
		return songFound;
	}
	
	public static String browseMenu(UserLibrary userLibrary, MusicStore musicStore) {
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
	
	// Used AI to help generate this function	
	public static void addSong(UserLibrary userLibrary, MusicStore musicStore) {
	    Scanner response = new Scanner(System.in);

	    while (true) {
	        System.out.print("\nSearch for a song by title or artist: ");
	        String input = response.nextLine().strip().toLowerCase();
	        String songSearch = musicStore.getSongByTitle(input);

	        if (songSearch.equals("This song cannot be found.")) {
	        	songSearch = musicStore.getSongByArtist(input);
	        }
	        if (songSearch.equals("Songs by this artist cannot be found.")) {
	            System.out.println("\nThis song cannot be found.\n");
	        } else {
	            String[] songs = songSearch.strip().split("\n"); // Splitting multiple results

	            String selectedSong;
	            if (songs.length > 1) {
	                System.out.println("\nMultiple songs found:");
	                for (int i = 0; i < songs.length; i++) {
	                    System.out.println((i + 1) + ". " + songs[i]);
	                }
	                System.out.print("Enter the NUMBER of the song you want to add: ");
	                
	                int choice;
	                try {
	                    choice = Integer.parseInt(response.nextLine().strip());
	                    if (choice < 1 || choice > songs.length) throw new NumberFormatException();
	                } catch (NumberFormatException e) {
	                    System.out.println("Invalid selection. Please try again.\n");
	                    continue;
	                }
	                selectedSong = songs[choice - 1];
	            } else {
	                selectedSong = songs[0];
	            }

	            // Extract artist from "Title - by: Artist (Album)" format
	            String artist = selectedSong.split(" - by: ")[1].split(" \\(")[0];
	            String title = selectedSong.split(" - by: ")[0];
	            
	            userLibrary.addSong(title, artist);
	            System.out.println("\n" + title + " by " + artist + " has been added to your library!\n");
	        }

	        System.out.print("Would you like to add another song? (Y/N): ");
	        if (!response.nextLine().trim().equalsIgnoreCase("Y")) break;
	    }
	}
	
	// Used AI to help generate this function
	public static void addAlbum(UserLibrary userLibrary, MusicStore musicStore) {
		Scanner response = new Scanner(System.in);
		String albumInfo;
		while(true) {
			System.out.print("\nSearch for an album by title or artist: ");
			String input = response.nextLine().strip().toLowerCase();
			String albumSearch = musicStore.getAlbumByTitle(input);
			
			if (albumSearch.equals("This album cannot be found.")) {
				albumSearch = musicStore.getAlbumByArtist(input);
			} 
			if (albumSearch.equals("Albums by this artist cannot be found.")){
				System.out.println("Album by this title/artist cannot be found.\n");
			} else {
			
				String[] lines = albumSearch.strip().split("\n");
	            ArrayList<String> albums = new ArrayList<>();
	            ArrayList<Integer> albumIndices = new ArrayList<>();
	            
	            // Identify album lines
	            for (int i = 0; i < lines.length; i++) {
	                if (!lines[i].startsWith("\t")) {
	                    albums.add(lines[i]);
	                    albumIndices.add(i);
	                }
	            }
	            
	            if (albums.size() > 1) {
	                System.out.println("\nMultiple albums found:");
	                for (int i = 0; i < albums.size(); i++) {
	                    System.out.println((i + 1) + ". " + albums.get(i));
	                }
	                System.out.print("Enter the NUMBER of the album you want to add: ");
	                
	                int albumChoice;
	                try {
	                    albumChoice = Integer.parseInt(response.nextLine().strip());
	                    if (albumChoice < 1 || albumChoice > albums.size()) throw new NumberFormatException();
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
	           
				String albumTitle = albumInfo.split(" - by: ")[0];
	            String artist = albumInfo.split(" - by: ")[1].split(" \\(")[0];
	            userLibrary.addAlbum(albumTitle);
	            System.out.println("\n" + albumTitle + " by " + artist + " has been added to your library!\n");
	            System.out.print("Would you like to add another album? (Y/N): ");
		        if (!response.nextLine().trim().equalsIgnoreCase("Y")) break;
	        }  
	    }
	}
	
	public static void editPlaylist(UserLibrary userLibrary, MusicStore musicStore) {
		Scanner response = new Scanner(System.in);
		System.out.print("\nWhat playlist would you like to edit? ");
		String playlistName = response.nextLine();
		String playlist = userLibrary.getPlaylist(playlistName);
		if (playlist.equals("Playlist by this name cannot be found.")) {
			System.out.print(playlist + ", would you like to create it? (Y/N) ");
			if (response.nextLine().trim().equalsIgnoreCase("Y")) {
				createPlaylist(userLibrary);
			}
		} else {
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

	// helper method to add a song to a playlist
	private static void addToPlaylist(UserLibrary userLibrary, MusicStore musicStore, String playlistName, Scanner response) {
		while (true) {
	        System.out.print("\nSearch for a song by title or artist: ");
	        String input = response.nextLine().strip().toLowerCase();
	        String songSearch = musicStore.getSongByTitle(input);

	        if (songSearch.equals("This song cannot be found.")) {
	        	songSearch = musicStore.getSongByArtist(input);
	        }
	        if (songSearch.equals("Songs by this artist cannot be found.")) {
	            System.out.println("\nThis song cannot be found.\n");
	        } else {
	            String[] songs = songSearch.strip().split("\n"); // Splitting multiple results

	            String selectedSong;
	            if (songs.length > 1) {
	                System.out.println("\nMultiple songs found:");
	                for (int i = 0; i < songs.length; i++) {
	                    System.out.println((i + 1) + ". " + songs[i]);
	                }
	                System.out.print("Enter the NUMBER of the song you want to add: ");
	                
	                int choice;
	                try {
	                    choice = Integer.parseInt(response.nextLine().strip());
	                    if (choice < 1 || choice > songs.length) throw new NumberFormatException();
	                } catch (NumberFormatException e) {
	                    System.out.println("Invalid selection. Please try again.\n");
	                    continue;
	                }
	                selectedSong = songs[choice - 1];
	            } else {
	                selectedSong = songs[0];
	            }

	            // Extract artist from "Title - by: Artist (Album)" format
	            String artist = selectedSong.split(" - by: ")[1].split(" \\(")[0];
	            String title = selectedSong.split(" - by: ")[0];
	            
	            userLibrary.addSongToPlaylist(title, artist, playlistName);
	            System.out.println("\n" + title + " by " + artist + " has been added to " + playlistName + "!\n");
	        }

	        System.out.print("Would you like to add another song? (Y/N): ");
	        if (!response.nextLine().trim().equalsIgnoreCase("Y")) break;
	    }
	}
	
	private static void removeFromPlaylist(UserLibrary userLibrary, MusicStore musicStore, String playlistName, Scanner response) {
		while (true) {
	        System.out.print("\nSearch for a song by title or artist: ");
	        String input = response.nextLine().strip().toLowerCase();
	        String songSearch = musicStore.getSongByTitle(input);

	        if (songSearch.equals("This song cannot be found.")) {
	        	songSearch = musicStore.getSongByArtist(input);
	        }
	        if (songSearch.equals("Songs by this artist cannot be found.")) {
	            System.out.println("\nThis song cannot be found.\n");
	        } else {
	            String[] songs = songSearch.strip().split("\n"); // Splitting multiple results

	            String selectedSong;
	            if (songs.length > 1) {
	                System.out.println("\nMultiple songs found:");
	                for (int i = 0; i < songs.length; i++) {
	                    System.out.println((i + 1) + ". " + songs[i]);
	                }
	                System.out.print("Enter the NUMBER of the song you want to remove: ");
	                
	                int choice;
	                try {
	                    choice = Integer.parseInt(response.nextLine().strip());
	                    if (choice < 1 || choice > songs.length) throw new NumberFormatException();
	                } catch (NumberFormatException e) {
	                    System.out.println("Invalid selection. Please try again.\n");
	                    continue;
	                }
	                selectedSong = songs[choice - 1];
	            } else {
	                selectedSong = songs[0];
	            }

	            // Extract artist from "Title - by: Artist (Album)" format
	            String artist = selectedSong.split(" - by: ")[1].split(" \\(")[0];
	            String title = selectedSong.split(" - by: ")[0];
	            
	            userLibrary.removeSongFromPlaylist(title, artist, playlistName);
	            System.out.println("\n" + title + " by " + artist + " has been removed from " + playlistName + "!\n");
	        }

	        System.out.print("Would you like to remove another song? (Y/N): ");
	        if (!response.nextLine().trim().equalsIgnoreCase("Y")) break;
	    }
	}
	
	public static void rateSong(UserLibrary userLibrary) {
		Scanner response = new Scanner(System.in);
		while (true) {
		System.out.print("\nSearch for a song by title or artist to rate: ");
		String input = response.nextLine();
		String songSearch = userLibrary.getSongByTitle(input);

        if (songSearch.equals("This song cannot be found.")) {
        	songSearch = userLibrary.getSongByArtist(input);
        }
        if (songSearch.equals("Songs by this artist cannot be found.")) {
            System.out.println("\nSong by this title/artist cannot be found in your library, go to the Add Song command to add it!\n");
        } else {
            String[] songs = songSearch.strip().split("\n"); // Splitting multiple results

            String selectedSong;
            if (songs.length > 1) {
                System.out.println("\nMultiple songs found:");
                for (int i = 0; i < songs.length; i++) {
                    System.out.println((i + 1) + ". " + songs[i]);
                }
                System.out.print("Enter the NUMBER of the song you want to rate: ");
                
                int choice;
                try {
                    choice = Integer.parseInt(response.nextLine().strip());
                    if (choice < 1 || choice > songs.length) throw new NumberFormatException();
                } catch (NumberFormatException e) {
                    System.out.println("Invalid selection. Please try again.\n");
                    continue;
                }
                selectedSong = songs[choice - 1];
            } else {
                selectedSong = songs[0];
            }

            // Extract artist from "Title - by: Artist (Album)" format
            String artist = selectedSong.split(" - by: ")[1].split(" \\(")[0];
            String title = selectedSong.split(" - by: ")[0];
            System.out.print("\nEnter your rating for " + title + " by " + artist + ": ");
            
            int rating = Integer.parseInt(response.nextLine().strip());
            userLibrary.rateSong(title, artist, rating);
            if (rating == 5) {
            	System.out.print("\n" + title + " by " + artist + " has been favorited!\n");
            }
        }

        System.out.print("Would you like to rate another song? (Y/N): ");
        if (!response.nextLine().trim().equalsIgnoreCase("Y")) break;
    }
	}
	
}



	
	
	

