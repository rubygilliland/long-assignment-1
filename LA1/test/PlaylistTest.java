package test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
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
	
	@Test
	void testClear() {
		Album adele21 = new Album("21", "Adele", "Pop", "2011");
		Song s1 = new Song("Rolling in the Deep", "Adele", adele21);
		Song s2 = new Song("Set Fire to the Rain", "Adele", adele21);
		Song s3 = new Song("Take It All", "Adele", adele21);
		Playlist myPlaylist = new Playlist("Adele Favs");
		myPlaylist.addSong(s1);
		myPlaylist.addSong(s2);
		myPlaylist.addSong(s3);
		myPlaylist.shufflePlaylist();
		myPlaylist.clear();
		String actual = myPlaylist.toString();
		String expected = "Adele Favs:\n";
		assertEquals(expected, actual);
	}
	
	@Test
	void testSongInPlaylistTrue() {
		Album adele21 = new Album("21", "Adele", "Pop", "2011");
		Song s1 = new Song("Rolling in the Deep", "Adele", adele21);
		Song s2 = new Song("Set Fire to the Rain", "Adele", adele21);
		Song s3 = new Song("Take It All", "Adele", adele21);
		Playlist myPlaylist = new Playlist("Adele Favs");
		myPlaylist.addSong(s1);
		myPlaylist.addSong(s2);
		myPlaylist.addSong(s3);
		assertTrue(myPlaylist.songInPlaylist("Take It All", "Adele"));
	}
	
	@Test
	void testSongInPlaylistFalse() {
		Album adele21 = new Album("21", "Adele", "Pop", "2011");
		Song s1 = new Song("Rolling in the Deep", "Adele", adele21);
		Song s2 = new Song("Set Fire to the Rain", "Adele", adele21);
		Song s3 = new Song("Take It All", "Adele", adele21);
		Playlist myPlaylist = new Playlist("Adele Favs");
		myPlaylist.addSong(s1);
		myPlaylist.addSong(s2);
		myPlaylist.addSong(s3);
		assertFalse(myPlaylist.songInPlaylist("Chasing Pavements", "Adele"));
	}
	
	@Test
	void testSetName() {
		Playlist myPlaylist = new Playlist("Adele Favs");
		myPlaylist.setName("I love Adele");
		String result = myPlaylist.getName();
		String expected = "I love Adele";
		assertEquals(expected, result);
	}
	
	@Test
	void testToStringPlays() {
		MusicStore myStore = new MusicStore();
		UserLibrary myLibrary = new UserLibrary(myStore);
		myLibrary.createPlaylist("Adele Favs");
		Album adele21 = new Album("21", "Adele", "Pop", "2011");
		Song s1 = new Song("Rolling in the Deep", "Adele", adele21);
		Song s2 = new Song("Set Fire to the Rain", "Adele", adele21);
		Song s3 = new Song("Take It All", "Adele", adele21);
		myLibrary.addSongToPlaylist("Rolling in the Deep", "Adele", "Adele Favs");
		myLibrary.addSongToPlaylist("Set Fire to the Rain", "Adele", "Adele Favs");
		myLibrary.addSongToPlaylist("Take It All", "Adele", "Adele Favs");
		myLibrary.play("Rolling in the Deep", "Adele");
		myLibrary.play("Rolling in the Deep", "Adele");
		myLibrary.play("Rolling in the Deep", "Adele");
		myLibrary.play("Rolling in the Deep", "Adele");
		myLibrary.play("Set Fire to the Rain", "Adele");
		myLibrary.play("Take It All", "Adele");
		String result = myLibrary.getPlaylistObj("Adele Favs").toString(myLibrary.getPlays());
		String expected = "Adele Favs:\n\tRolling in the Deep - by: Adele (21) - 4 plays\n"
		+ "\tSet Fire to the Rain - by: Adele (21) - 1 play\n"
		+ "\tTake It All - by: Adele (21) - 1 play\n";
		assertEquals(expected, result);
	}
	
	@Test
	void testEqualsTrue() {
		Album adele21 = new Album("21", "Adele", "Pop", "2011");
		Song s1 = new Song("Rolling in the Deep", "Adele", adele21);
		Song s2 = new Song("Set Fire to the Rain", "Adele", adele21);
		Song s3 = new Song("Take It All", "Adele", adele21);
		Playlist myPlaylist = new Playlist("Adele Favs");
		myPlaylist.addSong(s1);
		myPlaylist.addSong(s2);
		myPlaylist.addSong(s3);
		Playlist otherPlaylist = new Playlist(myPlaylist);
		assertEquals(myPlaylist, otherPlaylist);
	}
	
	@Test
	void testEqualsSimilar() {
		Album adele21 = new Album("21", "Adele", "Pop", "2011");
		Song s1 = new Song("Rolling in the Deep", "Adele", adele21);
		Song s2 = new Song("Set Fire to the Rain", "Adele", adele21);
		Song s3 = new Song("Take It All", "Adele", adele21);
		Playlist myPlaylist = new Playlist("Adele Favs");
		myPlaylist.addSong(s1);
		myPlaylist.addSong(s2);
		myPlaylist.addSong(s3);
		Playlist otherPlaylist = new Playlist(myPlaylist);
		Song s4 = new Song("Lovesong", "Adele", adele21);
		otherPlaylist.addSong(s4);
		assertFalse(myPlaylist.equals(otherPlaylist));
	}
}
