package com.gr02.BomberMania.model.game.elements;

import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.viewer.ElementViewer;
import com.gr02.BomberMania.viewer.FlameViewer;

import static com.gr02.BomberMania.Game.FPS;

public class Flame extends Element implements Timed {

    private int timer;
    public Flame(int x, int y) {
        super(x, y);
        timer = FPS;
    }

    public int getTimer() {
        return timer;
    }

    @Override
    public void reduceTimer() { timer--;}

    public boolean checkHit(PlayableCharacter player) {
        if (player.getPosition().equals(getPosition())) {
            return true;
        }
        return false;
    }

    @Override
    public <T extends Element> ElementViewer<T> getViewer() {
        return (ElementViewer<T>) new FlameViewer();
    }
}
