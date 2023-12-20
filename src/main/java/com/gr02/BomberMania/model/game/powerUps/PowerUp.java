package com.gr02.BomberMania.model.game.powerUps;

import com.gr02.BomberMania.model.game.elements.Element;
import com.gr02.BomberMania.model.game.elements.PlayableCharacter;
import com.gr02.BomberMania.viewer.ElementViewer;

public abstract class PowerUp extends Element {
    public PowerUp(int x, int y) {
        super(x, y);
    }
    public abstract void execute(PlayableCharacter player);
    @Override
    public abstract <T extends Element > ElementViewer<T> getViewer();
}
