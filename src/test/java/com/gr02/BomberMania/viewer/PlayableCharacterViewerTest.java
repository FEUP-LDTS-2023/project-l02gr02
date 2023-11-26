package com.gr02.BomberMania.viewer;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.elements.PlayableCharacter;
import com.gr02.BomberMania.viewer.game.PlayableCharacterViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class PlayableCharacterViewerTest {

    private PlayableCharacter playableCharacter;
    private PlayableCharacterViewer viewer;
    private GUI gui;

    @BeforeEach
    void setUp() {
        playableCharacter = new PlayableCharacter(10, 10);
        viewer = new PlayableCharacterViewer();
        gui = Mockito.mock(GUI.class);
    }

    @Test
    void drawElement() {
        viewer.draw(playableCharacter, gui);
        Mockito.verify(gui, Mockito.times(1)).drawPlayableCharacter(playableCharacter.getPosition());
    }
}
