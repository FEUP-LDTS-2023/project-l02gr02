package com.gr02.BomberMania.model.game.elements;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TimerTest {
    @Test
    void reduceTimerTest() {
        Timer timer = new Timer(0, 0, 60);

        assertEquals(1, timer.getTimeRemaining());

        for (int i = 0; i < 60; i++) {
            timer.reduceTimer();
        }

        assertEquals(0, timer.getTimeRemaining());
    }
}
