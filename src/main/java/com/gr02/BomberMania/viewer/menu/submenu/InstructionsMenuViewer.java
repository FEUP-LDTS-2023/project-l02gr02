package com.gr02.BomberMania.viewer.menu.submenu;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.Position;
import com.gr02.BomberMania.model.menu.submenu.InstructionsMenu;
import com.gr02.BomberMania.viewer.Viewer;

import static com.gr02.BomberMania.Game.height;
import static com.gr02.BomberMania.Game.width;

public class InstructionsMenuViewer extends Viewer<InstructionsMenu> {

    public InstructionsMenuViewer(InstructionsMenu model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        int heightShift = (int) (height * 0.1);
        int widthShift = (int) (width * 0.3);
        gui.drawText(new Position(width/2 - 6, 1 + heightShift), "INSTRUCTIONS", "#FFFFFF");
        gui.drawText(new Position(2 + widthShift, 4 + heightShift), "Player 1:", "#88dad4");
        gui.drawText(new Position(3 + widthShift, 6 + heightShift), "Movement:", "#FFFFFF");
        gui.drawText(new Position(15 + widthShift, 6 + heightShift), "W", "#FFFFFF"); // up|left|down|right arrows
        gui.drawText(new Position(14 + widthShift, 7 + heightShift), "A", "#FFFFFF"); // up|left|down|right arrows
        gui.drawText(new Position(15 + widthShift, 7 + heightShift), "S", "#FFFFFF"); // up|left|down|right arrows
        gui.drawText(new Position(16 + widthShift, 7 + heightShift), "D", "#FFFFFF"); // up|left|down|right arrows

        gui.drawText(new Position(3 + widthShift, 9 + heightShift), "Bomb: F", "#9F0000");
        gui.drawText(new Position(3 + widthShift, 10 + heightShift), "Detonator: E", "#9F0000");

        gui.drawText(new Position(2 + widthShift, 12 + heightShift), "Player 2:", "#fce97d");
        gui.drawText(new Position(3 + widthShift, 14 + heightShift), "Movement:", "#FFFFFF");
        gui.drawText(new Position(15 + widthShift, 14 + heightShift), "@", "#FFFFFF"); // up|left|down|right arrows
        gui.drawText(new Position(14 + widthShift, 15 + heightShift), "<", "#FFFFFF"); // up|left|down|right arrows
        gui.drawText(new Position(15 + widthShift, 15 + heightShift), "=", "#FFFFFF"); // up|left|down|right arrows
        gui.drawText(new Position(16 + widthShift, 15 + heightShift), ">", "#FFFFFF"); // up|left|down|right arrows

        gui.drawText(new Position(3 + widthShift, 17 + heightShift), "Bomb: P", "#9F0000");
        gui.drawText(new Position(3 + widthShift, 18 + heightShift), "Detonator: ~", "#9F0000");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(new Position(width/2 - 3, 20 + i + heightShift), getModel().getEntry(i), getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
    }
}