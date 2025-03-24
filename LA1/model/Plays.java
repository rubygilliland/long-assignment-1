/*
 * This class defines methods and instance variables for a Plays object.
 * Every user has a Plays object that keeps track of the plays for all of theis
 * songs.
 */
package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class Plays {
	private HashMap<Song, Integer> plays;
	private Playlist recentlyPlayed;
	private Playlist frequentlyPlayed;

	public Plays() {
		this.plays = new HashMap<>();
		this.recentlyPlayed = new Playlist("Recently Played");
		this.frequentlyPlayed = new Playlist("Frequently Played");
	}
	
	// copy constructor
	public Plays(Plays other) {
		this.plays = new HashMap(other.plays);
		this.recentlyPlayed = new Playlist(other.recentlyPlayed);
		this.frequentlyPlayed = new Playlist(other.frequentlyPlayed);
	}

	// assume song passed in is a copy
	// this method plays a given song
	public void playSong(Song song) {
		
		// adds song to hashmap if it has not yet been played
		plays.putIfAbsent(song, 0);
		
		// adds one to the value of the song key in the hashmap
		plays.replace(song, plays.get(song) + 1);
		
		// updates automatically made playlists based on plays
		updateRecentlyPlayed(new Song(song));
		updateFrequentlyPlayed();
	}

	 
	// assume song passed in is a copy
	// this method updates the recently played playlist given the most recently played song
	public void updateRecentlyPlayed(Song song) {
		
		// if the song has been played recently, it removes it from its place in the playlist and places it at the top
		if (recentlyPlayed.songInPlaylist(song.getTitle(), song.getArtist())) {
			recentlyPlayed.removeSong(song.getTitle(), song.getArtist());
			recentlyPlayed.insertSong(song); 
		}
		
		// otherwise it removes the song at the end of the playlist and puts the recently played on in at the top
		else {
			recentlyPlayed.insertSong(song);
			if (recentlyPlayed.getSongsList().size() > 10) recentlyPlayed.popSong();
		}
		
	}

	// this method creates a frequently played playlist based on song plays that holds 10 most frequently played songs
	public void updateFrequentlyPlayed() {
		
		// clear the existing playlist before updating
	    frequentlyPlayed.clear(); 

	    // sort songs by play count in descending order
	    List<Song> sortedSongs = new ArrayList<>(plays.keySet());
	    
	 // sort in descending order
	    sortedSongs.sort((s1, s2) -> plays.get(s2) - plays.get(s1)); 

	    // add up to 10 most played songs
	    int count = 0;
	    for (Song song : sortedSongs) {
	        if (count >= 10) break;
	        frequentlyPlayed.addSong(song);
	     count++;
	    } 

		}
	
	// this method helps with saving user data
	// assume playlist passed in is a copy
	public void setRecentlyPlayed(Playlist recent) {
		recentlyPlayed = new Playlist(recent);
		recentlyPlayed.setName("Recently Played");
	}
	
	// this method iterates through the plays hashmap and gets the plays for every song
	public int getPlaysBySong(Song song) {
		if (!plays.containsKey(song)) {
			return 0;
		}
		else {
			return plays.get(song);
		}
	}
	
	public Playlist getRecentlyPlayed() {
		return new Playlist(recentlyPlayed);
	}

	public Playlist getFrequentlyPlayed() {
		return new Playlist(frequentlyPlayed);
	}
	
	@Override
	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }
	    if (obj == null || getClass() != obj.getClass()) {
	        return false;
	    }
	    
	    Plays other = (Plays) obj;
	    
	    // compare plays HashMap
	    if (!this.plays.equals(other.plays)) {
	        return false;
	    }
	    
	    // compare recentlyPlayed and frequentlyPlayed playlists
	    return this.recentlyPlayed.equals(other.recentlyPlayed) &&
	           this.frequentlyPlayed.equals(other.frequentlyPlayed);
	}


}
