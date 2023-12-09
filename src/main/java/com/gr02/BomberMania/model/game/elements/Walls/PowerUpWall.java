package com.gr02.BomberMania.model.game.elements.Walls;

import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.game.elements.Element;
import com.gr02.BomberMania.model.game.powerUps.*;
import com.gr02.BomberMania.viewer.game.ElementViewer;
import com.gr02.BomberMania.viewer.game.walls.PowerUpWallViewer;

import java.util.List;
import java.util.Random;

public class PowerUpWall extends Wall{
    public PowerUpWall(int x, int y) {
        super(x, y, true);
    }

    public void dropPowerup(Arena arena) {
        Random random = new Random();
        int numeroAleatorio = random.nextInt(4) + 1;
        List<PowerUp> powerUps = arena.getPowerUps();

        switch (numeroAleatorio) {
            case 1:
                powerUps.add(new IncreaseExplosionRadius(getPosition().getX(), getPosition().getY()));
                break;
            case 2:
                powerUps.add(new AddBomb(getPosition().getX(), getPosition().getY()));
                break;
            case 3:
                powerUps.add(new DecreaseTimer(getPosition().getX(), getPosition().getY()));
                break;
            case 4:
                powerUps.add(new PushBomb(getPosition().getX(), getPosition().getY()));
                break;
            default:
                break;
        }
    }

    public <T extends Element> ElementViewer<T> getViewer() {
        return (ElementViewer<T>) new PowerUpWallViewer();
    }
}
