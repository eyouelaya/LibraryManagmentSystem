package librarysystem;

import business.SystemController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnBookUI extends JFrame {
    private JButton getStatusButton, returnButton;
    private JLabel memberID, bookCopyNumber, bookStatus;
    private JTextField memberIDInput, bookCopyNumberInput, bookStatusOutput;
    private JPanel returnInput,mainPanel;

    public ReturnBookUI() throws HeadlessException {
        initComponents();
//        handle();
    }

    private void initComponents(){
        memberID = new JLabel("Input Member ID");
        memberIDInput = new JTextField(10);
        bookCopyNumber = new JLabel("Input Book Copy Number");
        bookCopyNumberInput = new JTextField(13);
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
        returnInput.add(bookCopyNumber);
        returnInput.add(bookCopyNumberInput);
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
                String bookCopyNumber = bookCopyNumberInput.getText();
                if ((!memberId.isEmpty() && !bookCopyNumber.isEmpty()))
                    SystemController.getInstance().due(memberId,bookCopyNumber, ReturnBookUI.this);
                else JOptionPane.showMessageDialog(ReturnBookUI.this, "Please fill out all fields.");
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

    public void displayDuePayementSuccess() {
        JOptionPane.showMessageDialog(this, "due payment success");
    }
}
