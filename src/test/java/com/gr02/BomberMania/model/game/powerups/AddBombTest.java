package com.gr02.BomberMania.model.game.powerups;

import com.gr02.BomberMania.model.game.elements.PlayableCharacter;
import com.gr02.BomberMania.model.game.powerUps.AddBomb;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class AddBombTest {
    @Test
    void addBombTest() {
        PlayableCharacter character = Mockito.mock(PlayableCharacter.class);
        AddBomb powerup = new AddBomb(0, 0);
        powerup.execute(character);
        Mockito.verify(character, Mockito.times(1)).increaseNumberOfBombs();
    }
}
