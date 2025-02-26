package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import model.Song;
import model.Album;
import model.Parser;

public class ParserTest {
	
	@Test
	public void testMakeAlbumList() {
		ArrayList<Album> myAlbumList = Parser.makeAlbumList("LA1/albums.txt");
		ArrayList<Album> testAlbumList = new ArrayList<>();
		testAlbumList.add(new Album("19", "Adele", "Pop", "2008"));
		testAlbumList.add(new Album("21", "Adele", "Pop", "2011"));
		testAlbumList.add(new Album("Begin Again", "Norah Jones", "Pop", "2018"));
		testAlbumList.add(new Album("Boys & Girls", "Alabama Shakes", "Alternative", "2012"));
		testAlbumList.add(new Album("Cuando Los Angeles Lloran", "Mana", "Latin", "1995"));
		testAlbumList.add(new Album("Don't Mess With the Dragon", "Ozomatli", "Rock", "2007"));
		testAlbumList.add(new Album("Fight for Your Mind", "Ben Harper", "Alternative", "1995"));
		testAlbumList.add(new Album("Mission Bell", "Amos Lee", "Singer/Songwriter", "2010"));
		testAlbumList.add(new Album("Old Ideas", "Leonard Cohen", "Singer/Songwriter", "2012"));
		testAlbumList.add(new Album("Sigh No More", "Mumford & Sons", "Alternative", "2009"));
		testAlbumList.add(new Album("Waking Up", "OneRepublic", "Rock", "2009"));
		testAlbumList.add(new Album("A Rush of Blood to the Head", "Coldplay", "Alternative", "2002"));
		testAlbumList.add(new Album("Coat of Many Colors", "Dolly Parton", "Traditional Country", "1971"));
		testAlbumList.add(new Album("Tapestry", "Carol King", "Rock", "1971"));
		testAlbumList.add(new Album("Sons", "The Heavy", "Rock", "2019"));
		
		for (int i = 0; i < myAlbumList.size(); i++) {
			assertTrue(myAlbumList.get(i).equals(testAlbumList.get(i)));
		}
	} 
	
	@Test
	public void testMakeAlbum() {

		Album myAlbum = Parser.makeAlbum("LA1/19_Adele.txt");
		assertEquals(myAlbum.getTitle(), "19");
		assertEquals(myAlbum.getArtist(), "Adele");
		assertEquals(myAlbum.getYear(), 2008);
		Song[] albumSongs = myAlbum.getSongs().toArray(new Song[12]);
		String[] testSongs = {"Daydreamer", "Best for Last", "Chasing Pavements", "Cold Shoulder",
		                         "Crazy for You", "Melt My Heart to Stone", "First Love", "Right as Rain",
		                         "Make You Feel My Love", "My Same", "Tired", "Hometown Glory"};
		
		for (int i =0; i < albumSongs.length; i++) {
			assertEquals(albumSongs[i].getTitle(), testSongs[i]);
		}
		
		
	}
	
}
