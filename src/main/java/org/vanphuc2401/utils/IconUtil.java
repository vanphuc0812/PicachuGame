package org.vanphuc2401.utils;

import org.vanphuc2401.model.CustomIcon;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class IconUtil {
    public static final int ICON_NUM = 21;
    public static final int BOUND = 2;
    public static final int SIZE = 50;
    public static final Color BACK_GROUND_COLOR = Color.lightGray;

    private static int width = 48;
    private static int height = 48;

    private IconUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static final CustomIcon getIcon(int iconNum) {
        Image image = new ImageIcon(Objects.requireNonNull(IconUtil.class.getResource(
                "/icon/" + iconNum + ".png"))).getImage();
        return new CustomIcon(iconNum, image.getScaledInstance(width, height,
                Image.SCALE_SMOOTH));
    }
}
