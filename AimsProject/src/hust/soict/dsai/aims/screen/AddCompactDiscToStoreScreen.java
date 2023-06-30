package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store;

import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {

    private JTextField titleTextField;
    private JTextField categoryTextField;
    private JTextField directorTextField;
    private JTextField lengthTextField;
    private JTextField costTextField;

    public AddCompactDiscToStoreScreen(Store store) {
        super(store);
        Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		cp.add(createButtonPanel(),BorderLayout.SOUTH);
		setVisible(true);
		setTitle("Add CD To Store Screen");
		setSize(600,400);
    }

    @Override
    protected JPanel createCenter() {
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel titleLabel = new JLabel("Title:");
        titleTextField = new JTextField();
        JLabel categoryLabel = new JLabel("Category:");
        categoryTextField = new JTextField();
        JLabel directorLabel = new JLabel("Director:");
        directorTextField = new JTextField();
        JLabel lengthLabel = new JLabel("Length:");
        lengthTextField = new JTextField();
        JLabel costLabel = new JLabel("Cost:");
        costTextField = new JTextField();

        formPanel.add(titleLabel);
        formPanel.add(titleTextField);
        formPanel.add(categoryLabel);
        formPanel.add(categoryTextField);
        formPanel.add(directorLabel);
        formPanel.add(directorTextField);
        formPanel.add(lengthLabel);
        formPanel.add(lengthTextField);
        formPanel.add(costLabel);
        formPanel.add(costTextField);

        return formPanel;
    }

    @Override
    protected CompactDisc getItem() {
        String title = titleTextField.getText();
        String category = categoryTextField.getText();
        String director = directorTextField.getText();
        int length = Integer.parseInt(lengthTextField.getText());
        float cost = Float.parseFloat(costTextField.getText());

        if (title.isEmpty() || category.isEmpty() || director.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all fields.", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        return new CompactDisc(title, category, director, length, cost);
    }
}
