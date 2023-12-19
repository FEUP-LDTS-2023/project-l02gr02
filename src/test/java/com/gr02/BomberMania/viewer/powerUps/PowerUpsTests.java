package com.gr02.BomberMania.viewer.powerUps;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.powerUps.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PowerUpsTests {
    GUI gui;
    AddBombViewer addBombViewer;
    AddBomb addBomb;

    DecreaseTimerVIewer decreaseTimerVIewer;
    DecreaseTimer decreaseTimer;
    DetonateBombViewer detonateBombViewer;
    DetonateBomb detonateBomb;
    IncreaseExplosionRadiusViewer increaseExplosionRadiusViewer;
    IncreaseExplosionRadius increaseExplosionRadius;
    PushBombViewer pushBombViewer;
    PushBomb pushBomb;

    @BeforeEach
    public void helper() {
        gui = Mockito.mock(GUI.class);

        addBomb = new AddBomb(0,0);
        addBombViewer = new AddBombViewer();

        decreaseTimer = new DecreaseTimer(0,1);
        decreaseTimerVIewer = new DecreaseTimerVIewer();

        detonateBomb = new DetonateBomb(0,2);
        detonateBombViewer = new DetonateBombViewer();

        increaseExplosionRadius = new IncreaseExplosionRadius(0,3);
        increaseExplosionRadiusViewer = new IncreaseExplosionRadiusViewer();

        pushBomb = new PushBomb(0,4);
        pushBombViewer = new PushBombViewer();
    }

    @Test
    public void addBombDraw() {
        addBombViewer.draw(addBomb, gui);
        Mockito.verify(gui, Mockito.times(1)).drawAddBomb(addBomb.getPosition());
    }
    @Test
    public void DecreaseTimerTest() {
        decreaseTimerVIewer.draw(decreaseTimer, gui);
        Mockito.verify(gui, Mockito.times(1)).drawDecreaseTimer(decreaseTimer.getPosition());
    }
    @Test
    public void DetonateBombTest() {
        detonateBombViewer.draw(detonateBomb, gui);
        Mockito.verify(gui, Mockito.times(1)).drawDetonateBomb(detonateBomb.getPosition());
    }
    @Test
    public void IncreaseExplosionRadiusTest() {
        increaseExplosionRadiusViewer.draw(increaseExplosionRadius, gui);
        Mockito.verify(gui, Mockito.times(1)).drawIncreaseExplosionRadius(increaseExplosionRadius.getPosition());
    }
    @Test
    public void PushBombTest() {
        pushBombViewer.draw(pushBomb, gui);
        Mockito.verify(gui, Mockito.times(1)).drawPushBomb(pushBomb.getPosition());
    }
}
