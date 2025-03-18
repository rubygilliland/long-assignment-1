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
		USER_LIBRARY.addSong("Cup of Sorrow", "Amos Lee");
		String message = USER_LIBRARY.getSongByTitle("cup of sorrow");
		assertEquals(message, "Cup of Sorrow - by: Amos Lee (Mission Bell)\n");
	} 
	
	@Test
	void testGetSongsbyTitleFalse() {
		String message = USER_LIBRARY.getSongByTitle("Here I Am");
		assertEquals(message, "This song cannot be found.");
	}
	
	@Test
	void testGetSongByArtistTrue() {
		USER_LIBRARY.addSong("Cup of Sorrow", "Amos Lee");
		USER_LIBRARY.addSong("Hello Again", "Amos Lee");
		USER_LIBRARY.addSong("Jesus", "Amos Lee");
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
		expected += "\tHeavy for You - by: The Heavy (Sons)\n";
		expected += "\tThe Thief - by: The Heavy (Sons)\n";
		expected += "\tBetter as One - by: The Heavy (Sons)\n";
		expected += "\tFire - by: The Heavy (Sons)\n";
		expected += "\tFighting for the Same Thing - by: The Heavy (Sons)\n";
		expected += "\tHurt Interlude - by: The Heavy (Sons)\n";
		expected += "\tPut the Hurt on Me - by: The Heavy (Sons)\n";
		expected += "\tSimple Things - by: The Heavy (Sons)\n";
		expected += "\tA Whole Lot of Love - by: The Heavy (Sons)\n";
		expected += "\tWhat Don't Kill You - by: The Heavy (Sons)\n";
		expected += "\tBurn Bright - by: The Heavy (Sons)\n";
		assertEquals(expected, message);
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
		expected += "\tHeavy for You - by: The Heavy (Sons)\n";
		expected += "\tThe Thief - by: The Heavy (Sons)\n";
		expected += "\tBetter as One - by: The Heavy (Sons)\n";
		expected += "\tFire - by: The Heavy (Sons)\n";
		expected += "\tFighting for the Same Thing - by: The Heavy (Sons)\n";
		expected += "\tHurt Interlude - by: The Heavy (Sons)\n";
		expected += "\tPut the Hurt on Me - by: The Heavy (Sons)\n";
		expected += "\tSimple Things - by: The Heavy (Sons)\n";
		expected += "\tA Whole Lot of Love - by: The Heavy (Sons)\n";
		expected += "\tWhat Don't Kill You - by: The Heavy (Sons)\n";
		expected += "\tBurn Bright - by: The Heavy (Sons)\n";
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
		USER_LIBRARY.addSongToPlaylist("Begin Again","Norah Jones", "Pop Hits");
		USER_LIBRARY.addSongToPlaylist("Rolling in the Deep", "Adele","Pop Hits");
		USER_LIBRARY.addSongToPlaylist("Lovesong","Adele", "Pop Hits");
		USER_LIBRARY.addSongToPlaylist("Chasing Pavements","Adele", "Pop Hits");
		String message = USER_LIBRARY.getPlaylist("Pop Hits");
		String expected = "Pop Hits:\n";
		expected += "\tBegin Again - by: Norah Jones (Begin Again)\n";
		expected += "\tRolling in the Deep - by: Adele (21)\n";
		expected += "\tLovesong - by: Adele (21)\n";
		expected += "\tChasing Pavements - by: Adele (19)\n";
		assertEquals(message, expected);
	}
	
	@Test
	void testGetPlaylistFalse() {
		String message = USER_LIBRARY.getPlaylist("Rock Jams");
		assertEquals(message, "Playlist by this name cannot be found.");
	}
	
	@Test
	void testGetSongTitles() {
		USER_LIBRARY.addSong("Begin Again", "Norah Jones");
		USER_LIBRARY.addSong("Rolling in the Deep", "Adele");
		USER_LIBRARY.addSong("Lovesong", "Adele");
		USER_LIBRARY.addSong("Chasing Pavements", "Adele");
		String message = USER_LIBRARY.getSongTitles();
		String expected = "Songs in Your Library:\n";
		expected += "Begin Again\nRolling in the Deep\nLovesong\nChasing Pavements\n";
		assertEquals(message, expected);
	}
	
	@Test
	void testGetArtists() {
		USER_LIBRARY.addSong("Begin Again", "Norah Jones");
		USER_LIBRARY.addSong("Rolling in the Deep", "Adele");
		USER_LIBRARY.addSong("Cup of Sorrow", "Amos Lee");
		USER_LIBRARY.addSong("The Thief", "The Heavy");
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
		expected += "Favorites\nTop Rated\nPop Hits\nRock Jams\nSing-Alongs\n";
		assertEquals(message, expected);
		}
	
	@Test
	void testRateSongs() {
		USER_LIBRARY.addSong("Begin Again", "Norah Jones");
		USER_LIBRARY.addSong("Rolling in the Deep", "Adele");
		USER_LIBRARY.addSong("Cup of Sorrow", "Amos Lee");
		USER_LIBRARY.rateSong("Begin Again", "Norah Jones", 3);
		USER_LIBRARY.rateSong("Rolling in the Deep", "Adele", 5);
		USER_LIBRARY.rateSong("Cup of Sorrow", "Amos Lee", 5);
		String message = USER_LIBRARY.getFavoriteSongs();
		String favorites = "Your Favorited Songs:\n";
		favorites += "Rolling in the Deep - by: Adele (21)\n";
		favorites += "Cup of Sorrow - by: Amos Lee (Mission Bell)\n";
		assertEquals(favorites, message);
	}
	
	@Test
	void testToString() {
		USER_LIBRARY.addSong("Begin Again", "Norah Jones");
		USER_LIBRARY.addSong("Rolling in the Deep", "Adele");
		USER_LIBRARY.addSong("Cup of Sorrow", "Amos Lee");
		USER_LIBRARY.createPlaylist("Sing-Alongs");
		USER_LIBRARY.addSongToPlaylist("Begin Again","Norah Jones", "Sing-Alongs");
		USER_LIBRARY.addAlbum("Waking Up");
		String message = USER_LIBRARY.toString();
		String expected = "My Library:\n";
		expected += "\tAlbums:\n";
		expected += "\t\t1. Begin Again - by: Norah Jones (POP) 2018\n";
		expected += "\t\t2. 21 - by: Adele (POP) 2011\n";
		expected += "\t\t3. Mission Bell - by: Amos Lee (SINGER_SONGWRITER) 2010\n";
		expected += "\t\t4. Waking Up - by: OneRepublic (ROCK) 2009\n";
		expected += "\tSongs:\n";
		expected += "\t\t1. Begin Again - by: Norah Jones (Begin Again)\n";
		expected += "\t\t2. Rolling in the Deep - by: Adele (21)\n";
		expected += "\t\t3. Cup of Sorrow - by: Amos Lee (Mission Bell)\n";
		expected += "\t\t4. Made for You - by: OneRepublic (Waking Up)\n";
		expected += "\t\t5. All the Right Moves - by: OneRepublic (Waking Up)\n";
		expected += "\t\t6. Secrets - by: OneRepublic (Waking Up)\n";
		expected += "\t\t7. Everybody Loves Me - by: OneRepublic (Waking Up)\n";
		expected += "\t\t8. Missing Persons 1 & 2 - by: OneRepublic (Waking Up)\n";
		expected += "\t\t9. Good Life - by: OneRepublic (Waking Up)\n";
		expected += "\t\t10. All This Time - by: OneRepublic (Waking Up)\n";
		expected += "\t\t11. Fear - by: OneRepublic (Waking Up)\n";
		expected += "\t\t12. Waking Up - by: OneRepublic (Waking Up)\n";
		expected += "\t\t13. Marchin On - by: OneRepublic (Waking Up)\n";
		expected += "\t\t14. Lullaby - by: OneRepublic (Waking Up)\n";
		expected += "\tPlaylists:\n";
		expected += "\t\t1. Favorites:\n\n";
		expected += "\t\t2. Top Rated:\n\n";
		expected += "\t\t3. Sing-Alongs:\n";
		expected += "\t\t\t\tBegin Again - by: Norah Jones (Begin Again)\n\n";
		expected += "\t\t4. Rock:\n";
		expected += "\t\t\t\tMade for You - by: OneRepublic (Waking Up)\n"
				+ "\t\t\t\tAll the Right Moves - by: OneRepublic (Waking Up)\n"
				+ "\t\t\t\tSecrets - by: OneRepublic (Waking Up)\n"
				+ "\t\t\t\tEverybody Loves Me - by: OneRepublic (Waking Up)\n"
				+ "\t\t\t\tMissing Persons 1 & 2 - by: OneRepublic (Waking Up)\n"
				+ "\t\t\t\tGood Life - by: OneRepublic (Waking Up)\n"
				+ "\t\t\t\tAll This Time - by: OneRepublic (Waking Up)\n"
				+ "\t\t\t\tFear - by: OneRepublic (Waking Up)\n"
				+ "\t\t\t\tWaking Up - by: OneRepublic (Waking Up)\n"
				+ "\t\t\t\tMarchin On - by: OneRepublic (Waking Up)\n"
				+ "\t\t\t\tLullaby - by: OneRepublic (Waking Up)\n\n";
		
		assertEquals(expected, message);
	}
	
	@Test
	void testSongInPlaylist() {
		USER_LIBRARY.createPlaylist("Pop Hits");
		USER_LIBRARY.addSongToPlaylist("Rolling in the Deep", "Adele", "Pop Hits");
		assertTrue(USER_LIBRARY.songInPlaylist("Pop Hits","Rolling in the Deep", "Adele"));
	}
	
	@Test 
	void testGetSortedTitles() {
		USER_LIBRARY.addSong("Rolling in the Deep", "Adele");
		USER_LIBRARY.addSong("Begin Again", "Norah Jones");
		String expected = "Begin Again - by: Norah Jones (Begin Again)\nRolling in the Deep - by: Adele (21)\n";
		String actual = USER_LIBRARY.getSortedTitles();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetSortedRating() {
		USER_LIBRARY.addSong("Rolling in the Deep", "Adele");
		USER_LIBRARY.addSong("Begin Again", "Norah Jones");
		USER_LIBRARY.addSong("Cup of Sorrow", "Amos Lee");
		USER_LIBRARY.rateSong("Rolling in the Deep", "Adele", 5);
		USER_LIBRARY.rateSong("Begin Again", "Norah Jones", 3);
		USER_LIBRARY.rateSong("Cup of Sorrow", "Amos Lee", 1);
		String expected = "Cup of Sorrow - by: Amos Lee (Mission Bell)\n";
		expected += "Begin Again - by: Norah Jones (Begin Again)\nRolling in the Deep - by: Adele (21)\n";
		String actual = USER_LIBRARY.getSortedRating();
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetSongsByGenre() {
		USER_LIBRARY.addSong("Begin Again", "Norah Jones");
		USER_LIBRARY.addSong("Rolling in the Deep", "Adele");
		USER_LIBRARY.addSong("Lovesong", "Adele");
		USER_LIBRARY.addSong("Chasing Pavements", "Adele");
		String expected = "Begin Again - by: Norah Jones (Begin Again)\nRolling in the Deep - by: Adele (21)\n";
		expected += "Lovesong - by: Adele (21)\nChasing Pavements - by: Adele (19)\n";
		String actual = USER_LIBRARY.getSongsByGenre("pop");
		assertEquals(expected, actual);;
	}
	
	@Test
	void testGetSortedArtist() {
		USER_LIBRARY.addSong("Begin Again", "Norah Jones");
		USER_LIBRARY.addSong("Rolling in the Deep", "Adele");
		USER_LIBRARY.addSong("Cup of Sorrow", "Amos Lee");
		String expected = "Rolling in the Deep - by: Adele (21)\nCup of Sorrow - by: Amos Lee (Mission Bell)\n";
		expected += "Begin Again - by: Norah Jones (Begin Again)\n";
		String actual = USER_LIBRARY.getSortedArtist();
		assertEquals(expected, actual);
	}
	
	@Test
	void testRemoveSongFromLibrary() {
		USER_LIBRARY.createPlaylist("Sing-Alongs");
		USER_LIBRARY.addSongToPlaylist("Begin Again", "Norah Jones", "Sing-Alongs");
		USER_LIBRARY.addSongToPlaylist("Rolling in the Deep", "Adele", "Sing-Alongs");
		USER_LIBRARY.addSongToPlaylist("Cup of Sorrow", "Amos Lee", "Sing-Alongs");
		USER_LIBRARY.removeSongFromLibrary("Cup of Sorrow", "Amos Lee");
		String actual = USER_LIBRARY.toString();
		String expected = "My Library:\n";
		expected += "\tAlbums:\n";
		expected += "\t\t1. Begin Again - by: Norah Jones (POP) 2018\n";
		expected += "\t\t2. 21 - by: Adele (POP) 2011\n";
		expected += "\tSongs:\n";
		expected += "\t\t1. Begin Again - by: Norah Jones (Begin Again)\n";
		expected += "\t\t2. Rolling in the Deep - by: Adele (21)\n";
		expected += "\tPlaylists:\n";
		expected += "\t\t1. Favorites:\n\n";
		expected += "\t\t2. Top Rated:\n\n";
		expected += "\t\t3. Sing-Alongs:\n";
		expected += "\t\t\t\tBegin Again - by: Norah Jones (Begin Again)\n";
		expected += "\t\t\t\tRolling in the Deep - by: Adele (21)\n\n";
		assertEquals(expected, actual);
	}
	
	@Test
	void testRemoveAlbumFromLibrary() {
		USER_LIBRARY.addAlbum("21");
		USER_LIBRARY.addAlbum("Waking Up");
		USER_LIBRARY.removeAlbumFromLibrary("21", "Adele");
		String actual = USER_LIBRARY.toString();
		String expected = "My Library:\n";
		expected += "\tAlbums:\n";
		expected += "\t\t1. Waking Up - by: OneRepublic (ROCK) 2009\n";
		expected += "\tSongs:\n";
		expected += "\t\t1. Made for You - by: OneRepublic (Waking Up)\n";
		expected += "\t\t2. All the Right Moves - by: OneRepublic (Waking Up)\n";
		expected += "\t\t3. Secrets - by: OneRepublic (Waking Up)\n";
		expected += "\t\t4. Everybody Loves Me - by: OneRepublic (Waking Up)\n";
		expected += "\t\t5. Missing Persons 1 & 2 - by: OneRepublic (Waking Up)\n";
		expected += "\t\t6. Good Life - by: OneRepublic (Waking Up)\n"; 
		expected += "\t\t7. All This Time - by: OneRepublic (Waking Up)\n";
		expected += "\t\t8. Fear - by: OneRepublic (Waking Up)\n";
		expected += "\t\t9. Waking Up - by: OneRepublic (Waking Up)\n";
		expected += "\t\t10. Marchin On - by: OneRepublic (Waking Up)\n";
		expected += "\t\t11. Lullaby - by: OneRepublic (Waking Up)\n";
		expected += "\tPlaylists:\n";
		expected += "\t\t1. Favorites:\n\n";
		expected += "\t\t2. Top Rated:\n\n";
		expected += "\t\t3. Rock:\n";
		expected += "\t\t\t\tMade for You - by: OneRepublic (Waking Up)\n"
				+ "\t\t\t\tAll the Right Moves - by: OneRepublic (Waking Up)\n"
				+ "\t\t\t\tSecrets - by: OneRepublic (Waking Up)\n"
				+ "\t\t\t\tEverybody Loves Me - by: OneRepublic (Waking Up)\n"
				+ "\t\t\t\tMissing Persons 1 & 2 - by: OneRepublic (Waking Up)\n"
				+ "\t\t\t\tGood Life - by: OneRepublic (Waking Up)\n"
				+ "\t\t\t\tAll This Time - by: OneRepublic (Waking Up)\n"
				+ "\t\t\t\tFear - by: OneRepublic (Waking Up)\n"
				+ "\t\t\t\tWaking Up - by: OneRepublic (Waking Up)\n"
				+ "\t\t\t\tMarchin On - by: OneRepublic (Waking Up)\n"
				+ "\t\t\t\tLullaby - by: OneRepublic (Waking Up)\n\n";
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testFavoritesPlaylist() {
		USER_LIBRARY.addAlbum("Coat of Many Colors");
		USER_LIBRARY.rateSong("Traveling Man", "Dolly Parton", 5);
		USER_LIBRARY.rateSong("Here I Am", "Dolly Parton", 5);
		USER_LIBRARY.rateSong("My Blue Tears", "Dolly Parton", 5);
		String actual = USER_LIBRARY.getPlaylist("Favorites");
		String expected = "Favorites:\n\tTraveling Man - by: Dolly Parton (Coat of Many Colors)\n";
		expected += "\tHere I Am - by: Dolly Parton (Coat of Many Colors)\n\tMy Blue Tears - by: Dolly Parton (Coat of Many Colors)\n";
		assertEquals(expected, actual);
	}
	
	@Test
	void testRemoveSongFromPlaylist() {
		USER_LIBRARY.createPlaylist("Driving Around");
		USER_LIBRARY.addSongToPlaylist("Here I Am", "Dolly Parton", "Driving Around");
		USER_LIBRARY.addSongToPlaylist("Begin Again", "Norah Jones", "Driving Around");
		USER_LIBRARY.addSongToPlaylist("Rolling in the Deep", "Adele", "Driving Around");
		USER_LIBRARY.removeSongFromPlaylist("Here I Am", "Dolly Parton", "Driving Around");
		String actual = USER_LIBRARY.getPlaylist("Driving Around");
		String expected = "Driving Around:\n\tBegin Again - by: Norah Jones (Begin Again)\n\tRolling in the Deep - by: Adele (21)\n";
		assertEquals(expected, actual);
	}
}
