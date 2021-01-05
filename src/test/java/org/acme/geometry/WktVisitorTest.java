package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class WktVisitorTest {
    @Test
    public void testVisitPoint() {
        WktVisitor visitor = new WktVisitor();
        Geometry g = new Point(new Coordinate(3.0, 4.0));
        g.accept(visitor);
        Assert.assertEquals("POINT(3.0 4.0)", visitor.getResult());
    }

    @Test
    public void testVisitEmptyPoint() {
        WktVisitor visitor = new WktVisitor();
        Geometry g = new Point();
        g.accept(visitor);
        Assert.assertEquals("POINT EMPTY", visitor.getResult());
    }

    @Test
    public void testWriteLineString() {
        WktVisitor visitor = new WktVisitor();
        List<Point> points2 = new ArrayList<>();
        Coordinate c2 = new Coordinate(1.0, 1.1);
        Coordinate c3 = new Coordinate(2, 2.1);
        Point p2 = new Point(c2);
        Point p3 = new Point(c3);
        points2.add(p2);
        points2.add(p3);
        Geometry g = new LineString(points2);
        g.accept(visitor);
        Assert.assertEquals("LINESTRING(1.0 1.1,2.0 2.1)", visitor.getResult());
    }

    @Test
    public void testWriteEmptyLineString() {
        WktVisitor visitor = new WktVisitor();
        Geometry g = new LineString();
        g.accept(visitor);
        Assert.assertEquals("LINESTRING EMPTY", visitor.getResult());
    }
}
