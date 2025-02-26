package model;

import java.util.ArrayList;

public class MusicStore {
	private ArrayList<Song> songs;
	private ArrayList<Album> albums;
	
	public MusicStore() {
		albums = Parser.makeAlbumList("LA1/albums.txt");
		songs = new ArrayList<Song>();
		for (Album a : albums) {
			for (Song s : a.getSongs()) {
				songs.add(s);
			}
		}
	}
	
	public String getSongByTitle(String songTitle) {
		songTitle = songTitle.toLowerCase();
		String songStr = "";
		for (Song s : songs) {
			if (s.getTitle().toLowerCase().equals(songTitle)) {
				songStr += s.toString();
			}
		}
		if (songStr.equals("")) songStr = "This song cannot be found.";
		return songStr;
	}
	
	public String getSongByArtist(String artist) {
		artist = artist.toLowerCase();
		String songStr = "";
		for (Song s : songs) {
			if (s.getArtist().toLowerCase().equals(artist)) {
				songStr += s.toString();
			}
		}
		if (songStr.equals("")) songStr = "Songs by this artist cannot be found.";
		return songStr;
	}
	
	public String getAlbumByTitle(String albumTitle) {
		albumTitle = albumTitle.toLowerCase();
		String albumStr = "";
		for (Album a : albums) {
			if (a.getTitle().toLowerCase().equals(albumTitle)) {
				albumStr += a.toString();
				for (Song s : a.getSongs()) {
					albumStr += "\t" + s.toString();
				}
			}
		}
		if (albumStr.equals("")) albumStr = "This album cannot be found.";
		return albumStr;
	}
	
	public String getAlbumByArtist(String artist) {
		artist = artist.toLowerCase();
		String albumStr = "";
		for (Album a : albums) {
			if (a.getArtist().toLowerCase().equals(artist)) {
				albumStr += a.toString();
				for (Song s : a.getSongs()) {
					albumStr += "\t" + s.toString();
				}
			}
		}
		if (albumStr.equals("")) albumStr = "Albums by this artist cannot be found";
		return albumStr;
	}
	
	public ArrayList<Song> getSongs(){
		ArrayList<Song> copySongs = new ArrayList<>();
		for (Song s : songs) {
			copySongs.add(new Song(s));
		}
		
		return copySongs;
	}
	
	public ArrayList<Album> getAlbums(){
		ArrayList<Album> copyAlbums = new ArrayList<>();
		for (Album a : albums) {
			copyAlbums.add(new Album(a));
		}
		return copyAlbums;
	}
	
	@Override
	public String toString() {
		String message = "Music Store:\n";
		message += "\tAlbums:\n";
		for (int i = 0; i < albums.size(); i++){
			int j = i+1;
			message += "\t\t" + j + ". " + albums.get(i).toString();
		}
		message += "\tSongs:\n";
		for (int i = 0; i < songs.size(); i++) {
			int j = i+1;
			message += "\t\t" + j + ". " + songs.get(i).toString();
		}
		
		return message;
		
	}

	}

