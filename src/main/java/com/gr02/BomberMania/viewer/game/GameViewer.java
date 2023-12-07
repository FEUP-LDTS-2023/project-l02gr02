package com.gr02.BomberMania.viewer.game;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.PowerUp;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.game.Element;
import com.gr02.BomberMania.viewer.Viewer;

import java.util.List;

public class GameViewer extends Viewer<Arena> {
    public GameViewer(Arena arena) {
        super(arena);
    }

    @Override
    public void drawElements(GUI gui) {
        drawElements(gui, getModel().getIndestructibleWalls(), new IndestructibleWallViewer());
        drawElements(gui, getModel().getBrickWalls(), new BrickViewer());
        drawElement(gui, getModel().getPlayer1(), new Player1Viewer());
        drawElement(gui, getModel().getPlayer2(), new Player2Viewer());
        drawElements(gui, getModel().getBombs(), new BombViewer());
        drawElements(gui, getModel().getFlames(), new FlameViewer());
        drawElements(gui, getModel().getPowerUps(), new AddOneBombViewer());
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }
}
