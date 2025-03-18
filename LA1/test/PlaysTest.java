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
	
}
