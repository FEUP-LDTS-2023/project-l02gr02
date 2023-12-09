package com.gr02.BomberMania.model.game;

import com.gr02.BomberMania.model.game.elements.BombInfo;
import com.gr02.BomberMania.model.game.elements.PlayableCharacter;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.Positive;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayableCharacterTest {

    @Property
    void increaseNumberOfBombs(@ForAll @Positive int increase) {
        PlayableCharacter character = new PlayableCharacter(0, 0, new BombInfo());
        for (int i = 0; i < increase; i++) {
            character.increaseNumberOfBombs();
        }
        if (increase < 5) assertEquals(increase+1, character.getNumberOfBombs());
        else assertEquals(5, character.getNumberOfBombs());
    }

    @Property
    void decreaseNumberofBombs(@ForAll @Positive int increase, @ForAll @Positive int decrease) {
        PlayableCharacter character = new PlayableCharacter(0, 0, new BombInfo());
        for (int i = 0; i < increase; i++) {
            character.increaseNumberOfBombs();
        }
        for (int i = 0; i < decrease; i++) {
            character.decreaseNumberOfBombs();
        }
        if (increase >= 5) increase = 4;
        if (decrease > 6) decrease = 5;
        if (increase+1 > decrease) assertEquals(increase - decrease + 1, character.getNumberOfBombs());
        else assertEquals(0, character.getNumberOfBombs());
    }
}
