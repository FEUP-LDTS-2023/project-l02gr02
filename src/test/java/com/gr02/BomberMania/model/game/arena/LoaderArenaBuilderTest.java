package com.gr02.BomberMania.model.game.arena;

import org.junit.jupiter.api.Test;

import java.io.IOException;


public class LoaderArenaBuilderTest {
    @Test
    void buildArenaTest() throws IOException {
        Arena arena = new LoaderArenaBuilder("mapa1").createArena();


    }
}
