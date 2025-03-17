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
						LATIN, ROCK, SINGER_SONGWRITER, HIP_HOP, FOLK, JAZZ, CLASSICAL, INDIE, BLUES }
	private Genre genre;
	private String genreStr;
	
	// default constructor
	public Album(String title, String artist, String strGenre, String year) {
		songs = new ArrayList<Song>();
		this.title = title;
		this.artist = artist;
		this.genreStr = strGenre;
		setGenre(strGenre);
		this.year = Integer.valueOf(year);
	}
	
	// copy constructor
		public Album(Album album) {
			songs = new ArrayList<Song>();
			for (Song s : album.songs) {
				songs.add(new Song(s));
			}
			this.title = album.title;
			this.artist = album.artist;
			setGenre(album.genre);
			this.year = album.year;		
		}
	
	private void setGenre(Genre genre) {
		/*
		 * This method helps the copy constructor set the new album's Genre
		 * to match the original album's Genre.
		 */
		this.genre = genre;
	}
	
	private void setGenre(String strGenre) {
		/*
		 * This method helps the default constructor set the album's Genre.
		 */
		strGenre = strGenre.toLowerCase();
		switch (strGenre){
		case "pop":
			genre = Genre.POP;
			break;
		case "alternative":
			genre = Genre.ALTERNATIVE;
			break;
		case "traditional country":
			genre = Genre.TRADITIONAL_COUNTRY;
			break;
		case "latin":
			genre = Genre.LATIN;
			break;
		case "rock":
			genre = Genre.ROCK;
			break;
			
		case "hip-hop":
			genre = Genre.HIP_HOP;
			break;
			
		case "folk":
			genre = Genre.FOLK;
			break;
			
		case "jazz":
			genre = Genre.JAZZ;
			break;
			
		case "classical":
			genre = Genre.CLASSICAL;
			break;
			
		case "indie":
			genre = Genre.INDIE;
			break;
			
		case "blues":
			genre = Genre.BLUES;
			break;
		default:
			genre = Genre.SINGER_SONGWRITER;
		}
	}
	
	public void addSong(Song song) {
		song.setAlbum(this);
		songs.add(song);
	}
	
	public ArrayList<Song> getSongs() {
		/*
		 * This method returns a deep copy of an ArrayList
		 * containing all songs in the album
		 */
		ArrayList<Song> songsCopy = new ArrayList<Song>();
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
