package com.gr02.BomberMania.states;


public abstract class State<T> {

    private final T model;

    public State(T model) {
        this.model = model;
    }

    public T getModel() {
        return model;
    }

}
