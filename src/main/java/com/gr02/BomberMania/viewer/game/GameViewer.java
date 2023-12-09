package com.gr02.BomberMania.viewer.game;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.game.elements.Element;
import com.gr02.BomberMania.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getIndestructibleWalls());
        drawElements(gui, getModel().getBrickWalls());
        drawElements(gui, getModel().getPowerUpWalls());
        drawElement(gui, getModel().getPlayer1(), new Player1Viewer());
        drawElement(gui, getModel().getPlayer2(), new Player2Viewer());
        drawElements(gui, getModel().getPowerUps());
        drawElements(gui, getModel().getBombs());
        drawElements(gui, getModel().getFlames());
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements) {
        for (T element : elements)
            drawElement(gui, element, element.getViewer());
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
