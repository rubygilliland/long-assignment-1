package model;

import java.util.Optional;

public class Song {
	private Album album;
	private String title;
	private String artist;
	public enum Rating {ONE, TWO, THREE, FOUR, FAVORITE}
	private Rating rating;
	
	public Song(String title, String artist) {
		this.title = title;
		this.artist = artist;
	}
	
	public void setAlbum(Album album) {
		this.album = album;
	}
	
	public void rate(int userRating) {
		switch(userRating) {
		case 1:
			rating = Rating.ONE;
		case 2:
			rating = Rating.TWO;
		case 3: 
			rating = Rating.THREE;
		case 4:
			rating = Rating.FOUR;
		case 5:
			rating = Rating.FAVORITE;
		}
	}
	
	public Optional<Rating> getRating() {
		return Optional.ofNullable(this.rating);
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getArtist() {
		return artist;
	}
	
	public String getAlbum() {
		return album.getTitle();
	}
}
