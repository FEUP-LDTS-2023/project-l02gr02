package com.gr02.BomberMania.viewer;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.BombInfo;
import com.gr02.BomberMania.model.game.PlayableCharacter;
import com.gr02.BomberMania.viewer.game.Player1Viewer;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;

public class Player1ViewerTest {
    private PlayableCharacter playableCharacter;
    @Test
    public void testDraw() {
        GUI gui = mock(GUI.class);

        playableCharacter = new PlayableCharacter(10, 10, new BombInfo());

        Player1Viewer player1Viewer = new Player1Viewer();

        player1Viewer.draw(playableCharacter, gui);

        Mockito.verify(gui).drawPlayer1(eq(playableCharacter.getPosition()));
    }
}
