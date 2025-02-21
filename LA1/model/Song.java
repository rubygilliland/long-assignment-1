package model;

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
			break;
		case 2:
			rating = Rating.TWO;
			break;
		case 3: 
			rating = Rating.THREE;
			break;
		case 4:
			rating = Rating.FOUR;
			break;
		default:
			rating = Rating.FAVORITE;
		}
	}
	
	public void favorite() {
		rating = Rating.FAVORITE;
	}
	
	// how to make optional?
	public Rating getRating() {
		return rating;
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
	
	@Override
	public String toString() {
		String message = this.title + " - by: " + this.artist;
		return message;
	}
}
