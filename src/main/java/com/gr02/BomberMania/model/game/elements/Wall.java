package com.gr02.BomberMania.model.game.elements;

import com.gr02.BomberMania.model.Position;

public abstract class Wall extends Element {
    private final boolean destructible;
    public Wall(int x, int y, boolean destructible) {
        super(x, y);
        this.destructible = destructible;
    }
}
