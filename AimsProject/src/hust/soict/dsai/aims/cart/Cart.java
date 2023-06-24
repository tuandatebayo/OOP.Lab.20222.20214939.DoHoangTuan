package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Cart {
	private final int MAX_NUMBER_ORDERED = 20;
	private ObservableList<Media> itemsOrdered = FXCollections.observableArrayList();
	
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
	    	System.out.println(item.toString());
	    }
	    System.out.println("Total cost: " + totalCost() +"$");
	    System.out.println("***************************************************");
	}
	
	public Media searchMedia(String title) {
		for (Media items: itemsOrdered) {
			if (title.equalsIgnoreCase(items.getTitle())) {
				return items;	
			}	
		}
		return null;

	}
	public ObservableList<Media> getItemsInCart(){
		return itemsOrdered;
	} 
	public boolean isEmpty() {
	    return itemsOrdered.isEmpty();
	}
	public void clearCart() {
		itemsOrdered.clear();
	}
}
