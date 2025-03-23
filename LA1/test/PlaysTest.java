package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.Test;

import model.Album;
import model.Playlist;
import model.Plays;
import model.Song;

public class PlaysTest {
	private final Album ADELE = new Album("21", "Adele", "Pop", "2011");
	private final Song SONG = new Song("Rolling in the Deep", "Adele", ADELE);
	private final Song SONG2 = new Song("Don't You Remember", "Adele", ADELE);
	private final Song SONG3 = new Song("He Won't Go", "Adele", ADELE);
	private final Song SONG4 = new Song("Rumour Has It", "Adele", ADELE);
	private final Song SONG5 = new Song("Turning Tables", "Adele", ADELE);
	private final Song SONG6 = new Song("I Found a Boy", "Adele", ADELE);
	private final Song SONG7 = new Song("Someone Like You", "Adele", ADELE);
	private final Song SONG8 = new Song("Lovesong", "Adele", ADELE);
	private final Song SONG9 = new Song("One and Only", "Adele", ADELE);
	private final Song SONG10 = new Song("I'll Be Waiting", "Adele", ADELE);

	@Test
	public void testPlaySong() {
		Plays plays = new Plays();
		Album adele = new Album("21", "Adele", "Pop", "2011");
		Song song = new Song("Rolling in the Deep", "Adele", adele);
		plays.playSong(song);
		String actual =  plays.getRecentlyPlayed().toString();
		String expected = "Recently Played:\n\tRolling in the Deep - by: Adele (21)\n";
		assertEquals(expected, actual);
	}
	
	@Test
	public void testGetFrequentlyPlayed() {
		Plays plays = new Plays();
		plays.playSong(SONG3);
		plays.playSong(SONG);
		plays.playSong(SONG2);
		plays.playSong(SONG2);
		plays.playSong(SONG2); 
		plays.playSong(SONG3);
		plays.playSong(SONG);
		plays.playSong(SONG4);
		plays.playSong(SONG4);
		plays.playSong(SONG5);
		plays.playSong(SONG5);
		plays.playSong(SONG6);
		plays.playSong(SONG7);
		plays.playSong(SONG8);
		plays.playSong(SONG9);
		plays.playSong(SONG10);
		String actual = plays.getFrequentlyPlayed().toString();
		String expected = "Frequently Played:\n\tDon't You Remember - by: Adele (21)\n\tRolling in the Deep - by: Adele (21)\n";
		expected += "\tHe Won't Go - by: Adele (21)\n\tRumour Has It - by: Adele (21)\n\tTurning Tables - by: Adele (21)\n";
		expected += "\tLovesong - by: Adele (21)\n\tSomeone Like You - by: Adele (21)\n\tI Found a Boy - by: Adele (21)\n";
		expected += "\tOne and Only - by: Adele (21)\n\tI'll Be Waiting - by: Adele (21)\n";
		assertEquals(expected, actual);
		
	}
	
	@Test
	public void testGetPlaysBySong() {
		Plays plays = new Plays();
		Album adele = new Album("21", "Adele", "Pop", "2011");
		Song song = new Song("Rolling in the Deep", "Adele", adele);
		plays.playSong(song);
		assertEquals(plays.getPlaysBySong(song), 1);
		
	}
	
	@Test 
	public void testCopyConstructor() {
		Plays plays = new Plays();
		Album adele = new Album("21", "Adele", "Pop", "2011");
		Song song = new Song("Rolling in the Deep", "Adele", adele);
		plays.playSong(song);
		assertEquals(plays, new Plays(plays));
	}
	
	@Test
	public void testEqualsFalse() {
		Plays plays = new Plays();
		Album adele = new Album("21", "Adele", "Pop", "2011");
		Song song = new Song("Rolling in the Deep", "Adele", adele);
		plays.playSong(song);
		Playlist myPlaylist = new Playlist("Adele Favs");
		assertFalse(plays.equals(myPlaylist));	
	}
	
	@Test
	public void testEqualsNull() {
		Plays plays = new Plays();
		Album adele = new Album("21", "Adele", "Pop", "2011");
		Song song = new Song("Rolling in the Deep", "Adele", adele);
		plays.playSong(song);
		assertFalse(plays.equals(null));
	}
	
	@Test
	public void testEqualsDiff() {
		Plays plays = new Plays();
		Album adele = new Album("21", "Adele", "Pop", "2011");
		Song song = new Song("Rolling in the Deep", "Adele", adele);
		plays.playSong(song);
		Plays plays2 = new Plays();
		assertFalse(plays.equals(plays2));
	}
	
	@Test
	public void testEqualsSimilar() {
		Plays plays = new Plays();
		Album adele = new Album("21", "Adele", "Pop", "2011");
		Song song = new Song("Rolling in the Deep", "Adele", adele);
		plays.playSong(song);
		Plays plays2 = new Plays(plays);
		plays2.playSong(song);
		plays2.playSong(song);
		plays2.playSong(song);
		assertFalse(plays.equals(plays2));
	}
	
	@Test
	public void testEqualsTrue() {
		Plays plays = new Plays();
		Album adele = new Album("21", "Adele", "Pop", "2011");
		Song song = new Song("Rolling in the Deep", "Adele", adele);
		plays.playSong(song);
		assertTrue(plays.equals(plays));
	}

}
