package org.vanphuc2401.service;

import org.vanphuc2401.model.Matrix;
import org.vanphuc2401.model.Point;
import org.vanphuc2401.utils.IconUtil;
import org.vanphuc2401.utils.MatrixConstraintUtil;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameService {
    private final int col;
    private final int row;
    private final Random random = new Random();
    private List<Point> pointList;
    private JButton[][] buttons;

    public GameService(int col, int row) {
        this.col = col;
        this.row = row;
    }


    public void setButtons(JButton[][] buttons) {
        this.buttons = buttons;
    }

    public Matrix createRandomMatrix(int height, int width) {
        List<Point> listPoints = new ArrayList<Point>();
        List<Point> listMatrixPoints = new ArrayList<Point>();
        int randomNumber;
        int[] indices = new int[IconUtil.ICON_NUM];
        int max = MatrixConstraintUtil.getMaxShowTime(height, width);
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                listPoints.add(new Point(i, j));
            }
        }
        for (int i = 0; i < height * width / 2; i++) {
            do {
                randomNumber = random.nextInt(IconUtil.ICON_NUM) + 1;
            } while (indices[randomNumber - 1] >= max);
            for (int j = 0; j < 2; j++) {
                Point point = listPoints.get(random.nextInt(listPoints.size()));
                point.setIcon(IconUtil.getIcon(randomNumber));
                listPoints.remove(point);
                listMatrixPoints.add(point);
            }
            indices[randomNumber - 1] += 2;
        }
        for (int i = 0; i < height; i++) {
            listMatrixPoints.add(new Point(i, 0));
            listMatrixPoints.add(new Point(i, width + 1));
        }
        for (int i = 0; i < width + 2; i++) {
            listMatrixPoints.add(new Point(0, i));
            listMatrixPoints.add(new Point(height + 1, i));
        }
        Collections.sort(listMatrixPoints);
        this.pointList = listMatrixPoints;
        return new Matrix(height + 1, width + 1, listMatrixPoints);
    }

    public Point getPoint(int x, int y) {
        return pointList.stream().
                filter(p -> {
                    if (p.getX() == x && p.getY() == y) {
                        return true;
                    } else return false;
                })
                .findFirst()
                .orElse(null);
    }


    public Point[] checkTwoPoint(Point point1, Point point2) {
        Point[] results = new Point[4];
        Point junctionPoint1;
        Point junctionPoint2;
        if (point1.getIcon().getIconNumber() != point2.getIcon().getIconNumber() || (point1.getX() == point2.getX() && point1.getY() == point2.getY()))
            return null;
        if (checkLine(point1, point2)) {
            results[0] = point1;
            results[1] = point2;
            return results;
        } else {
            for (int i = 0; i < col + 2; i++) {
                if (i == point1.getX()) continue;
                junctionPoint1 = getPoint(i, point1.getY());
                junctionPoint2 = getPoint(i, point2.getY());
                if (junctionPoint1.getIcon() != null || junctionPoint2.getIcon() != null) continue;
                if (checkLine(point1, junctionPoint1) && checkLine(junctionPoint1, junctionPoint2)
                        && checkLine(junctionPoint2, point2)) {
                    results[0] = point1;
                    results[1] = point2;
                    results[2] = junctionPoint1;
                    results[3] = junctionPoint2;
                    return results;
                }
            }
            for (int i = 0; i < row + 2; i++) {
                if (i == point1.getY()) continue;
                junctionPoint1 = getPoint(point1.getX(), i);
                junctionPoint2 = getPoint(point2.getX(), i);
                if (junctionPoint1.getIcon() != null || junctionPoint2.getIcon() != null) continue;
                if (checkLine(point1, junctionPoint1) && checkLine(junctionPoint1, junctionPoint2)
                        && checkLine(junctionPoint2, point2)) {
                    results[0] = point1;
                    results[1] = point2;
                    results[2] = junctionPoint1;
                    results[3] = junctionPoint2;
                    return results;


                }
            }
        }

        return null;
    }

    private boolean checkAxis(int point1A, int point1B, int point2B) {
        for (int i = point1B + 1; i < point2B; i++) {
            if (buttons[point1A][i].getIcon() != null) return false;
        }
        return true;
    }

    private boolean checkLine(Point point1, Point point2) {
        if (point1.getX() == point2.getX()) {
            if (point1.getY() == point2.getY()) return true;
            if (point1.getY() < point2.getY()) {
                return checkAxis(point1.getX(), point1.getY(), point2.getY());
            } else {
                return checkAxis(point2.getX(), point2.getY(), point1.getY());
            }
        } else if (point1.getY() == point2.getY()) {
            if (point1.getX() < point2.getX()) {
                return checkAxis(point1.getY(), point1.getX(), point2.getX());
            } else {
                return checkAxis(point2.getY(), point2.getX(), point1.getX());
            }
        }
        return false;
    }

}
