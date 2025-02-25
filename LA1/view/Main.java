package view;
import model.*;
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
			System.out.print("Enter a command: ");
			Scanner userInput = new Scanner(System.in);
			String inputString = userInput.nextLine().strip().toLowerCase();
			
			switch(inputString) {
				case "search song":
					System.out.println("\n" + searchSongs(musicStore) + "\n");
					break;
				case "1":
					System.out.println("\n" + searchSongs(musicStore) + "\n");
					break;
				case "search album":
					System.out.println("\n" + searchAlbum(musicStore) + "\n");
					break;
				case "2":
					System.out.println("\n" + searchAlbum(musicStore) + "\n");
					break;
				case "browse":
					System.out.println("\n" + musicStore + "\n");
					break;
				case "3":
					System.out.println("\n" + musicStore + "\n");
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
		
		return songFound;
	}
}
