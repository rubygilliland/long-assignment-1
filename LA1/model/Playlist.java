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
	
	public void removeSong(String songName, String artist) {
		Song toRemove = new Song("", "");
		for (Song s : songs) {
			if (s.getTitle().equals(songName) && s.getArtist().equals(artist)) toRemove = s;
		}
		if (toRemove.getTitle() != "" && toRemove.getArtist() != "") {
		songs.remove(toRemove);
		}
	}
	
	public ArrayList<Song> getSongsList(){
		ArrayList<Song> newSongList = new ArrayList<>();
		for (Song s : songs) {
			newSongList.add(new Song(s));
		}
		return newSongList;
	}
	
	
	public String getSongs() {
		String songsStr = "";
		for (Song s : songs) {
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
