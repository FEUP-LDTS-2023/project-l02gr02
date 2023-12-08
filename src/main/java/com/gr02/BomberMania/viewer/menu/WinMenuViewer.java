package com.gr02.BomberMania.viewer.menu;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.Position;
import com.gr02.BomberMania.model.menu.WinMenu;
import com.gr02.BomberMania.viewer.Viewer;

public class WinMenuViewer extends Viewer<WinMenu> {
    public WinMenuViewer(WinMenu menu) {
        super(menu);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(3, 5), "PLAYER " + getModel().getPlayerNumber() + " WINS!", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(new Position(5, 7+i), getModel().getEntry(i), getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
    }
}
