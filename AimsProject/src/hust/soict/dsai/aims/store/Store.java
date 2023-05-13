package hust.soict.dsai.aims.store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
	private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[100];
	
	private int qtyAdded;
	
	public void addDVD(DigitalVideoDisc disc) {
		if (qtyAdded < 100) {
			itemsInStore[qtyAdded++] = disc;
            System.out.println("The disc has been added.");
        } else {
            System.out.println("The store is almost full.");
        }
	}
	public void removeDVD(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyAdded; i++) {
            if (itemsInStore[i] == disc) {
                found = true;
                qtyAdded--;
                for (int j = i; j < qtyAdded; j++) {
                	itemsInStore[j] = itemsInStore[j + 1];
                }
                itemsInStore[qtyAdded] = null;
                System.out.println("The disc has been removed.");
                break;
            }
        }
        if (!found) {
            System.out.println("The disc is not in the store.");
        }
    }

}
