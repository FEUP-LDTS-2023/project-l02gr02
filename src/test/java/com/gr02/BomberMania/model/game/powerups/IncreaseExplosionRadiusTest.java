package com.gr02.BomberMania.model.game.powerups;

import com.gr02.BomberMania.model.game.elements.PlayableCharacter;
import com.gr02.BomberMania.model.game.powerUps.IncreaseExplosionRadius;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class IncreaseExplosionRadiusTest {
    @Test
    void increaseExplosionRadiusTest() {
        PlayableCharacter character = Mockito.mock(PlayableCharacter.class);
        IncreaseExplosionRadius powerup = new IncreaseExplosionRadius(0, 0);
        powerup.execute(character);
        Mockito.verify(character, Mockito.times(1)).increaseOneExplosionRadius();
    }
}
