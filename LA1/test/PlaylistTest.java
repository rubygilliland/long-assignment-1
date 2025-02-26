package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Album;
import model.MusicStore;
import model.Playlist;
import model.Song;
import model.UserLibrary;

class PlaylistTest {
	private MusicStore MUSIC_STORE = new MusicStore();
	private UserLibrary USER_LIBRARY = new UserLibrary(MUSIC_STORE);

	@Test
	void testAddSongs() {
		USER_LIBRARY.createPlaylist("Pop Hits");
		USER_LIBRARY.addSongToPlaylist("Begin Again", "Pop Hits");
		USER_LIBRARY.addSongToPlaylist("Rolling in the Deep", "Pop Hits");
		USER_LIBRARY.addSongToPlaylist("Lovesong", "Pop Hits");
		USER_LIBRARY.addSongToPlaylist("Chasing Pavements", "Pop Hits");
		String expected = "Pop Hits:\n";
		expected += "Begin Again - by: Norah Jones (Begin Again)\n";
		expected += "Rolling in the Deep - by: Adele (21)\n";
		expected += "Lovesong - by: Adele (21)\n";
		expected += "Chasing Pavements - by: Adele (19)\n";
		assertEquals(expected, USER_LIBRARY.getPlaylist("Pop Hits"));
	}
	
	@Test
	void testRemoveSongs() {
		USER_LIBRARY.createPlaylist("Pop Hits");
		USER_LIBRARY.addSongToPlaylist("Begin Again", "Pop Hits");
		USER_LIBRARY.addSongToPlaylist("Rolling in the Deep", "Pop Hits");
		USER_LIBRARY.addSongToPlaylist("Lovesong", "Pop Hits");
		USER_LIBRARY.addSongToPlaylist("Chasing Pavements", "Pop Hits");
		USER_LIBRARY.removeSongFromPlaylist("Rolling in the Deep", "Pop Hits");
		USER_LIBRARY.removeSongFromPlaylist("Lovesong", "Pop Hits");
		String songStr = "Pop Hits:\nBegin Again - by: Norah Jones (Begin Again)\n";
		songStr += "Chasing Pavements - by: Adele (19)\n";
		assertEquals(songStr, USER_LIBRARY.getPlaylist("Pop Hits"));
	}
	
	@Test
	void testGetName() {
		Playlist myPlaylist = new Playlist("Pop Hits");
		assertEquals(myPlaylist.getName(), "Pop Hits");
	}

}
