package com.gr02.BomberMania.model.game.elements;

import static com.gr02.BomberMania.Game.FPS;

public class PlayableCharacter extends Element {
    private boolean canPushBombs = false;
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
        if (this.bombInfo.getTimer() > 2 * FPS) {
            this.bombInfo.setTimer(this.bombInfo.getTimer() - FPS);
        }
    }

    public int getNumberOfBombs() {
        return numberOfBombs;
    }

    public BombInfo getBombInfo() {
        return bombInfo;
    }

    public boolean canPushBombs() {
        return canPushBombs;
    }

    public void setCanPushBombs(boolean canPushBombs) {
        this.canPushBombs = canPushBombs;
    }
}
