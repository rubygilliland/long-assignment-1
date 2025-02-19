package model;

import java.util.ArrayList;

public class MusicStore {
	private ArrayList<Song> songs;
	private ArrayList<Album> albums;
	
	public MusicStore() {
		songs = new ArrayList<Song>();
		albums = new ArrayList<Album>();
	}
	
	public String getSongByTitle(String songTitle) {
		String songStr = "";
		for (Song s : songs) {
			if (s.getTitle().equals(songTitle)) {
				songStr += s.getTitle() + " by " + s.getArtist() + " (" + s.getAlbum() + ")\n";
			}
		}
		if (songStr.equals("")) songStr = "This song cannot be found.";
		return songStr;
	}
	
	public String getSongByArtist(String artist) {
		String songStr = "";
		for (Song s : songs) {
			if (s.getArtist().equals(artist)) {
				songStr += s.getTitle() + " by " + s.getArtist() + " (" + s.getAlbum() + ")\n";
			}
		}
		if (songStr.equals("")) songStr = "Songs by this artist cannot be found.";
		return songStr;
	}
	
	public String getAlbumByTitle(String albumTitle) {
		String albumStr = "";
		for (Album a : albums) {
			if (a.getTitle().equals(albumTitle)) {
				albumStr += a.getTitle() + " by " + a.getArtist() + "\n";
				albumStr += a.getSongs();
			}
		}
		if (albumStr.equals("")) albumStr = "This album cannot be found";
		return albumStr;
	}
	
	public String getAlbumByArtist(String artist) {
		String albumStr = "";
		for (Album a : albums) {
			if (a.getArtist().equals(artist)) {
				albumStr += a.getTitle() + " by " + a.getArtist() + "\n";
				albumStr += a.getSongs();
			}
		}
		if (albumStr.equals("")) albumStr = "Albums by this artist cannot be found";
		return albumStr;
	}
	

	}

