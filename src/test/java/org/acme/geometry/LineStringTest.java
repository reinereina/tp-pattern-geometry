package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LineStringTest {
    public static final double EPSILON = 1.0e-15;

    @Test
    public void testDefaultConstructor() {
        LineString ls = new LineString();
        Assert.assertEquals(0, ls.getNumPoints());
    }

    @Test
    public void testConstructor() {
        Coordinate c = new Coordinate(1.0, 1.0);
        Point p = new Point(c);
        List<Point> points = new ArrayList<>();
        points.add(p);
        LineString ls = new LineString(points);
        Assert.assertEquals(1, ls.getNumPoints());
        Assert.assertEquals(1, ls.getPointN(0).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(1, ls.getPointN(0).getCoordinate().getY(), EPSILON);
    }

    @Test
    public void testType() {
        LineString ls = new LineString();
        Assert.assertEquals("LineString", ls.getType());
    }
}
