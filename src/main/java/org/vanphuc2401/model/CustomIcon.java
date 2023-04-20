package org.vanphuc2401.model;

import javax.swing.*;
import java.awt.*;

public class CustomIcon extends ImageIcon {
    private int iconNumber;
    public CustomIcon(int iconNumber, Image image) {
        super(image);
        this.iconNumber = iconNumber;
    }

    public int getIconNumber() {
        return iconNumber;
    }
}
