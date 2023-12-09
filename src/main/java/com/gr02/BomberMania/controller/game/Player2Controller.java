package com.gr02.BomberMania.controller.game;

import com.gr02.BomberMania.Game;
import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.Position;
import com.gr02.BomberMania.model.game.elements.Bomb;
import com.gr02.BomberMania.model.game.elements.BombInfo;
import com.gr02.BomberMania.model.game.elements.PlayableCharacter;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.game.powerUps.PowerUp;
import com.gr02.BomberMania.model.menu.MainMenu;
import com.gr02.BomberMania.states.menu.MainMenuState;

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
        // Check if position is available
        if (getModel().isEmpty(position)) {
            getModel().getPlayer2().setPosition(position);
            // Check if upgrades exist and consume them
            PowerUp temp = getModel().checkForUpgrades(position);
            if (temp != null) {
                getModel().getPowerUps().remove(temp);
                temp.execute(getModel().getPlayer2());
            }
        } else if (getModel().getPlayer2().canPushBombs()){
            // If player can push bombs check if they exist in the position
            Bomb bomb = getModel().checkForBombs(position);
            if (bomb != null) {
                if (bomb.push(getModel(), getModel().getPlayer2().getPosition()))
                    getModel().getPlayer2().setPosition(position);
            }
        }
    }
    @Override
    protected void placeBomb() {
        PlayableCharacter player = getModel().getPlayer2();
        if (player.getNumberOfBombs() <= 0) return;
        getModel().addBomb( new Bomb(player.getPosition().getX(), player.getPosition().getY(), (BombInfo) player.getBombInfo().clone()) );
        player.decreaseNumberOfBombs();
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
                game.setState(new MainMenuState(new MainMenu()));
                break;
            case BOMB2:
                placeBomb();
                break;
            default:
        }
    }
}