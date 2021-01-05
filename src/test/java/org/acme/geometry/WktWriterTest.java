package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WktWriterTest {
    @Test
    public void testWritePoint() {
        Geometry g = new Point(new Coordinate(3.0, 4.0));
        WktWriter writer = new WktWriter();
        Assert.assertEquals("POINT(3.0 4.0)", writer.write(g));
    }

    @Test
    public void testWriteEmptyPoint() {
        Geometry g = new Point();
        WktWriter writer = new WktWriter();
        Assert.assertEquals("POINT EMPTY", writer.write(g));
    }

    @Test
    public void testWriteLineString() {
        List<Point> points2 = new ArrayList<>();
        Coordinate c2 = new Coordinate(1.0, 1.1);
        Coordinate c3 = new Coordinate(2, 2.1);
        Point p2 = new Point(c2);
        Point p3 = new Point(c3);
        points2.add(p2);
        points2.add(p3);
        Geometry g = new LineString(points2);
        WktWriter writer = new WktWriter();
        Assert.assertEquals("LINESTRING(1.0 1.1,2.0 2.1)", writer.write(g));
    }

    @Test
    public void testWriteEmptyLineString() {
        Geometry g = new LineString();
        WktWriter writer = new WktWriter();
        Assert.assertEquals("LINESTRING EMPTY", writer.write(g));
    }
}
