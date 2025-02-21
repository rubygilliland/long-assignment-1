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

}
