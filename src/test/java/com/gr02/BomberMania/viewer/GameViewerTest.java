package com.gr02.BomberMania.viewer;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.Position;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.game.elements.*;
import com.gr02.BomberMania.model.game.elements.Walls.BrickWall;
import com.gr02.BomberMania.model.game.elements.Walls.IndestructibleWall;
import com.gr02.BomberMania.model.game.elements.Walls.PowerUpWall;
import com.gr02.BomberMania.model.game.powerUps.AddBomb;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;


public class GameViewerTest {
    Arena arena;
    GameViewer gameViewer;
    GUI gui;

    @BeforeEach
    public void helper() {
        arena = new Arena(40, 40);
        gui = Mockito.mock(GUI.class);
        gameViewer = new GameViewer(arena);

        arena.setPlayer1(new PlayableCharacter(10,10, new BombInfo(), 1));
        arena.setPlayer2(new PlayableCharacter(10,11, new BombInfo(), 2));
        arena.setBrickWalls(Arrays.asList(new BrickWall(10, 12)));
        arena.setPowerUpWalls(Arrays.asList(new PowerUpWall(10, 13)));
        arena.setIndestructibleWalls(Arrays.asList(new IndestructibleWall(10, 14)));
        arena.setPowerUps(Arrays.asList(new AddBomb(10, 15)));
        arena.setBombs(Arrays.asList(new Bomb(10, 16, new BombInfo())));
        arena.setFlames(Arrays.asList(new Flame(10, 17)));
        arena.setTimer(new Timer(10, 18, 1));
    }

    @Test
    public void drawElementsTest() throws IOException {
        gameViewer.draw(gui);
        Mockito.verify(gui, Mockito.times(1)).drawPlayer1(new Position(10, 10));
        Mockito.verify(gui, Mockito.times(1)).drawPlayer2(new Position(10, 11));
        Mockito.verify(gui, Mockito.times(1)).drawBrickWall(new Position(10, 12));
        Mockito.verify(gui, Mockito.times(1)).drawPowerUpWall(new Position(10, 13));
        Mockito.verify(gui, Mockito.times(1)).drawIndestructibleWall(new Position(10, 14));
        Mockito.verify(gui, Mockito.times(1)).drawAddBomb(new Position(10, 15));
        Mockito.verify(gui, Mockito.times(1)).drawBomb(new Position(10, 16));
        Mockito.verify(gui, Mockito.times(1)).drawFlame(new Position(10, 17));
    }
}
