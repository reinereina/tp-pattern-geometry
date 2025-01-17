package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class PointTest {

    public static final double EPSILON = 1.0e-15;

    @Test
    public void testDefaultConstructor() {
        Point p = new Point();
        Assert.assertEquals(Double.NaN, p.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(Double.NaN, p.getCoordinate().getY(), EPSILON);
    }

    @Test
    public void testConstructor() {
        Coordinate c = new Coordinate(1.0, 1.0);
        Point p = new Point(c);
        Assert.assertEquals(1, p.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(1, p.getCoordinate().getY(), EPSILON);
    }

    @Test
    public void testType() {
        Point p = new Point();
        Assert.assertEquals("Point", p.getType());
    }

    @Test
    public void testEmpty() {
        Point p = new Point();
        Assert.assertTrue(p.isEmpty());
    }

    @Test
    public void testTranslate() {
        Point p = new Point(new Coordinate(0, 0));
        p.translate(1, 1);
        Assert.assertEquals(1, p.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(1, p.getCoordinate().getY(), EPSILON);
    }

    @Test
    public void testClone() {
        Point p = new Point(new Coordinate(0, 0));
        Geometry copy = p.clone();
        copy.translate(1, 1);
        Assert.assertEquals(0, p.getCoordinate().getX(), EPSILON);
        Assert.assertEquals(0, p.getCoordinate().getY(), EPSILON);
    }

    @Test
    public void testGetEnvelope() {
        Point p = new Point(new Coordinate(0, 0));
        Enveloppe e = p.getEnveloppe();
        Assert.assertEquals(0.0, e.getXmin(), EPSILON);
        Assert.assertEquals(0, e.getYmin(), EPSILON);
        Assert.assertEquals(0, e.getXmax(), EPSILON);
        Assert.assertEquals(0, e.getYmax(), EPSILON);
    }

}
