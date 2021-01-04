package org.acme.geometry;

public class Coordinate {
    private final double x;
    private final double y;

    public Coordinate() {
        this.x = Double.NaN;
        this.y = Double.NaN;
    }

    public Coordinate(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Boolean isEmpty() {
        return Double.isNaN(this.x) || Double.isNaN(this.y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
