package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Playlist;
import model.Song;

class PlaylistTest {
	private static final Song BEGIN_AGAIN = new Song("Begin Again", "Norah Jones");
	private static final Song ROLLING_DEEP = new Song("Rolling in the Deep", "Adele");
	private static final Song LOVE_SONG = new Song("Lovesong", "Adele");
	private static final Song CHASING_PAVEMENTS = new Song("Chasing Pavements", "Adele");

	@Test
	void testAddSongs() {
		Playlist myPlaylist = new Playlist("Pop Hits");
		myPlaylist.addSong(BEGIN_AGAIN);
		myPlaylist.addSong(ROLLING_DEEP);
		myPlaylist.addSong(LOVE_SONG);
		myPlaylist.addSong(CHASING_PAVEMENTS);
		String songStr = "Begin Again\nRolling in the Deep\nLovesong\nChasing Pavements\n";
		assertEquals(songStr, myPlaylist.getSongs());
	}
	
	@Test
	void testRemoveSongs() {
		Playlist myPlaylist = new Playlist("Pop Hits");
		myPlaylist.addSong(BEGIN_AGAIN);
		myPlaylist.addSong(ROLLING_DEEP);
		myPlaylist.addSong(LOVE_SONG);
		myPlaylist.addSong(CHASING_PAVEMENTS);
		myPlaylist.removeSong("Rolling in the Deep");
		myPlaylist.removeSong("Lovesong");
		String songStr = "Begin Again\nChasing Pavements\n";
		assertEquals(songStr, myPlaylist.getSongs());
	}

}
