package model;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Parser {
	
	public static Album makeAlbum(String fileName){
		File myFile = new File(fileName);
		try (Scanner fileScanner = new Scanner(myFile)){
			String firstLine = fileScanner.nextLine();
			String[] albumDetails = firstLine.strip().split(",");
			// [0] is name of album, [1] is artist, [2] is genre, [3] is year
			Album myAlbum = new Album(albumDetails[0], albumDetails[1], albumDetails[2], albumDetails[3]);
			while (fileScanner.hasNextLine()) {
				String line = fileScanner.nextLine();
				line = line.strip();
				Song newSong = new Song(line, albumDetails[1]);
				myAlbum.addSong(newSong);
			}
			return myAlbum;
		}
		catch (FileNotFoundException exception) {
			System.out.println("File not found.");
			return null;
		}
		
		
	}

}
