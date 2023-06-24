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
        setTitle("Add Book to Store");
        setSize(400, 250);
    }

    @Override
    protected JPanel createFormPanel() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel titleLabel = new JLabel("Title:");
        titleTextField = new JTextField();
        JLabel categoryLabel = new JLabel("Category:");
        categoryTextField = new JTextField();
        JLabel costLabel = new JLabel("Cost:");
        costTextField = new JTextField();

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
