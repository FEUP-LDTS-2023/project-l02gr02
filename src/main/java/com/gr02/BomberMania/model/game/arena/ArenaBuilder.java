package com.gr02.BomberMania.model.game.arena;

import com.gr02.BomberMania.model.game.elements.PlayableCharacter;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());
        arena.setPlayableCharacter(createPlayableCharacter());
        return arena;
    }
    protected abstract int getWidth();
    protected abstract int getHeight();
    protected abstract PlayableCharacter createPlayableCharacter();
}
