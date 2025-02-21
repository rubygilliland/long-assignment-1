package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class UserLibrary {
	private ArrayList<Song> songs;
	private ArrayList<Album> albums;
	private ArrayList<Playlist> playlists;
	private MusicStore musicStore;
	
	public UserLibrary(MusicStore musicStore) {
		songs = new ArrayList<Song>();
		albums = new ArrayList<Album>();
		playlists = new ArrayList<Playlist>();
		this.musicStore = musicStore;
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
	
	public String getPlaylist(String name) {
		String playlistStr = "";
		for (Playlist p : playlists) {
			if (p.getName().equals(name)) {
					playlistStr += p.getSongs();
				}
			}
		if (playlistStr.equals("")) playlistStr = "Playlist by this name cannot be found";
		return playlistStr;
		}
	
	public void addSong(String songName) {
		for (Song s : musicStore.getSongs()) {
			if (s.getTitle().equals(songName) && songs.contains(s) == false) songs.add(s);
		}
	}
	
	public void addAlbum(String albumName) {
		for (Album a : musicStore.getAlbums()) {
			if (a.getTitle().equals(albumName) && albums.contains(a) == false) {
				albums.add(a);
				for (Song s : a.getSongs()) {
					if (songs.contains(s) == false) songs.add(s);
					}
				}
			}
		}
	
	public void createPlaylist(String name) {
		Playlist myPlaylist = new Playlist(name);
		playlists.add(myPlaylist);
	}
	
	public String getSongTitles() {
		String songsStr = "";
		for (Song s : songs) {
			songsStr += s.getTitle() + "\n";
		}
		return songsStr;
	}
	
	public String getArtists() {
		HashSet<String> artists = new HashSet<String>();
		for (Song s : songs) {
			artists.add(s.getArtist());
		}
		
		ArrayList<String> artistsList = new ArrayList<String>(artists);
		Collections.sort(artistsList);
		String artistsStr = "";
		for (String a : artistsList) {
			artistsStr += a + "\n";
		}
		return artistsStr;
	}
	
	public String getAlbumTitles() {
		String albumsStr = "";
		for (Album a : albums) {
			albumsStr += a.getTitle() + "\n";
		}
		return albumsStr;
	}
	
	public String getPlaylists() {
		String playlistsStr = "";
		for (Playlist p : playlists) {
			playlistsStr += p.getName() + "\n";
		}
		return playlistsStr;
	}
	
	public String getFavoriteSongs() {
		String favorites = "";
		for (Song s : songs) {
			if(s.getRating().equals(Song.Rating.FAVORITE)) favorites += s.getTitle() + "\n";
		}
		return favorites;
	}
	
	}
