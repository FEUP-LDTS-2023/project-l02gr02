package com.gr02.BomberMania.viewer.walls;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.elements.Walls.BrickWall;
import com.gr02.BomberMania.model.game.elements.Walls.IndestructibleWall;
import com.gr02.BomberMania.model.game.elements.Walls.PowerUpWall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class WallsTests {
    GUI gui;

    BrickWall brickWall;
    BrickViewer brickViewer;
    IndestructibleWall indestructibleWall;
    IndestructibleWallViewer indestructibleWallViewer;
    PowerUpWall powerUpWall;
    PowerUpWallViewer powerUpWallViewer;

    @BeforeEach
    public void helper() {
        gui = Mockito.mock(GUI.class);

        brickWall = new BrickWall(0,0);
        brickViewer = new BrickViewer();
        indestructibleWall = new IndestructibleWall(0,1);
        indestructibleWallViewer = new IndestructibleWallViewer();
        powerUpWall = new PowerUpWall(0,2);
        powerUpWallViewer = new PowerUpWallViewer();
    }

    @Test
    public void BrickWallViewerTest() {
        brickViewer.draw(brickWall, gui);
        Mockito.verify(gui, Mockito.times(1)).drawBrickWall(brickWall.getPosition());
    }
    @Test
    public void IndestructibleWallViewerTest() {
        indestructibleWallViewer.draw(indestructibleWall, gui);
        Mockito.verify(gui, Mockito.times(1)).drawIndestructibleWall(indestructibleWall.getPosition());
    }
    @Test
    public void PowerUpWallViewerTest() {
        powerUpWallViewer.draw(powerUpWall, gui);
        Mockito.verify(gui, Mockito.times(1)).drawPowerUpWall(powerUpWall.getPosition());
    }
}
