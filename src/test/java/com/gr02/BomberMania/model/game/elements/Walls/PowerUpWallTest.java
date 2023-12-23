package com.gr02.BomberMania.model.game.elements.Walls;

import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.game.powerUps.PowerUp;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PowerUpWallTest {

    @Test
    void dropPowerUpTest() {
        // Mocking Arena and setting up List that will receive powerups
        Arena arena = Mockito.mock(Arena.class);

        List<PowerUp> receiver = new ArrayList<PowerUp>();
        Mockito.when(arena.getPowerUps()).thenReturn(receiver);

        for (int i = 0; i < 10; i++) {
            PowerUpWall powerUpWall = new PowerUpWall(i, i);
            powerUpWall.dropPowerup(arena);
        }

        assertEquals(10, receiver.size());
    }
}
