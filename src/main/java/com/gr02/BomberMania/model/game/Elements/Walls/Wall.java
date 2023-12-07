package com.gr02.BomberMania.model.game.Elements.Walls;

import com.gr02.BomberMania.model.game.Element;

public abstract class Wall extends Element {
    private final boolean destructible;
    public Wall(int x, int y, boolean destructible) {
        super(x, y);
        this.destructible = destructible;
    }
}
