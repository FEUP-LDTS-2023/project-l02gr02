package com.gr02.BomberMania.viewer.menu.submenu;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.Position;
import com.gr02.BomberMania.model.menu.submenu.DrawMenu;
import com.gr02.BomberMania.viewer.Viewer;

import static com.gr02.BomberMania.Game.height;
import static com.gr02.BomberMania.Game.width;

public class DrawMenuViewer extends Viewer<DrawMenu> {
    public DrawMenuViewer(DrawMenu menu) {
        super(menu);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(width/2 - 5, (int) (height * 0.2)), getModel().getDrawReason(), "#FFFFFF");
        gui.drawText(new Position(width/2 - 2, (int) (height * 0.2)+1), "DRAW!", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(new Position(5, (int) (height * 0.5) + i*3), getModel().getEntry(i), getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
    }
}
