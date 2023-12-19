package com.gr02.BomberMania.model.game;

import com.gr02.BomberMania.model.game.elements.BombInfo;
import com.gr02.BomberMania.model.game.elements.PlayableCharacter;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.Positive;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayableCharacterTest {

    @Property
    void increaseNumberOfBombs(@ForAll @Positive @IntRange(min = 0, max = 10) int increase) {
        PlayableCharacter character = new PlayableCharacter(0, 0, new BombInfo(), 1);
        for (int i = 0; i < increase; i++) {
            character.increaseNumberOfBombs();
        }
        if (increase < 5) assertEquals(increase+1, character.getNumberOfBombs());
        else assertEquals(5, character.getNumberOfBombs());
    }

    @Property
    void decreaseNumberofBombs(@ForAll @Positive @IntRange(min = 0, max = 10) int increase, @ForAll @Positive @IntRange(min = 0, max = 10)int decrease) {
        PlayableCharacter character = new PlayableCharacter(0, 0, new BombInfo(), 1);
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
