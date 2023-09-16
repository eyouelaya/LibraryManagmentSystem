package librarysystem;

import Toaster.Toaster;
import Utils.TextFieldUsername;
import Utils.UIUtils;
import business.CheckOutRecordEntry;
import business.SystemController;

import javax.swing.*;
import java.awt.*;
import java.util.List;


public class CheckoutRecordPrintUI extends JFrame {
    private Toaster toaster;
    private JPanel panel1;
    private JLabel memberIDLabel;
    private TextFieldUsername memberIdText;
    private JButton searchRecords;
    private JScrollPane scrollPane1;
    private JTable recordEntryTable;
    public CheckoutRecordPrintUI() {
        initComponents();
    }

    private void initComponents() {
        panel1 = new JPanel();
        toaster = new Toaster(panel1);
        memberIDLabel = new JLabel();
        memberIdText = new TextFieldUsername();
        searchRecords = new JButton();
        scrollPane1 = new JScrollPane();
        recordEntryTable = new JTable();

        //======== this ========
        var contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout(5, 5));

        //======== panel1 ========
        {
            panel1.setLayout(new FlowLayout());
            panel1.setBackground(UIUtils.COLOR_BACKGROUND);

            //---- label1 ----
            memberIDLabel.setText("Enter member id");
            memberIDLabel.setFont(UIUtils.FONT_GENERAL_UI);
            memberIDLabel.setForeground(Color.white);
            panel1.add(memberIDLabel);

            //---- memberIdText ----
            memberIdText.setColumns(10);
            panel1.add(memberIdText);

            //---- searchRecords ----
            searchRecords.setText("Search");
            searchRecords.setBackground(UIUtils.COLOR_INTERACTIVE_DARKER);
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
        contentPane.setBackground(UIUtils.COLOR_BACKGROUND);
        handle();
    }

    private void handle() {
        searchRecords.addActionListener(e -> {
            String memberId = memberIdText.getText();
            if (!memberId.isEmpty()) {
                SystemController.getInstance().searchCheckOutRecords(memberId, CheckoutRecordPrintUI.this);
            } else toaster.error("All fields are required");
        });
    }



    public void displayNoRecordsFound() {
        toaster.error("No records found");
    }

    public void displayUserNotFound() {
        toaster.error("No User found");
    }

    public void showRecords(List<CheckOutRecordEntry> recordEntries) {
        recordEntryTable.setModel(new TableModel(recordEntries));
    }
}
