package com.gr02.BomberMania.model.game.elements;

import com.gr02.BomberMania.model.Position;

public class Element {

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
}
