package librarysystem;

import Toaster.Toaster;
import business.SystemController;

import javax.swing.*;
import java.awt.*;


public class AddMemberUI extends JFrame {
    private Toaster toaster;
    public AddMemberUI() {
        initComponents();
    }
    private JLabel label1;
    private JPanel panel1;
    private JPanel panel4;
    private JLabel label4;
    private JTextField memberID;
    private JPanel panel3;
    private JLabel label3;
    private JTextField firstName;
    private JPanel panel2;
    private JLabel label2;
    private JTextField lastName;
    private JPanel panel6;
    private JLabel label6;
    private JTextField phoneNumber;
    private JPanel panel5;
    private JLabel label5;
    private JTextField state;
    private JPanel panel7;
    private JLabel label7;
    private JTextField city;
    private JPanel panel8;
    private JLabel label8;
    private JTextField zip;
    private JPanel panel9;
    private JLabel label9;
    private JTextField street;
    private JButton addNewMember;
    private void initComponents() {
        label1 = new JLabel();
        panel1 = new JPanel();
        toaster = new Toaster(panel1);
        panel4 = new JPanel();
        label4 = new JLabel();
        memberID = new JTextField();
        panel3 = new JPanel();
        label3 = new JLabel();
        firstName = new JTextField();
        panel2 = new JPanel();
        label2 = new JLabel();
        lastName = new JTextField();
        panel6 = new JPanel();
        label6 = new JLabel();
        phoneNumber = new JTextField();
        panel5 = new JPanel();
        label5 = new JLabel();
        state = new JTextField();
        panel7 = new JPanel();
        label7 = new JLabel();
        city = new JTextField();
        panel8 = new JPanel();
        label8 = new JLabel();
        zip = new JTextField();
        panel9 = new JPanel();
        label9 = new JLabel();
        street = new JTextField();
        addNewMember = new JButton();


        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(8, 8));



        label1.setText("Add new member");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1, BorderLayout.NORTH);



        {
            panel1.setLayout(new FlowLayout());


            {
                panel4.setLayout(new FlowLayout());



                label4.setText("Member ID");
                panel4.add(label4);


                memberID.setColumns(10);
                panel4.add(memberID);



                {
                    panel3.setLayout(new FlowLayout());

                    //---- label3 ----
                    label3.setText("First Name");
                    panel3.add(label3);

                    //---- firstName ----
                    firstName.setColumns(10);
                    panel3.add(firstName);
                }
                panel4.add(panel3);
            }
            panel1.add(panel4);

            //======== panel2 ========
            {
                panel2.setLayout(new FlowLayout());

                //---- label2 ----
                label2.setText("Last Name");
                panel2.add(label2);

                //---- lastName ----
                lastName.setColumns(10);
                panel2.add(lastName);

                //======== panel6 ========
                {
                    panel6.setLayout(new FlowLayout());

                    //---- label6 ----
                    label6.setText("Phone number");
                    panel6.add(label6);

                    //---- phoneNumber ----
                    phoneNumber.setColumns(10);
                    panel6.add(phoneNumber);
                }
                panel2.add(panel6);
            }
            panel1.add(panel2);

            //======== panel5 ========
            {
                panel5.setLayout(new FlowLayout());

                //---- label5 ----
                label5.setText("State");
                panel5.add(label5);

                //---- state ----
                state.setColumns(10);
                panel5.add(state);
            }
            panel1.add(panel5);

            //======== panel7 ========
            {
                panel7.setLayout(new FlowLayout());

                //---- label7 ----
                label7.setText("City");
                panel7.add(label7);

                //---- city ----
                city.setColumns(10);
                panel7.add(city);
            }
            panel1.add(panel7);

            //======== panel8 ========
            {
                panel8.setLayout(new FlowLayout());

                //---- label8 ----
                label8.setText("Zip");
                panel8.add(label8);

                //---- zip ----
                zip.setColumns(10);
                panel8.add(zip);
            }
            panel1.add(panel8);

            //======== panel9 ========
            {
                panel9.setLayout(new FlowLayout());

                //---- label9 ----
                label9.setText("street");
                panel9.add(label9);

                //---- street ----
                street.setColumns(10);
                panel9.add(street);
            }
            panel1.add(panel9);
        }
        contentPane.add(panel1, BorderLayout.CENTER);

        //---- addNewMember ----
        addNewMember.setText("Add new member");
        contentPane.add(addNewMember, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(getOwner());
        setSize(GuiProperties.SCREEN_WIDTH, GuiProperties.SCREEN_HEIGHT);
        GuiProperties.centerFrameOnDesktop(this);


        handle();
    }

    private void handle() {
        addNewMember.addActionListener(e -> {
            String firstNameText = firstName.getText();
            String lastNameText = lastName.getText();
            String phoneNumberText = phoneNumber.getText();
            String stateText = state.getText();
            String streetText = street.getText();
            String memberIDText = memberID.getText();
            String cityText = city.getText();
            String zipText = zip.getText();

            if (!(firstNameText.isEmpty() &&
                    lastNameText.isEmpty() &&
                    phoneNumberText.isEmpty() &&
                    stateText.isEmpty() &&
                    streetText.isEmpty() &&
                    memberIDText.isEmpty() &&
                    cityText.isEmpty() &&
                    zipText.isEmpty())) {

                SystemController.getInstance().addMember(
                        memberIDText,
                        firstNameText,
                        lastNameText,
                        phoneNumberText,
                        stateText,
                        streetText,
                        cityText,
                        zipText);
            } else toaster.error("All fields are required");
        });
    }



}
