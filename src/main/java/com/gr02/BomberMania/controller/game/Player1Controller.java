package com.gr02.BomberMania.controller.game;

import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.Position;
import com.gr02.BomberMania.model.game.Elements.Bomb;
import com.gr02.BomberMania.model.game.Elements.BombInfo;
import com.gr02.BomberMania.model.game.Elements.PlayableCharacter;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.menu.MainMenu;
import com.gr02.BomberMania.states.menu.MainMenuState;

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
    protected void placeBomb() {
        PlayableCharacter player = getModel().getPlayer1();
        if (player.getNumberOfBombs() <= 0) return;
        getModel().addBomb( new Bomb(player.getPosition().getX(), player.getPosition().getY(), (BombInfo) player.getBombInfo().clone()) );
        player.decreaseNumberOfBombs();
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
            default:
        }
    }
}
