package com.gr02.BomberMania.viewer.game.powerUps;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.PowerUps.AddOneBomb;
import com.gr02.BomberMania.viewer.game.ElementViewer;

public class AddOneBombViewer implements ElementViewer<AddOneBomb> {
    @Override
    public void draw(AddOneBomb element, GUI gui) {
        gui.drawAddOneBomb(element.getPosition());
    }
}
