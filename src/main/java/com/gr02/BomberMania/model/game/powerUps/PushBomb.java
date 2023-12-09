package com.gr02.BomberMania.model.game.powerUps;

import com.gr02.BomberMania.model.game.elements.PlayableCharacter;

public class PushBomb extends  PowerUp{
    public PushBomb(int x, int y) {
        super(x, y);
    }
    @Override
    public void execute(PlayableCharacter player) {
        player.setCanPushBombs(true);
    }
}
