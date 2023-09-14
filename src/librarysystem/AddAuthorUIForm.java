
package librarysystem;

import business.Address;
import business.Author;
import business.SystemController;

import javax.swing.*;
import java.awt.*;


public class AddAuthorUIForm extends JFrame {

    private JLabel label1;
    private JPanel panel21;
    private JButton addAuthorBtn;
    private JPanel panel11;
    private JPanel panel12;
    private JLabel label2;
    private JTextField firstNameTextField;
    private JPanel panel13;
    private JLabel label3;
    private JTextField lastNameText;
    private JPanel panel14;
    private JLabel label4;
    private JTextField phoneNumberText;
    private JPanel panel15;
    private JLabel label5;
    private JTextField cityText;
    private JPanel panel16;
    private JLabel label6;
    private JTextField stateText;
    private JPanel panel17;
    private JLabel label7;
    private JTextField zipText;
    private JPanel panel18;
    private JLabel label8;
    private JTextField streetText;
    private JPanel panel19;
    private JLabel label9;
    private JPanel panel20;
    private JLabel label10;
    private JTextField shortBioText;

    public AddAuthorUIForm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ali ziwa
        label1 = new JLabel();
        panel21 = new JPanel();
        addAuthorBtn = new JButton();
        panel11 = new JPanel();
        panel12 = new JPanel();
        label2 = new JLabel();
        firstNameTextField = new JTextField();
        panel13 = new JPanel();
        label3 = new JLabel();
        lastNameText = new JTextField();
        panel14 = new JPanel();
        label4 = new JLabel();
        phoneNumberText = new JTextField();
        panel15 = new JPanel();
        label5 = new JLabel();
        cityText = new JTextField();
        panel16 = new JPanel();
        label6 = new JLabel();
        stateText = new JTextField();
        panel17 = new JPanel();
        label7 = new JLabel();
        zipText = new JTextField();
        panel18 = new JPanel();
        label8 = new JLabel();
        streetText = new JTextField();
        panel19 = new JPanel();
        label9 = new JLabel();
        panel20 = new JPanel();
        label10 = new JLabel();
        shortBioText = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());

        //---- label1 ----
        label1.setText("Add author");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1, BorderLayout.PAGE_START);

        //======== panel21 ========
        {
            panel21.setLayout(new FlowLayout());

            //---- addAuthorBtn ----
            addAuthorBtn.setText("Add Author");
            panel21.add(addAuthorBtn);
        }
        contentPane.add(panel21, BorderLayout.PAGE_END);

        //======== panel11 ========
        {
            panel11.setLayout(new FlowLayout());

            //======== panel12 ========
            {
                panel12.setMaximumSize(new Dimension(50, 40));
                panel12.setMinimumSize(new Dimension(50, 40));
                panel12.setPreferredSize(null);
                panel12.setAutoscrolls(true);
                panel12.setLayout(new FlowLayout());

                //---- label2 ----
                label2.setText("First name: ");
                panel12.add(label2);

                //---- firstNameTextField ----
                firstNameTextField.setColumns(10);
                panel12.add(firstNameTextField);
            }
            panel11.add(panel12);

            //======== panel13 ========
            {
                panel13.setLayout(new FlowLayout());

                //---- label3 ----
                label3.setText("Last Name: ");
                panel13.add(label3);

                //---- lastNameText ----
                lastNameText.setColumns(10);
                panel13.add(lastNameText);
            }
            panel11.add(panel13);

            //======== panel14 ========
            {
                panel14.setLayout(new FlowLayout());

                //---- label4 ----
                label4.setText("Phone number: ");
                panel14.add(label4);

                //---- phoneNumberText ----
                phoneNumberText.setColumns(10);
                panel14.add(phoneNumberText);
            }
            panel11.add(panel14);

            //======== panel15 ========
            {
                panel15.setLayout(new FlowLayout());

                //---- label5 ----
                label5.setText("City: ");
                panel15.add(label5);

                //---- cityText ----
                cityText.setColumns(10);
                panel15.add(cityText);
            }
            panel11.add(panel15);

            //======== panel16 ========
            {
                panel16.setLayout(new FlowLayout());

                //---- label6 ----
                label6.setText("State: ");
                panel16.add(label6);

                //---- stateText ----
                stateText.setColumns(10);
                panel16.add(stateText);
            }
            panel11.add(panel16);

            //======== panel17 ========
            {
                panel17.setLayout(new FlowLayout());

                //---- label7 ----
                label7.setText("Zip: ");
                panel17.add(label7);

                //---- zipText ----
                zipText.setColumns(10);
                panel17.add(zipText);
            }
            panel11.add(panel17);

            //======== panel18 ========
            {
                panel18.setLayout(new FlowLayout());

                //---- label8 ----
                label8.setText("Street: ");
                panel18.add(label8);

                //---- streetText ----
                streetText.setColumns(10);
                panel18.add(streetText);
            }
            panel11.add(panel18);

            //======== panel19 ========
            {
                panel19.setLayout(new FlowLayout());


                //======== panel20 ========
                {
                    panel20.setLayout(new FlowLayout());

                    //---- label10 ----
                    label10.setText("Short Bio: ");
                    panel20.add(label10);

                    //---- shortBioText ----
                    shortBioText.setColumns(10);
                    panel20.add(shortBioText);
                }
                panel19.add(panel20);
            }
            panel11.add(panel19);
        }
        contentPane.add(panel11, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        setSize(GuiProperties.SCREEN_WIDTH, GuiProperties.SCREEN_HEIGHT);
        GuiProperties.centerFrameOnDesktop(this);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
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

            } else JOptionPane.showMessageDialog(AddAuthorUIForm.this, "Provide all data");


        });
    }


}
