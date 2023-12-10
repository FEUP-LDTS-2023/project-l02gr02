package com.gr02.BomberMania.controller.game;

import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.menu.MainMenu;
import com.gr02.BomberMania.states.menu.MainMenuState;

public class Player1Controller extends PlayableCharacterController {
    public Player1Controller(Arena arena) {
        super(arena, arena.getPlayer1());
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        switch (action) {
            case UP:
                moveHeroUp();
                break;
            case RIGHT:
                moveHeroRight();
                break;
            case DOWN:
                moveHeroDown();
                break;
            case LEFT:
                moveHeroLeft();
                break;
            case BACKTOMENU:
                game.setState(new MainMenuState(new MainMenu()));
                break;
            case BOMB:
                placeBomb();
                break;
            case DETONATE:
                if (!getPlayer().canDetonateBombs()) getPlayer().detonateBombs(getModel());
                break;
            default:
        }
    }
}
