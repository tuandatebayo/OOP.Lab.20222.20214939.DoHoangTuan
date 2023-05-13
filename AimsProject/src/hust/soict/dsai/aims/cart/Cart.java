package hust.soict.dsai.aims.cart;

import java.lang.reflect.Array;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
	public static final int MAX_NUMBERS_ORDERED = 20;
	private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
	private int qtyOrdered;
	
	public void addDigitalVideoDisc(DigitalVideoDisc disc) {
		if (qtyOrdered < MAX_NUMBERS_ORDERED) {
			itemsOrdered[qtyOrdered++] = disc;
            System.out.println("The disc has been added.");
        } else {
            System.out.println("The cart is almost full.");
        }
	}
	public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                found = true;
                qtyOrdered--;
                for (int j = i; j < qtyOrdered; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[qtyOrdered] = null;
                System.out.println("The disc has been removed.");
                break;
            }
        }
        if (!found) {
            System.out.println("The disc is not in the cart.");
        }
    }
	public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
	public void addDigitialVideoDisc(DigitalVideoDisc [] dvdList) {
		if (qtyOrdered + Array.getLength(dvdList) <= MAX_NUMBERS_ORDERED) {
			for (int i = 0; i < Array.getLength(dvdList); i++) {
				itemsOrdered[qtyOrdered + i] = dvdList[i];
			}
            System.out.println("These discs have been added.");
        } else {
            System.out.println("The cart is almost full.");
        }
	}	
	public void addDigitialVideoDisc(DigitalVideoDisc dvd1,DigitalVideoDisc dvd2) {
			if (qtyOrdered + 2 <= MAX_NUMBERS_ORDERED) {
				
				itemsOrdered[qtyOrdered] = dvd1;
				itemsOrdered[qtyOrdered + 1] = dvd2;
	            System.out.println("These discs have been added.");
	        } else {
	            System.out.println("The cart is almost full.");
	        }	
	}
	public void printOrder() {
	    System.out.println("***********************CART***********************");
	    System.out.println("Ordered Items:");
	    for (int i = 0; i < qtyOrdered; i++) {
	        DigitalVideoDisc dvd = itemsOrdered[i];
	        System.out.println((i+1) + ". DVD - " + dvd.toString());
	    }
	    System.out.println("Total cost: " + totalCost() +"$");
	    System.out.println("***************************************************");
	}
	public void searchByID(int id) {
	    boolean found = false;
	    for (int i = 0; i < qtyOrdered; i++) {
	        DigitalVideoDisc dvd = itemsOrdered[i];
	        if (dvd.getId() == id) {
	            System.out.println("Found DVD with ID" + id + ": " + dvd.toString());
	            found = true;
	            break;
	        }
	    }
	    if (!found) {
	        System.out.println("No DVD with ID " + id + " found in the cart.");
	    }
	}
	public void searchByTitle(String title) {
	    boolean found = false;
	    for (int i = 0; i < qtyOrdered; i++) {
	    	DigitalVideoDisc dvd = itemsOrdered[i];
	        if (dvd.isMatch(title)) {
	            found = true;
	            System.out.println("Found DVD with title \"" + title + "\": " + dvd.toString());
	        }
	    }
	    if (!found) {
	        System.out.println("No DVD with title \"" + title + "\" found in the cart.");
	    }
	}

	
}
