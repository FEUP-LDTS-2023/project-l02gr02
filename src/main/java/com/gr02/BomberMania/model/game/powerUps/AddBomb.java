package com.gr02.BomberMania.model.game.powerUps;

import com.gr02.BomberMania.model.game.elements.Element;
import com.gr02.BomberMania.model.game.elements.PlayableCharacter;
import com.gr02.BomberMania.viewer.game.ElementViewer;
import com.gr02.BomberMania.viewer.game.powerUps.AddBombViewer;

public class AddBomb extends PowerUp {

    public AddBomb(int x, int y) {
        super(x, y);
    }
    @Override
    public void execute(PlayableCharacter player) {
        player.increaseNumberOfBombs();
    }

    @Override
    public <T extends Element> ElementViewer<T> getViewer() {
        return (ElementViewer<T>) new AddBombViewer();
    }
}
