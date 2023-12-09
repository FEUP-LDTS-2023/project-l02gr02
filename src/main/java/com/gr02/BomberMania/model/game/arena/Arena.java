package com.gr02.BomberMania.model.game.arena;

import com.googlecode.lanterna.terminal.swing.TerminalScrollController;
import com.gr02.BomberMania.model.Position;
import com.gr02.BomberMania.model.game.elements.Bomb;
import com.gr02.BomberMania.model.game.elements.Flame;
import com.gr02.BomberMania.model.game.elements.PlayableCharacter;
import com.gr02.BomberMania.model.game.elements.Walls.BrickWall;
import com.gr02.BomberMania.model.game.elements.Walls.IndestructibleWall;
import com.gr02.BomberMania.model.game.elements.Walls.PowerUpWall;
import com.gr02.BomberMania.model.game.elements.Walls.Wall;
import com.gr02.BomberMania.model.game.powerUps.*;

import java.util.List;
import java.util.Random;

public class Arena {
    private final int height;
    private final int width;
    private PlayableCharacter player1;
    private PlayableCharacter player2;
    private List<IndestructibleWall> indestructibleWalls;
    private List<BrickWall> brickWalls;
    private List<PowerUpWall> powerUpWalls;
    private List<Bomb> bombs;
    private List<Flame> flames;
    private List<PowerUp> powerUps;

    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public PlayableCharacter getPlayer1() {
        return player1;
    }

    public void setPlayer1(PlayableCharacter player1) {
        this.player1 = player1;
    }

    public PlayableCharacter getPlayer2() {
        return player2;
    }

    public void setPlayer2(PlayableCharacter player) {
        this.player2 = player;
    }

    public List<IndestructibleWall> getIndestructibleWalls() {
        return indestructibleWalls;
    }

    public void setIndestructibleWalls(List<IndestructibleWall> indestructibleWalls) {
        this.indestructibleWalls = indestructibleWalls;
    }

    public List<BrickWall> getBrickWalls() {
        return brickWalls;
    }

    public void setBrickWalls(List<BrickWall> brickWalls) {
        this.brickWalls = brickWalls;
    }

    public List<PowerUpWall> getPowerUpWalls() {
        return powerUpWalls;
    }

    public void setPowerUpWalls(List<PowerUpWall> powerUpWalls) {
        this.powerUpWalls = powerUpWalls;
    }

    public List<Bomb> getBombs() { return bombs; }

    public void setBombs(List<Bomb> bombs) {
        this.bombs = bombs;
    }

    public void addBomb(Bomb bomb) { bombs.add(bomb); }

    public List<Flame> getFlames() { return flames; }

    public void setFlames(List<Flame> flames) { this.flames = flames; }

    public void addFlame(Flame flame) { flames.add(flame); }

    public List<PowerUp> getPowerUps() {
        return powerUps;
    }

    public void setPowerUps(List<PowerUp> powerUps) {
        this.powerUps = powerUps;
    }

    public boolean isEmpty(Position position) {
        // Checking collision with Walls
        for (Wall brick : brickWalls)
            if (brick.getPosition().equals(position))
                return false;
        for (Wall wall : indestructibleWalls)
            if (wall.getPosition().equals(position))
                return false;
        for (PowerUpWall powerUpWall : powerUpWalls)
            if (powerUpWall.getPosition().equals(position))
                return false;

        // Checking collision with bombs
        for (Bomb bomb : bombs)
            if (bomb.getPosition().equals(position)) {
                return false;
            }

        // Checking collision with player
        if (position.equals(player2.getPosition()) || position.equals(player1.getPosition()))
            return false;
        return true;
    }

    public Bomb checkForBombs(Position position) {
        for (Bomb bomb : bombs) {
            if (bomb.getPosition().equals(position)) {
                return bomb;
            }
        }
        return null;
    }

    public PowerUp checkForUpgrades(Position position) {
        for (PowerUp powerUp : powerUps) {
            if (powerUp.getPosition().equals(position)) {
                return powerUp;
            }
        }
        return null;
    }

    public boolean isNotIndestructible(Position position) {
        for (Wall wall : indestructibleWalls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }

    public boolean destruct(Position position) {
        // Checking if explosion hit a destructible wall
        for (Wall wall : brickWalls)
            if (wall.getPosition().equals(position)) {
                brickWalls.remove(wall);
                return true;
            }
        // Checking if explosion hit a destructible powerUp wall
        for (PowerUpWall wall : powerUpWalls)
            if (wall.getPosition().equals(position)) {
                powerUpWalls.remove(wall);
                wall.dropPowerup(this);
                return true;
            }
        // Checking if explosion hit another bomb
        for (Bomb bomb : bombs) {
            if (bomb.getPosition().equals(position)) {
                bomb.explode(this);
                return true;
            }
        }

        // Checking if explosion hit dropped powerUp
        List<PowerUp> powerUpsCopy = List.copyOf(getPowerUps());
        for (PowerUp powerUp : powerUpsCopy) {
            if (powerUp.getPosition().equals(position)) {
                powerUps.remove(powerUp);
            }
        }

        return false;
    }
}
