package com.gr02.BomberMania.model.game.elements;

import com.gr02.BomberMania.model.Position;
import com.gr02.BomberMania.viewer.ElementViewer;

public abstract class Element {

    private Position position;

    public Element(int x, int y) {
        this.position = new Position(x, y);
    }

    public Position getPosition() {
        return this.position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public abstract <T extends Element > ElementViewer<T> getViewer();
}
