package hust.soict.dsai.aims.media;

public class Track implements Playable {
	private String title;
	private int length;
	
	public String getTitle() {
		return title;
	}

	public int getLength() {
		return length;
	}

	public Track(String title, int length) {
		// TODO Auto-generated constructor stub
		this.title = title;
		this.length = length;
	}
	public void play() {
		System.out.println("Playing track: " + this.getTitle());
		System.out.println("Track length: " + this.getLength());
		}

	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }

	    if (!(obj instanceof Track)) {
	        return false;
	    }

	    Track other = (Track) obj;
	    return title.equals(other.title) && length == other.length;
	}

}
