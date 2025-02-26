package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Album;
import model.Album.Genre;
import model.Song;

public class AlbumTest {

	@Test
	public void testGenrePop() {
		Album myAlbum = new Album("21", "Adele", "Pop", "2011");
		assertEquals(Album.Genre.POP, myAlbum.getGenre());
	}
	
	@Test
	public void testGenreAlternative() {
		Album myAlbum = new Album("A Rush of Blood to the Head", "Coldplay", "Alternative", "2002");
		assertEquals(Album.Genre.ALTERNATIVE, myAlbum.getGenre());
	}
	
	@Test
	public void testGenreTraditionalCountry() {
		Album myAlbum = new Album("Coat of Many Colors", "Dolly Parton", "Traditional Country", "1971");
		assertEquals(Album.Genre.TRADITIONAL_COUNTRY, myAlbum.getGenre());
	}
	
	@Test
	public void testGenreLatin() {
		Album myAlbum = new Album("Cuando Los Angeles Lloran", "Mana", "Latin", "1995");
		assertEquals(Album.Genre.LATIN, myAlbum.getGenre());
	}
	
	@Test
	public void testGenreRock() {
		Album myAlbum = new Album("Waking Up", "OneRepublic", "Rock", "2009");
		assertEquals(Album.Genre.ROCK, myAlbum.getGenre());
	}
	
	@Test
	public void testGenreSingerSongwriter() {
		Album myAlbum = new Album("Old Ideas", "Leonard Cohen", "Singer/Songwriter", "2012");
		assertEquals(Album.Genre.SINGER_SONGWRITER, myAlbum.getGenre());
	}

	@Test
	public void testAddSong() {
		Album myAlbum = new Album("Old Ideas", "Leonard Cohen", "Singer/Songwriter", "2012");
		Song songOne = new Song("Going Home", "Leonard Cohen");
		Song songTwo = new Song("Amen", "Leonard Cohen");
		myAlbum.addSong(songOne);
		myAlbum.addSong(songTwo);
		assertEquals(2, myAlbum.getSongs().size());
	}
	
	@Test 
	public void testEqualsDifferentClass() {
		Album myAlbum = new Album("Old Ideas", "Leonard Cohen", "Singer/Songwriter", "2012");
		Song songOne = new Song("Going Home", "Leonard Cohen");
		assertFalse(myAlbum.equals(songOne));
	}
	
	@Test
	public void testEqualsDifferentTitle() {
		Album myAlbum1 = new Album("Old Ideas", "Leonard Cohen", "Singer/Songwriter", "2012");
		Album myAlbum2 = new Album("New Ideas", "Leonard Cohen", "Singer/Songwriter", "2012");
		assertFalse(myAlbum1.equals(myAlbum2));
	}
	
	@Test
	public void testEqualsDifferentArtist() {
		Album myAlbum1 = new Album("Old Ideas", "Leonard Cohen", "Singer/Songwriter", "2012");
		Album myAlbum2 = new Album("Old Ideas", "Beonard Cohen", "Singer/Songwriter", "2012");
		assertFalse(myAlbum1.equals(myAlbum2));
	}
	
	@Test
	public void testEqualsDifferentGenre() {
		Album myAlbum1 = new Album("Old Ideas", "Leonard Cohen", "Singer/Songwriter", "2012");
		Album myAlbum2 = new Album("Old Ideas", "Leonard Cohen", "Pop", "2012");
		assertFalse(myAlbum1.equals(myAlbum2));
	}
	
	@Test
	public void testEqualsDifferentYear() {
		Album myAlbum1 = new Album("Old Ideas", "Leonard Cohen", "Singer/Songwriter", "2012");
		Album myAlbum2 = new Album("Old Ideas", "Leonard Cohen", "Singer/Songwriter", "2009");
		assertFalse(myAlbum1.equals(myAlbum2));
	}
	
	@Test
	public void testEqualsSame(){
		Album myAlbum1 = new Album("Old Ideas", "Leonard Cohen", "Singer/Songwriter", "2012");
		Album myAlbum2 = new Album("Old Ideas", "Leonard Cohen", "Singer/Songwriter", "2012");
		assertTrue(myAlbum1.equals(myAlbum2));
	}
	
	@Test
	public void testToString() {
		Album myAlbum = new Album("Old Ideas", "Leonard Cohen", "Singer/Songwriter", "2012");
		String albumString = "Old Ideas - by: Leonard Cohen (" + Genre.SINGER_SONGWRITER + ") 2012\n";
		assertEquals(myAlbum.toString(), albumString);
		
	}
}
