package librarysystem;

import Utils.UIUtils;
import dataaccess.Auth;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;

public class MainView extends JFrame {

    private Auth role;
    private JLabel manageLibraryMembers, logoutButton,addBook, addMember, checkOutBook, addBookCopy, printCheckoutRecord, returnBook, getOverDueBooks;
    private UIUtils uiUtils = new UIUtils();
    private JPanel mainPanel;

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

         mainPanel = new JPanel(new GridLayout(6, 1));
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

        manageLibraryMembers = uiUtils.createCustomLabel("\uD83D\uDCD3 Manage Library Members", e -> { new ViewMembersUI(role).setVisible(true);});
        manageLibraryMembers.setBorder(paddingBorder);

        logoutButton = uiUtils.createCustomLogOut("⛔ LogOut", e -> {
            MainView.this.setVisible(false);
            try {
                new LoginUI().setVisible(true);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
        logoutButton.setBorder(paddingBorder);

        setSize(GuiProperties.SCREEN_WIDTH, GuiProperties.SCREEN_HEIGHT);
        GuiProperties.centerFrameOnDesktop(this);
        mainPanel.setBackground(UIUtils.COLOR_BACKGROUND);


        add(mainPanel);
    }



    private void handle() {
        switch (role) {
            case LIBRARIAN:
                mainPanel.add(checkOutBook);
                mainPanel.add(printCheckoutRecord);
                mainPanel.add(returnBook);
                mainPanel.add(getOverDueBooks);
                mainPanel.add(logoutButton);
                mainPanel.setBackground(UIUtils.COLOR_BACKGROUND);


//                addMember.setVisible(false);
//                addMember.setEnabled(false);
//                addBook.setVisible(false);
//                addBookCopy.setVisible(false);
//                manageLibraryMembers.setVisible(false);
                break;
            case ADMIN:
                mainPanel.add(addBook);
                mainPanel.add(addBookCopy);
                mainPanel.add(addMember);
                mainPanel.add(manageLibraryMembers);
                mainPanel.add(logoutButton);
//                checkOutBook.setVisible(false);
//                returnBook.setVisible(false);
//                printCheckoutRecord.setVisible(false);
//                getOverDueBooks.setVisible(false);
                break;
            case BOTH:
                mainPanel.add(addBook);
                mainPanel.add(addBookCopy);
                mainPanel.add(addMember);
                mainPanel.add(checkOutBook);
                mainPanel.add(printCheckoutRecord);
                mainPanel.add(returnBook);
                mainPanel.add(getOverDueBooks);
                mainPanel.add(manageLibraryMembers);
                mainPanel.add(logoutButton);
                mainPanel.setBackground(UIUtils.COLOR_BACKGROUND);
        }
    }


}
