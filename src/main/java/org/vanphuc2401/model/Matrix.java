package org.vanphuc2401.model;

import java.util.List;

public class Matrix {
    List<Point> pointList;
    private int height;
    private int width;

    public Matrix(int height, int width, List<Point> pointList) {
        this.height = height;
        this.width = width;
        this.pointList = pointList;
    }

    public List<Point> getPointList() {
        return pointList;
    }

    public int[][] getRawMatrix() {
        int[][] matrix = new int[height][width];
        pointList.stream().forEach(point -> {
            matrix[point.getX()][point.getY()] = point.getIcon().getIconNumber();
        });
        return matrix;
    }
}
