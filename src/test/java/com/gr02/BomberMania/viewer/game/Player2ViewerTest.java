package com.gr02.BomberMania.viewer.game;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.BombInfo;
import com.gr02.BomberMania.model.game.Elements.PlayableCharacter;
import com.gr02.BomberMania.viewer.game.Player2Viewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;

public class Player2ViewerTest {
    private PlayableCharacter playableCharacter;
    @Test
    public void testDraw() {
        GUI gui = mock(GUI.class);

        playableCharacter = new PlayableCharacter(10, 10, new BombInfo());

        Player2Viewer player2Viewer = new Player2Viewer();

        player2Viewer.draw(playableCharacter, gui);

        Mockito.verify(gui).drawPlayer2(eq(playableCharacter.getPosition()));
    }
}
