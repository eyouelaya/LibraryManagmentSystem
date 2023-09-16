package Utils;

import javax.swing.*;
import java.awt.*;

public class CustomWideComboBox extends JComboBox<String> {
    private static final Color BORDER_COLOR = new Color(0, 128, 128);
    private static final Color BACKGROUND_COLOR = Color.WHITE;
    private static final Color TEXT_COLOR = Color.BLACK;
    private static final int BORDER_THICKNESS = 2;
    private static final int PREF_WIDTH = 360; // Adjust to your preferred width
    private static final int PREF_HEIGHT = 40;

    public CustomWideComboBox(String[] items) {
        super(items);
        setOpaque(false);
        setRenderer(new CustomComboBoxRenderer());

        // Set the preferred size
        setPreferredSize(new Dimension(PREF_WIDTH, PREF_HEIGHT));

        // Set border style
        setBorder(BorderFactory.createMatteBorder(BORDER_THICKNESS, BORDER_THICKNESS, BORDER_THICKNESS, BORDER_THICKNESS, BORDER_COLOR));
    }

    private class CustomComboBoxRenderer extends DefaultListCellRenderer {
        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            // Customize the label's appearance
            label.setBackground(BACKGROUND_COLOR);
            label.setForeground(TEXT_COLOR);
            label.setFont(new Font("Arial", Font.PLAIN, 16)); // Adjust the font as needed
            label.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));

            return label;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Custom Wide ComboBox Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 100);

            String[] items = {"Option 1", "Option 2", "Option 3"};
            CustomWideComboBox comboBox = new CustomWideComboBox(items);

            frame.add(comboBox, BorderLayout.CENTER);
            frame.setVisible(true);
        });
    }
}
