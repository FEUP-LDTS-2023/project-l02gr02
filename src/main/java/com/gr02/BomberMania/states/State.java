package com.gr02.BomberMania.states;


import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.controller.Controller;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.viewer.Viewer;

import java.io.IOException;

public abstract class State<T> {

    private final T model;
    private final Viewer<T> viewer;
    private final Controller<T> controller;

    public State(T model) {
        this.model = model;
        this.viewer = getViewer();
        this.controller = getController();
    }

    public abstract Viewer<T> getViewer();

    public abstract Controller<T> getController();

    public T getModel() {
        return model;
    }

    public void step(Game game, GUI gui, long time) throws IOException {
        GUI.ACTION action = gui.getNextAction();
        controller.step(game, action, time);
        viewer.draw(gui);
    }

}
