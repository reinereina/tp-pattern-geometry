package org.acme.geometry;

public class WktWriter {

    public String write(Geometry geom) {
        StringBuilder wkt = new StringBuilder();
        if (geom instanceof Point) {
            wkt.append(geom.getType().toUpperCase());
            if (Boolean.TRUE.equals(geom.isEmpty())) {
                wkt.append(" EMPTY");
            } else {
                Point point = (Point) geom;
                wkt.append("(").append(point.getCoordinate().getX()).append(" ").append(point.getCoordinate().getY()).append(")");
            }
        } else if (geom instanceof LineString) {
            LineString lineString = (LineString) geom;
            wkt.append(lineString.getType().toUpperCase());
            if (Boolean.TRUE.equals(geom.isEmpty())) {
                wkt.append(" EMPTY");
            } else {
                wkt.append("(");
                for (int i = 0; i < lineString.getNumPoints(); i++) {
                    Point p = lineString.getPointN(i);
                    wkt.append(p.getCoordinate().getX()).append(" ").append(p.getCoordinate().getY());
                    if (i != lineString.getNumPoints() - 1) {
                        wkt.append(",");
                    }
                }
                wkt.append(")");
            }
        } else {
            throw new RuntimeException("Geometry type not supported");
        }

        return wkt.toString();
    }

}
