package hust.soict.dsai.aims.screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.LimitExceededException;
import javax.swing.JFrame;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CartScreen extends JFrame {
	private Cart cart;
	private Store store;

	public CartScreen(Cart cart, Store store) {
		super();
		this.cart = cart;
		this.store = store;
		this.setSize(1024,768);
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/cart.fxml"));
					CartScreenController controller = new CartScreenController(cart, store);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void main(String[] args) throws LimitExceededException {
		Cart cart = new Cart(); // Create a new instance of Cart
		Store store = new Store();
		//example to test
        List<String> authors = new ArrayList<>();
    	authors.add("Herbert Schildt");
    	authors.add("John Doe");
    	DigitalVideoDisc dvd1 = new DigitalVideoDisc(1,"Avengers", "Action", "Joss Whedon", 142, 19.99f);
        CompactDisc dvd2 = new CompactDisc(2,"SlamDunk", "Animation", "Inoue Takehiko", 148, 14.99f);
        Book book1 = new Book(3,"Java", "Herbert Schildt", authors, 29.99f);
        Book book2 = new Book(4,"Clean", "ad",authors, 49.99f);
       	
        
        //Add the instances to the cart or perform any other operations
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);
        cart.addMedia(book2);
        cart.addMedia(book1);
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(book2);
        store.addMedia(book1);
        

	    new CartScreen(cart, store); // Pass the Cart instance to the CartScreen constructor
	}

}
	
