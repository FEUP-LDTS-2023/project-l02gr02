package com.gr02.BomberMania.viewer.Game;


import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.Game.Element;

public interface ElementViewer<T extends Element> {
    void draw(T element, GUI gui);
}
