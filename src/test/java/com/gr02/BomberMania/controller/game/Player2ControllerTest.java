package com.gr02.BomberMania.controller.game;

import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.Position;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.game.elements.Bomb;
import com.gr02.BomberMania.model.game.elements.BombInfo;
import com.gr02.BomberMania.model.game.elements.PlayableCharacter;
import com.gr02.BomberMania.model.game.elements.Walls.BrickWall;
import com.gr02.BomberMania.model.game.powerUps.PowerUp;
import com.gr02.BomberMania.model.game.powerUps.PushBomb;
import com.gr02.BomberMania.states.menu.MainMenuState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class Player2ControllerTest {
    Game game;
    private Arena arena;
    private PlayableCharacter character2;
    private Player2Controller controller;

    @BeforeEach
    void setup() {
        game = Mockito.mock(Game.class);
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
        character2 = new PlayableCharacter(8, 8, new BombInfo(), 2);
        arena.setPlayer2(character2);
        PlayableCharacter character1 = new PlayableCharacter(10, 10, new BombInfo(), 1);
        arena.setPlayer1(character1);
        controller = new Player2Controller(arena);
    }

    @Test
    void stepTest() throws IOException {
        assertEquals(new Position(8, 8), arena.getPlayer2().getPosition());
        controller.step(game, GUI.ACTION.UP2, 1);
        assertEquals(new Position(8, 7), arena.getPlayer2().getPosition());
        controller.step(game, GUI.ACTION.DOWN2, 1);
        assertEquals(new Position(8, 8), arena.getPlayer2().getPosition());
        controller.step(game, GUI.ACTION.LEFT2, 1);
        assertEquals(new Position(7, 8), arena.getPlayer2().getPosition());
        controller.step(game, GUI.ACTION.RIGHT2, 1);
        assertEquals(new Position(8, 8), arena.getPlayer2().getPosition());

        assertEquals(1, arena.getBombs().size());
        controller.step(game, GUI.ACTION.BOMB2, 1);
        assertEquals(new Position(8, 8), arena.getPlayer2().getPosition());
        assertEquals(new Position(8, 8), arena.getBombs().get(1).getPosition());
        assertEquals(1, character2.getObservers().size());
        assertEquals(0, character2.getNumberOfBombs());
        assertEquals(2, arena.getBombs().size());

        controller.step(game, GUI.ACTION.BOMB2, 1);
        assertEquals(new Position(8, 8), arena.getPlayer2().getPosition());
        assertEquals(new Position(8, 8), arena.getBombs().get(1).getPosition());
        assertEquals(1, character2.getObservers().size());
        assertEquals(0, character2.getNumberOfBombs());
        assertEquals(2, arena.getBombs().size());

        character2.increaseNumberOfBombs();
        controller.step(game, GUI.ACTION.BOMB2, 1);
        assertEquals(new Position(8, 8), arena.getPlayer2().getPosition());
        assertEquals(new Position(8, 8), arena.getBombs().get(1).getPosition());
        assertEquals(1, character2.getObservers().size());
        assertEquals(1, character2.getNumberOfBombs());
        assertEquals(2, arena.getBombs().size());

        controller.step(game, GUI.ACTION.DETONATE2, 1);
        assertEquals(new Position(8, 8), arena.getPlayer2().getPosition());
        assertEquals(new Position(8, 8), arena.getBombs().get(1).getPosition());
        assertEquals(1, character2.getObservers().size());
        assertEquals(1, character2.getNumberOfBombs());
        assertEquals(2, arena.getBombs().size());

        character2.setCanDetonateBombs(true);
        controller.step(game, GUI.ACTION.DETONATE2, 1);
        assertEquals(new Position(8, 8), arena.getPlayer2().getPosition());
        assertEquals(1, arena.getBombs().size());
        assertEquals(0, character2.getObservers().size());
        assertEquals(2, character2.getNumberOfBombs());
        assertEquals(1, arena.getBombs().size());

        controller.step(game, GUI.ACTION.BACKTOMENU, 1);
        Mockito.verify(game, Mockito.times(1)).setState(any(MainMenuState.class));
    }
}
