package com.gr02.BomberMania.viewer.menu.submenu;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.Position;
import com.gr02.BomberMania.model.menu.submenu.WinMenu;
import com.gr02.BomberMania.viewer.Viewer;

import static com.gr02.BomberMania.Game.height;
import static com.gr02.BomberMania.Game.width;

public class WinMenuViewer extends Viewer<WinMenu> {
    public WinMenuViewer(WinMenu menu) {
        super(menu);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(width/2 - 7, (int) (height * 0.2)), "PLAYER " + getModel().getPlayerNumber() + " WINS!", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(new Position(5, (int) (height * 0.5) + i*3), getModel().getEntry(i), getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
    }
}
