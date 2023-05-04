package org.vanphuc2401.model;

public class Point implements Comparable<Point> {
    private int x;
    private int y;
    private CustomIcon icon;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(int x, int y, CustomIcon icon) {
        this.x = x;
        this.y = y;
        this.icon = icon;
    }

    public void removeIcon() {
        this.icon = null;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public CustomIcon getIcon() {
        return icon;
    }

    public void setIcon(CustomIcon icon) {
        this.icon = icon;
    }

    @Override
    public int compareTo(Point point) {
        if (y == point.y) {
            if (x < point.x)
                return -1;
            else
                return 1;
        } else if (y < point.y) {
            return -1;
        } else {
            return 1;
        }
    }

}
