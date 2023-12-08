package com.gr02.BomberMania.model.game.PowerUps;

import com.gr02.BomberMania.model.game.Elements.PlayableCharacter;

public class PushBomb extends  PowerUp{
    public PushBomb(int x, int y) {
        super(x, y);
    }
    @Override
    public void execute(PlayableCharacter player) {
        player.setCanPushBombs(true);
    }
}
