package com.gr02.BomberMania.music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class Music {
    protected Clip clip;
    protected Clip explosion;
    protected FloatControl fc;
    private boolean muted = false;

    public Music() {
        try {
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(new File("./src/main/resources/music/myimmortal.wav"));
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
        explosion.setFramePosition(0);
        explosion.start();
    }
}
