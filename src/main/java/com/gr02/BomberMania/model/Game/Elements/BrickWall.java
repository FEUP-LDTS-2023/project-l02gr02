package com.gr02.BomberMania.model.Game.Elements;

import com.gr02.BomberMania.model.Position;

public class BrickWall extends Wall {
    private final boolean destructible = false;
    public BrickWall(Position p) {
        super(p);
    }
}