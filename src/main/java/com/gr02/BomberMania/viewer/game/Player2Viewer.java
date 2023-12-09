package com.gr02.BomberMania.viewer.game;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.elements.PlayableCharacter;

public class Player2Viewer implements ElementViewer<PlayableCharacter> {
    @Override
    public void draw(PlayableCharacter playableCharacter, GUI gui) {
        gui.drawPlayer2(playableCharacter.getPosition());
    }
}
