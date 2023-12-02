package com.gr02.BomberMania.viewer.game;


import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.IndestructibleWall;

public class IndestructibleWallViewer implements ElementViewer<IndestructibleWall> {
    @Override
    public void draw(IndestructibleWall wall, GUI gui) {
        gui.drawIndestructibleWall(wall.getPosition());
    }
}
