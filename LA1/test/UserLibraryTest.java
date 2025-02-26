package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.MusicStore;
import model.UserLibrary;

class UserLibraryTest {
private MusicStore MUSIC_STORE = new MusicStore();
private UserLibrary USER_LIBRARY = new UserLibrary(MUSIC_STORE);

	@Test
	void testGetSongsByTitleTrue() {
		USER_LIBRARY.addSong("Cup of Sorrow");
		String message = USER_LIBRARY.getSongByTitle("Cup of Sorrow");
		assertEquals(message, "Cup of Sorrow - by: Amos Lee (Mission Bell)\n");
	}
	
	@Test
	void testGetSongsbyTitleFalse() {
		String message = USER_LIBRARY.getSongByTitle("Here I Am");
		assertEquals(message, "This song cannot be found.");
	}
	
	@Test
	void testGetSongByArtistTrue() {
		USER_LIBRARY.addSong("Cup of Sorrow");
		USER_LIBRARY.addSong("Hello Again");
		USER_LIBRARY.addSong("Jesus");
		String message = USER_LIBRARY.getSongByArtist("Amos Lee");
		String expected = "Cup of Sorrow - by: Amos Lee (Mission Bell)\n";
		expected += "Hello Again - by: Amos Lee (Mission Bell)\n";
		expected += "Jesus - by: Amos Lee (Mission Bell)\n";
		assertEquals(message, expected);
	}
	
	@Test
	void testGetSongByArtistFalse() {
		String message = USER_LIBRARY.getSongByArtist("Adele");
		assertEquals(message, "Songs by this artist cannot be found.");		
	}
	
	@Test
	void testGetAlbumByTitleTrue() {
		USER_LIBRARY.addAlbum("Sons");
		String message = USER_LIBRARY.getAlbumByTitle("Sons");
		String expected = "Sons - by: The Heavy (ROCK) 2019\n";
		assertEquals(message, expected);
	}
	
	@Test
	void testGetAlbumByTitleFalse() {
		String message = USER_LIBRARY.getAlbumByTitle("19");
		assertEquals(message, "This album cannot be found.");
	}
	
	@Test
	void testGetAlbumByArtistTrue() {
		USER_LIBRARY.addAlbum("Sons");
		String message = USER_LIBRARY.getAlbumByArtist("The Heavy");
		String expected = "Sons - by: The Heavy (ROCK) 2019\n";
		assertEquals(message, expected);
	}
	
	@Test
	void testGetAlbumByArtistFalse() {
		String message = USER_LIBRARY.getAlbumByArtist("Adele");
		assertEquals(message, "Albums by this artist cannot be found.");
	}
	
	@Test
	void testGetPlayListTrue() {
		USER_LIBRARY.createPlaylist("Pop Hits");
		USER_LIBRARY.addSongToPlaylist("Begin Again", "Pop Hits");
		USER_LIBRARY.addSongToPlaylist("Rolling in the Deep", "Pop Hits");
		USER_LIBRARY.addSongToPlaylist("Lovesong", "Pop Hits");
		USER_LIBRARY.addSongToPlaylist("Chasing Pavements", "Pop Hits");
		String message = USER_LIBRARY.getPlaylist("Pop Hits");
		String expected = "Pop Hits:\n";
		expected += "Begin Again - by: Norah Jones (Begin Again)\n";
		expected += "Rolling in the Deep - by: Adele (21)\n";
		expected += "Lovesong - by: Adele (21)\n";
		expected += "Chasing Pavements - by: Adele (19)\n";
		assertEquals(message, expected);
	}
	
	@Test
	void testGetPlaylistFalse() {
		String message = USER_LIBRARY.getPlaylist("Rock Jams");
		assertEquals(message, "Playlist by this name cannot be found.");
	}
	
	@Test
	void testGetSongTitles() {
		USER_LIBRARY.addSong("Begin Again");
		USER_LIBRARY.addSong("Rolling in the Deep");
		USER_LIBRARY.addSong("Lovesong");
		USER_LIBRARY.addSong("Chasing Pavements");
		String message = USER_LIBRARY.getSongTitles();
		String expected = "Songs in Your Library:\n";
		expected += "Begin Again\nRolling in the Deep\nLovesong\nChasing Pavements\n";
		assertEquals(message, expected);
	}
	
	@Test
	void testGetArtists() {
		USER_LIBRARY.addSong("Begin Again");
		USER_LIBRARY.addSong("Rolling in the Deep");
		USER_LIBRARY.addSong("Cup of Sorrow");
		USER_LIBRARY.addSong("The Thief");
		String message = USER_LIBRARY.getArtists();
		String expected = "Artists in Your Library:\n";
		expected += "Adele\nAmos Lee\nNorah Jones\nThe Heavy\n";
		assertEquals(message, expected);
	}
	
	@Test
	void testGetAlbumTitles() {
		USER_LIBRARY.addAlbum("Sons");
		USER_LIBRARY.addAlbum("19");
		USER_LIBRARY.addAlbum("Waking Up");
		String message = USER_LIBRARY.getAlbumTitles();
		String expected = "Albums in Your Library:\n";
		expected += "Sons - by: The Heavy\n19 - by: Adele\nWaking Up - by: OneRepublic\n";
		assertEquals(message, expected);
	}
	
	@Test
	void testGetPlaylists() {
		USER_LIBRARY.createPlaylist("Pop Hits");
		USER_LIBRARY.createPlaylist("Rock Jams");
		USER_LIBRARY.createPlaylist("Sing-Alongs");
		String message = USER_LIBRARY.getPlaylists();
		String expected = "Playlists in Your Library:\n";
		expected += "Pop Hits\nRock Jams\nSing-Alongs\n";
		assertEquals(message, expected);
		}
	
}
