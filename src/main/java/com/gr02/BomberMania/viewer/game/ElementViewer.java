package com.gr02.BomberMania.viewer.game;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}
