package test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.Album;
import model.Plays;
import model.Song;

public class PlaysTest {

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
		Album adele = new Album("21", "Adele", "Pop", "2011");
		Song song = new Song("Rolling in the Deep", "Adele", adele);
		Song song2 = new Song("Don't You Remember", "Adele", adele);
		Song song3 = new Song("He Won't Go", "Adele", adele);
		plays.playSong(song3);
		plays.playSong(song);
		plays.playSong(song2);
		plays.playSong(song2);
		plays.playSong(song2);
		plays.playSong(song3);
		String actual = plays.getFrequentlyPlayed().toString();
		String expected = "Frequently Played:\n\tDon't You Remember - by: Adele (21)\n\tHe Won't Go - by: Adele (21)\n";
		expected += "\tRolling in the Deep - by: Adele (21)\n";
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

}
