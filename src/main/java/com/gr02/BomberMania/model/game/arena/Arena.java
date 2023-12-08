package com.gr02.BomberMania.model.game.arena;

import com.gr02.BomberMania.model.Position;
import com.gr02.BomberMania.model.game.Elements.Bomb;
import com.gr02.BomberMania.model.game.Elements.Flame;
import com.gr02.BomberMania.model.game.Elements.PlayableCharacter;
import com.gr02.BomberMania.model.game.Elements.Walls.BrickWall;
import com.gr02.BomberMania.model.game.Elements.Walls.IndestructibleWall;
import com.gr02.BomberMania.model.game.Elements.Walls.PowerUpWall;
import com.gr02.BomberMania.model.game.Elements.Walls.Wall;
import com.gr02.BomberMania.model.game.PowerUps.*;

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
    public boolean isEmpty(Position position, PlayableCharacter player) {
        for (Wall brick : brickWalls)
            if (brick.getPosition().equals(position))
                return false;
        for (Wall wall : indestructibleWalls)
            if (wall.getPosition().equals(position))
                return false;
        for (Bomb bomb : bombs)
            if (bomb.getPosition().equals(position)) {
                if (player.getPosition().getX() > bomb.getPosition().getX()
                        && isEmptyForBombs(bomb.getPosition().getLeft()) && player.isCanPushBombs()) bomb.setPosition(bomb.getPosition().getLeft());
                if (player.getPosition().getX() < bomb.getPosition().getX()
                        && isEmptyForBombs(bomb.getPosition().getRight()) && player.isCanPushBombs()) bomb.setPosition(bomb.getPosition().getRight());
                if (player.getPosition().getY() > bomb.getPosition().getY()
                        && isEmptyForBombs(bomb.getPosition().getUp()) && player.isCanPushBombs()) bomb.setPosition(bomb.getPosition().getUp());
                if (player.getPosition().getY() < bomb.getPosition().getY()
                        && isEmptyForBombs(bomb.getPosition().getDown()) && player.isCanPushBombs()) bomb.setPosition(bomb.getPosition().getDown());
                return player.isCanPushBombs();
            }
        for (PowerUpWall powerUpWall : powerUpWalls)
            if (powerUpWall.getPosition().equals(position))
                return false;
        for (PowerUp powerUp : powerUps)
            if (powerUp.getPosition().equals(position)) {
                powerUps.remove(powerUp);
                powerUp.execute(player);
                return true;
            }
        if (position.equals(player2.getPosition()) || position.equals(player1.getPosition()))
            return false;
        return true;
    }

    public boolean isEmptyForBombs(Position position) {
        for (Wall brick : brickWalls)
            if (brick.getPosition().equals(position))
                return false;
        for (Wall wall : indestructibleWalls)
            if (wall.getPosition().equals(position))
                return false;
        for (Bomb bomb : bombs)
            if (bomb.getPosition().equals(position)) {
                return true;
            }
        for (PowerUpWall powerUpWall : powerUpWalls)
            if (powerUpWall.getPosition().equals(position))
                return false;
        for (PowerUp powerUp : powerUps)
            if (powerUp.getPosition().equals(position)) {
                powerUps.remove(powerUp);
                return false;
            }
        if (position.equals(player2.getPosition()) || position.equals(player1.getPosition()))
            return false;
        return true;
    }

    public boolean isNotIndestructible(Position position) {
        for (Wall wall : indestructibleWalls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }

    public boolean destruct(Position position) {
        for (Wall wall : brickWalls)
            if (wall.getPosition().equals(position)) {
                brickWalls.remove(wall);
                return true;
            }
        for (Wall wall : powerUpWalls)
            if (wall.getPosition().equals(position)) {
                powerUpWalls.remove(wall);
                Random random = new Random();
                int numeroAleatorio = random.nextInt(4) + 1;
                switch (numeroAleatorio) {
                    case 1:
                        powerUps.add(new AddOneExplosionRadius(wall.getPosition().getX(), wall.getPosition().getY()));
                        break;
                    case 2:
                        powerUps.add(new AddOneBomb(wall.getPosition().getX(), wall.getPosition().getY()));
                        break;
                    case 3:
                        powerUps.add(new DecreaseTimer(wall.getPosition().getX(), wall.getPosition().getY()));
                        break;
                    case 4:
                        powerUps.add(new PushBomb(wall.getPosition().getX(), wall.getPosition().getY()));
                        break;
                    default:
                        break;
                }
                return true;
            }
        for (Bomb bomb : bombs) {
            if (bomb.getPosition().equals(position)) {
                bomb.getBombInfo().setTimer(0);
                bombs.remove(bomb);
                bomb.explode(this);
                return true;
            }
        }
        return false;
    }

    public PlayableCharacter getPlayer2() {
        return player2;
    }

    public void setPlayer2(PlayableCharacter player) {
        this.player2 = player;
    }

    public List<Bomb> getBombs() { return bombs; }

    public void addBomb(Bomb bomb) { bombs.add(bomb); }

    public void setBombs(List<Bomb> bombs) {
        this.bombs = bombs;
    }

    public List<Flame> getFlames() { return flames; }

    public void setFlames(List<Flame> flames) { this.flames = flames; }

    public void addFlame(Flame flame) { flames.add(flame); }

    public List<PowerUp> getPowerUps() {
        return powerUps;
    }

    public void setPowerUps(List<PowerUp> powerUps) {
        this.powerUps = powerUps;
    }

    public List<PowerUpWall> getPowerUpWalls() {
        return powerUpWalls;
    }

    public void setPowerUpWalls(List<PowerUpWall> powerUpWalls) {
        this.powerUpWalls = powerUpWalls;
    }
}
