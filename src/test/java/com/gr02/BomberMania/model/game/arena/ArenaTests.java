package com.gr02.BomberMania.model.game.arena;

import com.gr02.BomberMania.model.Position;
import com.gr02.BomberMania.model.game.elements.Bomb;
import com.gr02.BomberMania.model.game.elements.BombInfo;
import com.gr02.BomberMania.model.game.elements.PlayableCharacter;
import com.gr02.BomberMania.model.game.elements.Walls.BrickWall;
import com.gr02.BomberMania.model.game.elements.Walls.IndestructibleWall;
import com.gr02.BomberMania.model.game.elements.Walls.PowerUpWall;
import com.gr02.BomberMania.model.game.powerUps.AddBomb;
import com.gr02.BomberMania.model.game.powerUps.PowerUp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArenaTests {
    Arena arena = new Arena(10, 10);
    Bomb bomb = Mockito.mock(Bomb.class);

    AddBomb addBomb = new AddBomb(6, 6);

    @BeforeEach
    void setup() {
        // Setting up obstacles
        BrickWall brickWall = new BrickWall(0, 0);
        BrickWall brickWall2 = new BrickWall(7, 7);
        List<BrickWall> brickWalls = new ArrayList<BrickWall>();
        brickWalls.add(brickWall);
        brickWalls.add(brickWall2);
        IndestructibleWall indestructibleWall = new IndestructibleWall(1, 1);
        IndestructibleWall indestructibleWall2 = new IndestructibleWall(8, 8);
        List<IndestructibleWall> indestructibleWalls = new ArrayList<IndestructibleWall>();
        indestructibleWalls.add(indestructibleWall);
        indestructibleWalls.add(indestructibleWall2);
        PowerUpWall powerUpWall = new PowerUpWall(2, 2);
        PowerUpWall powerUpWall2 = new PowerUpWall(9, 9);
        List<PowerUpWall> powerUpWalls = new ArrayList<PowerUpWall>();
        powerUpWalls.add(powerUpWall);
        powerUpWalls.add(powerUpWall2);
        PlayableCharacter character1 = new PlayableCharacter(4, 4, new BombInfo(), 1);
        PlayableCharacter character2 = new PlayableCharacter(5, 5, new BombInfo(), 2);
        List<PowerUp> powerUps = new ArrayList<PowerUp>();
        powerUps.add(addBomb);

        // Creating test arena
        arena.setBrickWalls(brickWalls);
        arena.setIndestructibleWalls(indestructibleWalls);
        arena.setPowerUpWalls(powerUpWalls);
        Bomb bomb2 = new Bomb(10, 10, new BombInfo());
        arena.addBomb(bomb);
        arena.addBomb(bomb2);
        arena.setPlayer1(character1);
        arena.setPlayer2(character2);
        arena.setPowerUps(powerUps);

        Mockito.when(bomb.getPosition()).thenReturn(new Position(3, 3));
        Mockito.doAnswer((i) -> {
            arena.getBombs().remove(bomb);
            return null;
        }).when(bomb).explode(arena);
    }

    @Test
    void isEmptyTest() {
        assertEquals(false, arena.isEmpty(new Position(0, 0)));
        assertEquals(false, arena.isEmpty(new Position(1, 1)));
        assertEquals(false, arena.isEmpty(new Position(2, 2)));
        assertEquals(false, arena.isEmpty(new Position(3, 3)));
        assertEquals(false, arena.isEmpty(new Position(4, 4)));
        assertEquals(false, arena.isEmpty(new Position(5, 5)));
        assertEquals(true, arena.isEmpty(new Position(6, 6)));
        assertEquals(true, arena.isEmpty(new Position(0, 1)));
    }

    @Test
    void checkForBombsTest() {
        assertEquals(null, arena.checkForBombs(new Position(0, 0)));
        assertEquals(bomb, arena.checkForBombs(new Position(3, 3)));
    }

    @Test
    void checkForUpgradesTest() {
        assertEquals(null, arena.checkForUpgrades(new Position(0, 0)));
        assertEquals(addBomb, arena.checkForUpgrades(new Position(6, 6)));
    }

    @Test
    void destructTest() {
        assertEquals(true, arena.destruct(new Position(0, 0)));
        assertEquals(1, arena.getBrickWalls().size());
        assertEquals(true, arena.destruct(new Position(2, 2)));
        assertEquals(1, arena.getPowerUpWalls().size());
        assertEquals(true, arena.destruct(new Position(3, 3)));
        assertEquals(1, arena.getBombs().size());
        assertEquals(false, arena.destruct(new Position(6, 6)));
        assertEquals(1, arena.getPowerUps().size());
        assertEquals(false, arena.destruct(new Position(0, 1)));
        assertEquals(1, arena.getBrickWalls().size());
        assertEquals(2, arena.getIndestructibleWalls().size());
        assertEquals(1, arena.getPowerUpWalls().size());
        assertEquals(1, arena.getBombs().size());
        assertEquals(1, arena.getPowerUps().size());
    }
}
