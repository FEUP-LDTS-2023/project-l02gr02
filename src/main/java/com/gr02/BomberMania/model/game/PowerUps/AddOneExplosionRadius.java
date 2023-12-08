package com.gr02.BomberMania.model.game.PowerUps;

import com.gr02.BomberMania.model.game.Elements.PlayableCharacter;

public class AddOneExplosionRadius extends PowerUp {

    public AddOneExplosionRadius(int x, int y) {
        super(x, y);
    }
    @Override
    public void execute(PlayableCharacter player) {
        player.increaseOneExplosionRadius();
    }
}
