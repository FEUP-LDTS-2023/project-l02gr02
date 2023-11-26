package com.gr02.BomberMania;

import com.gr02.BomberMania.gui.LanternaGUI;
import com.gr02.BomberMania.model.menu.Menu;
import com.gr02.BomberMania.states.MenuState;
import com.gr02.BomberMania.states.State;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(20, 20);
        this.state = new MenuState(new Menu());
    }

    public static void main(String[] args) throws FontFormatException, IOException, URISyntaxException {
        new Game().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    private void start() throws IOException {
        int FPS = 10;
        int frameTime = 1000/FPS;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();

            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                System.out.println("InterruptedException ERROR in Thread.sleep inside Game");
            }
        }

        gui.close();
    }
}