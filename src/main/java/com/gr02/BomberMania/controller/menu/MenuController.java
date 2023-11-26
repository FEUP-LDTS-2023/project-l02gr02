package com.gr02.BomberMania.controller.menu;

import com.gr02.BomberMania.controller.Controller;
import com.gr02.BomberMania.model.menu.Menu;
import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.gui.GUI;

import java.io.IOException;

public class MenuController extends Controller<Menu> {
    public MenuController(Menu menu) {
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
                if (getModel().isSelectedExit()) game.setState(null);
                if (getModel().isSelectedStart()) game.setState(null);
                break;
            default:
                break;
        }
    }
}
