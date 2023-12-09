package com.gr02.BomberMania.model.game.powerUps;

import com.gr02.BomberMania.model.game.elements.PlayableCharacter;

public class DecreaseTimer extends PowerUp {
    public DecreaseTimer(int x, int y) {
        super(x, y);
    }
    @Override
    public void execute(PlayableCharacter player) {
        player.decreaseBombTimer();
    }
}
