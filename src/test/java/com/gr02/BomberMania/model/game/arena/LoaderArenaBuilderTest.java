package com.gr02.BomberMania.model.game.arena;

import com.gr02.BomberMania.model.game.elements.BombInfo;
import com.gr02.BomberMania.model.game.elements.PlayableCharacter;
import com.gr02.BomberMania.model.game.elements.Timer;
import com.gr02.BomberMania.model.game.elements.Walls.BrickWall;
import com.gr02.BomberMania.model.game.elements.Walls.IndestructibleWall;
import com.gr02.BomberMania.model.game.elements.Walls.PowerUpWall;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.gr02.BomberMania.Game.height;
import static com.gr02.BomberMania.Game.width;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class LoaderArenaBuilderTest {
    @Test
    void buildArenaTest() throws IOException {
        Arena arena = new LoaderArenaBuilder("test").createArena();

        int widthShift = width/2 - 2;
        int heightShift = height/2 - 1;

        // Setting up elements and their expected placement
        BrickWall brickWall = new BrickWall(3 + widthShift, heightShift);
        BrickWall brickWall2 = new BrickWall(1 + widthShift, 1 + heightShift);
        BrickWall brickWall3 = new BrickWall(3 + widthShift, 1 + heightShift);
        List<BrickWall> brickWalls = new ArrayList<BrickWall>();
        brickWalls.add(brickWall);
        brickWalls.add(brickWall2);
        brickWalls.add(brickWall3);
        IndestructibleWall indestructibleWall = new IndestructibleWall(widthShift, heightShift);
        List<IndestructibleWall> indestructibleWalls = new ArrayList<IndestructibleWall>();
        indestructibleWalls.add(indestructibleWall);
        PowerUpWall powerUpWall = new PowerUpWall(widthShift, 1 + heightShift);
        List<PowerUpWall> powerUpWalls = new ArrayList<PowerUpWall>();
        powerUpWalls.add(powerUpWall);
        PlayableCharacter character1 = new PlayableCharacter(2 + widthShift, heightShift, new BombInfo(), 1);
        PlayableCharacter character2 = new PlayableCharacter(1 + widthShift, heightShift, new BombInfo(), 2);
        Timer timer = new Timer(width/2 - 3, 1, 3 * 60 * 60);

        // Testing if arena was correctly created
        for (BrickWall a : brickWalls) {
            boolean found = false;
            for (BrickWall b : arena.getBrickWalls()) {
                if (a.getPosition().equals(b.getPosition())) found = true;
            }
            assertEquals(true, found);
        }
        assertEquals(character1.getPosition(), arena.getPlayer1().getPosition());
        assertEquals(character2.getPosition(), arena.getPlayer2().getPosition());
        for (IndestructibleWall a : indestructibleWalls) {
            boolean found = false;
            for (IndestructibleWall b : arena.getIndestructibleWalls()) {
                if (a.getPosition().equals(b.getPosition())) found = true;
            }
            assertEquals(true, found);
        }
        for (PowerUpWall a : powerUpWalls) {
            boolean found = false;
            for (PowerUpWall b : arena.getPowerUpWalls()) {
                if (a.getPosition().equals(b.getPosition())) found = true;
            }
            assertEquals(true, found);
        }
        assertEquals(timer.getPosition(), arena.getTimer().getPosition());
    }
}
