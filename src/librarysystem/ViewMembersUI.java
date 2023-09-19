package librarysystem;

import Toaster.Toaster;
import Utils.TextFieldUsername;
import Utils.UIUtils;
import business.LibraryMember;
import business.SystemController;
import dataaccess.Auth;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public class ViewMembersUI extends JFrame {
    private Toaster toaster;
    private JPanel panel1;
    private JLabel memberIDLabel;
    private TextFieldUsername memberIdText;
    private JButton editButton, deleteButton;
    private JScrollPane scrollPane1;
    private JTable libraryMemberTable;
    public ViewMembersUI(Auth role) {
        initComponents();
    }

    private void initComponents() {
        panel1 = new JPanel();
        toaster = new Toaster(panel1);
        memberIDLabel = new JLabel();
        memberIdText = new TextFieldUsername();
        editButton = new JButton();
        deleteButton = new JButton("Delete");
        scrollPane1 = new JScrollPane();
        libraryMemberTable = new JTable();

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

            editButton.setText("\uD83D\uDD0D Edit");
            editButton.setFont(new Font("Arial", Font.PLAIN, 16));
            editButton.setBackground(new Color(0, 128, 0));
            editButton.setOpaque(true);
            editButton.setBorderPainted(false);
            editButton.setForeground(Color.WHITE);
            deleteButton.setBackground(UIUtils.COLOR_RED);
            deleteButton.setForeground(Color.white);
            deleteButton.setOpaque(true);
            deleteButton.setBorderPainted(false);
            deleteButton.setFont(new Font("Arial", Font.PLAIN, 16));
            panel1.add(editButton);
            panel1.add(deleteButton);
        }
        contentPane.add(panel1, BorderLayout.NORTH);

        //======== scrollPane1 ========
        {
            scrollPane1.setViewportView(libraryMemberTable);
        }
        contentPane.add(scrollPane1, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(getOwner());
        setSize(GuiProperties.SCREEN_WIDTH, GuiProperties.SCREEN_HEIGHT);
        GuiProperties.centerFrameOnDesktop(this);
        contentPane.setBackground(UIUtils.COLOR_BACKGROUND);
        handle();
        showRecords();
    }

    private void handle() {
        editButton.addActionListener(e -> {
            String memberId = memberIdText.getText();
            if (!memberId.isEmpty()) {
                if (SystemController.getInstance().getMember(memberId) != null) {
                    ViewMembersUI.this.dispose();
                    new EditMemberUI(SystemController.getInstance().getMember(memberId)).setVisible(true);
                } else
                    displayError("No Library Member found");
            } else toaster.error("All fields are required");
        });
        deleteButton.addActionListener(e -> {
            String memberId = memberIdText.getText();
            if (!memberId.isEmpty()) {
                if (SystemController.getInstance().getMember(memberId) != null) {
                    SystemController.getInstance().removeMember(memberId, ViewMembersUI.this);
                    libraryMemberTable.setModel(new MembersTableModel(SystemController.getInstance().getAllLibraryMembers()));
                } else
                    displayError("No Library Member found");
            } else toaster.error("All fields are required");
        });
        libraryMemberTable.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedRow = libraryMemberTable.getSelectedRow();
                if(selectedRow != -1) {
                    String selectedData =(String) libraryMemberTable.getValueAt(selectedRow,0);
                    memberIdText.setText("");
                    memberIdText.setText(selectedData);
                }
            }
        });
    }


    public void displaySuccess(String message){
        toaster.success(message);
    }
    public void displayError(String message) {
        toaster.error(message);
    }


    public void showRecords() {

        libraryMemberTable.setModel(new MembersTableModel( SystemController.getInstance().getAllLibraryMembers()));
    }
}
