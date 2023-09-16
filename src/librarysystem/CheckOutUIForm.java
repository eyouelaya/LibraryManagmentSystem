package librarysystem;

import Toaster.Toaster;
import Utils.TextFieldUsername;
import Utils.UIUtils;
import business.SystemController;

import javax.swing.*;
import java.awt.*;


public class CheckOutUIForm extends JFrame {
    private Toaster toaster;
    private JPanel panel4;
    private JButton checkoutButton;
    private JLabel label1;
    private JPanel panel5;
    private JPanel panel3;
    private JLabel label3;
    private JLabel label4;
    private TextFieldUsername memberIDTextField;
    private JPanel panel2;
    private JLabel label2;
    private TextFieldUsername isbnTextField;
    public CheckOutUIForm() {
        initComponents();
    }

    private void initComponents() {


        panel4 = new JPanel();
        checkoutButton = new JButton();
        checkoutButton.setFont(new Font("Arial", Font.PLAIN, 16));
        checkoutButton.setBackground(new Color(0, 128, 0));
        checkoutButton.setOpaque(true);
        checkoutButton.setBorderPainted(false);
        checkoutButton.setForeground(Color.WHITE);
        label1 = new JLabel();
        panel5 = new JPanel();
        panel3 = new JPanel();
        label3 = new JLabel();
        label4 = new JLabel();
        memberIDTextField = new TextFieldUsername();
        panel2 = new JPanel();
        label2 = new JLabel();
        isbnTextField = new TextFieldUsername();

        //======== this ========
        setLayout(new BorderLayout(8, 8));

        //======== panel4 ========

        //add(panel4, BorderLayout.SOUTH);
        //
        // panel5.add(panel4);

        //---- label1 ----
        JPanel titlePanel = new JPanel();
        label1.setText("Checkout book");
        label1.setFont(UIUtils.FONT_GENERAL_UI);
        titlePanel.setBackground(UIUtils.COLOR_BACKGROUND);
        titlePanel.add(label1);
        label1.setForeground(Color.white);
        label1.setBackground(UIUtils.COLOR_BACKGROUND);
        label1.setHorizontalAlignment(SwingConstants.CENTER);
        add(titlePanel, BorderLayout.PAGE_START);
        setBackground(UIUtils.COLOR_BACKGROUND);
        checkoutButton.setBackground(UIUtils.COLOR_INTERACTIVE_DARKER);

        JPanel inputPanel = new JPanel(new GridLayout(3,4,10,10));



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
                label3.setForeground(Color.white);
                label3.setFont(UIUtils.FONT_GENERAL_UI);
                panel3.add(label3);


                //---- memberIDTextField ----
                memberIDTextField.setColumns(20);
                panel3.add(memberIDTextField);
                panel3.setBackground(UIUtils.COLOR_BACKGROUND);
            }
            panel5.add(panel3);

            //======== panel2 ========
            {
                panel2.setLayout(new FlowLayout());

                //---- label2 ----
                label2.setText("Book ISBN: ");
                label2.setForeground(Color.white);
                label2.setFont(UIUtils.FONT_GENERAL_UI);
                panel2.add(label2);
                panel2.setBackground(UIUtils.COLOR_BACKGROUND);

                //---- isbnTextField ----
                isbnTextField.setColumns(20);
                panel2.add(isbnTextField);
                panel2.setBackground(UIUtils.COLOR_BACKGROUND);
            }
            panel5.add(panel2);

            {
                panel4.setLayout(new FlowLayout());

                label4.setText("                              ");
                label4.setForeground(Color.white);
                label4.setFont(UIUtils.FONT_GENERAL_UI);
                panel4.add(label4);


                //---- checkoutButton ----
                checkoutButton.setText("Checkout book");
                panel4.add(checkoutButton);
                panel4.setBackground(UIUtils.COLOR_BACKGROUND);
            }
            panel5.add(panel4);
        }

        panel5.setBackground(UIUtils.COLOR_BACKGROUND);
        toaster = new Toaster(inputPanel);

        inputPanel.add(label3);
        inputPanel.add(memberIDTextField);
        inputPanel.add(label2);
        inputPanel.add(isbnTextField);
        inputPanel.add(checkoutButton);
        inputPanel.setBackground(UIUtils.COLOR_BACKGROUND);
        JPanel mainpanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        mainpanel.setBackground(UIUtils.COLOR_BACKGROUND);
        mainpanel.add(inputPanel);
        add(mainpanel, BorderLayout.CENTER);

        setBackground(UIUtils.COLOR_BACKGROUND);
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
            }
            else
                toaster.error("All fields are required");
        });
    }



    public void displayBookUnavailable() {
        toaster.error("Book not available");
    }

    public void displayMemberUnavailable() {
        toaster.error("Member not available");
    }

    public void displayCheckoutSuccess() {
        toaster.success("Book checked out");
    }
}
