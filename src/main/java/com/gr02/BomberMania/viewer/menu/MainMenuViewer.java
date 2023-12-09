package com.gr02.BomberMania.viewer.menu;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.Position;
import com.gr02.BomberMania.model.menu.MainMenu;
import com.gr02.BomberMania.viewer.Viewer;

import static com.gr02.BomberMania.Game.height;
import static com.gr02.BomberMania.Game.width;

public class MainMenuViewer extends Viewer<MainMenu> {
    public MainMenuViewer(MainMenu menu) {
        super(menu);
    }

    @Override
    protected void drawElements(GUI gui) {
        gui.drawText(new Position(width/2 - 5, (int) (height * 0.2)), "B[mberMania", "#FFFFFF");

        for (int i = 0; i < getModel().getNumberEntries(); i++) {
            gui.drawText(new Position(5, (int) (height * 0.5) + i*3), getModel().getEntry(i), getModel().isSelected(i) ? "#FFD700" : "#FFFFFF");
        }
    }
}
