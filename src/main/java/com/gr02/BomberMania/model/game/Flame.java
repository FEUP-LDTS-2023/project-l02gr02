package com.gr02.BomberMania.model.game;

public class Flame extends Element{

    private int timer;
    public Flame(int x, int y) {
        super(x, y);
        timer = 60;
    }

    public int getTimer() {
        return timer;
    }

    public void reduceTimer() { timer--;}
}
