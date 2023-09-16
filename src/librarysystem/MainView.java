package librarysystem;

import Utils.UIUtils;
import dataaccess.Auth;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import librarysystem.AddBookUI;

public class MainView extends JFrame {

    private Auth role;
    private JLabel logoutButton,addBook, addMember, checkOutBook, addBookCopy, printCheckoutRecord, returnBook, getOverDueBooks;
    private UIUtils uiUtils = new UIUtils();

    MainView(Auth role) {
        this.role = role;
        initComponents();
        handle();
    }

    private void initComponents() {
        setTitle("Library System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);

        EmptyBorder paddingBorder = new EmptyBorder(10, 10, 10, 10);

        JPanel mainPanel = new JPanel(new GridLayout(6, 1));
        addBook = uiUtils.createCustomLabel("\uD83D\uDCDA  Add Book", e -> { new AddBookUI().setVisible(true);});
        addBook.setBorder(paddingBorder);
        addBookCopy = uiUtils.createCustomLabel("\uD83D\uDCD6 Add Book Copy", e -> {new AddBookCopyUI().setVisible(true);});
        addBookCopy.setBorder(paddingBorder);
        addMember = uiUtils.createCustomLabel("\uD83D\uDC64 Add Member", e -> { new AddMemberUI().setVisible(true);});
        addMember.setBorder(paddingBorder);
        checkOutBook = uiUtils.createCustomLabel("\uD83D\uDCD7 Book Checkout", e -> { new CheckOutUIForm().setVisible(true);});
        checkOutBook.setBorder(paddingBorder);
        printCheckoutRecord = uiUtils.createCustomLabel("\uD83D\uDDA8 Print Checkout Record", e -> {  new CheckoutRecordPrintUI().setVisible(true);});
        printCheckoutRecord.setBorder(paddingBorder);
        returnBook = uiUtils.createCustomLabel("\uD83D\uDCD3 Return Book", e -> {new ReturnBookUI().setVisible(true);});
        returnBook.setBorder(paddingBorder);
        getOverDueBooks = uiUtils.createCustomLabel("\uD83D\uDCD3 Get Overdue Book", e -> { new GetOverDueUI().setVisible(true);});
        getOverDueBooks.setBorder(paddingBorder);

        logoutButton = uiUtils.createCustomLabel("\uD83D\uDCD3 LogOut", e -> {
            MainView.this.setVisible(false);
            new LoginUI().setVisible(true);});
        logoutButton.setBorder(paddingBorder);
        logoutButton.setBackground(UIUtils.COLOR_OUTLINE);

        setSize(GuiProperties.SCREEN_WIDTH, GuiProperties.SCREEN_HEIGHT);
        GuiProperties.centerFrameOnDesktop(this);
        mainPanel.add(addBook);
        mainPanel.add(addBookCopy);
        mainPanel.add(addMember);
        mainPanel.add(checkOutBook);
        mainPanel.add(printCheckoutRecord);
        mainPanel.add(returnBook);
        mainPanel.add(getOverDueBooks);
        mainPanel.add(logoutButton);
        mainPanel.setBackground(UIUtils.COLOR_BACKGROUND);

        switch (role) {
            case LIBRARIAN:
                addMember.setVisible(false);
                addBook.setVisible(false);
                addBookCopy.setVisible(false);
                break;
            case ADMIN:
                checkOutBook.setVisible(false);
                returnBook.setVisible(false);
                printCheckoutRecord.setVisible(false);
                getOverDueBooks.setVisible(false);
                break;
        }

        add(mainPanel);
    }



    private void handle() {
    }


}
