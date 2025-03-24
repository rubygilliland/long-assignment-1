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
import java.util.Collections;

public class Playlist {
	private String name;
	private ArrayList<Song> songs;
	private ArrayList<Song> shuffled;
	private int shufflePointer;

	public Playlist(String name) {
		songs = new ArrayList<>();
		this.name = name;
		shufflePlaylist();
	}

	// copy constructor
	public Playlist(Playlist p) {
		this.name = p.getName();
		this.songs = p.getSongsList();
		ArrayList<Song> newShuffled = new ArrayList<Song>();
		for (Song s: p.shuffled) {
			newShuffled.add(new Song(s));
		}
		this.shuffled = newShuffled;
		this.shufflePointer = p.shufflePointer;
	}

	// adds the given Song object to the songs list
	public void addSong(Song song) {
		songs.add(song);
	}

	public void insertSong(Song song) {
		songs.addFirst(song);
	}

	public void popSong() {
		songs.remove(songs.size() -1);
	}

	// returns a boolean that represents whether a given song is in a playlist
	public boolean songInPlaylist(String songTitle, String artist) {
		boolean inPlaylist = false;
		for (Song s : songs) {
			
			// checks songs list for song with given title and artist
			if (s.getTitle().toLowerCase().equals(songTitle.toLowerCase()) &&
					s.getArtist().toLowerCase().equals(artist.toLowerCase())) {
				inPlaylist = true;
			}
		}
		return inPlaylist;
	}
	
	// removes a Song object from the songs list
	public void removeSong(String songName, String artist) {
		Song toRemove = new Song("", "", null);
		for (Song s : songs) {

			// finds the Song object in songs that matches the given title and artist
			if (s.getTitle().toLowerCase().equals(songName.toLowerCase()) &&
					s.getArtist().toLowerCase().equals(artist.toLowerCase())) {
				toRemove = s;
			}
		}
		// only removes an item from the songs list if a valid Song object is found
		if (toRemove.getTitle() != "" && toRemove.getArtist() != "") {
		songs.remove(toRemove);
		}
	} 


	public void shufflePlaylist() {
		shufflePointer = 0;
			ArrayList<Song> shuffle = new ArrayList<>();
			for (Song s : this.getSongsList()) {
				Song copyS = new Song(s);

				// avoids any escaping references
				shuffle.add(copyS);
			}

			// shuffles all the songs in that playlist
			Collections.shuffle(shuffle);
			shuffled = shuffle;
		}

	// gets a random song by picking a song from the shuffled playlist
	public Song getRandomSong() {
		Song random = shuffled.get(shufflePointer);
		shufflePointer += 1;
		return new Song(random);
	}
	
	public void clear() {
		songs.clear();
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
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String toStringShuffled() {
		String pString = this.name + ":\n";
		for (Song s : shuffled) {

			// Song object Strings are tabbed in to make for easier readability
			pString += "\t" + s.toString();
		}
		return pString;
		
	}
	 
	
	public String toString(Plays plays) {
		String pString = this.name + ":\n";
		for (Song s : songs) {
			if (plays.getPlaysBySong(s) != 1) {
				pString += "\t" + s.toString().strip() + " - " + plays.getPlaysBySong(s) + " plays\n";
			}
			else {
				pString += "\t" + s.toString().strip() + " - " + plays.getPlaysBySong(s) + " play\n";
			}
		}
		return pString;
	}
	
	@Override
	public String toString() {
		String pString = this.name + ":\n";
		pString += getSongs();
		return pString;
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    
	    Playlist other = (Playlist) obj;
	    
	    // compare names
	    if (!this.name.equals(other.name)) {
	        return false;
	    }
	    
	    // sompare songs lists 
	    if (!this.getSongsList().equals(other.getSongsList())) {
	        return false;
	    }
	    
	    // compare shuffled lists and shufflePointer
	    return this.shuffled.equals(other.shuffled) && this.shufflePointer == other.shufflePointer;
	}
	


}
