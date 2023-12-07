package com.gr02.BomberMania.model.game;

import com.gr02.BomberMania.model.game.Elements.PlayableCharacter;

public class BombInfo implements Cloneable {

    private int timer;
    private int explosionRadius;

    private PlayableCharacter player;

    public BombInfo(int timer, int explosionRadius, PlayableCharacter player) {
        this.timer = timer;
        this.explosionRadius = explosionRadius;
        this.player = player;
    }

    public BombInfo() {
        this.timer = 5 * 60;
        this.explosionRadius = 1;
    }

    public int getTimer() {
        return timer;
    }

    public void reduceTimer() { timer--;}
    public int getExplosionRadius() {
        return explosionRadius;
    }

    public PlayableCharacter getPlayer() {return player;}

    public void setPlayer(PlayableCharacter player) { this.player = player; }

    @Override
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
