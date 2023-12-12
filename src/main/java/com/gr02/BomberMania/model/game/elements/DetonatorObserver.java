package com.gr02.BomberMania.model.game.elements;

import com.gr02.BomberMania.controller.game.PlayableCharacterController;
import com.gr02.BomberMania.model.game.arena.Arena;

public interface DetonatorObserver {

    void explode(Arena arena);
}
