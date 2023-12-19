package com.gr02.BomberMania.viewer.walls;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.elements.Walls.BrickWall;
import com.gr02.BomberMania.viewer.ElementViewer;

public class BrickViewer implements ElementViewer<BrickWall> {
    @Override
    public void draw(BrickWall brick, GUI gui) {
        gui.drawBrickWall(brick.getPosition());
    }
}
