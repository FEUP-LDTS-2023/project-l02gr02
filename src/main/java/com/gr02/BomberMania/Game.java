package com.gr02.BomberMania;

import com.gr02.BomberMania.gui.LanternaGUI;
import com.gr02.BomberMania.model.menu.MainMenu;
import com.gr02.BomberMania.music.Sound;
import com.gr02.BomberMania.states.menu.MainMenuState;
import com.gr02.BomberMania.states.State;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;
    public static final int FPS = 60, width = 40, height = 30;
    private Sound music;
    public static Sound explosion;

    static {
        try {
            explosion = new Sound("./src/main/resources/music/explosion.wav");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            throw new RuntimeException(e);
        }
    }

    public Game() throws FontFormatException, IOException, URISyntaxException, UnsupportedAudioFileException, LineUnavailableException {
        this.gui = new LanternaGUI(width, height);
        this.state = new MainMenuState(new MainMenu());
        this.music = new Sound("./src/main/resources/music/battle.wav");
        music.runMusic();
        if (explosion.getfc() != null) explosion.getfc().setValue(-10);
    }

    public static void main(String[] args) throws FontFormatException, IOException, URISyntaxException, UnsupportedAudioFileException, LineUnavailableException {
        new Game().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    private void start() throws IOException {
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

    public Sound getMusic() {
        return music;
    }

    public void setMusic(Sound sound) {
        this.music = sound;
    }
}