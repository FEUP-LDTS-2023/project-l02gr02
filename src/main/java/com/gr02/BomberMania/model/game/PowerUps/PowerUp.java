package com.gr02.BomberMania.model.game.PowerUps;

import com.gr02.BomberMania.model.game.Elements.Element;
import com.gr02.BomberMania.model.game.Elements.PlayableCharacter;

public abstract class PowerUp extends Element {
    public PowerUp(int x, int y) {
        super(x, y);
    }
    public abstract void execute(PlayableCharacter player);
}
