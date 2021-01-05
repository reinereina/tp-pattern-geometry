package org.acme.geometry;

import java.util.Locale;

public class WktVisitor implements GeometryVisitor {
    private StringBuilder bufferString = new StringBuilder();

    @Override
    public void visit(Point point) {
        this.bufferString.append(point.getType().toUpperCase(Locale.ROOT));
        if (Boolean.TRUE.equals(point.isEmpty())) {
            this.bufferString.append(" EMPTY");
        } else {
            this.bufferString.append("(").append(point.getCoordinate().getX()).append(" ").append(point.getCoordinate().getY()).append(")");
        }
    }

    @Override
    public void visit(LineString lineString) {
        this.bufferString.append(lineString.getType().toUpperCase());
        if (Boolean.TRUE.equals(lineString.isEmpty())) {
            this.bufferString.append(" EMPTY");
        } else {
            this.bufferString.append("(");
            for (int i = 0; i < lineString.getNumPoints(); i++) {
                Point p = lineString.getPointN(i);
                this.bufferString.append(p.getCoordinate().getX()).append(" ").append(p.getCoordinate().getY());
                if (i != lineString.getNumPoints() - 1) {
                    this.bufferString.append(",");
                }
            }
            this.bufferString.append(")");
        }
    }

    public String getResult() {
        return this.bufferString.toString();
    }
}
