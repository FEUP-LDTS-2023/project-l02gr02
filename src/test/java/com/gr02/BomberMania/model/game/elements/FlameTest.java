package com.gr02.BomberMania.model.game.elements;

import com.gr02.BomberMania.model.Position;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlameTest {

    private List<Flame> flames;

    @BeforeEach
    void setup() {
        flames = new ArrayList<Flame>();
        for (int i = 0; i < 10; i++) {
            flames.add(new Flame(i, i));
        }
    }

    @Test
    void reduceTimerTest() {
        assertEquals(1 * 60, flames.get(0).getTimer());

        for (int i = 0; i < 60; i++) {
            flames.get(0).reduceTimer();
        }

        assertEquals(0, flames.get(0).getTimer());
    }

    @Test
    void checkHitTest() {
        PlayableCharacter character = new PlayableCharacter(5, 5, new BombInfo(), 1);

        for (Flame flame : flames) {
            if (flame.getPosition().equals(new Position(5, 5))) {
                assertEquals(true, flame.checkHit(character));
                continue;
            }
            assertEquals(false, flame.checkHit(character));
        }

        flames.get(5).setPosition(new Position(0, 0));

        assertEquals(false, flames.get(5).checkHit(character));
    }
}
