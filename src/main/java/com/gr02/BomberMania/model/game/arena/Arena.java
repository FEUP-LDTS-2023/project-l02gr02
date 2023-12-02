package com.gr02.BomberMania.model.game.arena;

import com.gr02.BomberMania.model.game.elements.BrickWall;
import com.gr02.BomberMania.model.game.elements.IndestructibleWall;
import com.gr02.BomberMania.model.game.elements.PlayableCharacter;
import com.gr02.BomberMania.model.game.elements.Wall;
import com.gr02.BomberMania.model.Position;

import java.util.List;

public class Arena {
    private final int height;
    private final int width;
    private PlayableCharacter playableCharacter;
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

    public PlayableCharacter getPlayableCharacter() {
        return playableCharacter;
    }

    public void setPlayableCharacter(PlayableCharacter playableCharacter) {
        this.playableCharacter = playableCharacter;
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
}
