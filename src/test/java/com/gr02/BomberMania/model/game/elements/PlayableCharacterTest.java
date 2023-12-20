package com.gr02.BomberMania.model.game.elements;

import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.game.elements.Bomb;
import com.gr02.BomberMania.model.game.elements.BombInfo;
import com.gr02.BomberMania.model.game.elements.PlayableCharacter;
import net.jqwik.api.ForAll;
import net.jqwik.api.Property;
import net.jqwik.api.constraints.IntRange;
import net.jqwik.api.constraints.Positive;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static com.gr02.BomberMania.Game.FPS;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayableCharacterTest {
    private PlayableCharacter character;

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

    @BeforeEach
    void setUp() {
        character = new PlayableCharacter(0, 0, new BombInfo(), 1);
    }

    @Test
    void increaseOneExplosionRadiusTest() {
        BombInfo info = character.getBombInfo();
        character.increaseOneExplosionRadius();
        assertEquals(2, info.getExplosionRadius());
        info.setExplosionRadius(4);
        character.increaseOneExplosionRadius();
        assertEquals(5, info.getExplosionRadius());
        character.increaseOneExplosionRadius();
        assertEquals(5, info.getExplosionRadius());
    }

    @Test
    void decreaseBombTimerTest() {
        BombInfo info = character.getBombInfo();
        character.decreaseBombTimer();
        assertEquals(4*FPS, info.getTimer());
        character.decreaseBombTimer();
        character.decreaseBombTimer();
        assertEquals(2*FPS, info.getTimer());
        character.decreaseBombTimer();
        assertEquals(2*FPS, info.getTimer());
    }

    @Test
    void observersTest() {
        // Mock bombs and their behaviour
        Bomb bomb1 = Mockito.mock(Bomb.class);
        Mockito.doAnswer((i) -> {
            character.removeObserver(bomb1);
            return null;
        }).when(bomb1).explode(Mockito.any(Arena.class));

        Bomb bomb2 = Mockito.mock(Bomb.class);
        Mockito.doAnswer((i) -> {
            character.removeObserver(bomb2);
            return null;
        }).when(bomb2).explode(Mockito.any(Arena.class));

        // Mock arena
        Arena arena = Mockito.mock(Arena.class);

        // Player tries to detonate bombs without permission
        character.addObserver(bomb1);
        Mockito.verify(bomb1, Mockito.never()).explode(arena);
        Mockito.verify(bomb2, Mockito.never()).explode(arena);
        if (character.canDetonateBombs()) character.detonateBombs(arena);
        Mockito.verify(bomb1, Mockito.never()).explode(arena);
        Mockito.verify(bomb2, Mockito.never()).explode(arena);
        // Player gains powerup and detonates bombs
        character.setCanDetonateBombs(true);
        if (character.canDetonateBombs()) character.detonateBombs(arena);
        Mockito.verify(bomb1, Mockito.times(1)).explode(arena);
        Mockito.verify(bomb2, Mockito.never()).explode(arena);
        character.addObserver(bomb1);
        character.addObserver(bomb2);
        Mockito.verify(bomb1, Mockito.times(1)).explode(arena);
        Mockito.verify(bomb2, Mockito.never()).explode(arena);
        character.detonateBombs(arena);
        Mockito.verify(bomb1, Mockito.times(2)).explode(arena);
        Mockito.verify(bomb2, Mockito.times(1)).explode(arena);
    }
}
