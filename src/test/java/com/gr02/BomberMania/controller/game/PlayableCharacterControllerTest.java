package com.gr02.BomberMania.controller.game;

import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.model.Position;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.game.elements.Bomb;
import com.gr02.BomberMania.model.game.elements.BombInfo;
import com.gr02.BomberMania.model.game.elements.PlayableCharacter;
import com.gr02.BomberMania.model.game.elements.Walls.BrickWall;
import com.gr02.BomberMania.model.game.powerUps.AddBomb;
import com.gr02.BomberMania.model.game.powerUps.PowerUp;
import com.gr02.BomberMania.model.game.powerUps.PushBomb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PlayableCharacterControllerTest {
    private Arena arena;
    private PlayableCharacter character1;

    private PlayableCharacterController controller;

    @BeforeEach
    void setup() {
        arena = new Arena(10, 10);
        PushBomb pushBomb = new PushBomb(6, 5);
        List<PowerUp> powerUps = new ArrayList<PowerUp>();
        powerUps.add(pushBomb);
        arena.setPowerUps(powerUps);
        BrickWall brickWall = new BrickWall(4, 5);
        List<BrickWall> walls = new ArrayList<BrickWall>();
        walls.add(brickWall);
        arena.setBrickWalls(walls);
        Bomb bomb = new Bomb(5, 6, new BombInfo());
        List<Bomb> bombs = new ArrayList<Bomb>();
        bombs.add(bomb);
        arena.setBombs(bombs);
        character1 = new PlayableCharacter(5, 5, new BombInfo(), 1);
        arena.setPlayer1(character1);
        PlayableCharacter character2 = new PlayableCharacter(10, 10, new BombInfo(), 1);
        arena.setPlayer2(character2);
        controller = new Player1Controller(arena);
    }

    @Test
    void moveHero() {
        assertEquals(new Position(5, 5), arena.getPlayer1().getPosition());
        controller.moveHeroUp();
        assertEquals(new Position(5, 4), arena.getPlayer1().getPosition());
        controller.moveHeroDown();
        assertEquals(new Position(5, 5), arena.getPlayer1().getPosition());
        controller.moveHeroLeft();
        assertEquals(new Position(5, 5), arena.getPlayer1().getPosition());
        controller.moveHeroDown();
        assertEquals(new Position(5, 5), arena.getPlayer1().getPosition());
        assertEquals(new Position(5, 6), arena.getBombs().get(0).getPosition());
        controller.moveHeroRight();
        assertEquals(new Position(6, 5), arena.getPlayer1().getPosition());
        assertTrue(character1.canPushBombs());
        controller.moveHeroLeft();
        assertEquals(new Position(5, 5), arena.getPlayer1().getPosition());
        controller.moveHeroDown();
        assertEquals(new Position(5, 6), arena.getPlayer1().getPosition());
        assertEquals(new Position(5, 7), arena.getBombs().get(0).getPosition());
    }
}
