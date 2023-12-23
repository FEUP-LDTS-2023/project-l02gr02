package com.gr02.BomberMania.music;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

import static org.mockito.Mockito.times;

public class SoundTest {
    Sound sound;
    Clip clip;
    FloatControl fc;

    @BeforeEach
    public void helper() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        sound = new Sound("./src/main/resources/music/battle.wav");
        clip = Mockito.mock(Clip.class);
        fc = Mockito.mock(FloatControl.class);
        sound.fc = fc;
        sound.clip = clip;
    }

    @Test
    public void isMutedTest() {
        Assertions.assertEquals(false, sound.isMuted());
        sound.volumeSoundMute();
        Assertions.assertEquals(true,sound.isMuted());
        sound.volumeSoundMute();
        Assertions.assertEquals(false, sound.isMuted());
    }

    @Test
    public void runMusicTest() {
        sound.runMusic();
        Mockito.verify(clip,times(1)).loop(Clip.LOOP_CONTINUOUSLY);
    }

    @Test
    public void playTest() {
        sound.play();
        Mockito.verify(clip,times(1)).start();
        Mockito.verify(clip,times(1)).setFramePosition(0);
    }

    @Test
    public void getFCTest() {
        Assertions.assertEquals(fc, sound.getfc());
    }
}
