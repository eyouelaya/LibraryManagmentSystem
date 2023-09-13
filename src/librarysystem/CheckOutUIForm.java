/*
 * Created by JFormDesigner on Wed Oct 07 02:47:13 CDT 2020
 */

package librarysystem;

import business.SystemController;

import javax.swing.*;
import java.awt.*;


public class CheckOutUIForm extends JFrame {
    private JPanel panel4;
    private JButton checkoutButton;
    private JLabel label1;
    private JPanel panel5;
    private JPanel panel3;
    private JLabel label3;
    private JTextField memberIDTextField;
    private JPanel panel2;
    private JLabel label2;
    private JTextField isbnTextField;
    public CheckOutUIForm() {
        initComponents();
    }

    private void initComponents() {


        panel4 = new JPanel();
        checkoutButton = new JButton();
        label1 = new JLabel();
        panel5 = new JPanel();
        panel3 = new JPanel();
        label3 = new JLabel();
        memberIDTextField = new JTextField();
        panel2 = new JPanel();
        label2 = new JLabel();
        isbnTextField = new JTextField();

        //======== this ========
        setLayout(new BorderLayout(8, 8));

        //======== panel4 ========
        {
            panel4.setLayout(new FlowLayout());

            //---- checkoutButton ----
            checkoutButton.setText("Checkout book");
            panel4.add(checkoutButton);
        }
        add(panel4, BorderLayout.PAGE_END);

        //---- label1 ----
        label1.setText("Checkout book");
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        add(label1, BorderLayout.PAGE_START);

        //======== panel5 ========
        {
            panel5.setPreferredSize(null);
            panel5.setMaximumSize(null);
            panel5.setMinimumSize(null);
            panel5.setLayout(new FlowLayout());

            //======== panel3 ========
            {
                panel3.setLayout(new FlowLayout());

                //---- label3 ----
                label3.setText("Member ID: ");
                panel3.add(label3);

                //---- memberIDTextField ----
                memberIDTextField.setColumns(20);
                panel3.add(memberIDTextField);
            }
            panel5.add(panel3);

            //======== panel2 ========
            {
                panel2.setLayout(new FlowLayout());

                //---- label2 ----
                label2.setText("Book ISBN: ");
                panel2.add(label2);

                //---- isbnTextField ----
                isbnTextField.setColumns(20);
                panel2.add(isbnTextField);
            }
            panel5.add(panel2);
        }
        add(panel5, BorderLayout.CENTER);
        setSize(GuiProperties.SCREEN_WIDTH, GuiProperties.SCREEN_HEIGHT);
        GuiProperties.centerFrameOnDesktop(this);

        handle();
    }

    private void handle() {
        checkoutButton.addActionListener(e -> {
            String isbn = isbnTextField.getText();
            String memberId = memberIDTextField.getText();

            if (!(isbn.isEmpty() && memberId.isEmpty())) {
                SystemController.getInstance().checkOutBook(memberId, isbn, CheckOutUIForm.this);
            } else JOptionPane.showMessageDialog(CheckOutUIForm.this, "Please enter details.");
        });
    }

    public void displayBookUnavailable() {
        JOptionPane.showMessageDialog(this, "Book not available");
    }

    public void displayMemberUnavailable() {
        JOptionPane.showMessageDialog(this, "Member not available");
    }

    public void displayCheckoutSuccess() {
        JOptionPane.showMessageDialog(this, "Book checked out");
    }
}
