package com.gr02.BomberMania.music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound {
    protected Clip clip;
    protected FloatControl fc;
    private boolean muted = false;

    public Sound(String path) throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));
        clip = AudioSystem.getClip();
        clip.open(inputStream);
        fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
    }

    public boolean isMuted() {
        return muted;
    }

    public FloatControl getfc() {
        return fc;
    }

    public void runMusic() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void play() {
        clip.setFramePosition(0);
        clip.start();
    }

    public void volumeSoundMute(){
        if (!isMuted()) {
            fc.setValue(fc.getMinimum());
            muted = true;
        }
        else {
            fc.setValue(0);
            muted = false;
        }

    }
}
