package com.gr02.BomberMania.model.game;

public class AddOneBomb extends PowerUp {
    @Override
    public void execute(PlayableCharacter player) {
        player.increaseNumberOfBombs();
    }
}
