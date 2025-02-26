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
	"\n5. View Playlists\n6. Add Songs\n7. Add Alubms\n8. Rate Song";
	
	
	public static void main(String[] args) {
		System.out.println(WELCOME_MESSAGE);
		MusicStore musicStore = new MusicStore();
		UserLibrary userLibrary = new UserLibrary(musicStore);
		
		while (true) {
			System.out.println(LIST_OF_COMMANDS);
			System.out.print("Enter a command (1-8): ");
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
			System.out.println("Go to the Add Songs command to add to this playlist!\n");
		}
		else {
			System.out.println("\nCreate playlist canceled\n");
		}
		
	}
	
	
}
