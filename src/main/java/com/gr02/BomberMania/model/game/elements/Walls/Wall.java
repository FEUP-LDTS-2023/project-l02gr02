package com.gr02.BomberMania.model.game.elements.Walls;

import com.gr02.BomberMania.model.game.elements.Element;
import com.gr02.BomberMania.viewer.ElementViewer;

public abstract class Wall extends Element {
    public Wall(int x, int y) {
        super(x, y);
    }

    @Override
    public abstract <T extends Element > ElementViewer<T> getViewer();
}
