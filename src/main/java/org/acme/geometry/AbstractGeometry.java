package org.acme.geometry;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGeometry implements Geometry {
    private List<GeometryListener> listeners = new ArrayList<>();

    @Override
    public abstract Geometry clone();

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

    public void addListener(GeometryListener listener) {
        this.listeners.add(listener);
    }

    protected void triggerChange() {
        for (GeometryListener listener : this.listeners) {
            listener.onChange(this);
        }
    }
}
