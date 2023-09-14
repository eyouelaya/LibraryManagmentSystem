package librarysystem;

import business.SystemController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnBookUI extends JFrame {
    private JButton getStatusButton, returnButton;
    private JLabel memberID, bookISBN, bookStatus;
    private JTextField memberIDInput, bookISBNInput, bookStatusOutput;
    private JPanel returnInput,mainPanel;

    public ReturnBookUI() throws HeadlessException {
        initComponents();
//        handle();
    }

    private void initComponents(){
        memberID = new JLabel("Input Member ID");
        memberIDInput = new JTextField(10);
        bookISBN = new JLabel("Input Book ISBN");
        bookISBNInput = new JTextField(13);
        getStatusButton=new JButton("Show");
        returnButton = new JButton("Returned");
        returnInput = new JPanel();
        mainPanel = new JPanel();
        bookStatus = new JLabel("Book Status");
        bookStatusOutput = new JTextField(10);
        bookStatusOutput.setEditable(false);

        returnInput.setLayout(new GridLayout(5,2,4,4));
        returnInput.add(memberID);
        returnInput.add(memberIDInput);
        returnInput.add(bookISBN);
        returnInput.add(bookISBNInput);
        returnInput.add(bookStatus);
        returnInput.add(bookStatusOutput);
        returnInput.add(getStatusButton);
        returnInput.add(returnButton);
        mainPanel.add(returnInput);
        add(mainPanel);
        setSize(GuiProperties.SCREEN_WIDTH, GuiProperties.SCREEN_HEIGHT);
        GuiProperties.centerFrameOnDesktop(this);
    }

    private void handle(){
        getStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberId = memberIDInput.getText();
                String isbn = bookISBNInput.getText();
//                if ((!memberId.isEmpty() && !isbn.isEmpty()))
                 //   SystemController.getInstance().due(memberId,isbn, ReturnBookUI.this);
//                else JOptionPane.showMessageDialog(ReturnBookUI.this, "Please fill out all fields.");
 }
        });

        bookStatusOutput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }

    public void displayBookUnavailable() {
        JOptionPane.showMessageDialog(this, "Book not available");
    }

    public void displayMemberUnavailable() {
        JOptionPane.showMessageDialog(this, "Member not available");
    }

    public void displayPayementSuccess() {
        JOptionPane.showMessageDialog(this, "due payment success");
    }
}
