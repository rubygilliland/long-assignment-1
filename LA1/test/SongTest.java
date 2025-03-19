package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Album;
import model.Song;

class SongTest {

	@Test
	void testAlbum() {
		Album myAlbum = new Album("19", "Adele", "Pop", "2008");
		Song mySong = new Song("Chasing Pavements", "Adele", myAlbum);
		assertEquals(myAlbum.getTitle(), mySong.getAlbum());		
	}
	
	@Test
	void testRatingOne() {
		Album myAlbum = new Album("19", "Adele", "Pop", "2008");
		Song mySong = new Song("Make You Feel My Love", "Adele", myAlbum);
		mySong.rate(1);
		assertEquals(Song.Rating.ONE, mySong.getRating());
	}
	
	@Test
	void testRatingTwo() {
		Album myAlbum = new Album("19", "Adele", "Pop", "2008");
		Song mySong = new Song("Make You Feel My Love", "Adele", myAlbum);
		mySong.rate(2);
		assertEquals(Song.Rating.TWO, mySong.getRating());
	}
	
	@Test
	void testRatingFive() {
		Album myAlbum = new Album("19", "Adele", "Pop", "2008");
		Song mySong = new Song("Make You Feel My Love", "Adele", myAlbum);
		mySong.rate(5);
		assertEquals(Song.Rating.FAVORITE, mySong.getRating());
	}
	
	@Test
	void testFavorite() {
		Album myAlbum = new Album("19", "Adele", "Pop", "2008");
		Song mySong = new Song("My Same", "Adele", myAlbum);
		mySong.favorite();
		assertEquals(Song.Rating.FAVORITE, mySong.getRating());
	}
	
	@Test
	void testGetTitle() {
		Album myAlbum = new Album("19", "Adele", "Pop", "2008");
		Song mySong = new Song("Chasing Pavements", "Adele", myAlbum);
		assertEquals("Chasing Pavements", mySong.getTitle());
	}
	
	@Test
	void testGetArtist() {
		Album myAlbum = new Album("19", "Adele", "Pop", "2008");
		Song mySong = new Song("Crazy for You", "Adele", myAlbum);
		assertEquals("Adele", mySong.getArtist());
	}
	
	@Test
	void testToString() {
		Album myAlbum = new Album("A Rush of Blood to the Head", "Coldplay", "Alternative", "2002");
		Song mySong = new Song("In My Place", "Coldplay", myAlbum);
		assertEquals(mySong.toString(), "In My Place - by: Coldplay (A Rush of Blood to the Head)\n");
	}
	
	@Test
	void testEqualsSame() {
		Album myAlbum = new Album("19", "Adele", "Pop", "2008");
		Song mySong1 = new Song("Crazy for You", "Adele", myAlbum);
		Song mySong2 = new Song("Crazy for You", "Adele", myAlbum);
		assertEquals(mySong1, mySong2);
	}
	
	@Test
	void testEqualsDifferentArtist() {
		Album myAlbum = new Album("19", "Adele", "Pop", "2008");
		Song mySong1 = new Song("Crazy for You", "Coldplay", myAlbum);
		Song mySong2 = new Song("Crazy for You", "Adele", myAlbum);
		assertFalse(mySong1.equals(mySong2));
	}
	
	@Test
	void testEqualsDiffertObjects() {
		Album myAlbum = new Album("19", "Adele", "Pop", "2008");
		Song mySong = new Song("Crazy for You", "Coldplay", myAlbum);
		Album myAlbum2 = new Album("A Rush of Blood to the Head", "Coldplay", "Alternative", "2002");
		assertFalse(mySong.equals(myAlbum));
	}
	
	@Test
	void testEqualsCopyConstructor() {
		Album myAlbum = new Album("19", "Adele", "Pop", "2008");
		Song mySong1 = new Song("Crazy for You", "Adele", myAlbum);
		Song mySong2 = new Song(mySong1);
		assertEquals(mySong1, mySong2);
	}
	
	@Test
	void testCopyConstructor() {
		Album myAlbum = new Album("19", "Adele", "Pop", "2008");
		Song mySong1 = new Song("Crazy for You", "Adele", myAlbum);
		mySong1.rate(4);
		Song mySong2 = new Song(mySong1);
		assertTrue(mySong1.getAlbum().equals(mySong2.getAlbum()));
		assertTrue(mySong1.getRating().equals(mySong2.getRating()));
	}
	
	@Test
	void testToStringFile() {
		Album myAlbum = new Album("19", "Adele", "Pop", "2008");
		Song mySong1 = new Song("Crazy for You", "Adele", myAlbum);
		mySong1.rate(4);
		String expected = "Crazy for You - by: Adele (19) FOUR\n";
		String actual = mySong1.toStringFile();
		assertEquals(expected, actual);
	}
	
	
}
