/*
 * Description: This class represents the music store in the app, which holds all the songs
 * and albums available to the user. The user can search for songs and albums by title and artist
 * in order to find songs and albums to add to their user library.
 */

package model;

import java.util.ArrayList;

public class MusicStore {
	private ArrayList<Song> songs;
	private ArrayList<Album> albums;

	public MusicStore() {
		albums = Parser.makeAlbumList("LA1/albums.txt");
		songs = new ArrayList<>();
		for (Album a : albums) {
			for (Song s : a.getSongs()) {
				songs.add(s);
			}
		}
	}
	
	public String getSongByGenre(String genre) {
		/*
		 * This method searches the music store for song(s) by title and returns
		 * a string representing the song(s) if the song(s) exist in the music store.
		 */
		genre = genre.toLowerCase();
		String songStr = "";
		for (Song s : songs) {
			if (s.getGenre().toLowerCase().equals(genre)) {
				songStr += s.toString();
			}
		}
		if (songStr.equals("")) {
			songStr = "Songs for this genre can not be found.";
		}
		return songStr;
	}
	
	
	
	public String getSongByTitle(String songTitle) {
		/*
		 * This method searches the music store for song(s) by title and returns
		 * a string representing the song(s) if the song(s) exist in the music store.
		 */
		songTitle = songTitle.toLowerCase();
		String songStr = "";
		for (Song s : songs) {
			if (s.getTitle().toLowerCase().equals(songTitle)) {
				songStr += s.toString();
			}
		}
		if (songStr.equals("")) {
			songStr = "This song cannot be found.";
		}
		return songStr;
	}

	public String getSongByArtist(String artist) {
		/*
		 * This method searches the music store for song(s) by artist and returns
		 * a string representing the song(s) if the song(s) exist in the music store.
		 */
		artist = artist.toLowerCase();
		String songStr = "";
		for (Song s : songs) {
			if (s.getArtist().toLowerCase().equals(artist)) {
				songStr += s.toString();
			}
		}
		if (songStr.equals("")) {
			songStr = "Songs by this artist cannot be found.";
		}
		return songStr;
	}
	
	public String getAlbumInfo(String songTitle, String artist, UserLibrary userLibrary) {
		/*
		 * This method retrieves the album information for a song given by the title and artist.
		 * It then determines whether the album is in the given users library.
		 */
		String albumStr = "";
		for (Song s : songs) {
			
			// searches for song to find album info
			if (s.getTitle().toLowerCase().equals(songTitle.toLowerCase())
					&& s.getArtist().toLowerCase().equals(artist.toLowerCase())) {
				albumStr += s.getAlbumObj().toString().strip();
				
				// searches for album in user library
				for (Album a : userLibrary.getAlbumList()) {
					if (s.getAlbumObj().getTitle().equals(a.getTitle())) {
						albumStr += " - is in your library!";
						return albumStr;
					}
				}
			}
		}
		albumStr += " is not in your library.";
		return albumStr;
	}

	public String getAlbumByTitle(String albumTitle) {
		/*
		 * This method searches the music store for an album by title and returns
		 * a string representing the album along with the strings that represent
		 * each song on the album (all concatenated to one string).
		 */
		albumTitle = albumTitle.toLowerCase();
		String albumStr = "";
		for (Album a : albums) {
			if (a.getTitle().toLowerCase().equals(albumTitle)) {
				albumStr += a.toString();
				for (Song s : a.getSongs()) {
					albumStr += "\t" + s.toString();
				}
			}
		}
		if (albumStr.equals("")) {
			albumStr = "This album cannot be found.";
		}
		return albumStr;
	}

	public String getAlbumByArtist(String artist) {
		/*
		 * This method searches the music store for album(s) by artist and returns
		 * a string representing of each album along with the strings that represent
		 * each song on the album (all concatenated to one string).
		 */
		artist = artist.toLowerCase();
		String albumStr = "";
		for (Album a : albums) {
			if (a.getArtist().toLowerCase().equals(artist)) {
				albumStr += a.toString();
				for (Song s : a.getSongs()) {
					albumStr += "\t" + s.toString();
				}
			}
		}
		if (albumStr.equals("")) {
			albumStr = "Albums by this artist cannot be found.";
		}
		return albumStr;
	}
	
	// searches for songs in music by genre
			public String getAlbumByGenre(String genre) {
				String albumStr = "";
				for (Album a : albums) {

					// checks if given genre matches genre of Song in songs, ignoring capitalization
					if (a.getGenreStr().toLowerCase().equals(genre.toLowerCase())) {

						// adds String of every Song of given genre to songStr
						albumStr += a.toString();
					}
				}

				if (albumStr.equals("")) {
					albumStr = "Albums of this genre cannot be found.";
				}
				return albumStr;
			}

	public ArrayList<Song> getSongs(){
		/*
		 * This method returns a deep copy of an ArrayList of
		 * all songs in the music library
		 */
		ArrayList<Song> copySongs = new ArrayList<>();
		for (Song s : songs) {
			copySongs.add(new Song(s));
		}

		return copySongs;
	}

	public ArrayList<Album> getAlbums(){
		/*
		 * This method returns a deep copy of an ArrayList of
		 * all albums in the music library
		 */
		ArrayList<Album> copyAlbums = new ArrayList<>();
		for (Album a : albums) {
			copyAlbums.add(new Album(a));
		}
		return copyAlbums;
	}

	@Override
	public String toString() {
		String message = "Music Store:\n";
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

		return message;

	}

	}

