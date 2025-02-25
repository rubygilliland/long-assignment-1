package model;

import java.util.ArrayList;

public class MusicStore {
	private ArrayList<Song> songs;
	private ArrayList<Album> albums;
	
	public MusicStore() {
		albums = Parser.makeAlbumList("albums.txt");
		songs = new ArrayList<Song>();
		for (Album a : albums) {
			for (Song s : a.getSongs()) {
				songs.add(s);
			}
		}
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
	
	public ArrayList<Song> getSongs(){
		return new ArrayList<Song>(songs);
	}
	
	public ArrayList<Album> getAlbums(){
		return new ArrayList<Album>(albums);
	}
	
	@Override
	public String toString() {
		String message = "Music Store:\n";
		message += "\tAlbums:\n";
		for (int i = 0; i < albums.size(); i++){
			int j = i+1;
			message += "\t\t" + j + ". " + albums.get(i).toString() + "\n";
		}
		message += "\tSongs:\n";
		for (int i = 0; i < songs.size(); i++) {
			int j = i+1;
			message += "\t\t" + j + ". " + songs.get(i).toString() + "\n";
		}
		
		return message;
		
	}

	}

