package org.acme.geometry;

public abstract class AbstractGeometry implements Geometry {
    @Override
    public Geometry clone() {
        return this.clone();
    }

    public String asText() {
        WktVisitor visitor = new WktVisitor();
        this.accept(visitor);
        return visitor.getResult();
    }

    public Enveloppe getEnveloppe() {
        EnveloppeBuilder builder = new EnveloppeBuilder();
        this.accept(builder);
        return builder.build();
    }
}
