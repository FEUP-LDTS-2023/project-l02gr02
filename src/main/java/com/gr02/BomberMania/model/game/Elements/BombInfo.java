package com.gr02.BomberMania.model.game.Elements;

import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.model.game.Elements.PlayableCharacter;
import com.gr02.BomberMania.model.game.Elements.Timer;

public class BombInfo implements Cloneable, Timer {

    private int timer;
    private int explosionRadius;

    private PlayableCharacter player;

    public BombInfo(int timer, int explosionRadius, PlayableCharacter player) {
        this.timer = timer;
        this.explosionRadius = explosionRadius;
        this.player = player;
    }

    public BombInfo() {
        this.timer = 5 * Game.FPS;
        this.explosionRadius = 1;
    }

    public int getTimer() {
        return timer;
    }
    public void setTimer(int timer) {
        this.timer = timer;
    }

    @Override
    public void reduceTimer() { timer--;}
    public int getExplosionRadius() {
        return explosionRadius;
    }

    public void setExplosionRadius(int explosionRadius) {
        this.explosionRadius = explosionRadius;
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
