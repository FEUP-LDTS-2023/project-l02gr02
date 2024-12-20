package com.gr02.BomberMania.gui;


import com.gr02.BomberMania.model.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawPlayer1(Position position);

    void drawPlayer2(Position position);

    void drawText(Position position, String text, String color);

    void drawIndestructibleWall(Position position);

    void drawBrickWall(Position position);

    void drawPowerUpWall(Position position);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    void drawBomb(Position position);

    void drawFlame(Position position);

    void drawAddBomb(Position position);

    void drawIncreaseExplosionRadius(Position position);

    void drawDecreaseTimer(Position position);
    void drawPushBomb(Position position);

    void drawDetonateBomb(Position position);

    void drawTimer(Position position, int minutes, int seconds);

    enum ACTION { NONE, BACKTOMENU, SELECT, UP, RIGHT, DOWN, LEFT, BOMB, DETONATE, UP2, RIGHT2, DOWN2, LEFT2, BOMB2, DETONATE2}
}
