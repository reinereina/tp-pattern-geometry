package org.acme.geometry;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

public class GeometryCollectionTest {
    public static final double EPSILON = 1.0e-15;

    @Test
    public void testDefaultConstructor() {
        GeometryCollection geomC = new GeometryCollection();
        Assert.assertTrue(geomC.isEmpty());
        Assert.assertEquals(0, geomC.getNumGeometries());
    }

    @Test
    public void testConstructor() {
        List<Geometry> geom = new ArrayList<>();
        geom.add(new Point(new Coordinate(1.0, 2.0)));
        geom.add(new Point(new Coordinate(0.5, 1.0)));
        GeometryCollection geometryCollection = new GeometryCollection(geom);
        Assert.assertEquals(2, geometryCollection.getNumGeometries());
    }

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testNullConstructor() {
        thrown.expect(AssertionError.class);
        new GeometryCollection(null);
    }

    @Test
    public void testGetGeometryN() {
        List<Geometry> geom = new ArrayList<>();
        geom.add(new Point(new Coordinate(1.0, 2.0)));
        geom.add(new Point(new Coordinate(0.5, 1.0)));
        GeometryCollection geometryCollection = new GeometryCollection(geom);
        AbstractGeometry g = (AbstractGeometry) geometryCollection.getGeometryN(0);
        Assert.assertEquals("POINT(1.0 2.0)", g.asText());
    }

    @Test
    public void testGetGeometryNOutOfSize() {
        List<Geometry> geom = new ArrayList<>();
        geom.add(new Point(new Coordinate(1.0, 2.0)));
        geom.add(new Point(new Coordinate(0.5, 1.0)));
        GeometryCollection geometryCollection = new GeometryCollection(geom);
        AbstractGeometry g = (AbstractGeometry) geometryCollection.getGeometryN(5);
        Assert.assertNull(g);
    }

    @Test
    public void testType() {
        List<Geometry> geom = new ArrayList<>();
        geom.add(new Point(new Coordinate(1.0, 2.0)));
        geom.add(new Point(new Coordinate(0.5, 1.0)));
        GeometryCollection geometryCollection = new GeometryCollection(geom);
        Assert.assertEquals("GeometryCollection", geometryCollection.getType());
    }

    @Test
    public void testTranslate() {
        List<Geometry> geom = new ArrayList<>();
        geom.add(new Point(new Coordinate(1.0, 2.0)));
        geom.add(new Point(new Coordinate(0.5, 1.0)));
        GeometryCollection geometryCollection = new GeometryCollection(geom);
        geometryCollection.translate(1.0, 5.0);
        Assert.assertEquals("GEOMETRYCOLLECTION(POINT(2.0 7.0),POINT(1.5 6.0))", ((AbstractGeometry) geometryCollection).asText());
    }

    @Test
    public void testGetEnveloppe() {
        List<Geometry> geom = new ArrayList<>();
        geom.add(new Point(new Coordinate(1.0, 2.0)));
        geom.add(new Point(new Coordinate(0.5, 1.0)));
        GeometryCollection geometryCollection = new GeometryCollection(geom);
        Enveloppe e = geometryCollection.getEnveloppe();
        Assert.assertEquals(0.5, e.getXmin(), EPSILON);
        Assert.assertEquals(1.0, e.getYmin(), EPSILON);
        Assert.assertEquals(1.0, e.getXmax(), EPSILON);
        Assert.assertEquals(2.0, e.getYmax(), EPSILON);
    }

    @Test
    public void testClone() {
        List<Geometry> geom = new ArrayList<>();
        geom.add(new Point(new Coordinate(1.0, 2.0)));
        geom.add(new Point(new Coordinate(0.5, 1.0)));
        GeometryCollection geometryCollection = new GeometryCollection(geom);
        Geometry copy = geometryCollection.clone();
        copy.translate(1.0, 3.0);
        Assert.assertEquals(1.0, ((Point) geometryCollection.getGeometryN(0)).getCoordinate().getX(), EPSILON);
        Assert.assertEquals(2.0, ((Point) geometryCollection.getGeometryN(0)).getCoordinate().getY(), EPSILON);
    }
}
