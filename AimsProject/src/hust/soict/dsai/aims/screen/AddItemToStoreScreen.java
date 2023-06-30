package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.screen.StoreScreen.addBookListener;
import hust.soict.dsai.aims.screen.StoreScreen.addCdListener;
import hust.soict.dsai.aims.screen.StoreScreen.addDvdListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AddItemToStoreScreen extends JFrame {

    protected Store store;
    protected Cart cart;
    public AddItemToStoreScreen(Store store) {
        this.store = store;
    }

    protected abstract JPanel createCenter();
    
    JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
    
    JMenuBar createMenuBar() {
  	  JMenu menu = new JMenu("Options");
  	
  	  JMenu smUpdateStore = new JMenu("Update Store");
  	  
  	  JMenuItem addBook = new JMenuItem("Add Book");
  	  smUpdateStore.add(addBook);
  	  addBook.addActionListener(new addBookListener());
  	  
  	  JMenuItem addCd = new JMenuItem("Add CD");
  	  smUpdateStore.add(addCd);
  	  addCd.addActionListener(new addCdListener());
  	  
  	  JMenuItem addDvd = new JMenuItem("Add DVD");
  	  smUpdateStore.add(addDvd);
  	  addDvd.addActionListener(new addDvdListener());
  	
  	  menu.add(smUpdateStore);
  	  JMenuItem viewStore = new JMenuItem("View Store");
      menu.add(viewStore);
      viewStore.addActionListener(new ViewStoreListener());
  	
  	  JMenuBar menuBar = new JMenuBar();
  	  menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
  	  menuBar.add(menu);
  	
  	  return menuBar;
  	}
    JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		header.add(Box.createRigidArea(new Dimension(10,10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		
		return header;	
	}
    
    private class addBookListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new AddBookToStoreScreen(store);
        }
    }

    private class addCdListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new AddCompactDiscToStoreScreen(store);
        }
    }

    private class addDvdListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new AddDigitalVideoDiscToStoreScreen(store);
        }
    }
    protected class ViewStoreListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
            new StoreScreen(store, cart);
        }
    }
    
    protected JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton addButton = new JButton("Add");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Media item = getItem();
                if (item != null) {
                    store.addMedia(item);
                    JOptionPane.showMessageDialog(null, "Item added to store successfully.", "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                    new StoreScreen(store, cart);
                }
            }
        });

        JButton cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new StoreScreen(store, cart);
            }
        });

        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);

        return buttonPanel;
    }

    protected abstract Media getItem();
}
