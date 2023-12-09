package com.gr02.BomberMania.model.game.elements;

import com.gr02.BomberMania.viewer.game.ElementViewer;
import com.gr02.BomberMania.viewer.game.Player1Viewer;
import com.gr02.BomberMania.viewer.game.Player2Viewer;

import static com.gr02.BomberMania.Game.FPS;

public class PlayableCharacter extends Element {
    private boolean canPushBombs = false;
    private int numberOfBombs;
    private BombInfo bombInfo;

    private int playerNum;

    public PlayableCharacter(int x, int y, BombInfo bombInfo, int playerNum) {
        super(x, y);
        this.bombInfo = bombInfo;
        this.numberOfBombs = 1;
        bombInfo.setPlayer(this);
        this.playerNum = playerNum;
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

    public <T extends Element> ElementViewer<T> getViewer() {
        if (playerNum == 1) {
            return (ElementViewer<T>) new Player1Viewer();
        } else return (ElementViewer<T>) new Player2Viewer();
    }
}
