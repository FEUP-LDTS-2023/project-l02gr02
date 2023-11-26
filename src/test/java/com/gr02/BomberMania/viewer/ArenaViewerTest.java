package com.gr02.BomberMania.viewer;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.game.elements.PlayableCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class ArenaViewerTest {
    private Arena arena;
    private GUI gui;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
        gui = Mockito.mock(GUI.class);
        arena.setPlayableCharacter(new PlayableCharacter(5, 8));
    }
    
}
