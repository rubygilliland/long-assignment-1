package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import model.Album;
import model.Parser;

public class ParserTest {

	@Test
	public void testmakeAlbum() {
		Album myAlbum = Parser.makeAlbum("C:\\Users\\colin\\eclipse-workspace\\long-assignment-1\\LA1\\model\\19_Adele.txt");
		assertEquals(myAlbum.getTitle(), "19");
		assertEquals(myAlbum.getArtist(), "Adele");
		assertEquals(myAlbum.getYear(), 2008);
		String[] albumSongs = myAlbum.getSongs().toArray(new String[12]);
		String[] testSongs = {"Daydreamer", "Best for Last", "Chasing Pavements", "Cold Shoulder",
		                         "Crazy for You", "Melt My Heart to Stone", "First Love", "Right as Rain",
		                         "Make You Feel My Love", "My Same", "Tired", "Hometown Glory"};
		
		for (int i =0; i < albumSongs.length; i++) {
			assertEquals(albumSongs[i], testSongs[i]);
		}
		
		
	}

}
