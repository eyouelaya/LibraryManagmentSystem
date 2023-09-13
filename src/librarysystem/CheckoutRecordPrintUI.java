/*
 * Created by JFormDesigner on Wed Oct 07 15:09:27 CDT 2020
 */

package librarysystem;

import business.CheckOutRecordEntry;
import business.SystemController;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @author Ali ziwa
 */
public class CheckoutRecordPrintUI extends JFrame {
    public CheckoutRecordPrintUI() {
        initComponents();
    }

    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Ali ziwa
        panel1 = new JPanel();
        label1 = new JLabel();
        memberIdText = new JTextField();
        searchRecords = new JButton();
        scrollPane1 = new JScrollPane();
        recordEntryTable = new JTable();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(5, 5));

        //======== panel1 ========
        {
            panel1.setLayout(new FlowLayout());

            //---- label1 ----
            label1.setText("Enter member id");
            panel1.add(label1);

            //---- memberIdText ----
            memberIdText.setColumns(10);
            panel1.add(memberIdText);

            //---- searchRecords ----
            searchRecords.setText("Search");
            panel1.add(searchRecords);
        }
        contentPane.add(panel1, BorderLayout.NORTH);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(recordEntryTable);
        }
        contentPane.add(scrollPane1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        setSize(GuiProperties.SCREEN_WIDTH, GuiProperties.SCREEN_HEIGHT);
        GuiProperties.centerFrameOnDesktop(this);
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
        handle();
    }

    private void handle() {
        searchRecords.addActionListener(e -> {
            String memberId = memberIdText.getText();
            if (!memberId.isEmpty()) {
                SystemController.getInstance().searchCheckOutRecords(memberId, CheckoutRecordPrintUI.this);
            } else JOptionPane.showMessageDialog(CheckoutRecordPrintUI.this, "Please fill out all fields.");
        });
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Ali ziwa
    private JPanel panel1;
    private JLabel label1;
    private JTextField memberIdText;
    private JButton searchRecords;
    private JScrollPane scrollPane1;
    private JTable recordEntryTable;

    public void displayNoRecordsFound() {
        JOptionPane.showMessageDialog(this, "No records found");
    }

    public void displayUserNotFound() {
        JOptionPane.showMessageDialog(this, "No user found");
    }

    public void showRecords(List<CheckOutRecordEntry> recordEntries) {
        recordEntryTable.setModel(new TableModel(recordEntries));
    }
    // JFormDesigner - End of variables declaration  //GEN-END:variables
}
