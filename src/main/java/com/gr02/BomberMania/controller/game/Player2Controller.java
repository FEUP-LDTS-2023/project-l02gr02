package com.gr02.BomberMania.controller.game;

import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.Position;
import com.gr02.BomberMania.model.game.Bomb;
import com.gr02.BomberMania.model.game.BombInfo;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.menu.Menu;
import com.gr02.BomberMania.states.MenuState;

public class Player2Controller extends PlayableCharacterController {
    public Player2Controller(Arena arena) {
        super(arena);
    }
    @Override
    public void moveHeroLeft() {
        moveHero(getModel().getPlayer2().getPosition().getLeft());
    }
    @Override
    public void moveHeroRight() {
        moveHero(getModel().getPlayer2().getPosition().getRight());
    }
    @Override
    public void moveHeroUp() {
        moveHero(getModel().getPlayer2().getPosition().getUp());
    }
    @Override
    public void moveHeroDown() {
        moveHero(getModel().getPlayer2().getPosition().getDown());
    }
    @Override
    protected void moveHero(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getPlayer2().setPosition(position);
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time) {
        switch (action) {
            case UP2:
                moveHeroUp();
                break;
            case RIGHT2:
                moveHeroRight();
                break;
            case DOWN2:
                moveHeroDown();
                break;
            case LEFT2:
                moveHeroLeft();
                break;
            case BACKTOMENU:
                game.setState(new MenuState(new Menu()));
                break;
            case BOMB2:
                placeBomb(getModel().getPlayer2().getPosition(), getModel().getPlayer2().getBombInfo());
                break;
            default:
        }
    }
}