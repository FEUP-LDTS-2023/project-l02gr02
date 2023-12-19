package com.gr02.BomberMania.viewer.powerUps;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.powerUps.DetonateBomb;
import com.gr02.BomberMania.viewer.ElementViewer;

public class DetonateBombViewer implements ElementViewer<DetonateBomb> {
    @Override
    public void draw(DetonateBomb element, GUI gui) {
        gui.drawDetonateBomb(element.getPosition());
    }
}
