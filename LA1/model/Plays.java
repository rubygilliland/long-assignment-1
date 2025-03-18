package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Plays {
	private HashMap<Song, Integer> plays;
	private Playlist recentlyPlayed; 
	private Playlist frequentlyPlayed;
	
	public Plays() {
		this.plays = new HashMap<Song, Integer>();
		this.recentlyPlayed = new Playlist("Recently Played");
		this.frequentlyPlayed = new Playlist("Frequently Played");
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
		if (recentlyPlayed.getSongsList().size() > 1) recentlyPlayed.popSong();
	}
	
	public void updateFrequentlyPlayed() {
		ArrayList songsList = new ArrayList(plays.values());
		Collections.sort(songsList); 
		int songsNum = 0;
		while ((songsNum < 10) && songsNum < songsList.size()) {
		for (Song key : plays.keySet())
			if (plays.get(key) == songsList.get(songsNum)) {
			frequentlyPlayed.addSong(key);
			songsNum += 1;
			}
		}
	}
	
	public Playlist getRecentlyPlayed() {
		return new Playlist(recentlyPlayed);
	}
	
	public Playlist getFrequentlyPlayed() {
		return new Playlist(frequentlyPlayed);
	}
	
}
