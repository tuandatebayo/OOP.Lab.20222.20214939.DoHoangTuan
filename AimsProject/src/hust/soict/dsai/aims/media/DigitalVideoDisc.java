package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc{
	private static int nbDigitalVideoDiscs = 0; // class attribute
    //DigitalVideoDisc dvd1 = new DigitalVideoDisc();
	public DigitalVideoDisc(String title) {
		super(title);
		this.setId(++nbDigitalVideoDiscs);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super(title, category, cost);
		this.setId(++nbDigitalVideoDiscs);
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super(title, category, director, cost);
		this.setId(++nbDigitalVideoDiscs);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super(title, category, director, length, cost);
		this.setId(++nbDigitalVideoDiscs);
	}
	public String toString() {
	    return this.getTitle() + " - " + this.getCategory() + " - " + this.getDirector() + " - " + this.getLength() + ": " + this.getCost() +"$";
	}
	public boolean isMatch(String title) {
	    if (this.getTitle().equalsIgnoreCase(title)) {
	        return true;
	    } else {
	        return false;
	    }
	}

}
