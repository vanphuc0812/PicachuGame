package org.vanphuc2401.service;

import org.vanphuc2401.model.Matrix;
import org.vanphuc2401.model.Point;
import org.vanphuc2401.utils.IconUtil;
import org.vanphuc2401.utils.MatrixConstraintUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameService {
    private Random random = new Random();

    public Matrix createRandomMatrix(int height, int width) {
        List<Point> listPoints = new ArrayList<Point>();
        List<Point> listMatrixPoints = new ArrayList<Point>();
        int randomNumber;
        int[] indices = new int[IconUtil.iconNum];
        int max = MatrixConstraintUtil.getMaxShowTime(height, width);
        for (int i = 1; i <= height; i++) {
            for (int j = 1; j <= width; j++) {
                listPoints.add(new Point(i, j));
            }
        }
        for (int i = 0; i < height * width / 2; i++) {
            do {
                randomNumber = random.nextInt(IconUtil.iconNum) + 1;
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

        return new Matrix(height + 1, width + 1, listMatrixPoints);
    }
}
