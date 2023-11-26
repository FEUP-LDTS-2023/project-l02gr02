package com.gr02.BomberMania.model.game.elements;

import com.gr02.BomberMania.model.Position;

public class IndestructibleWall extends Wall{
    public IndestructibleWall(int x, int y) {
        super(x, y, false);
    }
}
