package librarysystem;

import Toaster.Toaster;
import Utils.TextFieldUsername;
import Utils.UIUtils;
import business.LibraryMember;
import business.SystemController;

import javax.swing.*;
import java.awt.*;


public class EditMemberUI extends JFrame {
    private Toaster toaster;
    private JLabel title, memberIdLabel;
    private JPanel topPanel,bottomPanel,middlePanel, mainPanel;
    private JButton addNewMember;
    private JLabel firstName;
    private TextFieldUsername firstNameTextField,memberID, lastNameText,phoneNumberText,cityText,stateText,zipText,streetText;;
    private JLabel lastName;

    private JLabel phoneNumber;
    private JLabel city;
    private JLabel state;
    private JLabel zip;
    private JLabel street;
    private LibraryMember libraryMember;

    public EditMemberUI(LibraryMember libraryMember) {
        this.libraryMember = libraryMember;
        initComponents();
        handle();
    }
    private void initComponents() {



        title = new JLabel("Edit Member");
        title.setFont(UIUtils.FONT_GENERAL_UI);
        title.setForeground(Color.white);

        addNewMember = new JButton("Edit Member");
        addNewMember.setFont(new Font("Arial", Font.PLAIN, 16));
        addNewMember.setBackground(new Color(0, 128, 0));
        addNewMember.setOpaque(true);
        addNewMember.setBorderPainted(false);
        addNewMember.setForeground(Color.WHITE);
        memberIdLabel = new JLabel("Member ID");
        memberIdLabel.setFont(UIUtils.FONT_GENERAL_UI);
        memberIdLabel.setForeground(Color.white);
        memberID = new TextFieldUsername();
        memberID.setEditable(false);
        memberID.setText(libraryMember.getMemberId());
        firstName = new JLabel("First Name");
        firstName.setFont(UIUtils.FONT_GENERAL_UI);
        firstName.setForeground(Color.white);
        firstNameTextField = new TextFieldUsername();
        firstNameTextField.setColumns(10);
        firstNameTextField.setText(libraryMember.getFirstName());
        lastName = new JLabel("Last Name");
        lastName.setFont(UIUtils.FONT_GENERAL_UI);
        lastName.setForeground(Color.white);
        lastNameText = new TextFieldUsername();
        lastNameText.setColumns(10);
        lastNameText.setText(libraryMember.getLastName());
        phoneNumber = new JLabel("Phone Number");
        phoneNumber.setForeground(Color.white);
        phoneNumber.setFont(UIUtils.FONT_GENERAL_UI);
        phoneNumberText = new TextFieldUsername();
        phoneNumberText.setColumns(10);
        phoneNumberText.setText(libraryMember.getTelephone());
        city = new JLabel("City");
        city.setFont(UIUtils.FONT_GENERAL_UI);
        city.setForeground(Color.white);
        cityText = new TextFieldUsername();
        cityText.setColumns(10);
        cityText.setText(libraryMember.getAddress().getCity());
        state = new JLabel("State");
        state.setFont(UIUtils.FONT_GENERAL_UI);
        state.setForeground(Color.white);
        stateText = new TextFieldUsername();
        stateText.setColumns(10);
        stateText.setText(libraryMember.getAddress().getState());
        zip = new JLabel("Zip");
        zip.setFont(UIUtils.FONT_GENERAL_UI);
        zip.setForeground(Color.white);
        zipText = new TextFieldUsername();
        zipText.setColumns(10);
        zipText.setText(libraryMember.getAddress().getZip());
        street = new JLabel("Street");
        street.setFont(UIUtils.FONT_GENERAL_UI);
        street.setForeground(Color.white);
        streetText = new TextFieldUsername();
        streetText.setColumns(10);
        streetText.setText(libraryMember.getAddress().getStreet());
        middlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainPanel= new JPanel();
        toaster = new Toaster(mainPanel);
        mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));


        JPanel inputPanel = new JPanel(new GridLayout(5,4,10,10));
        inputPanel.add(memberIdLabel);
        inputPanel.add(memberID);
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

        topPanel.add(title);
        middlePanel.add(inputPanel);
        bottomPanel.add(addNewMember);
        mainPanel.add(topPanel);
        mainPanel.add(middlePanel);
        mainPanel.add(bottomPanel);

        add(mainPanel);

        inputPanel.setBackground(UIUtils.COLOR_BACKGROUND);
        topPanel.setBackground(UIUtils.COLOR_BACKGROUND);
        bottomPanel.setBackground(UIUtils.COLOR_BACKGROUND);
        middlePanel.setBackground(UIUtils.COLOR_BACKGROUND);
        mainPanel.setBackground(UIUtils.COLOR_BACKGROUND);



        pack();
        setLocationRelativeTo(getOwner());

        setBackground(UIUtils.COLOR_BACKGROUND);
        setSize(GuiProperties.SCREEN_WIDTH, GuiProperties.SCREEN_HEIGHT);
        GuiProperties.centerFrameOnDesktop(this);


    }

    private void handle() {
        addNewMember.addActionListener(e -> {
            String firstNameTextInput = firstNameTextField.getText();
            String lastNameTextInput = lastNameText.getText();
            String phoneNumberTextInput = phoneNumberText.getText();
            String stateTextInput = stateText.getText();
            String streetTextInput = streetText.getText();
            String memberIDTextInput = memberID.getText();
            String cityTextInput = cityText.getText();
            String zipTextInput = zipText.getText();

            if (!(firstNameTextInput.isEmpty() &&
                    lastNameTextInput.isEmpty() &&
                    phoneNumberTextInput.isEmpty() &&
                    stateTextInput.isEmpty() &&
                    streetTextInput.isEmpty() &&
                    memberIDTextInput.isEmpty() &&
                    cityTextInput.isEmpty() &&
                    zipTextInput.isEmpty())) {

                SystemController.getInstance().editMember(
                        memberIDTextInput,
                        firstNameTextInput,
                        lastNameTextInput,
                        phoneNumberTextInput,
                        stateTextInput,
                        cityTextInput,
                        streetTextInput,
                        zipTextInput,
                        EditMemberUI.this);
            } else toaster.error("All fields are required");
        });
    }

    public void displaySuccess(String message){
        toaster.success(message);
        clearFields();
    }
    public void displayError(String message) {
        toaster.error(message);
    }

    private void clearFields(){
        firstNameTextField.setText("");
        lastNameText.setText("");
        phoneNumberText.setText("");
        stateText.setText("");
        streetText.setText("");
        memberID.setText("");
        cityText.setText("");
        zipText.setText("");
    }

}
