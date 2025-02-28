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
	
	// copy constructor
		public Song(Song song) {
			this(song.title, song.artist);
			if (song.album != null) {
				this.setAlbum(song.album);
			}
			if (song.rating != null) {
				this.rate(song.rating);
			}
		}
	public void setAlbum(Album album) {
		this.album = album;
	}
	
	private void rate(Rating rating) {
		this.rating = rating;
	}
	
	
	// @pre int userRating must be a rating from 1-5
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
	public boolean equals(Object otherSong) {
		if (this.getClass() != otherSong.getClass()) {
			return false;
		}
		else {
			return (this.title.equals(((Song) otherSong).title) && this.artist.equals(((Song) otherSong).artist));
		}
		
	}
	
	@Override
	public String toString() {
		String message = this.title + " - by: " + this.artist + " (" + this.getAlbum() + ")\n";
		return message;
	} 
}
