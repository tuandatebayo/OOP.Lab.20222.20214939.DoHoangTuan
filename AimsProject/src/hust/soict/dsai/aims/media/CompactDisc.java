package hust.soict.dsai.aims.media;

import java.util.ArrayList;
public class CompactDisc extends Disc implements Playable {
	private String artist;
	private ArrayList<Track> tracks = new ArrayList<Track>();
	
	public String getArtist() {
		return artist;
	}
	public CompactDisc(String title) {
		super(title);
	}
	public CompactDisc(int id, String title, String category, String director, int length, float cost) {
		super(id, title, category, director,length, cost);
	}
	public CompactDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}
	
	public CompactDisc(int id, String title, String category, String director, String artist, int length, float cost) {
		super(id, title, category, director,length, cost);
		this.artist = artist;
	}
	public CompactDisc(String title, String category, String director, String artist, int length, float cost) {
		super(title, category, director, length, cost);
		this.artist = artist;
	}
	
	public void addTrack(Track track) {
		if (tracks.contains(track)){
			tracks.add(track);
			System.out.println("The track has been added.");
		}
		else {
			System.out.println("The track has already existed.");
		}
	}
	
	public void removeTrack(Track track) {
		if (tracks.contains(track)){
			tracks.remove(track);
			System.out.println("The track has been removed.");
		}
		else {
			System.out.println("The track has not existed.");
		}
	}
	
	public int getLength() {
		int total = 0;
        for (Track track: tracks) {
            total += track.getLength();
        }
        return total;
    }
	
	public void play() {
		for (Track track: tracks) {
			track.play();
		}
		}
	public String toString() {
	    return this.getId()+ " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " +this.getArtist() + " - " + this.getLength() + ": " + this.getCost() +"$";
	}
}
	
