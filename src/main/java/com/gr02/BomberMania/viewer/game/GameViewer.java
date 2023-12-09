package com.gr02.BomberMania.viewer.game;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.powerUps.AddBomb;
import com.gr02.BomberMania.model.game.powerUps.IncreaseExplosionRadius;
import com.gr02.BomberMania.model.game.powerUps.DecreaseTimer;
import com.gr02.BomberMania.model.game.powerUps.PushBomb;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.game.elements.Element;
import com.gr02.BomberMania.viewer.Viewer;
import com.gr02.BomberMania.viewer.game.powerUps.AddBombViewer;
import com.gr02.BomberMania.viewer.game.powerUps.IncreaseExplosionRadiusViewer;
import com.gr02.BomberMania.viewer.game.powerUps.DecreaseTimerVIewer;
import com.gr02.BomberMania.viewer.game.powerUps.PushBombViewer;
import com.gr02.BomberMania.viewer.game.walls.BrickViewer;
import com.gr02.BomberMania.viewer.game.walls.IndestructibleWallViewer;
import com.gr02.BomberMania.viewer.game.walls.PowerUpWallViewer;

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
        drawElements(gui, getModel().getPowerUpWalls(), new PowerUpWallViewer());
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
            if (element instanceof AddBomb) {
                ElementViewer<AddBomb> viewer = new AddBombViewer();
                viewer.draw((AddBomb) element, gui);
            }
            if (element instanceof IncreaseExplosionRadius) {
                ElementViewer<IncreaseExplosionRadius> viewer = new IncreaseExplosionRadiusViewer();
                viewer.draw((IncreaseExplosionRadius) element, gui);
            }
            if (element instanceof DecreaseTimer) {
                ElementViewer<DecreaseTimer> viewer = new DecreaseTimerVIewer();
                viewer.draw((DecreaseTimer) element, gui);
            }
            if (element instanceof PushBomb) {
                ElementViewer<PushBomb> viewer = new PushBombViewer();
                viewer.draw((PushBomb) element, gui);
            }
        }
    }
}
