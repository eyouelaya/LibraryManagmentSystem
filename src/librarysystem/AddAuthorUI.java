
package librarysystem;

import Utils.TextFieldUsername;
import Utils.UIUtils;
import business.Address;
import business.Author;
import business.SystemController;

import javax.swing.*;
import java.awt.*;


public class AddAuthorUI extends JFrame {

    private JLabel title;
    private JPanel topPanel,bottomPanel,middlePanel, mainPanel;
    private JButton addAuthorBtn;
    private JLabel firstName;
    private TextFieldUsername firstNameTextField, lastNameText,phoneNumberText,cityText,stateText,zipText,streetText,shortBioText;;
    private JLabel lastName;

    private JLabel phoneNumber;
    private JLabel city;
    private JLabel state;
    private JLabel zip;
    private JLabel street;
    private JLabel shortBio;

    public AddAuthorUI() {
        initComponents();
    }

    private void initComponents() {
        title = new JLabel("Add Author");
        title.setFont(UIUtils.FONT_GENERAL_UI);
        title.setForeground(Color.white);

        addAuthorBtn = new JButton("Add Author");
        addAuthorBtn.setFont(new Font("Arial", Font.PLAIN, 16));
        addAuthorBtn.setBackground(new Color(0, 128, 0));
        addAuthorBtn.setOpaque(true);
        addAuthorBtn.setBorderPainted(false);
        addAuthorBtn.setForeground(Color.WHITE);

        firstName = new JLabel("First Name");
        firstName.setFont(UIUtils.FONT_GENERAL_UI);
        firstName.setForeground(Color.white);
        firstNameTextField = new TextFieldUsername();
        lastName = new JLabel("Last Name");
        lastName.setFont(UIUtils.FONT_GENERAL_UI);
        lastName.setForeground(Color.white);
        lastNameText = new TextFieldUsername();
        phoneNumber = new JLabel("Phone Number");
        phoneNumber.setForeground(Color.white);
        phoneNumber.setFont(UIUtils.FONT_GENERAL_UI);
        phoneNumberText = new TextFieldUsername();
        city = new JLabel("City");
        city.setFont(UIUtils.FONT_GENERAL_UI);
        city.setForeground(Color.white);
        cityText = new TextFieldUsername();
        state = new JLabel("State");
        state.setFont(UIUtils.FONT_GENERAL_UI);
        state.setForeground(Color.white);
        stateText = new TextFieldUsername();
        zip = new JLabel("Zip");
        zip.setFont(UIUtils.FONT_GENERAL_UI);
        zip.setForeground(Color.white);
        zipText = new TextFieldUsername();
        street = new JLabel("Street");
        street.setFont(UIUtils.FONT_GENERAL_UI);
        street.setForeground(Color.white);
        streetText = new TextFieldUsername();
        shortBio = new JLabel("Short Bio");
        shortBio.setFont(UIUtils.FONT_GENERAL_UI);
        shortBio.setForeground(Color.white);
        shortBioText = new TextFieldUsername();
        middlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel= new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));


        JPanel inputPanel = new JPanel(new GridLayout(5,4,10,10));
        JPanel secondRow = new JPanel();
        JPanel thirdRow = new JPanel();

        inputPanel.add(firstName);
        inputPanel.add(firstNameTextField);
        inputPanel.add(lastName);
        inputPanel.add(lastNameText);
        inputPanel.add(phoneNumber);
        inputPanel.add(phoneNumberText);
        inputPanel.add(city);
        inputPanel.add(cityText);
        inputPanel.add(state);
        inputPanel.add(stateText);
        inputPanel.add(zip);
        inputPanel.add(zipText);
        inputPanel.add(street);
        inputPanel.add(streetText);
        inputPanel.add(shortBio);
        inputPanel.add(shortBioText);

        topPanel.add(title);
        middlePanel.add(inputPanel);
        bottomPanel.add(addAuthorBtn);
        mainPanel.add(topPanel);
        mainPanel.add(middlePanel);
        mainPanel.add(bottomPanel);

        add(mainPanel);

        inputPanel.setBackground(UIUtils.COLOR_BACKGROUND);
        topPanel.setBackground(UIUtils.COLOR_BACKGROUND);
        bottomPanel.setBackground(UIUtils.COLOR_BACKGROUND);
        middlePanel.setBackground(UIUtils.COLOR_BACKGROUND);
        mainPanel.setBackground(UIUtils.COLOR_BACKGROUND);

//        contentPane.add(panel11, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        setBackground(UIUtils.COLOR_BACKGROUND);
        setSize(GuiProperties.SCREEN_WIDTH, GuiProperties.SCREEN_HEIGHT);
        GuiProperties.centerFrameOnDesktop(this);
        handle();
    }

    private void handle() {
        addAuthorBtn.addActionListener(e -> {

            String state = stateText.getText();
            String city = cityText.getText();
            String street = streetText.getText();

            Address address = new Address(street, city, state, zipText.getText());
            String lastName = lastNameText.getText();
            String phoneNumber = phoneNumberText.getText();
            String firstName = firstNameTextField.getText();
            String shortBio = shortBioText.getText();

            if (!(state.isEmpty() &&
                    city.isEmpty() &&
                    street.isEmpty() &&
                    lastName.isEmpty() &&
                    firstName.isEmpty() &&
                    phoneNumber.isEmpty() &&
                    shortBio.isEmpty()
            )) {
                Author author = new Author(firstName,
                        lastName,
                        phoneNumber,
                        address,
                        shortBio);
                SystemController.getInstance().addAuthors(author);

                stateText.setText("");
                cityText.setText("");
                streetText.setText("");
                lastNameText.setText("");
                phoneNumberText.setText("");
                firstNameTextField.setText("");
                shortBioText.setText("");
                zipText.setText("");

            } else JOptionPane.showMessageDialog(AddAuthorUI.this, "Provide all data");


        });
    }


}
