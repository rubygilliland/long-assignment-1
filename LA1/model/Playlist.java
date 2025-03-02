package model;
/*
 * This class defines methods and instance variables for a Playlist object.
 * Playlist objects have a String name and an ArrayList of Song objects that 
 * represent the songs in the playlist.
 * 
 * A Playlist object can have songs added to it and songs removed from it.
 * It has methods to return a deep copy of the songs list and a String representation
 * of the songs list.
 */
import java.util.ArrayList;

public class Playlist {
	private String name;
	private ArrayList<Song> songs;
	
	public Playlist(String name) {
		songs = new ArrayList<Song>();
		this.name = name;
	}
	
	// adds the given Song object to the songs list
	public void addSong(Song song) {
		songs.add(song);
	}
	
	// removes a Song object from the songs list
	public void removeSong(String songName, String artist) {
		Song toRemove = new Song("", "");
		for (Song s : songs) {
			
			// finds the Song object in songs that matches the given title and artist
			if (s.getTitle().equals(songName) && s.getArtist().equals(artist)) toRemove = s;
		}
		// only removes an item from the songs list if a valid Song object is found
		if (toRemove.getTitle() != "" && toRemove.getArtist() != "") {
		songs.remove(toRemove);
		}
	}
	
	// gets a deep copy of the Songs list
	public ArrayList<Song> getSongsList(){
		ArrayList<Song> newSongList = new ArrayList<>();
		for (Song s : songs) {
			
			// makes a copy of every Song object in songs list to avoid escaping references
			newSongList.add(new Song(s));
		}
		return newSongList;
	}
	
	// returns a String representation of the songs list
	public String getSongs() {
		String songsStr = "";
		for (Song s : songs) {
			
			// Song object Strings are tabbed in to make for easier readability
			songsStr += "\t" + s.toString();
		}
		return songsStr;
	}
	
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		String pString = this.name + ":\n";
		pString += getSongs();
		return pString;
	}
	

}
