package hust.soict.dsai.aims.screen;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class CartScreen extends JFrame {
	private Cart cart;
	
	public CartScreen(Cart cart) {
		super();
		this.cart = cart;
		JFXPanel fxPanel = new JFXPanel();
		this.add(fxPanel);
		
		this.setTitle("Cart");
		this.setVisible(true);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("/hust/soict/dsai/aims/screen/cart.fxml"));
					CartScreenController controller = new CartScreenController(cart);
					loader.setController(controller);
					Parent root = loader.load();
					fxPanel.setScene(new Scene(root));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}
	public static void main(String[] args) {
		Cart cart = new Cart(); // Create a new instance of Cart
		
		//example to test
       
    	DigitalVideoDisc dvd1 = new DigitalVideoDisc(1,"Avengers", "Action", "Joss Whedon", 142, 19.99f);
        CompactDisc dvd2 = new CompactDisc(2,"SlamDunk", "Animation", "Inoue Takehiko", 148, 14.99f);
       	
        
        //Add the instances to the cart or perform any other operations
        cart.addMedia(dvd1);
        cart.addMedia(dvd2);

	    new CartScreen(cart); // Pass the Cart instance to the CartScreen constructor
	}

}
	
