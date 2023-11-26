package com.gr02.BomberMania.viewer.Game;


import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.Game.Elements.IndestructibleWall;

public class WallViewer implements ElementViewer<IndestructibleWall> {
    @Override
    public void draw(IndestructibleWall wall, GUI gui) {
        gui.drawIndestructibleWall(wall.getPosition());
    }
}
