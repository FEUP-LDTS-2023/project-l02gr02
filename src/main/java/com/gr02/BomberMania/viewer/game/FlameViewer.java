package com.gr02.BomberMania.viewer.game;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.elements.Flame;

public class FlameViewer implements ElementViewer<Flame> {

    @Override
    public void draw(Flame flame, GUI gui) {
        gui.drawFlame(flame.getPosition());
    }
}
