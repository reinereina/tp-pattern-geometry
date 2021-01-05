package org.acme.geometry;

import junit.framework.Assert;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class LogGeometryVisitorTest {
    @Test
    public void testVisitPoint() {
        String wanted = "Je suis un Point avec x=3.0 et y=4.0";
        ByteArrayOutputStream outStr = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStr);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);
        Geometry geometry = new Point(new Coordinate(3.0, 4.0));
        geometry.accept(visitor);
        Assert.assertEquals(wanted, outStr.toString());
    }

    @Test
    public void testVisitLineString() {
        String wanted = "Je suis une LineString définie par 2 point(s)";
        ByteArrayOutputStream outStr = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStr);
        LogGeometryVisitor visitor = new LogGeometryVisitor(out);

        List<Point> points2 = new ArrayList<>();
        Coordinate c2 = new Coordinate(1.0, 1.1);
        Coordinate c3 = new Coordinate(2, 2.1);
        Point p2 = new Point(c2);
        Point p3 = new Point(c3);
        points2.add(p2);
        points2.add(p3);
        Geometry g = new LineString(points2);

        g.accept(visitor);
        Assert.assertEquals(wanted, outStr.toString());
    }

}
