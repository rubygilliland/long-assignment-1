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
	
	public Plays(Plays other) {
		this.plays = other.plays;
		this.recentlyPlayed = other.recentlyPlayed;
		this.frequentlyPlayed = other.frequentlyPlayed;
	}

	// assume song passed in is a copy
	public void playSong(Song song) {
		plays.putIfAbsent(song, 0);
		plays.replace(song, plays.get(song) + 1);
		updateRecentlyPlayed(new Song(song));
		updateFrequentlyPlayed();
	}

	 
	// assume song passed in is a copy
	public void updateRecentlyPlayed(Song song) {
		recentlyPlayed.insertSong(song); 
		if (recentlyPlayed.getSongsList().size() > 10) recentlyPlayed.popSong();
	}

	public void updateFrequentlyPlayed() {

	    frequentlyPlayed.clear(); // Clear the existing list before updating

	    // Sort songs by play count in descending order
	    List<Song> sortedSongs = new ArrayList<>(plays.keySet());
	    sortedSongs.sort((s1, s2) -> plays.get(s2) - plays.get(s1)); // Sort in descending order

	    // Add up to 10 most played songs
	    int count = 0;
	    for (Song song : sortedSongs) {
	        if (count >= 10) break;
	        frequentlyPlayed.addSong(song);
	        count++;
	    }

		}
	
	
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

}
