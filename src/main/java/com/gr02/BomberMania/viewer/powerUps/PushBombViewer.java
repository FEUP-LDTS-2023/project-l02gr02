package com.gr02.BomberMania.viewer.powerUps;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.powerUps.PushBomb;
import com.gr02.BomberMania.viewer.ElementViewer;

public class PushBombViewer implements ElementViewer<PushBomb> {
    @Override
    public void draw(PushBomb element, GUI gui) {
        gui.drawPushBomb(element.getPosition());
    }
}
