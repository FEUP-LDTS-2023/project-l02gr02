package com.gr02.BomberMania.model.game.powerups;

import com.gr02.BomberMania.model.game.elements.BombInfo;
import com.gr02.BomberMania.model.game.elements.PlayableCharacter;
import com.gr02.BomberMania.model.game.powerUps.PushBomb;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class PushBombTest {
    @Test
    void pushBombTest() {
        PlayableCharacter character = new PlayableCharacter(0, 0, new BombInfo(), 1);
        PushBomb powerup = new PushBomb(0, 0);
        assertTrue(!character.canPushBombs());
        powerup.execute(character);
        assertTrue(character.canPushBombs());
    }
}
