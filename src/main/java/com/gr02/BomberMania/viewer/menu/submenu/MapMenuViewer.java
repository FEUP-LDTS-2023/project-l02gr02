package com.gr02.BomberMania.viewer.menu.submenu;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.Position;
import com.gr02.BomberMania.model.menu.submenu.MapMenu;
import com.gr02.BomberMania.viewer.Viewer;

import static com.gr02.BomberMania.Game.height;
import static com.gr02.BomberMania.Game.width;

public class MapMenuViewer extends Viewer<MapMenu> {

    public MapMenuViewer(MapMenu model) {
        super(model);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(width/2 - 14, 2), "Please select the chosen map", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(new Position( (int) (width*0.1), 5 + i*3 + (int) (height * 0.1)), getModel().getEntry(i), getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
    }
}
