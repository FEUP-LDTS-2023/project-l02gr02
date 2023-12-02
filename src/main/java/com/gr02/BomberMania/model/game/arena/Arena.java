package com.gr02.BomberMania.model.game.arena;

import com.gr02.BomberMania.model.game.BrickWall;
import com.gr02.BomberMania.model.game.IndestructibleWall;
import com.gr02.BomberMania.model.game.PlayableCharacter;
import com.gr02.BomberMania.model.game.Wall;
import com.gr02.BomberMania.model.Position;

import java.util.List;

public class Arena {
    private final int height;
    private final int width;
    private PlayableCharacter Player1;
    private PlayableCharacter Player2;
    private List<IndestructibleWall> IndestructibleWalls;
    private List<BrickWall> BrickWalls;

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
        return Player1;
    }

    public void setPlayer1(PlayableCharacter player1) {
        this.Player1 = player1;
    }

    public List<IndestructibleWall> getIndestructibleWalls() {
        return IndestructibleWalls;
    }

    public void setIndestructibleWalls(List<IndestructibleWall> indestructibleWalls) {
        IndestructibleWalls = indestructibleWalls;
    }

    public List<BrickWall> getBrickWalls() {
        return BrickWalls;
    }

    public void setBrickWalls(List<BrickWall> brickWalls) {
        BrickWalls = brickWalls;
    }
    public boolean isEmpty(Position position) {
        for (Wall wall : BrickWalls)
            if (wall.getPosition().equals(position))
                return false;
        for (Wall wall : IndestructibleWalls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }

    public PlayableCharacter getPlayer2() {
        return Player2;
    }

    public void setPlayer2(PlayableCharacter player) {
        this.Player2 = player;
    }
}
