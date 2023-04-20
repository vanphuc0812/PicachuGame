package org.vanphuc2401.utils;

import org.vanphuc2401.model.CustomIcon;

import javax.swing.*;
import java.awt.*;

public class IconUtil {
    public static final int iconNum = 21;
    private static int width = 48;
    private static int height = 48;

    private IconUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static final CustomIcon getIcon(int iconNum) {
        Image image = new ImageIcon(IconUtil.class.getResource(
                "/icon/" + iconNum + ".png")).getImage();
        CustomIcon icon = new CustomIcon(iconNum, image.getScaledInstance(width, height,
                image.SCALE_SMOOTH));
        return icon;
    }
}
