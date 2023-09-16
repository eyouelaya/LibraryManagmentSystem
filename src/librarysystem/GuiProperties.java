package librarysystem;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import java.awt.*;


public class GuiProperties {

    private static GuiProperties control;

    private GuiProperties() {
    }

    public static GuiProperties getInstance() {
        if (control == null) {
            control = new GuiProperties();
        }
        return control;
    }

    public static int SCREEN_WIDTH = 800;
    public static int SCREEN_HEIGHT = 400;

    public static void centerFrameOnDesktop(Component f) {
        final int SHIFT_AMOUNT = 0;
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        f.setLocation(screenSize.width / 2 - f.getWidth() / 2, screenSize.height / 2 - f.getHeight() / 2);

    }



    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
    }

}
