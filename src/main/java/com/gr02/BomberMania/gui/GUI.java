package com.gr02.BomberMania.gui;


import com.gr02.BomberMania.model.Position;

import java.io.IOException;

public interface GUI {
    ACTION getNextAction() throws IOException;

    void drawPlayableCharacter(Position position);

    void drawText(Position position, String text, String color);

    void drawIndestructibleWall(Position position);

    void drawBrickWall(Position position);

    void clear();

    void refresh() throws IOException;

    void close() throws IOException;

    void drawBomb(Position position);

    enum ACTION {UP, RIGHT, DOWN, LEFT, NONE, BACKTOMENU, SELECT}
}
