package org.vanphuc2401.utils;

public class MatrixConstraintUtil {
    public static int getMaxShowTime(int height, int width) {
        return (int) height*width/IconUtil.iconNum+1;
    }
}
