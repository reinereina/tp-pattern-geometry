package org.acme.geometry;

public class GeoJSONWriter implements GeometryWriter {
    @Override
    public String getName() {
        return "GeoJSON";
    }

    @Override
    public String write(Geometry geom) {
        StringBuilder buffer = new StringBuilder("{\"type\": \"FeatureCollection\", \"features\": [");
        if (geom instanceof Point) {
            Point point = (Point) geom;
            if (Boolean.FALSE.equals(point.isEmpty())) {
                buffer.append("{\"type\": \"Feature\",\"geometry\": { \"type\": \"").append(point.getType()).append("\", \"coordinates\": [").append(point.getCoordinate().getX()).append(", ").append(point.getCoordinate().getY()).append("]}}");
            }
        } else if (geom instanceof LineString) {
            LineString lineString = (LineString) geom;
            if (Boolean.FALSE.equals(lineString.isEmpty())) {
                buffer.append("{\"type\": \"Feature\",\"geometry\": { \"type\": \"").append(lineString.getType()).append("\", \"coordinates\": [");
                for (int i = 0; i < lineString.getNumPoints(); i++) {
                    Point p = lineString.getPointN(i);
                    buffer.append("[").append(p.getCoordinate().getX()).append(", ").append(p.getCoordinate().getY()).append("]");
                    if (i != lineString.getNumPoints() - 1) {
                        buffer.append(",");
                    }
                }
                buffer.append("]");
            }
        } else {
            throw new RuntimeException("Geometry type not supported");
        }
        return buffer.toString();
    }
}
