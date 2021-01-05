package org.acme.geometry;

public class GeometryWithCachedEnveloppe implements Geometry, GeometryListener {
    private Geometry original;
    private Enveloppe cachedEnveloppe;

    public GeometryWithCachedEnveloppe(Geometry original) {
        this.original = original;
    }

    @Override
    public String getType() {
        return this.original.getType();
    }

    @Override
    public Boolean isEmpty() {
        return this.original.isEmpty();
    }

    @Override
    public void translate(double dx, double dy) {
        this.original.translate(dx, dy);
    }

    @Override
    public Geometry clone() {
        return this.original.clone();
    }

    @Override
    public Enveloppe getEnveloppe() {
        if (this.cachedEnveloppe == null) {
            this.cachedEnveloppe = this.original.getEnveloppe();
            this.addListener(this);
        }
        return this.cachedEnveloppe;
    }

    @Override
    public void accept(GeometryVisitor visitor) {
        this.original.accept(visitor);
    }

    @Override
    public void addListener(GeometryListener listener) {
        this.original.addListener(listener);
    }

    @Override
    public void onChange(Geometry geometry) {
        this.cachedEnveloppe = geometry.getEnveloppe();
    }
}
