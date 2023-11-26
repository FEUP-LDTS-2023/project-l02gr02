package com.gr02.BomberMania.viewer.game;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.elements.Bomb;

public class BombViewer implements ElementViewer<Bomb> {
    @Override
    public void draw(Bomb bomb, GUI gui) {
        gui.drawBomb(bomb.getPosition());
    }
}
