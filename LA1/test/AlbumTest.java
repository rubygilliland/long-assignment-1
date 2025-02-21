package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Album;
import model.Song;

class AlbumTest {

	@Test
	void testGenrePop() {
		Album myAlbum = new Album("21", "Adele", "Pop", "2011");
		assertEquals(Album.Genre.POP, myAlbum.getGenre());
	}
	
	@Test
	void testGenreAlternative() {
		Album myAlbum = new Album("A Rush of Blood to the Head", "Coldplay", "Alternative", "2002");
		assertEquals(Album.Genre.ALTERNATIVE, myAlbum.getGenre());
	}
	
	@Test
	void testGenreTraditionalCountry() {
		Album myAlbum = new Album("Coat of Many Colors", "Dolly Parton", "Traditional Country", "1971");
		assertEquals(Album.Genre.TRADITIONAL_COUNTRY, myAlbum.getGenre());
	}
	
	@Test
	void testGenreLatin() {
		Album myAlbum = new Album("Cuando Los Angeles Lloran", "Mana", "Latin", "1995");
		assertEquals(Album.Genre.LATIN, myAlbum.getGenre());
	}
	
	@Test
	void testGenreRock() {
		Album myAlbum = new Album("Waking Up", "OneRepublic", "Rock", "2009");
		assertEquals(Album.Genre.ROCK, myAlbum.getGenre());
	}
	
	@Test
	void testGenreSingerSongwriter() {
		Album myAlbum = new Album("Old Ideas", "Leonard Cohen", "Singer/Songwriter", "2012");
		assertEquals(Album.Genre.SINGER_SONGWRITER, myAlbum.getGenre());
	}

	@Test
	void testAddSong() {
		Album myAlbum = new Album("Old Ideas", "Leonard Cohen", "Singer/Songwriter", "2012");
		Song songOne = new Song("Going Home", "Leonard Cohen");
		Song songTwo = new Song("Amen", "Leonard Cohen");
		myAlbum.addSong(songOne);
		myAlbum.addSong(songTwo);
		assertEquals(2, myAlbum.getSongs().size());
	}
}
