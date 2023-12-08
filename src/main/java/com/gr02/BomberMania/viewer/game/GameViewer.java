package com.gr02.BomberMania.viewer.game;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.PowerUps.AddOneBomb;
import com.gr02.BomberMania.model.game.PowerUps.AddOneExplosionRadius;
import com.gr02.BomberMania.model.game.PowerUps.DecreaseTimer;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.game.Elements.Element;
import com.gr02.BomberMania.viewer.Viewer;
import com.gr02.BomberMania.viewer.game.powerUps.AddOneBombViewer;
import com.gr02.BomberMania.viewer.game.powerUps.AddOneExplosionRadiusViewer;
import com.gr02.BomberMania.viewer.game.powerUps.DecreaseTimerVIewer;

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
        drawPowerUp(gui, getModel().getPowerUps());
    }

    private <T extends Element> void drawElements(GUI gui, List<T> elements, ElementViewer<T> viewer) {
        for (T element : elements)
            drawElement(gui, element, viewer);
    }

    private <T extends Element> void drawElement(GUI gui, T element, ElementViewer<T> viewer) {
        viewer.draw(element, gui);
    }

    private <T extends Element> void drawPowerUp(GUI gui, List<T> elements) {
        for (T element : elements) {
            if (element instanceof AddOneBomb) {
                ElementViewer<AddOneBomb> viewer = new AddOneBombViewer();
                viewer.draw((AddOneBomb) element, gui);
            }
            if (element instanceof AddOneExplosionRadius) {
                ElementViewer<AddOneExplosionRadius> viewer = new AddOneExplosionRadiusViewer();
                viewer.draw((AddOneExplosionRadius) element, gui);
            }
            if (element instanceof DecreaseTimer) {
                ElementViewer<DecreaseTimer> viewer = new DecreaseTimerVIewer();
                viewer.draw((DecreaseTimer) element, gui);
            }
        }
    }
}
