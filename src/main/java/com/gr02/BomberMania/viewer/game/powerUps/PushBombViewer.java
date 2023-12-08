package com.gr02.BomberMania.viewer.game.powerUps;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.PowerUps.PushBomb;
import com.gr02.BomberMania.viewer.game.ElementViewer;

public class PushBombViewer implements ElementViewer<PushBomb> {
    @Override
    public void draw(PushBomb element, GUI gui) {
        gui.drawPushBomb(element.getPosition());
    }
}
