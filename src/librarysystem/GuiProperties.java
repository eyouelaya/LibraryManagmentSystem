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

    public static int SCREEN_WIDTH = 640;
    public static int SCREEN_HEIGHT = 480;

    public static void centerFrameOnDesktop(Component f) {
        final int SHIFT_AMOUNT = 0;
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        int height = toolkit.getScreenSize().height;
        int width = toolkit.getScreenSize().width;
        int frameHeight = f.getSize().height;
        int frameWidth = f.getSize().width;
        f.setLocation(((width - frameWidth) / 2) - SHIFT_AMOUNT, (height - frameHeight) / 3);
    }



    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
    }

}
