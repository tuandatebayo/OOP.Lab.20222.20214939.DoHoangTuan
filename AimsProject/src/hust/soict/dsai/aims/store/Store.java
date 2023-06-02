package hust.soict.dsai.aims.store;
import java.util.ArrayList;

import hust.soict.dsai.aims.media.Media;

public class Store {
	private ArrayList<Media> itemsInStore = new ArrayList<Media>();
	
	public void addMedia(Media media) {
		if (itemsInStore.contains(media)) {
	        System.out.println("The item has already existed.");
		}
		else {
			itemsInStore.add(media);
	        System.out.println("The item has been added.");
	        
		}
		
	}
	
	public void removeMedia(Media media) {
		if (itemsInStore.contains(media)) {
			itemsInStore.remove(media);
	        System.out.println("The item has been removed.");
		}
		else {
			System.out.println("The item is not in the store.");
		}
	}

	public void printStore() {
		// TODO Auto-generated method stub
		for (Media items: itemsInStore) {
			System.out.println("- " + items.getTitle());
		}
		
	}
	
	public Media searchMedia(String title) {
		for (Media items: itemsInStore) {
			if (title.equalsIgnoreCase(items.getTitle())) {
				return items;	
			}	
		}
		return null;

	}

}
