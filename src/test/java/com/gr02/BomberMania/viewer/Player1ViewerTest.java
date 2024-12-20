package com.gr02.BomberMania.viewer;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.elements.BombInfo;
import com.gr02.BomberMania.model.game.elements.Element;
import com.gr02.BomberMania.model.game.elements.PlayableCharacter;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;

public class Player1ViewerTest {
    private PlayableCharacter playableCharacter;
    @Test
    public void testDraw() {
        GUI gui = mock(GUI.class);

        playableCharacter = new PlayableCharacter(10, 10, new BombInfo(), 1);

        ElementViewer<Element> player1Viewer = playableCharacter.getViewer();

        player1Viewer.draw(playableCharacter, gui);

        Mockito.verify(gui).drawPlayer1(eq(playableCharacter.getPosition()));
    }
}
