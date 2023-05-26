package hust.soict.dsai.aims.media;

import java.util.ArrayList;
public class CompactDisc extends Disc{
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}
	public CompactDisc(String title) {
		super(title);
	}
	public CompactDisc(String title, String category, float cost) {
		super(title, category, cost);
	}
	public CompactDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
	}
	public CompactDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}
	
	public void addTrack(Track tracks) {
		
	}
	
	public void removeAuthor(String authorName) {

	}
	
}