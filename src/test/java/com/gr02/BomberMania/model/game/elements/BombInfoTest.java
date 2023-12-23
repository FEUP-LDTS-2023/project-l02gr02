package com.gr02.BomberMania.model.game.elements;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BombInfoTest {
    private BombInfo bombInfo;
    private PlayableCharacter character;

    @BeforeEach
    void setup() {
        character = new PlayableCharacter(0, 0, new BombInfo(), 1);
        bombInfo = new BombInfo(60, 1, character);
    }

    @Test
    void reduceTimerTest() {
        Assertions.assertEquals(1 * 60, bombInfo.getTimer());

        for (int i = 0; i < 60; i++) {
            bombInfo.reduceTimer();
        }

        Assertions.assertEquals(0, bombInfo.getTimer());
    }

    @Test
    void cloneTest() {
        assertEquals(60, bombInfo.getTimer());
        assertEquals(5 * 60, character.getBombInfo().getTimer());

        bombInfo = (BombInfo) character.getBombInfo().clone();

        assertEquals(5 * 60, bombInfo.getTimer());
        assertEquals(5 * 60, character.getBombInfo().getTimer());

        bombInfo.reduceTimer();

        assertEquals(5 * 60 - 1 , bombInfo.getTimer());
        assertEquals(5 * 60, character.getBombInfo().getTimer());
    }
}
