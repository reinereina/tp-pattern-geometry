package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class GeometryCollection extends AbstractGeometry {
    private List<Geometry> geometries;

    public GeometryCollection() {
        this.geometries = new ArrayList<>();
    }

    public GeometryCollection(List<Geometry> geometries) {
        assert (geometries != null);
        this.geometries = geometries;
    }

    public int getNumGeometries() {
        return this.geometries.size();
    }

    public Geometry getGeometryN(int n) {
        if (n >= this.geometries.size() || n < 0) {
            return null;
        }
        return this.geometries.get(n);
    }

    @Override
    public String getType() {
        return "GeometryCollection";
    }

    @Override
    public Boolean isEmpty() {
        return this.getNumGeometries() == 0;
    }

    @Override
    public void translate(double dx, double dy) {
        for (Geometry geometry : this.geometries) {
            geometry.translate(dx, dy);
        }
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Geometry clone() {
        List<Geometry> newGeometries = new ArrayList<>();
        for (Geometry geometry : this.geometries) {
            newGeometries.add(geometry.clone());
        }
        return new GeometryCollection(newGeometries);
    }


}
