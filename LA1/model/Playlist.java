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
		for (Song s : songs) {
			if (s.getTitle().equals(songName)) songs.remove(s);
		}
	}
	
	public String getSongs() {
		String songsStr = "";
		for (Song s : songs) {
			songsStr += s.getTitle() + "/n";
		}
		return songsStr;
	}
}
