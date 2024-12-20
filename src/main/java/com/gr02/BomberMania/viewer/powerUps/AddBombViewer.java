package com.gr02.BomberMania.viewer.powerUps;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.powerUps.AddBomb;
import com.gr02.BomberMania.viewer.ElementViewer;

public class AddBombViewer implements ElementViewer<AddBomb> {
    @Override
    public void draw(AddBomb element, GUI gui) {
        gui.drawAddBomb(element.getPosition());
    }
}
