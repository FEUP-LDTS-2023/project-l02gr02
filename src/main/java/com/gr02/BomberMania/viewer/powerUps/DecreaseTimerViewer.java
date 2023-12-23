package com.gr02.BomberMania.viewer.powerUps;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.powerUps.DecreaseTimer;
import com.gr02.BomberMania.viewer.ElementViewer;

public class DecreaseTimerViewer implements ElementViewer<DecreaseTimer> {
    @Override
    public void draw(DecreaseTimer element, GUI gui) {
        gui.drawDecreaseTimer(element.getPosition());
    }
}
