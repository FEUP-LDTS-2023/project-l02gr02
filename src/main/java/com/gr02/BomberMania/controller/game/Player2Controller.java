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
        super(arena, arena.getPlayer2());
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