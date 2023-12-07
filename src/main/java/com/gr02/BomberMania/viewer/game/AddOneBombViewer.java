package com.gr02.BomberMania.viewer.game;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.AddOneBomb;

public class AddOneBombViewer implements ElementViewer<AddOneBomb> {
    @Override
    public void draw(AddOneBomb AddOneBomb, GUI gui) {
        gui.drawAddOneBomb(AddOneBomb.getPosition());
    }
}
