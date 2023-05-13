package hust.soict.dsai.aims.disc;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int length;
	private float cost;
	
	private static int nbDigitalVideoDiscs = 0; // class attribute
    private int id; // instance attribute
	
	public String getTitle() {
		return title;
	}
	public String getCategory() {
		return category;
	}
	public String getDirector() {
		return director;
	}
	public int getLength() {
		return length;
	}
	public float getCost() {
		return cost;
	}
	//DigitalVideoDisc dvd1 = new DigitalVideoDisc();
	public DigitalVideoDisc(String title) {
		super();
		this.title = title;
		this.setId(++nbDigitalVideoDiscs);
	}
	public DigitalVideoDisc(String title, String category, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.cost = cost;
		this.setId(++nbDigitalVideoDiscs);
	}
	public DigitalVideoDisc(String title, String category, String director, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.cost = cost;
		this.setId(++nbDigitalVideoDiscs);
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
		super();
		this.title = title;
		this.category = category;
		this.director = director;
		this.length = length;
		this.cost = cost;
		this.setId(++nbDigitalVideoDiscs);
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String toString() {
	    return this.title + " - " + this.category + " - " + this.director + " - " + this.length + ": " + this.cost +"$";
	}
	public boolean isMatch(String title) {
	    if (this.title.equalsIgnoreCase(title)) {
	        return true;
	    } else {
	        return false;
	    }
	}

}
