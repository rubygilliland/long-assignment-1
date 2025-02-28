package test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

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
		USER_LIBRARY.addSongToPlaylist("Begin Again", "Norah Jones", "Pop Hits");
		USER_LIBRARY.addSongToPlaylist("Rolling in the Deep","Adele", "Pop Hits");
		USER_LIBRARY.addSongToPlaylist("Lovesong", "Adele", "Pop Hits");
		USER_LIBRARY.addSongToPlaylist("Chasing Pavements", "Adele", "Pop Hits");
		String expected = "Pop Hits:\n";
		expected += "\tBegin Again - by: Norah Jones (Begin Again)\n";
		expected += "\tRolling in the Deep - by: Adele (21)\n";
		expected += "\tLovesong - by: Adele (21)\n";
		expected += "\tChasing Pavements - by: Adele (19)\n";
		assertEquals(expected, USER_LIBRARY.getPlaylist("Pop Hits"));
	}
	
	@Test
	void testRemoveSongs() {
		USER_LIBRARY.createPlaylist("Pop Hits");
		USER_LIBRARY.addSongToPlaylist("Begin Again", "Norah Jones", "Pop Hits");
		USER_LIBRARY.addSongToPlaylist("Rolling in the Deep","Adele", "Pop Hits");
		USER_LIBRARY.addSongToPlaylist("Lovesong", "Adele", "Pop Hits");
		USER_LIBRARY.addSongToPlaylist("Chasing Pavements", "Adele", "Pop Hits");
		USER_LIBRARY.removeSongFromPlaylist("Rolling in the Deep", "Adele", "Pop Hits");
		USER_LIBRARY.removeSongFromPlaylist("Lovesong", "Adele","Pop Hits");
		String songStr = "Pop Hits:\n\tBegin Again - by: Norah Jones (Begin Again)\n";
		songStr += "\tChasing Pavements - by: Adele (19)\n";
		assertEquals(songStr, USER_LIBRARY.getPlaylist("Pop Hits"));
	}
	
	@Test
	void testGetSongsList() {
		Playlist myPlaylist = new Playlist("Pop Hits");
		myPlaylist.addSong(new Song("Begin Again", "Norah Jones"));
		myPlaylist.addSong(new Song("Lovesong", "Adele"));
		myPlaylist.addSong(new Song("Chasing Pavements", "Adele"));
		ArrayList<Song> testSongs = new ArrayList<>();
		testSongs.add(new Song("Begin Again", "Norah Jones"));
		testSongs.add(new Song("Lovesong", "Adele"));
		testSongs.add(new Song("Chasing Pavements", "Adele"));
		
		for (int i = 0; i < testSongs.size(); i++) {
			assertEquals(testSongs.get(i), myPlaylist.getSongsList().get(i));
		}
		
		
		
	}
	
	@Test
	void testGetName() {
		Playlist myPlaylist = new Playlist("Pop Hits");
		assertEquals(myPlaylist.getName(), "Pop Hits");
	}

}
