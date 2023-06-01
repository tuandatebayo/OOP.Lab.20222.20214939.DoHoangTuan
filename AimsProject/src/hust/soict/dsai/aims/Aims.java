package hust.soict.dsai.aims;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Disc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class Aims {
	public static void showMenu() {
		System.out.println("AIMS: ");
		System.out.println("--------------------------------");
		System.out.println("1. View store");
		System.out.println("2. Update store");
		System.out.println("3. See current cart");
		System.out.println("0. Exit");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3");
		}
	public static void viewStore() {
		System.out.println("Items in the store:");
        store.printStore();
        storeMenu();
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        while (choice != 0) {
            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    playMedia(); 
                    break;
                case 4:
                    seeCurrentCart();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
         choice = scanner.nextInt();

	
	}
	}
        
		public static void seeMediaDetails() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the title of the media: ");
            String title = scanner.nextLine();
            Media media = store.searchMedia(title);
            if (media != null) {
                System.out.println(media);
                if (media instanceof Disc) {
                	mediaDetailsMenu();
                    int choice = scanner.nextInt();
                    switch (choice) {
                        case 1:
                            cart.addMedia(media);
                            break;
                        case 2:
                            playMedia(media);
                            break;
                        default:
                            break;
                    }
                } else {
                    System.out.println("--------------------------------");
                    System.out.println("1. Add to cart");
                    System.out.println("0. Back");
                    System.out.println("--------------------------------");
                    System.out.println("Please choose a number: 0 - 1");

                    int choice = scanner.nextInt();
                    if (choice == 1) {
                    	cart.addMedia(media);
                    }
                }
            } else {
                System.out.println("Media not found.");
            }
        }
        
        

        public static void playMedia(Media media) {
            if (media instanceof DigitalVideoDisc) {
                ((DigitalVideoDisc) media).play();
            } else if (media instanceof CompactDisc) {
                ((CompactDisc) media).play();
            }
        }
        
        
        public static void addToCart() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the title of the media: ");
            String title = scanner.nextLine();

            Media media = store.searchMedia(title);
            if (media != null) {
                cart.addMedia(media);
                //print the number of current DVD in cart
            } else {
                System.out.println("Media not found.");
            }
        }
        
        public static void playMedia() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the title of the media: ");
            String title = scanner.nextLine();

            Media media = store.searchMedia(title);
            if (media != null) {
                playMedia(media);
            } else {
                System.out.println("Media not found.");
            }
        }
    
    public static void updateStore() {
    	System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add a media to store");
		System.out.println("2. Remove a media to store");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		
		Scanner scanner = new Scanner(System.in);
        System.out.print("Choose options: ");
        int choice = scanner.nextInt();
        while (choice != 0) {
            switch (choice) {
                case 1:
                	addMediaToStore();
                    break;
                case 2:
                	removeMediaFromStore();
                    break;
                case 3:
                	seeCurrentCart();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        
		}
    }
    
    public static void addMediaToStore() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the type of the media: ");
        String type = scanner.nextLine();
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        System.out.print("Enter the id of the media: ");
        int id = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the category of the media: ");
        String category = scanner.nextLine();
        //System.out.print("Enter the director/artist of the media: ");
        //String director = scanner.nextLine();
        //System.out.print("Enter the length of the media: ");
        //int length = scanner.nextInt();
        System.out.print("Enter the cost of the media: ");
        float cost = scanner.nextFloat();

        Media media = null;
        if (type.equalsIgnoreCase("book")) {
            scanner.nextLine(); // Consume the remaining newline character
            System.out.print("Enter the authors of the book: ");
            String authors = scanner.nextLine();

            media = new Book(id, title, category, cost); //maybe some author
        } else if (category.equalsIgnoreCase("compactdisc")) {
            scanner.nextLine(); // Consume the remaining newline character
            System.out.print("Enter the director of the DVD: ");
            String director = scanner.nextLine();
            System.out.print("Enter the length of the DVD: ");
            int length = scanner.nextInt();
            System.out.print("Enter the artist of the CD: ");
            String artist = scanner.nextLine();

            media = new CompactDisc(title, category, director, length, cost);
        } else if (category.equalsIgnoreCase("digitalvideodisc")) {
            scanner.nextLine(); // Consume the remaining newline character
            System.out.print("Enter the director of the DVD: ");
            String director = scanner.nextLine();
            System.out.print("Enter the length of the DVD: ");
            int length = scanner.nextInt();

            media = new DigitalVideoDisc(title, category, director, length, cost);
        }

        if (media != null) {
            store.addMedia(media);
            }
        else {
            System.out.println("Invalid media.");
        }
    }
    
    public static void removeMediaFromStore() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();

        Media media = store.searchMedia(title);
        if (media != null) {
            store.removeMedia(media);
            System.out.println("Media removed from the store.");
        }
        else {
            System.out.println("Media not found.");
        }
    }
    
    public static void seeCurrentCart() {
        System.out.println("Items in the cart:");
        cart.printCart();
        cartMenu();
        
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        while (choice != 0) {
            switch (choice) {
                case 1:
                    filterMediasInCart();
                    break;
                case 2:
                    sortMediasInCart();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMedia();
                    break;
                case 5:
                    placeOrder();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            choice = scanner.nextInt();
    }
    }
    
    public static ArrayList<Media> filterMediasInCart() {
        System.out.println("Filter options:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter by ID");
        System.out.println("2. Filter by Title");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character after reading the integer

        ArrayList<Media> filteredList = new ArrayList<>();

        switch (choice) {
            case 1:
                System.out.print("Enter media ID: ");
                int id = scanner.nextInt();
                for (Media media : cart.getItemsInCart()) {
                    if (media.getId() == id) {
                        filteredList.add(media);
                    }
                }
                break;

            case 2:
                System.out.print("Enter media title: ");
                String title = scanner.nextLine();
                for (Media media : cart.getItemsInCart()) {
                    if (media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                        filteredList.add(media);
                    }
                }
                break;

            case 0:
                cartMenu();
                break;

            default:
                System.out.println("Invalid choice. Please try again.");
                filterMediasInCart();
                break;
        }
        return filteredList;
    }
    
    public static void sortMediasInCart() {
        System.out.println("Sort options:");
        System.out.println("--------------------------------");
        System.out.println("1. Sort by Title");
        System.out.println("2. Sort by Cost");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
        
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
        case 1:
        	Collections.sort(cart.getItemsInCart(),Media.COMPARE_BY_TITLE_COST);
        	cart.printCart();
            break;
        case 2:
        	Collections.sort(cart.getItemsInCart(),Media.COMPARE_BY_COST_TITLE);
        	cart.printCart();
            break;
        case 0:
            cartMenu();
            return;
        default:
            System.out.println("Invalid choice. Please try again.");
            sortMediasInCart();
            return;
    }
        
    }
    
    public static void removeMediaFromCart() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();

        Media media = cart.searchMedia(title);
        if (media != null) {
            store.removeMedia(media);
            System.out.println("Media removed from the cart.");
        }
        else {
            System.out.println("Media not found.");
        }
    }
    
    public static void placeOrder() {
        System.out.println("Placing order...");
        System.out.println("Order placed successfully.");
        System.out.println("Thank you!");
    }
        
	public static void storeMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. See a media’s details");
		System.out.println("2. Add a media to cart");
		System.out.println("3. Play a media");
		System.out.println("4. See current cart");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4");
		}
	
	public static void mediaDetailsMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Add to cart");
		System.out.println("2. Play");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2");
		}
	
	public static void cartMenu() {
		System.out.println("Options: ");
		System.out.println("--------------------------------");
		System.out.println("1. Filter medias in cart");
		System.out.println("2. Sort medias in cart");
		System.out.println("3. Remove media from cart");
		System.out.println("4. Play a media");
		System.out.println("5. Place order");
		System.out.println("0. Back");
		System.out.println("--------------------------------");
		System.out.println("Please choose a number: 0-1-2-3-4-5");
		}
	
	
	
	static Store store = new Store();
	static Cart cart = new Cart();
	

	public static void main(String[] args) {
        /*
        //example to test
        List<String> authors = new ArrayList<>();
    	authors.add("Herbert Schildt");
    	authors.add("John Doe");
    	DigitalVideoDisc dvd1 = new DigitalVideoDisc(1,"The Avengers", "Action", "Joss Whedon", 142, 19.99f);
        CompactDisc dvd2 = new CompactDisc(2,"Inception", "Sci-Fi", "Christopher Nolan", 148, 14.99f);
        Book book1 = new Book(3,"Java: A Beginner's Guide", "Herbert Schildt", authors, 29.99f);
        Book book2 = new Book(4,"Clean Code: A Handbook of Agile Software Craftsmanship", "ad",authors, 49.99f);
        
        // Add media instances to the store
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book1);
        store.addMedia(book2);
        */
        showMenu();
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        while (choice != 0) {
            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                	updateStore();
                    break;
                case 3:
                	seeCurrentCart();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            showMenu();
            choice = scanner.nextInt();
        }

        System.out.println("Exiting the program. Goodbye!");
    }
	

}


    