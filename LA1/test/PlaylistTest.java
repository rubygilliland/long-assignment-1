package test;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
	void testGetName() {
		Playlist myPlaylist = new Playlist("Pop Hits");
		assertEquals(myPlaylist.getName(), "Pop Hits");
	}

	@Test
	void testPopAndInsert() {
		Album adele21 = new Album("21", "Adele", "Pop", "2011");
		Song s1 = new Song("Rolling in the Deep", "Adele", adele21);
		Song s2 = new Song("Set Fire to the Rain", "Adele", adele21);
		Song s3 = new Song("Take It All", "Adele", adele21);
		Playlist myPlaylist = new Playlist("Adele Favs");
		myPlaylist.addSong(s1);
		myPlaylist.addSong(s2);
		myPlaylist.insertSong(s3);
		myPlaylist.popSong();
		String actual = myPlaylist.toString();
		String expected = "Adele Favs:\n\tTake It All - by: Adele (21)\n\tRolling in the Deep - by: Adele (21)\n";
		assertEquals(expected, actual);
	}
	
	@Test
	void testShuffle() { 
		Album adele21 = new Album("21", "Adele", "Pop", "2011");
		Song s1 = new Song("Rolling in the Deep", "Adele", adele21);
		Song s2 = new Song("Set Fire to the Rain", "Adele", adele21);
		Song s3 = new Song("Take It All", "Adele", adele21);
		Playlist myPlaylist = new Playlist("Adele Favs");
		myPlaylist.addSong(s1);
		myPlaylist.addSong(s2);
		myPlaylist.addSong(s3);
		myPlaylist.shufflePlaylist();
		String actual = myPlaylist.getRandomSong().toString();
		assertNotNull(actual);
	}
}
