package com.gr02.BomberMania.controller.menu.submenu;

import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.controller.Controller;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.arena.LoaderArenaBuilder;
import com.gr02.BomberMania.model.menu.MainMenu;
import com.gr02.BomberMania.model.menu.submenu.MapMenu;
import com.gr02.BomberMania.states.game.GameState;
import com.gr02.BomberMania.states.menu.MainMenuState;

import java.io.IOException;

public class MapMenuController extends Controller<MapMenu> {


    public MapMenuController(MapMenu model) {
        super(model);
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
                if (getModel().isSelectedMap1()) game.setState(new GameState(new LoaderArenaBuilder("mapa1").createArena()));
                if (getModel().isSelectedMap2()) game.setState(new GameState(new LoaderArenaBuilder("mapa2").createArena()));
                if (getModel().isSelectedMap3()) game.setState(new GameState(new LoaderArenaBuilder("mapa3").createArena()));
                if (getModel().isSelectedRandomMap()) game.setState(new GameState(new LoaderArenaBuilder().createArena()));
                if (getModel().isSelectedGoBack()) game.setState(new MainMenuState(new MainMenu()));
                break;
            default:
                break;
        }
    }
}
