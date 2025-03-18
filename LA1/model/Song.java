package model;


/*
 * This class defines methods and instance variables for a Song object.
 * Song objects have a String artist and title, an assigned Album object,
 * and a Rating.
 * 
 * Songs can be copied (with the copy constructor), have an Album object assigned
 * to them, rated, rated as a favorite, and can be compared to other Song objects
 * (equals method). 
 */
public class Song {
private final Album ALBUM;
private String title;
private String artist;
public enum Rating {ONE, TWO, THREE, FOUR, FAVORITE}
private Rating rating;

public Song(String title, String artist, Album album) {
	this.title = title;
	this.artist = artist;
	this.ALBUM = album;
}

// copy constructor
	public Song(Song song) {
		this(song.title, song.artist, song.ALBUM);
		if (song.rating != null) {
			this.rate(song.rating);
		} 
	}

// helper method for Song copy constructor
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
		
		// if the user rating is 5, song is automatically marked as favorite
		rating = Rating.FAVORITE;
	}
}

public void favorite() {
	rating = Rating.FAVORITE;
}

public Rating getRating() {
	return rating;
}

public String getTitle() {
	return title;
}

public String getArtist() {
	return artist;
}

public Album getAlbumObj() {
	return new Album(ALBUM);
}
public String getAlbum() {
	return ALBUM.getTitle();
}

public String getGenre() {
	return ALBUM.getGenreStr();	
}

@Override
public boolean equals(Object otherSong) {
	if (this.getClass() != otherSong.getClass()) {
		return false;
	}
	else {
		// compares Song objects based on their title and artist
		return (this.title.equals(((Song) otherSong).title) && this.artist.equals(((Song) otherSong).artist));
	}
	

	public String toStringFile() {
		String message = toString().strip() + " " + this.rating + "\n";
		return message;
	}
	
	@Override
	public String toString() {
		String message = this.title + " - by: " + this.artist + " (" + this.getAlbum() + ")\n";
		return message;
	} 


//public class Song {
//	private Album album;
//	private String title;
//	private String artist;
//	public enum Rating {ONE, TWO, THREE, FOUR, FAVORITE}
//	private Rating rating;
//	
//	public Song(String title, String artist, Album album) {
//		this.title = title;
//		this.artist = artist;
//		this.album = album;
//		
//		// default rating
//		this.rating = Rating.ONE;
//	}	
//	
//	// Copy constructor
//    public Song(String title, String artist, Album album, int rating) {
//        this.title = title;
//        this.artist = artist;
//        this.album = album;
//        this.rating = rate(rating);
//    }
//    
//    // copy constructor
//    public Song(Song s) {
//    	this.title = s.getTitle();
//    	this.artist = s.getArtist();
//    	this.album = s.getAlbum();
//    	this.rating = s.getRating();
//    }
//
//	// @pre int userRating must be a rating from 1-5
//	private Rating rate(int userRating) {
//		switch(userRating) {
//		case 1:
//			return Rating.ONE;
//		case 2:
//			return Rating.TWO;
//		case 3: 
//			return Rating.THREE;
//		case 4:
//			return Rating.FOUR;
//		default:
//			
//			// if the user rating is 5, song is automatically marked as favorite
//			return Rating.FAVORITE;
//		}
//	}
//	
//	public Song rateSong(int newRating) {
//        return new Song(this.title,this.artist, this.album, newRating);
//    }
//	
//	public void favorite() {
//		rating = Rating.FAVORITE;
//	}
//	
//	public int getRatingInt() {
//		return rating.ordinal();
//	}
//	
//	public Rating getRating() {
//		return rating;
//	}
//	
//	public String getTitle() {
//		return title;
//	}
//	
//	public String getArtist() {
//		return artist;
//	}
//	
////	public Album getAlbum() {
////		return new Album(album);
////	}
////	
//	public String getAlbumTitle() {
//		return album.getTitle();
//	}
//	
//	public String getGenre() {
//		return album.getGenreStr();
//	}
//	@Override
//	public boolean equals(Object otherSong) {
//		if (this.getClass() != otherSong.getClass()) {
//			return false;
//		}
//		else {
//			// compares Song objects based on their title and artist
//			return (this.title.equals(((Song) otherSong).title) && this.artist.equals(((Song) otherSong).artist));
//		}
//		
//	}
//	
//	@Override
//	public String toString() {
//		String message = this.title + " - by: " + this.artist + " (" + this.getAlbum() + ")\n";
//		return message;
//	}

