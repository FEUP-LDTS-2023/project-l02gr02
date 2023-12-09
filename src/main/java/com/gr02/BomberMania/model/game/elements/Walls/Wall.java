package com.gr02.BomberMania.model.game.elements.Walls;

import com.gr02.BomberMania.model.game.elements.Element;

public abstract class Wall extends Element {
    private final boolean destructible;
    public Wall(int x, int y, boolean destructible) {
        super(x, y);
        this.destructible = destructible;
    }
}
