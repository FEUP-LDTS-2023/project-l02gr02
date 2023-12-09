package com.gr02.BomberMania.viewer.menu.submenu;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.Position;
import com.gr02.BomberMania.model.menu.MainMenu;
import com.gr02.BomberMania.model.menu.submenu.InstructionsMenu;
import com.gr02.BomberMania.viewer.Viewer;

public class InstructionsMenuViewer extends Viewer<InstructionsMenu> {

    public InstructionsMenuViewer(InstructionsMenu model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(1, 1), "INSTRUCTIONS:", "#FFFFFF");
        gui.drawText(new Position(2, 4), "Player 1:", "#88dad4");
        gui.drawText(new Position(3, 6), "Movement:", "#FFFFFF");
        gui.drawText(new Position(15, 6), "W", "#FFFFFF"); // up|left|down|right arrows
        gui.drawText(new Position(14, 7), "A", "#FFFFFF"); // up|left|down|right arrows
        gui.drawText(new Position(15, 7), "S", "#FFFFFF"); // up|left|down|right arrows
        gui.drawText(new Position(16, 7), "D", "#FFFFFF"); // up|left|down|right arrows

        gui.drawText(new Position(3, 8), "Bomb: F", "#9F0000");

        gui.drawText(new Position(2, 10), "Player 2:", "#fce97d");
        gui.drawText(new Position(3, 12), "Movement:", "#FFFFFF");
        gui.drawText(new Position(15, 12), "@", "#FFFFFF"); // up|left|down|right arrows
        gui.drawText(new Position(14, 13), "<", "#FFFFFF"); // up|left|down|right arrows
        gui.drawText(new Position(15, 13), "=", "#FFFFFF"); // up|left|down|right arrows
        gui.drawText(new Position(16, 13), ">", "#FFFFFF"); // up|left|down|right arrows
        gui.drawText(new Position(3, 14), "Bomb: P", "#9F0000");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(new Position(4, 17+i), getModel().getEntry(i), getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
    }
}