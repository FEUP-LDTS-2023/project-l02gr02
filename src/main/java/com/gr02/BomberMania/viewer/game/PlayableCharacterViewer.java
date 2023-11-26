package com.gr02.BomberMania.viewer.game;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.elements.PlayableCharacter;

public class PlayableCharacterViewer implements ElementViewer<PlayableCharacter> {
    @Override
    public void draw(PlayableCharacter playableCharacter, GUI gui) {
        gui.drawPlayableCharacter(playableCharacter.getPosition());
    }
}
