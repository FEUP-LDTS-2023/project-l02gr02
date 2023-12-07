package com.gr02.BomberMania.model.game.arena;

import com.gr02.BomberMania.model.game.*;
import com.gr02.BomberMania.model.Position;

import java.util.List;

public class Arena {
    private final int height;
    private final int width;
    private PlayableCharacter player1;
    private PlayableCharacter player2;
    private List<IndestructibleWall> indestructibleWalls;
    private List<BrickWall> brickWalls;
    private List<Bomb> bombs;
    private List<Flame> flames;

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
    public boolean isEmpty(Position position) {
        for (Wall wall : brickWalls)
            if (wall.getPosition().equals(position))
                return false;
        for (Wall wall : indestructibleWalls)
            if (wall.getPosition().equals(position))
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
}
