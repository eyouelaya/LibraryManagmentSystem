package librarysystem;

import Toaster.Toaster;
import business.SystemController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookCopyUI extends JFrame {
    private Toaster toaster;
    private JLabel titleLabel;
    private JPanel mainPanel;
    private JPanel inputPanel;
    private JLabel copyNumberLabel;
    private JTextField copyNumberTextField;
    private JLabel isbnLabel;
    private JTextField isbnTextField;
    private JButton addButton;

    public AddBookCopyUI() {
        initComponents();
        handle();
    }

    private void initComponents() {
        setTitle("Add Book Copy");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);

        // Title Label
        titleLabel = new JLabel("Add Book Copy");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Main Panel
        mainPanel = new JPanel(new BorderLayout());
        toaster = new Toaster(mainPanel);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Input Panel
        inputPanel = new JPanel(new GridLayout(2, 2, 10, 10));

        // Copy Number Input
        copyNumberLabel = new JLabel("Copy Number:");
        copyNumberTextField = new JTextField(10);

        // ISBN Input
        isbnLabel = new JLabel("ISBN:");
        isbnTextField = new JTextField(10);

        inputPanel.add(copyNumberLabel);
        inputPanel.add(copyNumberTextField);
        inputPanel.add(isbnLabel);
        inputPanel.add(isbnTextField);

        // Add Button
        addButton = new JButton("Add Copy");
        addButton.setFont(new Font("Arial", Font.PLAIN, 16));
        addButton.setBackground(new Color(0, 128, 0));
        addButton.setForeground(Color.WHITE);

        // Add components to main panel
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.add(addButton, BorderLayout.SOUTH);

        // Add main panel to the frame
        add(mainPanel);
        setSize(GuiProperties.SCREEN_WIDTH, GuiProperties.SCREEN_HEIGHT);
        GuiProperties.centerFrameOnDesktop(this);
    }
    private void handle(){

        // Handle button click event
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addCopyButtonClicked();
            }
        });
    }

    private void addCopyButtonClicked() {
        String isbn = isbnTextField.getText();
        String copyNumberText = copyNumberTextField.getText();

        if (!isbn.isEmpty() && !copyNumberText.isEmpty()) {
            try {
                int copyNumber = Integer.parseInt(copyNumberText);
                SystemController.getInstance().addBookCopy(isbn, copyNumber);
                toaster.success("Book Copy Added Successfully.");
                clearInputs();
            } catch (NumberFormatException e) {
                showError("Copy Number must be a numeric value.");
            }
        } else {
            showError("Please fill in all fields.");
        }
    }

    private void clearInputs() {
        isbnTextField.setText("");
        copyNumberTextField.setText("");
    }

    private void showError(String message) {
        toaster.error("All fields required");
    }


}
