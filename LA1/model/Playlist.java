package model;

import java.util.ArrayList;

public class Playlist {
	private String name;
	private ArrayList<Song> songs;
	
	public Playlist(String name) {
		songs = new ArrayList<Song>();
		this.name = name;
	}
	
	public void addSong(Song song) {
		songs.add(song);
	}
	
	public void removeSong(String songName) {
		Song toRemove = new Song("", "");
		for (Song s : songs) {
			if (s.getTitle().equals(songName)) toRemove = s;
		}
		if (toRemove.getTitle() != "" && toRemove.getArtist() != "") {
		songs.remove(toRemove);
		}
	}
	
	public String getSongs() {
		String songsStr = "";
		for (Song s : songs) {
			songsStr += s.getTitle() + "\n";
		}
		return songsStr;
	}
	
	public String getName() {
		return name;
	}
}
