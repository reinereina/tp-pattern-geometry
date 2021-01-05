package org.acme.geometry;

public interface Geometry {
    String getType();

    Boolean isEmpty();

    void translate(double dx, double dy);

    Geometry clone();

    Enveloppe getEnveloppe();

}
