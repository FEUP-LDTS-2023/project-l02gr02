package com.gr02.BomberMania.model.game.elements;

import com.gr02.BomberMania.viewer.ElementViewer;
import com.gr02.BomberMania.viewer.TimerViewer;

public class Timer extends Element implements Timed{
    private int timeRemaining;

    public Timer(int x, int y, int timeRemaining) {
        super(x, y);
        this.timeRemaining = timeRemaining;
    }

    public int getTimeRemaining() {
        return timeRemaining;
    }

    @Override
    public void reduceTimer() {
        timeRemaining--;
    }

    @Override
    public <T extends Element> ElementViewer<T> getViewer() {
        return (ElementViewer<T>) new TimerViewer();
    }
}
