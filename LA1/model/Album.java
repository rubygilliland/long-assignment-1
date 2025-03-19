/*
 * Description: This class models an album, storing a list of songs, a title, artist, year, and genre of music.
 */

package model;
import java.util.ArrayList;

public class Album {
	private ArrayList<Song> songs;
	private String title;
	private String artist;
	private int year;
	public enum Genre {POP, ALTERNATIVE, TRADITIONAL_COUNTRY,
						LATIN, ROCK, SINGER_SONGWRITER }
	private Genre genre;
	private String genreStr;

	// default constructor
	public Album(String title, String artist, String strGenre, String year) {
		songs = new ArrayList<>();
		this.title = title;
		this.artist = artist;
		this.genreStr = strGenre;
		this.genre = setGenre(strGenre);
		this.year = Integer.valueOf(year);
	}

	// copy constructor
		public Album(Album album) {
			songs = new ArrayList<>();
			for (Song s : album.songs) {
				songs.add(new Song(s));
			}
			this.title = album.title;
			this.artist = album.artist;
			this.genreStr = album.genreStr;
			this.genre = album.genre;
			this.year = album.year;
		}

	private void setGenre(Genre genre) {
		/*
		 * This method helps the copy constructor set the new album's Genre
		 * to match the original album's Genre.
		 */
		this.genre = genre;
	}

	private Genre setGenre(String strGenre) {
		/*
		 * This method helps the default constructor set the album's Genre.
		 */
		switch (strGenre.toLowerCase()){
		case "pop":
			return Genre.POP;
		case "alternative":
			return Genre.ALTERNATIVE;
		case "traditional country":
			return Genre.TRADITIONAL_COUNTRY;
		case "latin":
			return Genre.LATIN;
		case "rock":
			return Genre.ROCK;
		default:
			return Genre.SINGER_SONGWRITER;
		}
	}

	public void addSong(Song song) {
		songs.add(song);
	}

	public ArrayList<Song> getSongs() {
		/*
		 * This method returns a deep copy of an ArrayList
		 * containing all songs in the album
		 */
		ArrayList<Song> songsCopy = new ArrayList<>();
		for (Song s : songs) {
			songsCopy.add(new Song(s));
		}
		return songsCopy;
	}

	public String getTitle() {
		return title;
	}

	public String getArtist() {
		return artist;
	}

	public Genre getGenre() {
		return genre;
	}

	public int getYear() {
		return year;
	}

	public String getGenreStr() {
		return genreStr;
	}

	@Override
	public boolean equals(Object otherAlbum) {
		/*
		 * This method helps with testing
		 */
		if (this.getClass() != otherAlbum.getClass()) {
			return false;
		}
		else {
			return (this.title.equals(((Album) otherAlbum).title) && this.genre == ((Album) otherAlbum).genre &&
				this.year == ((Album) otherAlbum).year && this.artist.equals(((Album) otherAlbum).artist));
		}
	}

	@Override
	public String toString() {
		return this.title + " - by: " + this.artist + " (" + this.genre + ") " + this.year + "\n";
	}
}
