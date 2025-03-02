package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Album;
import model.Song;

class SongTest {

	@Test
	void testAlbum() {
		Album myAlbum = new Album("19", "Adele", "Pop", "2008");
		Song mySong = new Song("Chasing Pavements", "Adele");
		mySong.setAlbum(myAlbum);
		assertEquals(myAlbum.getTitle(), mySong.getAlbum());		
	}
	
	@Test
	void testRatingOne() {
		Song mySong = new Song("Make You Feel My Love", "Adele");
		mySong.rate(1);
		assertEquals(Song.Rating.ONE, mySong.getRating());
	}
	
	@Test
	void testRatingTwo() {
		Song mySong = new Song("Make You Feel My Love", "Adele");
		mySong.rate(2);
		assertEquals(Song.Rating.TWO, mySong.getRating());
	}
	
	@Test
	void testRatingFive() {
		Song mySong = new Song("Make You Feel My Love", "Adele");
		mySong.rate(5);
		assertEquals(Song.Rating.FAVORITE, mySong.getRating());
	}
	
	@Test
	void testFavorite() {
		Song mySong = new Song("My Same", "Adele");
		mySong.favorite();
		assertEquals(Song.Rating.FAVORITE, mySong.getRating());
	}
	
	@Test
	void testGetTitle() {
		Song mySong = new Song("Chasing Pavements", "Adele");
		assertEquals("Chasing Pavements", mySong.getTitle());
	}
	
	@Test
	void testGetArtist() {
		Song mySong = new Song("Crazy for You", "Adele");
		assertEquals("Adele", mySong.getArtist());
	}
	
	@Test
	void testToString() {
		Song mySong = new Song("In My Place", "Coldplay");
		Album myAlbum = new Album("A Rush of Blood to the Head", "Coldplay", "Alternative", "2002");
		mySong.setAlbum(myAlbum);
		assertEquals(mySong.toString(), "In My Place - by: Coldplay (A Rush of Blood to the Head)\n");
	}
	
	@Test
	void testEqualsSame() {
		Song mySong1 = new Song("Crazy for You", "Adele");
		Song mySong2 = new Song("Crazy for You", "Adele");
		assertEquals(mySong1, mySong2);
	}
	
	@Test
	void testEqualsDifferentArtist() {
		Song mySong1 = new Song("Crazy for You", "Coldplay");
		Song mySong2 = new Song("Crazy for You", "Adele");
		assertFalse(mySong1.equals(mySong2));
	}
	
	@Test
	void testEqualsDiffertObjects() {
		Song mySong = new Song("Crazy for You", "Coldplay");
		Album myAlbum = new Album("A Rush of Blood to the Head", "Coldplay", "Alternative", "2002");
		assertFalse(mySong.equals(myAlbum));
	}
	
	@Test
	void testEqualsCopyConstructor() {
		Song mySong1 = new Song("Crazy for You", "Coldplay");
		Song mySong2 = new Song(mySong1);
		assertEquals(mySong1, mySong2);
	}
	
	@Test
	void testCopyConstructor() {
		Song mySong1 = new Song("Crazy for You", "Coldplay");
		Album myAlbum = new Album("A Rush of Blood to the Head", "Coldplay", "Alternative", "2002");
		mySong1.setAlbum(myAlbum);
		mySong1.rate(4);
		Song mySong2 = new Song(mySong1);
		assertTrue(mySong1.getAlbum().equals(mySong2.getAlbum()));
		assertTrue(mySong1.getRating().equals(mySong2.getRating()));
		
	}
	
	
}
