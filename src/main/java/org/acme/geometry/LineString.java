package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class LineString implements Geometry {
    private List<Point> points;

    public LineString() {
        this.points = new ArrayList<>();
    }

    public LineString(List<Point> points) {
        assert (points != null);
        this.points = points;
    }

    public int getNumPoints() {
        return points.size();
    }

    public Point getPointN(int n) {
        return points.get(n);
    }

    @Override
    public String getType() {
        return "LineString";
    }

    @Override
    public Boolean isEmpty() {
        if (points.isEmpty()) return true;
        for (Point pt : points) {
            if (Boolean.TRUE.equals(pt.isEmpty())) return true;
        }
        return false;
    }

    @Override
    public void translate(double dx, double dy) {
        for (Point point : this.points) {
            point.translate(dx, dy);
        }
    }

    @Override
    public LineString clone() {
        List<Point> pointsC = new ArrayList<>();
        for (Point point : this.points) {
            pointsC.add(point.clone());
        }
        return new LineString(pointsC);
    }
}
