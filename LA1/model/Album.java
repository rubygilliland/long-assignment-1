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
	
	public Album(String title, String artist, String strGenre, String year) {
		songs = new ArrayList<Song>();
		this.title = title;
		this.artist = artist;
		setGenre(strGenre);
		this.year = Integer.valueOf(year);
	}
	
	// copy constructor
		public Album(Album album) {
			songs = new ArrayList<Song>();
			for (Song s : album.songs) {
				songs.add(s);
			}
			this.title = album.title;
			this.artist = album.artist;
			setGenre(album.genre);
			this.year = album.year;		
		}
	
	private void setGenre(Genre genre) {
		this.genre = genre;
	}
	
	private void setGenre(String strGenre) {
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
		default:
			genre = Genre.SINGER_SONGWRITER;
		}
	}
	
	public void addSong(Song song) {
		song.setAlbum(this);
		songs.add(song);
	}
	
	public ArrayList<Song> getSongs() {
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
	
	@Override
	public boolean equals(Object otherAlbum) {
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
