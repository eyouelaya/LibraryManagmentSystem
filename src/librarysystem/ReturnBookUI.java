package librarysystem;

import Utils.TextFieldUsername;
import Utils.UIUtils;
import business.SystemController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnBookUI extends JFrame {
    private JButton getStatusButton, returnButton;
    private JLabel memberID, bookCopyNumber, bookStatus, bookISBN;
    private TextFieldUsername memberIDInput, bookCopyNumberInput, bookStatusOutput, bookISBNInput;
    private JPanel returnInput, mainPanel;

    public ReturnBookUI() throws HeadlessException {
        initComponents();
        handle();
    }

    private void initComponents() {
        memberID = new JLabel("Input Member ID");
        memberID.setForeground(Color.white);
        memberID.setFont(UIUtils.FONT_GENERAL_UI);
        memberIDInput = new TextFieldUsername();
        memberIDInput.setColumns(10);
        bookCopyNumber = new JLabel("Input Book Copy Number");
        bookCopyNumber.setFont(UIUtils.FONT_GENERAL_UI);
        bookCopyNumber.setForeground(Color.white);
        bookCopyNumberInput = new TextFieldUsername();
        bookCopyNumberInput.setColumns(13);
        getStatusButton = new JButton("Show");
        getStatusButton.setBackground(UIUtils.COLOR_OUTLINE);
        returnButton = new JButton("Return");
        returnButton.setBackground(UIUtils.COLOR_INTERACTIVE_DARKER);
        returnInput = new JPanel();
        mainPanel = new JPanel();
        bookStatus = new JLabel("Book Fee Due");
        bookStatus.setFont(UIUtils.FONT_GENERAL_UI);
        bookStatus.setForeground(Color.white);
        bookStatusOutput = new TextFieldUsername();
        bookStatusOutput.setColumns(10);
        bookISBN = new JLabel("Input Book ISBN");
        bookISBN.setFont(UIUtils.FONT_GENERAL_UI);
        bookISBN.setForeground(Color.white);
        bookISBNInput = new TextFieldUsername();
        bookISBNInput.setColumns(13);
        bookStatusOutput.setEditable(false);

        returnInput.setLayout(new GridLayout(6, 2, 4, 4));
        returnInput.add(memberID);
        returnInput.add(memberIDInput);
        returnInput.add(bookCopyNumber);
        returnInput.add(bookCopyNumberInput);
        returnInput.add(bookISBN);
        returnInput.add(bookISBNInput);
        returnInput.add(bookStatus);
        returnInput.add(bookStatusOutput);
        returnInput.add(getStatusButton);
        returnInput.add(returnButton);
        returnInput.setBackground(UIUtils.COLOR_BACKGROUND);
        mainPanel.add(returnInput);
        add(mainPanel);
        mainPanel.setBackground(UIUtils.COLOR_BACKGROUND);
        setBackground(UIUtils.COLOR_BACKGROUND);
        setSize(GuiProperties.SCREEN_WIDTH, GuiProperties.SCREEN_HEIGHT);
        GuiProperties.centerFrameOnDesktop(this);
        returnButton.setEnabled(false);
    }

    private void handle() {
        getStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberId = memberIDInput.getText();
                String bookCopyNumber = bookCopyNumberInput.getText();
                String bookISBN = bookISBNInput.getText();

                if ((!memberId.isEmpty() && !bookCopyNumber.isEmpty() && !bookISBN.isEmpty())) {
                    bookStatusOutput.setText(SystemController.getInstance().showBookFine(memberId, bookISBN, bookCopyNumber, ReturnBookUI.this));
                } else JOptionPane.showMessageDialog(ReturnBookUI.this, "Please fill out all fields.");
                returnButton.setEnabled(true);
            }
        });

        returnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String memberId = memberIDInput.getText();
                String bookISBN = bookISBNInput.getText();
                String bookCopyNumber = bookCopyNumberInput.getText();

                if ((!memberId.isEmpty() && !bookCopyNumber.isEmpty() && !bookCopyNumber.isEmpty()))
                    SystemController.getInstance().due(memberId, bookISBN, bookCopyNumber, ReturnBookUI.this);
                else JOptionPane.showMessageDialog(ReturnBookUI.this, "Please fill out all fields.");
                returnButton.setEnabled(false);
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
