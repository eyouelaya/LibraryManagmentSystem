package librarysystem;


import dataaccess.Auth;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainView extends JFrame {

    private JButton addBook, addMember, checkOutBook, addBookCopy, printCheckoutRecord, returnBook;
    private Auth role;

    MainView(Auth role) {
        JPanel mainPanel = new JPanel(new FlowLayout());
        addBook = new JButton("Add Book");
        addBookCopy = new JButton("Add Book Copy");
        addMember = new JButton("Add member");
        checkOutBook = new JButton("Checkout book");
        printCheckoutRecord = new JButton("Print checkout record");
        returnBook = new JButton("Return Book");
        this.role = role;

        setInsets(addBook, addMember, checkOutBook, addBookCopy, printCheckoutRecord);
        mainPanel.add(addBook);
        mainPanel.add(addBookCopy);
        mainPanel.add(addMember);
        mainPanel.add(checkOutBook);
        mainPanel.add(printCheckoutRecord);
        mainPanel.add(returnBook);
        switch (role) {
            case LIBRARIAN: {
                addMember.setVisible(false);
                addBook.setVisible(false);
                addBookCopy.setVisible(false);
                break;
            }
            case ADMIN:
                checkOutBook.setVisible(false);
                returnBook.setVisible(false);
                printCheckoutRecord.setVisible(false);
                break;
        }

        getContentPane().add(mainPanel);
        setSize(200, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(GuiProperties.SCREEN_WIDTH, GuiProperties.SCREEN_HEIGHT);
        GuiProperties.centerFrameOnDesktop(this);

        handle();
    }

    private void handle() {
        addMember.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddMemberUI().setVisible(true);
            }
        });

        addBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBookUI().setVisible(true);
            }
        });

        checkOutBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CheckOutUIForm().setVisible(true);
            }
        });

        addBookCopy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddBookCopyUI().setVisible(true);
            }
        });

        printCheckoutRecord.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CheckoutRecordPrintUI().setVisible(true);
            }
        });
        returnBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ReturnBookUI().setVisible(true);
            }
        });

    }

    private void setInsets(JButton... buttons) {
        for (JButton b : buttons) {
            b.setMargin(new Insets(5, 5, 5, 5));
        }
    }

}
