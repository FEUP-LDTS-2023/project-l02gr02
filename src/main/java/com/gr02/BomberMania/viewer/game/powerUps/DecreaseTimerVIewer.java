package com.gr02.BomberMania.viewer.game.powerUps;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.PowerUps.DecreaseTimer;
import com.gr02.BomberMania.viewer.game.ElementViewer;

public class DecreaseTimerVIewer implements ElementViewer<DecreaseTimer> {
    @Override
    public void draw(DecreaseTimer element, GUI gui) {
        gui.drawDecreaseTimer(element.getPosition());
    }
}
