package Utils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class UIUtils {
    public static final Font FONT_GENERAL_UI = new Font("Segoe UI", Font.PLAIN, 20);
    public static final Font FONT_FORGOT_PASSWORD = new Font("Segoe UI", Font.PLAIN, 12);

    public static final Color COLOR_OUTLINE = new Color(103, 112, 120);
    public static final Color COLOR_BACKGROUND = new Color(37, 51, 61);
    public static final Color COLOR_INTERACTIVE = new Color(108, 216, 158);
    public static final Color COLOR_INTERACTIVE_DARKER = new Color(87, 171, 127);
    public static final Color OFFWHITE = new Color(229, 229, 229);

    public static final String BUTTON_TEXT_LOGIN = "Login";
    public static final String BUTTON_TEXT_FORGOT_PASS = "Forgot your password?";
    public static final String BUTTON_TEXT_REGISTER = "Register";

    public static final String PLACEHOLDER_TEXT_USERNAME = "User Id";

    public static final int ROUNDNESS = 8;

    public static Graphics2D get2dGraphics(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.addRenderingHints(new HashMap<RenderingHints.Key, Object>() {{
            put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            put(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
        }});
        return g2;
    }

    public JLabel createCustomLabel(String labelText, ActionListener actionListener) {
        final Color[] buttonColors = {UIUtils.COLOR_INTERACTIVE, Color.WHITE};

        JLabel customLabel = new JLabel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = UIUtils.get2dGraphics(g);
                super.paintComponent(g2);

                Insets insets = getInsets();
                int w = getWidth() - insets.left - insets.right;
                int h = getHeight() - insets.top - insets.bottom;
                g2.setColor(buttonColors[0]);
                g2.fillRoundRect(insets.left, insets.top, w, h, UIUtils.ROUNDNESS, UIUtils.ROUNDNESS);

                FontMetrics metrics = g2.getFontMetrics(UIUtils.FONT_GENERAL_UI);
                int x2 = (getWidth() - metrics.stringWidth(labelText)) / 2;
                int y2 = ((getHeight() - metrics.getHeight()) / 2) + metrics.getAscent();
                g2.setFont(UIUtils.FONT_GENERAL_UI);
                g2.setColor(buttonColors[1]);
                g2.drawString(labelText, x2, y2);
            }
        };

        customLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // Perform the action associated with the label
                if (actionListener != null) {
                    actionListener.actionPerformed(new ActionEvent(this, ActionEvent.ACTION_PERFORMED, null));
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                buttonColors[0] = UIUtils.COLOR_INTERACTIVE_DARKER;
                buttonColors[1] = UIUtils.OFFWHITE;
                customLabel.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                buttonColors[0] = UIUtils.COLOR_INTERACTIVE;
                buttonColors[1] = Color.WHITE;
                customLabel.repaint();
            }
        });

        customLabel.setBackground(UIUtils.COLOR_BACKGROUND);
        customLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        return customLabel;
    }

}