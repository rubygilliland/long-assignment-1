package model;
/*
 * This class defines methods and instance variables for a UserLibrary object.
 * UserLibrary objects have ArrayLists of Song objects, Album objects, and Playlist
 * objects to contain the music stored in a users music library. It also has an 
 * assigned MusicStore object that holds all possible music for the user to add
 * to their library.
 * 
 * A UserLibrary object can be searched for songs by title or artist. It can also 
 * be searched for albums by title or artist. User playlists can be created and edited. 
 * Songs and albums can be added to the UserLibrary as long as they are in the music store.
 * Songs can also be rated.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class UserLibrary {
	private ArrayList<Song> songs;
	private ArrayList<Album> albums;
	private ArrayList<Playlist> playlists;
	private MusicStore musicStore;
	
	public UserLibrary(MusicStore musicStore) {
		songs = new ArrayList<Song>();
		albums = new ArrayList<Album>();
		playlists = new ArrayList<Playlist>();
		this.musicStore = musicStore;
	}
	
	// returns a list of songs in the users library sorted by title
	public String getSortedTitles() {
		
		// HashSet ensures every song title is only counted once
		HashSet<String> songTitles = new HashSet<String>();
		for (Song s : songs) {
			songTitles.add(s.getTitle());
		}
		
		ArrayList<String> titles = new ArrayList<String>(songTitles);
		Collections.sort(titles);
		String songsByTitle = "";
		for (String songTitle : titles) {
			
			// calls method that returns string of all songs of given title
			songsByTitle += getSongByTitle(songTitle);
		}
		
		if (titles.size() == 0) return "There are no songs in this library.";
		else return songsByTitle;
	}
	
	// returns a list of songs in the users library sorted by artist
	public String getSortedArtist() {
		
		// HashSet ensures every artist is only counted once
		HashSet<String> artists = new HashSet<String>();
		for (Song s : songs) {
			artists.add(s.getArtist());
		}
		
		ArrayList<String> libraryArtists = new ArrayList<String>(artists);
		Collections.sort(libraryArtists);
		String songsByArtist = "";
		for (String artist : libraryArtists) {
			
			// calls method that returns string of all songs by given artist
			songsByArtist += getSongByArtist(artist);
		}
		
		if (libraryArtists.size() == 0) return "There are no songs in this library.";
		else return songsByArtist;
	}
	
	// returns a string list of all the songs sorted by rating
	public String getSortedRating() {
		String nonRated = "";
		String one = "";
		String two = "";
		String three = "";
		String four = "";
		String favorite = "";
		
		// adds the string of a song to a specific string based on its rating
		for (Song s : songs) {
			if (s.getRating() == Song.Rating.ONE) one += s.toString();
			else if (s.getRating() == Song.Rating.TWO) two += s.toString();
			else if (s.getRating() == Song.Rating.THREE) three += s.toString();
			else if (s.getRating() == Song.Rating.FOUR) four += s.toString();
			else if (s.getRating() == Song.Rating.FAVORITE) favorite += s.toString();
			else nonRated += s.toString();
		}
		
		return nonRated + one + two + three + four + favorite;
	}
	
	// removes a song from the users library given a song title and artist
	public void removeSongFromLibrary(String songName, String artist) {
		Song toRemove = new Song("", "");
		for (Song s : songs) {
			
			// finds the Song object in songs that matches the given title and artist
			if (s.getTitle().toLowerCase().equals(songName.toLowerCase()) 
					&& s.getArtist().toLowerCase().equals(artist.toLowerCase())) toRemove = s;
		}
		// only removes an item from the songs list if a valid Song object is found
		if (toRemove.getTitle() != "" && toRemove.getArtist() != "") {
		songs.remove(toRemove);
		removeSongsFromPlaylists(songName, artist);
		}
	}
	
	// removes an album from a users library given an album title and artist
	public void removeAlbumFromLibrary(String albumName, String artist) {
		Album toRemove = new Album("", "", "", "");
		for (Album a : albums) {
			
			// finds the Album object in songs that matches the given title and artist
			if (a.getTitle().toLowerCase().equals(albumName.toLowerCase()) 
					&& a.getArtist().toLowerCase().equals(artist.toLowerCase())) toRemove = a;
		}
		
		// only removes an item from the albums list if a valid Song object is found
		if (toRemove.getTitle() != "" && toRemove.getArtist() != "") {
			albums.remove(toRemove);
			
			// removes all the songs from an album
			for (Song s : toRemove.getSongs()) {
				removeSongFromLibrary(s.getTitle(), s.getArtist());
				removeSongsFromPlaylists(s.getTitle(), s.getArtist());
			}
		}
	}
	
	// helper method to remove songs from all playlists when they are removed from library
	private void removeSongsFromPlaylists(String songName, String artist) {
		for (Playlist p : playlists) {
			p.removeSong(songName, artist);
		}
	}
	// searches for songs in the user library by title
	public String getSongByTitle(String songTitle) {
		String songStr = "";
		for (Song s : songs) {
			
			// checks if given title matches a title of Song in songs, ignoring capitalization
			if (s.getTitle().toLowerCase().equals(songTitle.toLowerCase())) {
				
				// adds String of every Song with given title to songStr
				songStr += s.toString();
			}
		}
		
		// if no songs of given title are found, return message
		if (songStr.equals("")) songStr = "This song cannot be found.";
		return songStr;
	}
	
	// searches for songs in user library by artist
	public String getSongByArtist(String artist) {
		String songStr = "";
		for (Song s : songs) {
			
			// checks if given artist matches artist of Song in songs, ignoring capitalization
			if (s.getArtist().toLowerCase().equals(artist.toLowerCase())) {
				
				// adds String of every Song with given artist to songStr
				songStr += s.toString();
			}
		}
		
		// if no songs of given artist are found, return message
		if (songStr.equals("")) songStr = "Songs by this artist cannot be found.";
		return songStr;
	}
	
	// searches for songs in user library by genre
	public String getSongsByGenre(String genre) {
		String songStr = "";
		for (Song s : songs) {
			
			// checks if given genre matches genre of Song in songs, ignoring capitalization
			if (s.getGenre().toLowerCase().equals(genre.toLowerCase())) {
				
				// adds String of every Song of given genre to songStr
				songStr += s.toString();
			}
		}
		
		if (songStr.equals("")) songStr = "Songs of this genre cannot be found.";
		return songStr;
	}
	
	
	// searches for albums in user library by title
	public String getAlbumByTitle(String albumTitle) {
		String albumStr = "";
		for (Album a : albums) {
			
			// checks if given title matches title of Album in albums, ignoring capitalization
			if (a.getTitle().toLowerCase().equals(albumTitle.toLowerCase())) {
				
				// adds String of every Album with given title to albumStr
				albumStr += a.toString();
				for (Song s : a.getSongs()) {
					
					// adds String of every song in the Album to albumStr, tabbed in for readability
					albumStr += "\t" + s.toString();
				}
			}
		}
		
		// if no albums of given title are found, return message
		if (albumStr.equals("")) albumStr = "This album cannot be found.";
		return albumStr;
	}
	
	// searches for albums in user library by artist
	public String getAlbumByArtist(String artist) {
		String albumStr = "";
		for (Album a : albums) { 
			
			// checks if given artist matches artist of Album in albums, ignoring capitalization
			if (a.getArtist().toLowerCase().equals(artist.toLowerCase())) {
				
				// adds String of every Album with given title to albumStr
				albumStr += a.toString();
				for (Song s : a.getSongs()) {
					
					// adds String of every song in the Album to albumStr, tabbed in for readability
					albumStr += "\t" + s.toString();
				}
			}
		}
		
		// if no albums of given artist are found, return message
		if (albumStr.equals("")) albumStr = "Albums by this artist cannot be found.";
		return albumStr;
	}
	
	
	// searches for a playlist in user library by playlist name
	public String getPlaylist(String name) {
		String playlistStr = "";
		for (Playlist p : playlists) {
			
			// checks if given name matches name of Playlist in playlists, ignoring capitalization
			if (p.getName().toLowerCase().equals(name.toLowerCase())) {
				
					// adds playlist with matching name to playlistStr
					playlistStr += p.toString();
				}
			}
		
		// if no playlists of given name are found, return message 
		if (playlistStr.equals("")) playlistStr = "Playlist by this name cannot be found.";
		return playlistStr;
		}
	
	// determines whether a Song is in given playlist, with given Song title and artist
	public boolean songInPlaylist(String playlistName, String songTitle, String songArtist) {
		for (Playlist p : playlists) {
			
			// checks if name matches name of Playlist in playlists, ignoring capitalization
			if (p.getName().toLowerCase().equals(playlistName.toLowerCase())) {
				for (Song s : p.getSongsList()) {
					
					// checks if title and artist match title and artist of Song in playlist
					if (s.getTitle().toLowerCase().equals(songTitle.toLowerCase()) 
							&& s.getArtist().toLowerCase().equals(songArtist.toLowerCase())) {
						
						// only returns true if given Song is found in given Playlist
						return true;
					}
				}
				return false;
			}
		}
		return false;
	}
	
	// adds a song to user library based on title and artist
	public void addSong(String songName, String artist) {
		
		// only searches for Songs in music store
		for (Song s : musicStore.getSongs()) {
			
			// adds a Song with given artist and given title to songs, if it is not already in songs list
			if (s.getTitle().toLowerCase().equals(songName.toLowerCase()) && songs.contains(s) == false && 
					s.getArtist().toLowerCase().equals(artist.toLowerCase())){ 
				songs.add(s);
				addPartAlbum(s.getAlbum());
			}
		}
	}
	
	// adds an album to user library based on title 
	public void addAlbum(String albumName) {
		
		// only searches for Albums in music store 
		for (Album a : musicStore.getAlbums()) {
			
			// adds an Album with given title to albums, if it is not already in albums
			if (a.getTitle().equals(albumName) && albums.contains(a) == false) {
				albums.add(a);
				
				// adds all Songs in Album to songs, if they are not already in songs
				for (Song s : a.getSongs()) {
					if (songs.contains(s) == false) songs.add(s);
					}
				}
			}
		}
	
	// helper method to add album to user library without adding all songs
	private void addPartAlbum(String albumName) {
		// only searches for Albums in music store 
				for (Album a : musicStore.getAlbums()) {
					
					// adds an Album with given title to albums, if it is not already in albums
					if (a.getTitle().equals(albumName) && albums.contains(a) == false) {
						albums.add(a);
					}
				}
	}
	
	// creates a Playlist object and adds it to playlists list
	public void createPlaylist(String name) {
		Playlist myPlaylist = new Playlist(name);
		playlists.add(myPlaylist);
	}

	// adds a song to a playlist given Song title and artist
	public void addSongToPlaylist(String songName, String artist, String playlistName) {
		
		// if the given Song is not already in the users library, add it to songs
		if (getSongByTitle(songName).equals("This song cannot be found.")) {
			addSong(songName, artist);
		}
		for (Song s : songs) {
			
			// search for Song with given title and artist, ignoring capitalization
			if (s.getTitle().toLowerCase().equals(songName.toLowerCase()) 
					&& s.getArtist().toLowerCase().equals(artist.toLowerCase())) {
				for (Playlist p : playlists) {
					
					// adds given Song to Playlist of given name, calling addSong method on that Playlist object
					if (p.getName().toLowerCase().equals(playlistName.toLowerCase())) {
						p.addSong(s);
					}
				}
			}
		}
	}
	
	// removes a Song from a playlist, given Song title and artist
	public void removeSongFromPlaylist(String songName, String artist, String playlistName) {
		
		// searches for playlist of given name and calls removeSong method on that Playlist object
		for (Playlist p : playlists) {
			if (p.getName().equals(playlistName)) {
				p.removeSong(songName, artist);
			}
		}
	}
	
	// returns a String of the titles of the Songs in the songs list
	public String getSongTitles() {
		String songsStr = "Songs in Your Library:\n";
		for (Song s : songs) {
			songsStr += s.getTitle() + "\n";
		}
		return songsStr;
	}
	
	// returns an alphabetized list of artists in the user library
	public String getArtists() {
		
		// HashSet structure disallows repeats in artist names
		HashSet<String> artists = new HashSet<String>();
		for (Song s : songs) {
			artists.add(s.getArtist());
		}
		
		// create an ArrayList of the HashSet to sort it alphabetically
		ArrayList<String> artistsList = new ArrayList<String>(artists);
		Collections.sort(artistsList);
		String artistsStr = "Artists in Your Library:\n";
		
		// add the names of all the artists to artistsStr
		for (String a : artistsList) {
			artistsStr += a + "\n";
		}
		return artistsStr;
	}
	
	// returns a String of all the Album titles in the user library
	public String getAlbumTitles() {
		String albumsStr = "Albums in Your Library:\n";
		for (Album a : albums) {
			albumsStr += a.getTitle() + " - by: "+ a.getArtist() + "\n";
		}
		return albumsStr;
	}
	
	// returns a String of all the playlists in the user library
	public String getPlaylists() {
		String playlistsStr = "Playlists in Your Library:\n";
		for (Playlist p : playlists) {
			playlistsStr += p.getName() + "\n";
		}
		return playlistsStr;
	}
	
	// rates a song in the user library
	// @pre int rating must be a rating from 1-5
	public void rateSong(String songName, String artist, int rating) {
		for (Song s : songs) {
			
			// searches for Song with given title and artist, ignoring capitalization
			if (s.getTitle().toLowerCase().equals(songName.toLowerCase()) 
					&& s.getArtist().toLowerCase().equals(artist.toLowerCase())) {
				s.rate(rating);
			}
		}
	}
	
	// returns a String of all the favorited Songs in a users library
	public String getFavoriteSongs() {
		String favorites = "Your Favorited Songs:\n";
		for (Song s : songs) {
			if (s.getRating() != null) {
			if(s.getRating().equals(Song.Rating.FAVORITE)) favorites += s.toString();
		}
		}
		return favorites;
	}
	
	public String toStringFile() {
		String message = "My Library:\n";
		message += "\tAlbums:\n";
		for (int i = 0; i < albums.size(); i++){
			int j = i+1;
			message += "\t\t" + j + ". " + albums.get(i).toString();
		}
		message += "\tSongs:\n";
		for (int i = 0; i < songs.size(); i++) {
			int j = i+1;
			message += "\t\t" + j + ". " + songs.get(i).toStringFile();
		}
		message += "\tPlaylists:\n";
	    for (int i = 0; i < playlists.size(); i++) {
	        message += "\t\t" + (i + 1) + ". "+ (playlists.get(i).getName()) + ":\n";
	        message += formatPlaylistSongs(playlists.get(i).getSongs()) + "\n";
	    }

	    return message;
	}
	
	@Override
	public String toString() {
		String message = "My Library:\n";
		message += "\tAlbums:\n";
		for (int i = 0; i < albums.size(); i++){
			int j = i+1;
			message += "\t\t" + j + ". " + albums.get(i).toString();
		}
		message += "\tSongs:\n";
		for (int i = 0; i < songs.size(); i++) {
			int j = i+1;
			message += "\t\t" + j + ". " + songs.get(i).toString();
		}
		message += "\tPlaylists:\n";
	    for (int i = 0; i < playlists.size(); i++) {
	        message += "\t\t" + (i + 1) + ". "+ (playlists.get(i).getName()) + ":\n";
	        message += formatPlaylistSongs(playlists.get(i).getSongs()) + "\n";
	    }

	    return message; 
	}

	// Helper method to properly indent playlist songs
	private String formatPlaylistSongs(String playlistSongs) {
	    return playlistSongs.replaceAll("(?m)^", "\t\t\t"); // Adds an extra tab for proper indentation
	}
	
	}
