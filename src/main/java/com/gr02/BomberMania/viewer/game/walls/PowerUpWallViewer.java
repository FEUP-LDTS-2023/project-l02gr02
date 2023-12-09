package com.gr02.BomberMania.viewer.game.walls;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.elements.Walls.PowerUpWall;
import com.gr02.BomberMania.viewer.game.ElementViewer;

public class PowerUpWallViewer implements ElementViewer<PowerUpWall> {
    @Override
    public void draw(PowerUpWall powerUpWall, GUI gui) {
        gui.drawPowerUpWall(powerUpWall.getPosition());
    }
}
