package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
	private JTextField idTextField;
    private JTextField titleTextField;
    private JTextField categoryTextField;
    private JTextField costTextField;

    public AddBookToStoreScreen(Store store) {
        super(store);
        Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		cp.add(createButtonPanel(),BorderLayout.SOUTH);
		setVisible(true);
		setTitle("Add Book To Store Screen");
		setSize(600,400);
    }

    @Override
    protected JPanel createCenter() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2, 10, 10));
        
        JLabel idLabel = new JLabel("Id:");
        idTextField = new JTextField();
        JLabel titleLabel = new JLabel("Title:");
        titleTextField = new JTextField();
        JLabel categoryLabel = new JLabel("Category:");
        categoryTextField = new JTextField();
        JLabel costLabel = new JLabel("Cost:");
        costTextField = new JTextField();
        
        formPanel.add(idLabel);
        formPanel.add(idTextField);
        formPanel.add(titleLabel);
        formPanel.add(titleTextField);
        formPanel.add(categoryLabel);
        formPanel.add(categoryTextField);
        formPanel.add(costLabel);
        formPanel.add(costTextField);

        return formPanel;
    }

    @Override
    protected Book getItem() {
    	String id = idTextField.getText();
    	int number = Integer.parseInt(id);
        String title = titleTextField.getText();
        String category = categoryTextField.getText();
        float cost = Float.parseFloat(costTextField.getText());

        if (title.isEmpty() || category.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        return new Book(number, title, category, cost);
    }

}
