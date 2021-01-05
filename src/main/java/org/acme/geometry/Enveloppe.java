package org.acme.geometry;

public class Enveloppe {
    private final Coordinate bottomLeft;
    private final Coordinate topRight;

    public Enveloppe() {
        this.bottomLeft = new Coordinate();
        this.topRight = new Coordinate();
    }

    public Enveloppe(Coordinate bottomLeft, Coordinate topRight) {
        this.bottomLeft = bottomLeft;
        this.topRight = topRight;
    }

    public Boolean isEmpty() {
        return bottomLeft.isEmpty() || topRight.isEmpty();
    }

    public double getXmin() {
        return this.bottomLeft.getX();
    }

    public double getXmax() {
        return this.topRight.getX();
    }

    public double getYmin() {
        return this.bottomLeft.getY();
    }

    public double getYmax() {
        return this.topRight.getY();
    }
}
