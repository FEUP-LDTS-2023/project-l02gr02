package com.gr02.BomberMania.viewer.walls;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.elements.Walls.IndestructibleWall;
import com.gr02.BomberMania.viewer.ElementViewer;

public class IndestructibleWallViewer implements ElementViewer<IndestructibleWall> {
    @Override
    public void draw(IndestructibleWall wall, GUI gui) {
        gui.drawIndestructibleWall(wall.getPosition());
    }
}
