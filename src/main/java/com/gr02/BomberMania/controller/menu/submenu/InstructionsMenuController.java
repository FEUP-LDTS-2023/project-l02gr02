package com.gr02.BomberMania.controller.menu.submenu;

import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.controller.Controller;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.menu.MainMenu;
import com.gr02.BomberMania.model.menu.submenu.InstructionsMenu;
import com.gr02.BomberMania.states.menu.MainMenuState;

import java.io.IOException;

public class InstructionsMenuController extends Controller<InstructionsMenu> {
    public InstructionsMenuController(InstructionsMenu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case SELECT:
                if (getModel().isSelectedGoBack()) game.setState(new MainMenuState(new MainMenu()));
                break;
            default:
                break;
        }
    }
}
