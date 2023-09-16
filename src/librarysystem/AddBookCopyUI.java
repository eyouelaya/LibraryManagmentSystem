package librarysystem;

import Toaster.Toaster;
import Utils.TextFieldUsername;
import Utils.UIUtils;
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
    private TextFieldUsername copyNumberTextField;
    private JLabel isbnLabel;
    private TextFieldUsername isbnTextField;
    private JButton addButton;
    private JLabel submitButton;

    private UIUtils uiUtils = new UIUtils();

    public AddBookCopyUI() {
        initComponents();
    }

    private void initComponents() {
        setTitle("Add Book Copy");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        setSize(400, 200);
        setLocationRelativeTo(null);
        setResizable(false);

        // Title Label
        titleLabel = new JLabel("Add Book Copy");
        titleLabel.setFont(UIUtils.FONT_GENERAL_UI);
        titleLabel.setForeground(Color.white);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Main Panel
        mainPanel = new JPanel(new GridLayout(3,1,10,10));
        toaster = new Toaster(mainPanel);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Input Panel
        inputPanel = new JPanel(new GridLayout(3, 2, 10, 10));

        // Copy Number Input
        copyNumberLabel = new JLabel("Copy Number:");
        copyNumberLabel.setFont(UIUtils.FONT_GENERAL_UI);
        copyNumberLabel.setForeground(Color.white);
        copyNumberTextField = new TextFieldUsername();
        copyNumberTextField.setColumns(10);

        // ISBN Input
        isbnLabel = new JLabel("ISBN:");
        isbnLabel.setFont(UIUtils.FONT_GENERAL_UI);
        isbnLabel.setForeground(Color.white);
        isbnTextField = new TextFieldUsername();
        isbnTextField.setColumns(10);

        submitButton = uiUtils.createCustomLabel("Add Copy", e -> { addCopyButtonClicked();});

        JLabel x= new  JLabel("x");
        x.setForeground(UIUtils.COLOR_BACKGROUND);

        inputPanel.add(copyNumberLabel);
        inputPanel.add(copyNumberTextField);
        inputPanel.add(isbnLabel);
        inputPanel.add(isbnTextField);
        inputPanel.add(x);
        inputPanel.add(submitButton);
        inputPanel.setBackground(UIUtils.COLOR_BACKGROUND);



        // Add components to main panel
        mainPanel.add(titleLabel, BorderLayout.NORTH);
        mainPanel.add(inputPanel, BorderLayout.CENTER);
        mainPanel.setBackground(UIUtils.COLOR_BACKGROUND);

        // Add main panel to the frame
        add(mainPanel);
        setSize(GuiProperties.SCREEN_WIDTH, GuiProperties.SCREEN_HEIGHT);
        GuiProperties.centerFrameOnDesktop(this);
    }

    private void addCopyButtonClicked() {
        String isbn = isbnTextField.getText();
        String copyNumberText = copyNumberTextField.getText();

        if (!isbn.isEmpty() && !copyNumberText.isEmpty()) {
            try {
                int copyNumber = Integer.parseInt(copyNumberText);
                SystemController.getInstance().addBookCopy(isbn, copyNumber, AddBookCopyUI.this);
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

    public void showError(String message) {
        toaster.error(message);
    }

    public void showSuccess(String message) {
        toaster.success(message);
    }


}
