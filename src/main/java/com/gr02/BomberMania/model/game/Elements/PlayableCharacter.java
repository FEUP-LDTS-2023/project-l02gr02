package com.gr02.BomberMania.model.game.Elements;

import com.gr02.BomberMania.Game;

public class PlayableCharacter extends Element {

    private int numberOfBombs;
    private BombInfo bombInfo;

    public PlayableCharacter(int x, int y, BombInfo bombInfo) {
        super(x, y);
        this.bombInfo = bombInfo;
        this.numberOfBombs = 1;
        bombInfo.setPlayer(this);
    }

    public void decreaseNumberOfBombs() {
        if (this.numberOfBombs > 0) this.numberOfBombs--;
    }

    public void increaseNumberOfBombs() {
        if (this.numberOfBombs < 5) this.numberOfBombs++;
    }

    public void increaseOneExplosionRadius() {
        if (this.bombInfo.getExplosionRadius() < 5) {
            this.bombInfo.setExplosionRadius(this.bombInfo.getExplosionRadius() + 1);
        }
    }

    public void decreaseBombTimer() {
        if (this.bombInfo.getTimer() > 2) {
            this.bombInfo.setTimer(this.bombInfo.getTimer() - Game.FPS);
        }
    }

    public int getNumberOfBombs() {
        return numberOfBombs;
    }

    public BombInfo getBombInfo() {
        return bombInfo;
    }

}
