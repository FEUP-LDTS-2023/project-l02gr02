package com.gr02.BomberMania.controller.game;


import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.Position;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.menu.Menu;
import com.gr02.BomberMania.states.MenuState;


public class HeroController extends GameController {
    public HeroController(Arena arena) {
        super(arena);
    }

    public void moveHeroLeft() {
        moveHero(getModel().getPlayableCharacter().getPosition().getLeft());
    }

    public void moveHeroRight() {
        moveHero(getModel().getPlayableCharacter().getPosition().getRight());
    }

    public void moveHeroUp() {
        moveHero(getModel().getPlayableCharacter().getPosition().getUp());
    }

    public void moveHeroDown() {
        moveHero(getModel().getPlayableCharacter().getPosition().getDown());
    }

    private void moveHero(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getPlayableCharacter().setPosition(position);
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
