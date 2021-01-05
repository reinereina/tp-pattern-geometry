package org.acme.geometry;

public class LogGeometryVisitor implements GeometryVisitor {
    public void visit(Point point) {
        System.out.println("Je suis un " + point.getType() + " avec x=" +
                point.getCoordinate().getX() + " et y=" +
                point.getCoordinate().getY());
    }

    public void visit(LineString lineString) {
        System.out.println("Je suis une " + lineString.getType() + " défnie par " +
                lineString.getNumPoints() + " point(s)");
    }
}
