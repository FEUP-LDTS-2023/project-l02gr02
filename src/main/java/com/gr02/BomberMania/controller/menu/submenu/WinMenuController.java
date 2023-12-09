package com.gr02.BomberMania.controller.menu.submenu;

import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.controller.Controller;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.menu.MainMenu;
import com.gr02.BomberMania.model.menu.submenu.MapMenu;
import com.gr02.BomberMania.model.menu.submenu.WinMenu;
import com.gr02.BomberMania.states.menu.MainMenuState;
import com.gr02.BomberMania.states.menu.submenu.MapMenuState;

import java.io.IOException;

public class WinMenuController extends Controller<WinMenu> {
    public WinMenuController(WinMenu menu) {
        super(menu);
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) throws IOException {
        switch (action) {
            case UP:
                getModel().previousEntry();
                break;
            case DOWN:
                getModel().nextEntry();
                break;
            case SELECT:
                if (getModel().isSelectedReplay()) game.setState(new MapMenuState(new MapMenu()));
                if (getModel().isSelectedMainMenu()) game.setState(new MainMenuState(new MainMenu()));
                if (getModel().isSelectedExit()) game.setState(null);
                break;
            default:
                break;
        }
    }
}
