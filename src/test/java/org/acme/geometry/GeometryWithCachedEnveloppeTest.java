package org.acme.geometry;

import org.junit.Assert;
import org.junit.Test;

public class GeometryWithCachedEnveloppeTest {

    public static final double EPSILON = 1.0e-15;


    @Test
    public void testGetEnvelope() {
        Geometry g = new Point(new Coordinate(3.0, 4.0));
        g = new GeometryWithCachedEnveloppe(g);
        Enveloppe a = g.getEnveloppe();
        Enveloppe b = g.getEnveloppe();
        Assert.assertSame(a, b);
    }

    @Test
    public void testType() {
        Geometry g = new Point(new Coordinate(3.0, 4.0));
        g = new GeometryWithCachedEnveloppe(g);
        Assert.assertEquals("Point", g.getType());
    }

    @Test
    public void testIsEmpty() {
        Geometry g = new Point();
        g = new GeometryWithCachedEnveloppe(g);
        Assert.assertTrue(g.isEmpty());
    }

    @Test
    public void testObserver() {
        Geometry g = new Point(new Coordinate(3.0, 4.0));
        g = new GeometryWithCachedEnveloppe(g);
        Enveloppe a = g.getEnveloppe();
        g.translate(-1.0, 10.0);
        Enveloppe b = g.getEnveloppe();
        Assert.assertNotSame(a, b);
    }

    @Test
    public void testClone() {
        Geometry g = new Point(new Coordinate(3.0, 4.0));
        g = new GeometryWithCachedEnveloppe(g);
        Geometry copy = g.clone();
        copy.translate(-1.0, 10.0);
        Assert.assertNotSame(g.getEnveloppe(), copy.getEnveloppe());
    }

    @Test
    public void testAccept() {
        GeometryVisitor builder = new EnveloppeBuilder();
        Geometry g = new Point(new Coordinate(3.0, 4.0));
        g = new GeometryWithCachedEnveloppe(g);
        g.accept(builder);
        Assert.assertEquals(3.0, g.getEnveloppe().getXmin(), EPSILON);
    }
}
