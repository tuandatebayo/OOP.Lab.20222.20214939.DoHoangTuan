package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import hust.soict.dsai.aims.cart.Cart;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CartScreenController {
	private Cart cart;
	@FXML
	private Button btnPlay;
	@FXML
	private Button btnRemove;
	@FXML
	private Button btnPlaceOrder;
    @FXML
    private TableView<Media> tblMedia;
    @FXML
    private TextField totalCostValue;
    @FXML
    private TableColumn<Media, Float> colMediaCost;
    @FXML
    private TableColumn<Media, String> colMediaTitle;
    @FXML
    private TableColumn<Media, String> colMediacategory;

    public CartScreenController(Cart cart) {
    	super();
    	this.cart = cart;
    }
    
    @FXML
    private void initialize() {
    	colMediaTitle.setCellValueFactory(new PropertyValueFactory<Media, String>("title"));
    	colMediacategory.setCellValueFactory(new PropertyValueFactory<Media, String>("category"));
    	colMediaCost.setCellValueFactory(new PropertyValueFactory<Media, Float>("Cost"));
    	tblMedia.setItems(this.cart.getItemsInCart());
    	
    	btnPlay.setVisible(false);
    	btnRemove.setVisible(false);
    	
    	tblMedia.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Media>() {
    		
    		@Override
    		public void changed(ObservableValue<? extends Media> observable, Media oldValue, Media newValue) {
    			if (newValue != null) {
    				updateButtonBar(newValue);
    			}
    		}
    	});
    	// Calculate and display the total cost
        float totalCost = calculateTotalCost();
        totalCostValue.setText(String.valueOf(totalCost));
    	
    }
    
    void updateButtonBar(Media media) {
    	btnRemove.setVisible(true);
    	if (media instanceof Playable) {
    		btnPlay.setVisible(true);
    	}
    	else { btnPlay.setVisible(false);
    }
    }
    
    @FXML
    void btnRemovePressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	cart.removeMedia(media);
    	// Recalculate and update the total cost
        float totalCost = calculateTotalCost();
        totalCostValue.setText(String.valueOf(totalCost));
    }
    
    	
    @FXML
    void btnPlaceOrderPressed(ActionEvent event) {
        // Create a dialog to display the total cost
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Place Order");
        alert.setHeaderText(null);
        alert.setContentText("Total Cost: " + totalCostValue.getText());
        alert.showAndWait();
    }


    @FXML
    void btnPlayPressed(ActionEvent event) {
    	Media media = tblMedia.getSelectionModel().getSelectedItem();
    	// Show an alert to play the media
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Play Media");
        alert.setHeaderText("Playing Media");
        alert.setContentText(media.getTitle());
        alert.showAndWait();
    }
    
    float calculateTotalCost() {
        float totalCost = 0.0f;
        for (Media media : cart.getItemsInCart()) {
            totalCost += media.getCost();
        }
        return totalCost;
    }
}
