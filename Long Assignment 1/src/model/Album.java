package model;

import java.util.ArrayList;

public class Album {
	private ArrayList<Song> songs;
	private String title;
	private String artist;
	public enum Genre {POP, ALTERNATIVE, TRADITIONAL_COUNTRY, 
						LATIN, ROCK, SINGER_SONGWRITER }
	private Genre genre;
}
