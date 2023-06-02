package hust.soict.dsai.aims.media;

import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;

public abstract class Media {
	private int id;
	private String title;
	private String category;
	private float cost;
	
	public static final Comparator<Media> COMPARE_BY_TITLE_COST = new MediaComparatorByTitleCost();
	public static final Comparator<Media> COMPARE_BY_COST_TITLE = new MediaComparatorByCostTitle();
	
	public Media(String title) {
		this.title = title;
	}
	public Media(String title, String category, float cost) {
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	public Media(int id,String title, String category, float cost) {
		this.id = id;
		this.title = title;
		this.category = category;
		this.cost = cost;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public float getCost() {
		return cost;
	}

	public boolean equals(Object obj) {
	    if (this == obj) {
	        return true;
	    }

	    if (!(obj instanceof Media)) {
	        return false;
	    }

	    Media other = (Media) obj;
	    return title.equals(other.title);
	}
	
	public static void main(String[] args) {
	    ArrayList<Media> mediae = new ArrayList<>();
	    
	    CompactDisc cd = new CompactDisc(3,"SpiderMan","Action",null,123,305.5f);
	    DigitalVideoDisc dvd = new DigitalVideoDisc(1,"SlamDunk", "Animation","Inoue",120, 1563.6f );
	    Book book = new Book(5,"Dark", "Psychology", 55.6f);
	    
	    // Add some media objects to the list
	    mediae.add(cd);
	    mediae.add(dvd);
	    mediae.add(book);
	    
	    Collections.sort(mediae, Media.COMPARE_BY_TITLE_COST);    
	    
	    for (Media media : mediae) {
	        System.out.println(media.toString());
	    }
	}

	
}
