package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    public static final double EPSILON = 1.0e-15;

    @Test
    public void testDefaultConstructor() {
        Point p = new Point();
        Coordinate c = new Coordinate();
        Assert.assertEquals(p.getCoordinate().getX(), 0, EPSILON);
        Assert.assertEquals(p.getCoordinate().getY(), 0, EPSILON);
    }

    @Test
    public void testConstructor() {
        Coordinate c = new Coordinate(1.0, 1.0);
        Point p = new Point(c);
        Assert.assertEquals(p.getCoordinate(), c);
    }

    @Test
    public void testType() {
        Point p = new Point();
        Assert.assertEquals("Point", p.getType());
    }
}
