package com.gr02.BomberMania.model.game.powerups;

import com.gr02.BomberMania.model.game.elements.PlayableCharacter;

import com.gr02.BomberMania.model.game.powerUps.DecreaseTimer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class DecreaseTimerTest {
    @Test
    void decreaseTimerTest() {
        PlayableCharacter character = Mockito.mock(PlayableCharacter.class);
        DecreaseTimer powerup = new DecreaseTimer(0, 0);
        powerup.execute(character);
        Mockito.verify(character, Mockito.times(1)).decreaseBombTimer();
    }
}
