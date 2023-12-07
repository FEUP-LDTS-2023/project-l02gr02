package com.gr02.BomberMania.viewer.game;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.Elements.Walls.BrickWall;

public class BrickViewer implements ElementViewer<BrickWall> {
    @Override
    public void draw(BrickWall brick, GUI gui) {
        gui.drawBrickWall(brick.getPosition());
    }
}
