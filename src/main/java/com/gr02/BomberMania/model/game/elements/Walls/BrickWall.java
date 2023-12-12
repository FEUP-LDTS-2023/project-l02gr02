package com.gr02.BomberMania.model.game.elements.Walls;

import com.gr02.BomberMania.model.game.elements.Element;
import com.gr02.BomberMania.viewer.game.ElementViewer;
import com.gr02.BomberMania.viewer.game.walls.BrickViewer;

public class BrickWall extends Wall {
    public BrickWall(int x, int y) {
        super(x, y, true);
    }

    @Override
    public <T extends Element> ElementViewer<T> getViewer() {
        return (ElementViewer<T>) new BrickViewer();
    }
}