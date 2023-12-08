package com.gr02.BomberMania.viewer.game;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.game.Elements.BombInfo;
import com.gr02.BomberMania.model.game.Elements.PlayableCharacter;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mockito;

public class ArenaViewerTest {
    private Arena arena;
    private GUI gui;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
        gui = Mockito.mock(GUI.class);
        arena.setPlayer1(new PlayableCharacter(5, 8, new BombInfo()));
    }

    //  TO DO:
    //  -  Need to implement the test, but we need to create the Game viewer to test it
}