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

    @Test
    public void testEmpty() {
        LineString ls = new LineString();
        Coordinate c = new Coordinate();
        Point p = new Point(c);
        Assert.assertTrue(ls.isEmpty());

        List<Point> points = new ArrayList<>();
        points.add(p);
        LineString ls2 = new LineString(points);
        Assert.assertTrue(ls2.isEmpty());

        List<Point> points2 = new ArrayList<>();
        Coordinate c2 = new Coordinate(1.0, 1.0);
        Point p2 = new Point(c2);
        points2.add(p2);
        LineString ls3 = new LineString(points2);
        Assert.assertFalse(ls3.isEmpty());
    }

    @Test
    public void testTranslate() {
        List<Point> points2 = new ArrayList<>();
        Coordinate c2 = new Coordinate(1.0, 1.0);
        Point p2 = new Point(c2);
        points2.add(p2);
        points2.add(p2);
        LineString ls3 = new LineString(points2);
        ls3.translate(1, 1);
        Assert.assertEquals(3, ls3.getPointN(0).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(3, ls3.getPointN(0).getCoordinate().getX(), EPSILON);
    }

    @Test
    public void testClone() {
        List<Point> points2 = new ArrayList<>();
        Coordinate c2 = new Coordinate(1.0, 1.0);
        Point p2 = new Point(c2);
        points2.add(p2);
        LineString ls3 = new LineString(points2);
        Geometry copy = ls3.clone();
        copy.translate(1, 1);
        Assert.assertEquals(1, ls3.getPointN(0).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(1, ls3.getPointN(0).getCoordinate().getY(), EPSILON);
    }

}
