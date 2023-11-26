package com.gr02.BomberMania.model.game.elements;

public class PlayableCharacter extends Element {

    private int numberOfBombs;

    public PlayableCharacter(int x, int y) {
        super(x, y);
    }

    public void decreaseNumberOfBombs() {
        this.numberOfBombs--;
    }

    public int getNumberOfBombs() {
        return numberOfBombs;
    }
}
