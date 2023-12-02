package com.gr02.BomberMania.viewer.game;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.elements.PlayableCharacter;

public class Player1Viewer implements ElementViewer<PlayableCharacter> {
    @Override
    public void draw(PlayableCharacter playableCharacter, GUI gui) {
        gui.drawPlayer1(playableCharacter.getPosition());
    }
}
