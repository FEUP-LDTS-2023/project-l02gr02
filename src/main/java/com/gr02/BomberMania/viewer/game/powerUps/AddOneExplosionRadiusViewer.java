package com.gr02.BomberMania.viewer.game.powerUps;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.PowerUps.AddOneExplosionRadius;
import com.gr02.BomberMania.viewer.game.ElementViewer;

public class AddOneExplosionRadiusViewer implements ElementViewer<AddOneExplosionRadius> {
    @Override
    public void draw(AddOneExplosionRadius element, GUI gui) {
        gui.drawAddOneExplosionRadius(element.getPosition());
    }
}
