package librarysystem;

import dataaccess.Auth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import librarysystem.AddBookUI;

public class MainView extends JFrame {

    private JButton addBook, addMember, checkOutBook, addBookCopy, printCheckoutRecord, returnBook, getOverDueBooks;
    private Auth role;

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

        JPanel mainPanel = new JPanel(new GridLayout(6, 1));
        addBook = createStyledButton("Add Book", new Color(0, 128, 0));
        addBookCopy = createStyledButton("Add Book Copy", new Color(0, 128, 0));
        addMember = createStyledButton("Add Member", new Color(0, 128, 128));
        checkOutBook = createStyledButton("Checkout Book", new Color(0, 128, 128));
        printCheckoutRecord = createStyledButton("Print Checkout Record", new Color(0, 128, 128));
        returnBook = createStyledButton("Return Book", new Color(0, 128, 128));
        getOverDueBooks = createStyledButton("Get Overdue Books", new Color(0, 128, 128));

        setSize(GuiProperties.SCREEN_WIDTH, GuiProperties.SCREEN_HEIGHT);
        GuiProperties.centerFrameOnDesktop(this);
        mainPanel.add(addBook);
        mainPanel.add(addBookCopy);
        mainPanel.add(addMember);
        mainPanel.add(checkOutBook);
        mainPanel.add(printCheckoutRecord);
        mainPanel.add(returnBook);
        mainPanel.add(getOverDueBooks);

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
                break;
        }

        add(mainPanel);
    }

    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setMargin(new Insets(10, 20, 10, 20));
        return button;
    }


    private void handle() {
        addMember.addActionListener(e -> {
            new AddMemberUI().setVisible(true);
        });

        addBook.addActionListener(e -> {
            new AddBookUI().setVisible(true);
        });

        checkOutBook.addActionListener(e -> {
            new CheckOutUIForm().setVisible(true);
        });

        addBookCopy.addActionListener(e -> {
            new AddBookCopyUI().setVisible(true);
        });

        printCheckoutRecord.addActionListener(e -> {
            new CheckoutRecordPrintUI().setVisible(true);
        });

        returnBook.addActionListener(e -> {
            new ReturnBookUI().setVisible(true);
        });

        getOverDueBooks.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GetOverDueUI().setVisible(true);
            }
        });
    }


}
