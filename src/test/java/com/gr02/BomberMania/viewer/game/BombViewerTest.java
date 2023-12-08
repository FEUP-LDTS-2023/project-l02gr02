package com.gr02.BomberMania.viewer.game;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.Elements.Bomb;
import com.gr02.BomberMania.model.game.Elements.BombInfo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class BombViewerTest {

    private Bomb bomb;
    private BombViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        bomb = new Bomb(10, 10, new BombInfo());
        viewer = new BombViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(bomb, gui);
        Mockito.verify(gui, Mockito.times(1)).drawBomb(bomb.getPosition());
    }
}
