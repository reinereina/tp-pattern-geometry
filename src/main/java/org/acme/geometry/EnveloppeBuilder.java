package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public class EnveloppeBuilder {
    private List<Coordinate> coordinates;

    public EnveloppeBuilder() {
        this.coordinates = new ArrayList<>();
    }

    public EnveloppeBuilder(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public void insert(Coordinate coordinate) {
        assert (coordinate != null);
        this.coordinates.add(coordinate);
    }

    public Enveloppe build() {
        if (!coordinates.isEmpty()) {
            double minX = coordinates.get(0).getX();
            double maxX = coordinates.get(0).getX();
            double minY = coordinates.get(0).getY();
            double maxY = coordinates.get(0).getY();
            for (Coordinate coordinate : coordinates) {
                minX = Math.min(minX, coordinate.getX());
                minY = Math.min(minY, coordinate.getY());
                maxX = Math.max(maxX, coordinate.getX());
                maxY = Math.max(maxY, coordinate.getY());
            }

            return new Enveloppe(new Coordinate(minX, minY), new Coordinate(maxX, maxY));
        } else {
            return new Enveloppe();
        }
    }
}
