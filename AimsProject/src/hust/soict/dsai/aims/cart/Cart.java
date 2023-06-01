package hust.soict.dsai.aims.cart;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Cart {
	private final int MAX_NUMBER_ORDERED = 20;
	private ArrayList<Media> itemsOrdered = new ArrayList<Media>(MAX_NUMBER_ORDERED);
	
	public void addMedia(Media media) {
		if (itemsOrdered.size() < MAX_NUMBER_ORDERED) {
			itemsOrdered.add(media);
	        System.out.println("The item has been added.");
		}
		else {
			System.out.println("The cart is full");
		}
	}
	
	public void removeMedia(Media media) {
		if (itemsOrdered.contains(media)) {
			itemsOrdered.remove(media);
	        System.out.println("The item has been removed.");
		}
		else {
			System.out.println("The item has not been in the cart yet.");
		}
		
	}
	
	public float totalCost() {
        float total = 0;
        for (Media item: itemsOrdered) {
            total += item.getCost();
        }
        return total;
    }
	
	
	public void printCart() {
	    System.out.println("***********************CART***********************");
	    System.out.println("Ordered Items:");
	    for (Media item: itemsOrdered) {
	        item.toString();
	    }
	    System.out.println("Total cost: " + totalCost() +"$");
	    System.out.println("***************************************************");
	}
	
	public void searchByID(int id) {
	    boolean found = false;
	    for (Media item: itemsOrdered) 
	        if (item.getId() == id) {
	            System.out.println("Found item with ID" + id + ": " + item.toString());
	            found = true;
	            break;
	        }
	    
	    if (!found) {
	        System.out.println("No item with ID " + id + " found in the cart.");
	    }
	}
	public void searchByTitle(String title) {
	    boolean found = false;
	    for (Media item: itemsOrdered) 
	        if (item.getTitle().equalsIgnoreCase(title)) {
	            found = true;
	            System.out.println("Found item with title \"" + title + "\": " + item.toString());
	        }															
	    
	    if (!found) {
	        System.out.println("No item with title \"" + title + "\" found in the cart.");
	    }
	}
	
	public Media searchMedia(String title) {
		for (Media items: itemsOrdered) {
			if (title.equalsIgnoreCase(items.getTitle())) {
				return items;	
			}	
		}
		return null;

	}
	public ArrayList<Media> getItemsInCart(){
		return itemsOrdered;
	} 

	
}
