package view;
import model.*;
import java.util.Scanner;

public class Main {
	
	public static final String WELCOME_MESSAGE = "Welcome to VibeStream, the number one fake music app!\n\n"
			+ "Get ready to discover, stream, and vibe to your favorite music like never before! " +
			"Whether you're in the mood for chill beats, \nhigh-energy anthems, or fresh new sounds, " + 
			"VibeStream brings the best music straight to you!\n";
	
	public static final String LIST_OF_COMMANDS = "List of Commands:\n1. Search\n2. Browse \n3. Create Playlist" + 
	"\n4. View Playlists\n5. Add Songs\n6. Add Alubms\n7. Rate Song";
	
	
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
				case "search":
					System.out.println("\n" + searchSongs(musicStore) + "\n");
					break;
				case "1":
					System.out.println("\n" + searchSongs(musicStore) + "\n");
					break;
				default:
					System.out.println("Sorry command not found. Please try again!\n");	
					break;
			}
				
			
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
}
