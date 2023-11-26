package com.gr02.BomberMania.model.game.arena;

import com.gr02.BomberMania.model.game.elements.PlayableCharacter;

public class Arena {
    private final int height;
    private final int width;
    private PlayableCharacter playableCharacter;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public PlayableCharacter getPlayableCharacter() {
        return playableCharacter;
    }

    public void setPlayableCharacter(PlayableCharacter playableCharacter) {
        this.playableCharacter = playableCharacter;
    }
}
