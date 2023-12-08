package com.gr02.BomberMania.viewer.game.walls;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.Elements.Walls.IndestructibleWall;
import com.gr02.BomberMania.viewer.game.ElementViewer;

public class IndestructibleWallViewer implements ElementViewer<IndestructibleWall> {
    @Override
    public void draw(IndestructibleWall wall, GUI gui) {
        gui.drawIndestructibleWall(wall.getPosition());
    }
}
