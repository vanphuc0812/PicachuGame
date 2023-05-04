package org.vanphuc2401.utils;

public class MatrixConstraintUtil {
    private MatrixConstraintUtil() {
        
    }

    public static int getMaxShowTime(int height, int width) {
        return (int) height * width / IconUtil.ICON_NUM + 1;
    }
}
