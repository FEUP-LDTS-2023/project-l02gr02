package com.gr02.BomberMania.model.game.powerUps;

import com.gr02.BomberMania.model.game.elements.Element;
import com.gr02.BomberMania.model.game.elements.PlayableCharacter;

public abstract class PowerUp extends Element {
    public PowerUp(int x, int y) {
        super(x, y);
    }
    public abstract void execute(PlayableCharacter player);
}
