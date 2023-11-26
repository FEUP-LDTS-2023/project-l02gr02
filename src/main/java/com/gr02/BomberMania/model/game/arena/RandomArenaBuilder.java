package com.gr02.BomberMania.model.game.arena;

import com.gr02.BomberMania.model.game.elements.BombInfo;
import com.gr02.BomberMania.model.game.elements.PlayableCharacter;

import java.util.Random;

public class RandomArenaBuilder extends ArenaBuilder {
    private final Random rng;

    private final int width;
    private final int height;

    public RandomArenaBuilder(int width, int height) {
        this.rng = new Random();

        this.width = width;
        this.height = height;
    }

    @Override
    protected int getWidth() {
        return width;
    }

    @Override
    protected int getHeight() {
        return height;
    }

    @Override
    protected PlayableCharacter createPlayableCharacter() {
        return new PlayableCharacter(width / 2, height / 2, new BombInfo());
    }
}