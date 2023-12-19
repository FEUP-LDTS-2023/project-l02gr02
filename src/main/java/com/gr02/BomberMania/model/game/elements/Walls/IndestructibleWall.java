package com.gr02.BomberMania.model.game.elements.Walls;

import com.gr02.BomberMania.model.game.elements.Element;
import com.gr02.BomberMania.viewer.game.ElementViewer;
import com.gr02.BomberMania.viewer.game.walls.IndestructibleWallViewer;

public class IndestructibleWall extends Wall {
    public IndestructibleWall(int x, int y) {
        super(x, y);
    }

    @Override
    public <T extends Element> ElementViewer<T> getViewer() {
        return (ElementViewer<T>) new IndestructibleWallViewer();
    }
}
