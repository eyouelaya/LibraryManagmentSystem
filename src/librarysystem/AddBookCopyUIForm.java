/*
 * Created by JFormDesigner on Wed Oct 07 04:04:41 CDT 2020
 */

package librarysystem;

import business.SystemController;

import javax.swing.*;
import java.awt.*;

/**
 * @author Ali ziwa
 */
public class AddBookCopyUIForm extends JFrame {
    public AddBookCopyUIForm() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ali ziwa
        label1 = new JLabel();
        panel1 = new JPanel();
        panel4 = new JPanel();
        addCopyBtn = new JButton();
        panel2 = new JPanel();
        label2 = new JLabel();
        copyNumberTextField = new JTextField();
        panel3 = new JPanel();
        label3 = new JLabel();
        isbnTextField = new JTextField();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(5, 5));

        //---- label1 ----
        label1.setText("Add book copy");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(label1, BorderLayout.NORTH);

        //======== panel1 ========
        {
            panel1.setLayout(new BorderLayout(5, 5));

            //======== panel4 ========
            {
                panel4.setLayout(new FlowLayout());

                //---- addCopyBtn ----
                addCopyBtn.setText("Add copy");
                panel4.add(addCopyBtn);
            }
            panel1.add(panel4, BorderLayout.SOUTH);

            //======== panel2 ========
            {
                panel2.setLayout(new FlowLayout());

                //---- label2 ----
                label2.setText("Copy number: ");
                panel2.add(label2);

                //---- copyNumberTextField ----
                copyNumberTextField.setColumns(5);
                panel2.add(copyNumberTextField);
            }
            panel1.add(panel2, BorderLayout.CENTER);

            //======== panel3 ========
            {
                panel3.setLayout(new FlowLayout());

                //---- label3 ----
                label3.setText("ISBN: ");
                panel3.add(label3);

                //---- isbnTextField ----
                isbnTextField.setColumns(10);
                panel3.add(isbnTextField);
            }
            panel1.add(panel3, BorderLayout.NORTH);
        }
        contentPane.add(panel1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        setSize(GuiProperties.SCREEN_WIDTH, GuiProperties.SCREEN_HEIGHT);
        GuiProperties.centerFrameOnDesktop(this);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        handle();
    }

    private void handle() {
        addCopyBtn.addActionListener(e -> {
            String isbn = isbnTextField.getText();
            try {
                int copyNumber = Integer.parseInt(copyNumberTextField.getText());

                if (!(isbn.isEmpty())) {
                    SystemController.getInstance().addBookCopy(isbn, copyNumber, AddBookCopyUIForm.this);
                } else JOptionPane.showMessageDialog(AddBookCopyUIForm.this, "Enter all fields.");
            } catch (NumberFormatException err) {
                JOptionPane.showMessageDialog(AddBookCopyUIForm.this, "Copy number must be a numeric value");
            }
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ali ziwa
    private JLabel label1;
    private JPanel panel1;
    private JPanel panel4;
    private JButton addCopyBtn;
    private JPanel panel2;
    private JLabel label2;
    private JTextField copyNumberTextField;
    private JPanel panel3;
    private JLabel label3;
    private JTextField isbnTextField;

    public void displayBookNotFoundUI() {
        JOptionPane.showMessageDialog(this, "The book is not found.");
    }

    public void displayBookAddedUI() {
        JOptionPane.showMessageDialog(this, "Book copy added");
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
