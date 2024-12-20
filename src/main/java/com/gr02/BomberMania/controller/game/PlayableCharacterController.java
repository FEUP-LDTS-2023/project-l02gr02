package com.gr02.BomberMania.controller.game;

import com.gr02.BomberMania.model.Position;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.game.elements.*;
import com.gr02.BomberMania.model.game.powerUps.PowerUp;


public abstract class PlayableCharacterController extends GameController {

    private final PlayableCharacter player;
    public PlayableCharacterController(Arena arena, PlayableCharacter player) {
        super(arena);
        this.player = player;
    }

    public void moveHeroLeft() {
        moveHero(player.getPosition().getLeft());
    }

    public void moveHeroRight() {
        moveHero(player.getPosition().getRight());
    }

    public void moveHeroUp() {
        moveHero(player.getPosition().getUp());
    }

    public void moveHeroDown() {
        moveHero(player.getPosition().getDown());
    }

    protected void moveHero(Position position) {
        // Check if position is available
        if (getModel().isEmpty(position)) {
            player.setPosition(position);
            // Check if upgrades exist and consume them
            PowerUp temp = getModel().checkForUpgrades(position);
            if (temp != null) {
                getModel().getPowerUps().remove(temp);
                temp.execute(player);
            }
        } else if (player.canPushBombs()){
            // If player can push bombs check if they exist in the position
            Bomb bomb = getModel().checkForBombs(position);
            if (bomb != null) {
                if (bomb.push(getModel(), player.getPosition()))
                    player.setPosition(position);
            }
        }
    }

    protected void placeBomb() {
        if (player.getNumberOfBombs() < 1) return;
        Bomb aux = getModel().checkForBombs(new Position(player.getPosition().getX(), player.getPosition().getY()));
        if (aux != null) return;
        Bomb bomb = new Bomb(player.getPosition().getX(), player.getPosition().getY(), (BombInfo) player.getBombInfo().clone());
        getModel().addBomb(bomb);
        player.addObserver(bomb);
        player.decreaseNumberOfBombs();
    }

    protected PlayableCharacter getPlayer() {
        return player;
    }
}
