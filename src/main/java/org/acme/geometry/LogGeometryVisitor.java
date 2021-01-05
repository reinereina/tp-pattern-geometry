package org.acme.geometry;

import java.io.PrintStream;

public class LogGeometryVisitor implements GeometryVisitor {
    private PrintStream out;

    public LogGeometryVisitor(PrintStream io) {
        this.out = io;
    }

    public void visit(Point point) {
        this.out.print("Je suis un " + point.getType() + " avec x=" +
                point.getCoordinate().getX() + " et y=" +
                point.getCoordinate().getY());
    }

    public void visit(LineString lineString) {
        this.out.print("Je suis une " + lineString.getType() + " définie par " +
                lineString.getNumPoints() + " point(s)");
    }
}
