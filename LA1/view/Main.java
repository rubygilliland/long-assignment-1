package view;
import model.*;

public class Main {
	
	public static void main(String[] args) {
		MusicStore musicStore = new MusicStore();
		UserLibrary userLibrary = new UserLibrary(musicStore);
		
		System.out.print(musicStore);
		
	}
}
