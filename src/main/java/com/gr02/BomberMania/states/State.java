package com.gr02.BomberMania.states;


import com.gr02.BomberMania.viewer.Viewer;

public abstract class State<T> {

    private final T model;
    private final Viewer<T> viewer;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
    }

    protected abstract Viewer<T> getViewer();

    public T getModel() {
        return model;
    }

}
