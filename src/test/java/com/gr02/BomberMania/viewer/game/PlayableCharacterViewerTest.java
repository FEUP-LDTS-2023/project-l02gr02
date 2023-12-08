package com.gr02.BomberMania.viewer.game;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.Elements.BombInfo;
import com.gr02.BomberMania.model.game.Elements.PlayableCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PlayableCharacterViewerTest {

    private PlayableCharacter playableCharacter;
    private Player1Viewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        playableCharacter = new PlayableCharacter(10, 10, new BombInfo());
        viewer = new Player1Viewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(playableCharacter, gui);
        Mockito.verify(gui, Mockito.times(1)).drawPlayer1(playableCharacter.getPosition());
    }
}
