package com.gr02.BomberMania.model.game;

public class PlayableCharacter extends Element {

    private int numberOfBombs;
    private BombInfo bombInfo;

    public PlayableCharacter(int x, int y, BombInfo bombInfo) {
        super(x, y);
        this.bombInfo = bombInfo;
        this.numberOfBombs = 1;
    }

    public void decreaseNumberOfBombs() {
        if (this.numberOfBombs > 0) this.numberOfBombs--;
    }

    public void increaseNumberOfBombs() {
        if (this.numberOfBombs < 5) this.numberOfBombs++;
    }

    public int getNumberOfBombs() {
        return numberOfBombs;
    }

    public BombInfo getBombInfo() {
        return bombInfo;
    }

}
