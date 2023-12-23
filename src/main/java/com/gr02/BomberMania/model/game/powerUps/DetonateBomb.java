package com.gr02.BomberMania.model.game.powerUps;

import com.gr02.BomberMania.model.game.elements.Element;
import com.gr02.BomberMania.model.game.elements.PlayableCharacter;
import com.gr02.BomberMania.viewer.ElementViewer;
import com.gr02.BomberMania.viewer.powerUps.DetonateBombViewer;

public class DetonateBomb extends PowerUp{
    public DetonateBomb(int x, int y) {
        super(x, y);
    }
    @Override
    public void execute(PlayableCharacter player) {
        player.setCanDetonateBombs(true);
    }

    @Override
    public <T extends Element> ElementViewer<T> getViewer() {
        return (ElementViewer<T>) new DetonateBombViewer();
    }
}
