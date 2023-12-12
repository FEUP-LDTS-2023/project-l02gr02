package com.gr02.BomberMania.music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class Music {
    protected Clip clip;
    private float currentVolume = 0;
    private float previousVolume = 0;
    protected FloatControl fc;
    private boolean muted = false;

    public Music(String path) {
        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File(path));
            clip = AudioSystem.getClip();
            clip.open(inputStream);
            fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isMuted() {
        return muted;
    }

    public void setMuted(boolean muted) {
        this.muted = muted;
    }

    public void runMusic() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void play(){
        clip.setFramePosition(0);
        clip.start();
    }

    public void volumeMusicMute(){
        if (!isMuted()) {
            previousVolume = currentVolume;
            currentVolume = -80.0f;
            fc.setValue(currentVolume);
            muted = true;
        }
        else {
            currentVolume = previousVolume;
            fc.setValue(currentVolume);
            muted = false;
        }

    }
}
