/*
 * Created by JFormDesigner on Wed Oct 07 11:03:49 CDT 2020
 */

package librarysystem;

import business.Author;
import business.SystemController;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Ali ziwa
 */
public class AddBookUIForm extends JFrame {
    public AddBookUIForm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ali ziwa
        label1 = new JLabel();
        addBookAuthor = new JButton();
        panel1 = new JPanel();
        panel5 = new JPanel();
        successText = new JLabel();
        panel3 = new JPanel();
        label3 = new JLabel();
        bookTitle = new JTextField();
        panel2 = new JPanel();
        label2 = new JLabel();
        isbnTextField = new JTextField();
        panel4 = new JPanel();
        addAuthorBtn = new JButton();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(5, 5));

        //---- label1 ----
        label1.setText("Add Book");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1, BorderLayout.NORTH);

        //---- addBookAuthor ----
        addBookAuthor.setText("Add book");
        contentPane.add(addBookAuthor, BorderLayout.SOUTH);

        //======== panel1 ========
        {

            panel1.setLayout(new BorderLayout(4, 4));

            //======== panel5 ========
            {
                panel5.setLayout(new FlowLayout());

                //---- successText ----
                successText.setText("Book Added successfully");
                successText.setVisible(false);
                panel5.add(successText);
            }
            panel1.add(panel5, BorderLayout.SOUTH);

            //======== panel3 ========
            {
                panel3.setLayout(new FlowLayout());

                //---- label3 ----
                label3.setText("Book title: ");
                panel3.add(label3);

                //---- bookTitle ----
                bookTitle.setColumns(10);
                panel3.add(bookTitle);
            }
            panel1.add(panel3, BorderLayout.NORTH);

            //======== panel2 ========
            {
                panel2.setLayout(new FlowLayout());

                //---- label2 ----
                label2.setText("ISBN: ");
                panel2.add(label2);

                //---- isbnTextField ----
                isbnTextField.setColumns(10);
                panel2.add(isbnTextField);

                //======== panel4 ========
                {
                    panel4.setLayout(new BorderLayout(5, 5));

                    //---- addAuthorBtn ----
                    addAuthorBtn.setText("Add Authors");
                    panel4.add(addAuthorBtn, BorderLayout.CENTER);
                }
                panel2.add(panel4);
            }
            panel1.add(panel2, BorderLayout.CENTER);
        }
        contentPane.add(panel1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        setSize(GuiProperties.SCREEN_WIDTH, GuiProperties.SCREEN_HEIGHT);
        GuiProperties.centerFrameOnDesktop(this);
        handle();
    }

    private void handle() {
        addAuthorBtn.addActionListener(e -> {
            new AddAuthorUIForm().setVisible(true);
        });

        addBookAuthor.addActionListener(e -> {
            String title = bookTitle.getText();
            String isbnText = isbnTextField.getText();
            List<Author> authorsList = SystemController.getInstance().getAuthorsList();

            if ((!title.isEmpty() && !isbnText.isEmpty() && !authorsList.isEmpty())) {
                SystemController.getInstance().addBook(title, isbnText, authorsList);
                successText.setForeground(Color.green);
                successText.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(AddBookUIForm.this, "Please provide all information.");
                successText.setVisible(false);
            }
        });
    }

    private JLabel label1;
    private JButton addBookAuthor;
    private JPanel panel1;
    private JPanel panel5;
    private JLabel successText;
    private JPanel panel3;
    private JLabel label3;
    private JTextField bookTitle;
    private JPanel panel2;
    private JLabel label2;
    private JTextField isbnTextField;
    private JPanel panel4;
    private JButton addAuthorBtn;
}
