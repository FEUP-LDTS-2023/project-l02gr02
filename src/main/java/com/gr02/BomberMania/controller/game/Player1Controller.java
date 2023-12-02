package com.gr02.BomberMania.controller.game;

import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.Position;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.menu.Menu;
import com.gr02.BomberMania.states.MenuState;

public class Player1Controller extends PlayableCharacterController {
    public Player1Controller(Arena arena) {
        super(arena);

    }
    @Override
    public void moveHeroLeft() {
        moveHero(getModel().getPlayer1().getPosition().getLeft());
    }
    @Override
    public void moveHeroRight() {
        moveHero(getModel().getPlayer1().getPosition().getRight());
    }
    @Override
    public void moveHeroUp() {
        moveHero(getModel().getPlayer1().getPosition().getUp());
    }
    @Override
    public void moveHeroDown() {
        moveHero(getModel().getPlayer1().getPosition().getDown());
    }
    @Override
    protected void moveHero(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getPlayer1().setPosition(position);
        }
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
                game.setState(new MenuState(new Menu()));
                break;
        }
    }
}
