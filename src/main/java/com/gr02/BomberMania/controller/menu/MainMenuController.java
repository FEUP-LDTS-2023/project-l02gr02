package com.gr02.BomberMania.controller.menu;

import com.gr02.BomberMania.controller.Controller;
import com.gr02.BomberMania.model.game.arena.LoaderArenaBuilder;
import com.gr02.BomberMania.model.menu.MainMenu;
import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.states.GameState;

import java.io.IOException;

public class MainMenuController extends Controller<MainMenu> {
    public MainMenuController(MainMenu menu) {
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
                if (getModel().isSelectedStart()) game.setState(new GameState(new LoaderArenaBuilder().createArena()));
                if (getModel().isSelectedInstruction()) game.setState(null);
                break;
            default:
                break;
        }
    }
}
