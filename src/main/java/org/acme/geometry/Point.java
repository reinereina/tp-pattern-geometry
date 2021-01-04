package org.acme.geometry;

public class Point implements Geometry {
    private Coordinate coordinate;

    public Point() {
        this.coordinate = new Coordinate();
    }

    public Point(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public String getType() {
        return "Point";
    }

    @Override
    public Boolean isEmpty() {
        return this.coordinate.isEmpty();
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }
}
