package com.gr02.BomberMania.viewer.powerUps;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.powerUps.IncreaseExplosionRadius;
import com.gr02.BomberMania.viewer.ElementViewer;

public class IncreaseExplosionRadiusViewer implements ElementViewer<IncreaseExplosionRadius> {
    @Override
    public void draw(IncreaseExplosionRadius element, GUI gui) {
        gui.drawIncreaseExplosionRadius(element.getPosition());
    }
}
