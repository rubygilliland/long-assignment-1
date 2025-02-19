package model;

import java.util.ArrayList;

public class Album {
	private ArrayList<Song> songs;
	private String title;
	private String artist;
	public enum Genre {POP, ALTERNATIVE, TRADITIONAL_COUNTRY, 
						LATIN, ROCK, SINGER_SONGWRITER }
	private Genre genre;
	
	public Album(String title, String artist, String strGenre) {
		songs = new ArrayList<Song>();
		this.title = title;
		this.artist = artist;
		setGenre(strGenre);
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
	
	public String getSongs() {
		String songsStr = "";
		for (Song s : songs) {
			songsStr += s.getTitle() + "\n";
		}
		
		return songsStr;
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
	}
