package com.gr02.BomberMania.model.game.powerups;

import com.gr02.BomberMania.model.game.elements.BombInfo;
import com.gr02.BomberMania.model.game.elements.PlayableCharacter;
import com.gr02.BomberMania.model.game.powerUps.DetonateBomb;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DetonateBombTest {
    @Test
    void detonateBombTest() {
        PlayableCharacter character = new PlayableCharacter(0, 0, new BombInfo(), 1);
        DetonateBomb powerup = new DetonateBomb(0, 0);
        assertTrue(!character.canDetonateBombs());
        powerup.execute(character);
        assertTrue(character.canDetonateBombs());
    }
}
