package com.gr02.BomberMania.viewer.powerUps;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.elements.Element;
import com.gr02.BomberMania.model.game.powerUps.*;
import com.gr02.BomberMania.viewer.ElementViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PowerUpsTests {
    GUI gui;
    ElementViewer<Element> addBombViewer;
    AddBomb addBomb;
    ElementViewer<Element>decreaseTimerViewer;
    DecreaseTimer decreaseTimer;
    ElementViewer<Element>detonateBombViewer;
    DetonateBomb detonateBomb;
    ElementViewer<Element> increaseExplosionRadiusViewer;
    IncreaseExplosionRadius increaseExplosionRadius;
    ElementViewer<Element> pushBombViewer;
    PushBomb pushBomb;

    @BeforeEach
    public void helper() {
        gui = Mockito.mock(GUI.class);

        addBomb = new AddBomb(0,0);
        addBombViewer = addBomb.getViewer();

        decreaseTimer = new DecreaseTimer(0,1);
        decreaseTimerViewer = decreaseTimer.getViewer();

        detonateBomb = new DetonateBomb(0,2);
        detonateBombViewer = detonateBomb.getViewer();

        increaseExplosionRadius = new IncreaseExplosionRadius(0,3);
        increaseExplosionRadiusViewer = increaseExplosionRadius.getViewer();

        pushBomb = new PushBomb(0,4);
        pushBombViewer = pushBomb.getViewer();
    }

    @Test
    public void addBombDraw() {
        addBombViewer.draw(addBomb, gui);
        Mockito.verify(gui, Mockito.times(1)).drawAddBomb(addBomb.getPosition());
    }
    @Test
    public void DecreaseTimerTest() {
        decreaseTimerViewer.draw(decreaseTimer, gui);
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
