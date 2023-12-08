package com.gr02.BomberMania.model.game.Elements;

import com.gr02.BomberMania.model.game.Element;
import com.gr02.BomberMania.model.game.arena.Arena;

public class Flame extends Element implements Timer {

    private int timer;
    public Flame(int x, int y) {
        super(x, y);
        timer = 60;
    }

    public int getTimer() {
        return timer;
    }

    @Override
    public void reduceTimer() { timer--;}

    public boolean checkHit(Arena arena, PlayableCharacter player) {
        if (player.getPosition().equals(getPosition())) {
            return true;
        }
        return false;
    }
}
