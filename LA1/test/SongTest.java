package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import model.Album;
import model.Song;
import model.Song.Rating;

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
	void testRatingThree() {
		Album myAlbum = new Album("19", "Adele", "Pop", "2008");
		Song mySong = new Song("Make You Feel My Love", "Adele", myAlbum);
		mySong.rate(3);
		assertEquals(Song.Rating.THREE, mySong.getRating());
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
		String expected = "Crazy for You - by: Adele (19):FOUR\n";
		String actual = mySong1.toStringFile();
		assertEquals(expected, actual);
	}
	
	@Test
	void testRateWithStringOne() {
		Album myAlbum = new Album("19", "Adele", "Pop", "2008");
		Song mySong1 = new Song("Crazy for You", "Adele", myAlbum);
		mySong1.rate("one");
		Rating expected = Song.Rating.ONE;
		Rating actual = mySong1.getRating();
		assertEquals(expected, actual);
	}
	
	@Test
	void testRateWithStringTwo() {
		Album myAlbum = new Album("19", "Adele", "Pop", "2008");
		Song mySong1 = new Song("Crazy for You", "Adele", myAlbum);
		mySong1.rate("two");
		Rating expected = Song.Rating.TWO;
		Rating actual = mySong1.getRating();
		assertEquals(expected, actual);
	}
	
	@Test
	void testRateWithStringThree() {
		Album myAlbum = new Album("19", "Adele", "Pop", "2008");
		Song mySong1 = new Song("Crazy for You", "Adele", myAlbum);
		mySong1.rate("three");
		Rating expected = Song.Rating.THREE;
		Rating actual = mySong1.getRating();
		assertEquals(expected, actual);
	}
	
	@Test
	void testRateWithStringFour() {
		Album myAlbum = new Album("19", "Adele", "Pop", "2008");
		Song mySong1 = new Song("Crazy for You", "Adele", myAlbum);
		mySong1.rate("four");
		Rating expected = Song.Rating.FOUR;
		Rating actual = mySong1.getRating();
		assertEquals(expected, actual);
	}
	
	@Test
	void testRateWithStringFavorite() {
		Album myAlbum = new Album("19", "Adele", "Pop", "2008");
		Song mySong1 = new Song("Crazy for You", "Adele", myAlbum);
		mySong1.rate("favorite");
		Rating expected = Song.Rating.FAVORITE;
		Rating actual = mySong1.getRating();
		assertEquals(expected, actual);
	}
	
	@Test
	void getAlbumObj() {
		Album myAlbum = new Album("19", "Adele", "Pop", "2008");
		Song mySong1 = new Song("Crazy for You", "Adele", myAlbum);
		myAlbum.addSong(mySong1);
		assertEquals(myAlbum, mySong1.getAlbumObj());
	}
	
	@Test
	void testGetGenre() {
		Album myAlbum = new Album("19", "Adele", "Pop", "2008");
		Song mySong1 = new Song("Crazy for You", "Adele", myAlbum);
		assertEquals("Pop", mySong1.getGenre());
	}


}
