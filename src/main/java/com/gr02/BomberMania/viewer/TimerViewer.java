package com.gr02.BomberMania.viewer;

import com.gr02.BomberMania.gui.GUI;
import com.gr02.BomberMania.model.game.elements.Timer;

public class TimerViewer implements ElementViewer<Timer> {

    @Override
    public void draw(Timer timer, GUI gui) {
        int minutes = timer.getTimeRemaining()/(60*60), seconds = (timer.getTimeRemaining()/60) % 60;
        gui.drawTimer(timer.getPosition(), minutes, seconds);
    }
}
