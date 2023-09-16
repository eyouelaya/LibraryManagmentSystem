package librarysystem;

import Utils.CustomWideComboBox;
import Utils.TextFieldUsername;
import Utils.UIUtils;
import business.Author;
import business.SystemController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AddBookUI extends JFrame {
    private JLabel titleLabel;
    private JButton addButton;
    private JPanel mainPanel;
    private JLabel successLabel;
    private JLabel bookTitleLabel;
    private TextFieldUsername bookTitleField;
    private JLabel isbnLabel;
    private TextFieldUsername isbnField;
    private CustomWideComboBox checkoutLengthSelector;
    private JButton addAuthorButton;
    private JLabel checkoutLengthLabel;

    public AddBookUI() {
        initComponents();
        handle();
    }

    private void initComponents() {
        titleLabel = new JLabel("Add Book");
        titleLabel.setForeground(Color.white);
        titleLabel.setFont(UIUtils.FONT_GENERAL_UI);

        addButton = new JButton("Add Book");
        addButton.setBackground(new Color(0, 128, 0));
        addButton.setForeground(Color.WHITE);
        addButton.setFont(new Font("Arial", Font.PLAIN, 16));

        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        successLabel = new JLabel("Book Added Successfully!");
        successLabel.setForeground(new Color(0, 128, 0));
        successLabel.setFont(new Font("Arial", Font.BOLD, 16));
        successLabel.setVisible(false);

        bookTitleLabel = new JLabel("Book Title:");
        bookTitleLabel.setForeground(Color.white);
        bookTitleLabel.setFont(UIUtils.FONT_GENERAL_UI);
        bookTitleField = new TextFieldUsername();
        bookTitleField.setColumns(20);

        isbnLabel = new JLabel("ISBN:");
        isbnLabel.setForeground(Color.white);;
        isbnLabel.setFont(UIUtils.FONT_GENERAL_UI);
        isbnField = new TextFieldUsername();
        isbnField.setColumns(20);

        checkoutLengthLabel = new JLabel("Max Checkout Length:");
        checkoutLengthLabel.setForeground(Color.white);
        checkoutLengthLabel.setFont(UIUtils.FONT_GENERAL_UI);
        DefaultComboBoxModel<Integer> model = new DefaultComboBoxModel<>();
        model.addElement(7);
        model.addElement(21);
        String items [] = {"7","21"};
        checkoutLengthSelector = new CustomWideComboBox(items);

        addAuthorButton = new JButton("Add Authors");
        addAuthorButton.setBackground(new Color(0, 128, 128));
        addAuthorButton.setForeground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(titleLabel, gbc);

        gbc.gridy = 1;
        gbc.gridwidth = 1;
        mainPanel.add(bookTitleLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(bookTitleField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        mainPanel.add(isbnLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(isbnField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        mainPanel.add(checkoutLengthLabel, gbc);

        gbc.gridx = 1;
        mainPanel.add(checkoutLengthSelector, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        mainPanel.add(addAuthorButton, gbc);

        gbc.gridy = 5;
        mainPanel.add(successLabel, gbc);

        gbc.gridy = 6;
        mainPanel.add(addButton, gbc);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(GuiProperties.SCREEN_WIDTH, GuiProperties.SCREEN_HEIGHT);
        mainPanel.setBackground(UIUtils.COLOR_BACKGROUND);
        GuiProperties.centerFrameOnDesktop(this);
    }

    public void handle(){
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = bookTitleField.getText();
                String isbnText = isbnField.getText();
                List<Author> authorsList = SystemController.getInstance().getAuthorsList();
                int checkOutLength = (int) checkoutLengthSelector.getSelectedItem();

                if ((!title.isEmpty() && !isbnText.isEmpty() && !authorsList.isEmpty())) {
                    SystemController.getInstance().addBook(title, isbnText, checkOutLength, authorsList);
                    successLabel.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(AddBookUI.this, "Please provide all information.");
                    successLabel.setVisible(false);
                }
            }
        });

        addAuthorButton.addActionListener(e -> {
            new AddAuthorUI().setVisible(true);
        });

        setLayout(new BorderLayout());
        add(mainPanel, BorderLayout.CENTER);

        setTitle("Library System");

        setVisible(true);

    }

}
