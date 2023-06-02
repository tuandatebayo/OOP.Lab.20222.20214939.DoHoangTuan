package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable{
	public DigitalVideoDisc(String title) {
		super(title);
	}
	public DigitalVideoDisc(int id, String title, String category, String director, int length, float cost) {
		super(id, title, category, director,length, cost);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
	}
	public String toString() {
	    return this.getId()+ " - " + this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() +"$";
	}
	public boolean isMatch(String title) {
	    if (this.getTitle().equalsIgnoreCase(title)) {
	        return true;
	    } else {
	        return false;
	    }
	}
	
	public void play() {
		System.out.println("Playing DVD: " + this.getTitle());
		System.out.println("DVD length: " + this.getLength());
		}

}
