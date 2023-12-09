package com.gr02.BomberMania.model.game.powerUps;

import com.gr02.BomberMania.model.game.elements.PlayableCharacter;

public class IncreaseExplosionRadius extends PowerUp {

    public IncreaseExplosionRadius(int x, int y) {
        super(x, y);
    }
    @Override
    public void execute(PlayableCharacter player) {
        player.increaseOneExplosionRadius();
    }
}
