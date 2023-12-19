package com.gr02.BomberMania.model.game.elements;

import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.viewer.game.ElementViewer;
import com.gr02.BomberMania.viewer.game.Player1Viewer;
import com.gr02.BomberMania.viewer.game.Player2Viewer;

import java.util.ArrayList;
import java.util.List;

import static com.gr02.BomberMania.Game.FPS;

public class PlayableCharacter extends Element {
    private boolean canPushBombs = false;
    private boolean canDetonateBombs = false;
    private int numberOfBombs;
    private BombInfo bombInfo;
    private int playerNum;
    private List<DetonatorObserver> observers;

    public PlayableCharacter(int x, int y, BombInfo bombInfo, int playerNum) {
        super(x, y);
        this.bombInfo = bombInfo;
        this.numberOfBombs = 1;
        bombInfo.setPlayer(this);
        this.playerNum = playerNum;
        observers = new ArrayList<>();
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

    public boolean canDetonateBombs() {
        return canDetonateBombs;
    }

    public void setCanDetonateBombs(boolean canDetonateBombs) {
        this.canDetonateBombs = canDetonateBombs;
    }

    public void addObserver(DetonatorObserver bomb) {
        observers.add(bomb);
    }

    public void removeObserver(DetonatorObserver bomb) {
        observers.remove(bomb);
    }

    public void detonateBombs(Arena arena) {
        while (!observers.isEmpty()) {
            observers.get(0).explode(arena);
        }
    }

    @Override
    public <T extends Element> ElementViewer<T> getViewer() {
        if (playerNum == 1) {
            return (ElementViewer<T>) new Player1Viewer();
        } else return (ElementViewer<T>) new Player2Viewer();
    }
}
