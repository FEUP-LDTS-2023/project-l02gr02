package com.gr02.BomberMania.gui;


import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.gr02.BomberMania.model.Position;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class LanternaGUITest {
    private Screen screen;
    private LanternaGUI gui;
    private TextGraphics tg;

    @BeforeEach
    void setUp() {
        screen = Mockito.mock(Screen.class);
        tg = Mockito.mock(TextGraphics.class);
        Mockito.when(screen.newTextGraphics()).thenReturn(tg);
        gui = new LanternaGUI(screen);
    }

    @Test
    void drawPlayableCharacter() {
        gui.drawPlayer1(new Position(1, 1));
        gui.drawPlayer2(new Position(1, 2));

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(136,218,212));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "?");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(252,233,125));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 3, "?");
    }

    @Test
    void drawText() {
        gui.drawText(new Position(1, 1), "Hello World", "#336699");

        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(51, 102, 153));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 1, "Hello World");
    }

    @Test
    public void getNextActionTest() throws IOException {
        List<String> listOfLetters = Arrays.asList("q", "p", "o", "w", "d", "s", "a", "f", "e");
        List<GUI.ACTION> listOfActionsForLetters = Arrays.asList(GUI.ACTION.BACKTOMENU,
                GUI.ACTION.BOMB, GUI.ACTION.DETONATE, GUI.ACTION.UP2, GUI.ACTION.RIGHT2, GUI.ACTION.DOWN2,
                GUI.ACTION.LEFT2, GUI.ACTION.BOMB2, GUI.ACTION.DETONATE2);

        List<KeyType> listOfKeytype = Arrays.asList(KeyType.ArrowUp, KeyType.ArrowRight, KeyType.ArrowDown,
                KeyType.ArrowLeft, KeyType.Enter);
        List<GUI.ACTION> listOfActionsForKeytypes = Arrays.asList(GUI.ACTION.UP, GUI.ACTION.RIGHT, GUI.ACTION.DOWN,
                GUI.ACTION.LEFT, GUI.ACTION.SELECT);

        for (int k = 0; k < listOfLetters.size(); k++) {
            Mockito.when(screen.pollInput()).thenReturn(KeyStroke.fromString(listOfLetters.get(k)));
            Assertions.assertEquals(gui.getNextAction(), listOfActionsForLetters.get(k));
        }

        for (int k = 0; k < listOfKeytype.size(); k++) {
            Mockito.when(screen.pollInput()).thenReturn(new KeyStroke(listOfKeytype.get(k)));
            Assertions.assertEquals(gui.getNextAction(), listOfActionsForKeytypes.get(k));
        }
    }

    @Test
    public void drawBombTest() {
        gui.drawBomb(new Position(1, 1));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "+");
    }

    @Test
    public void drawIndestructibleWallTest() {
        gui.drawIndestructibleWall(new Position(1, 1));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(188, 74, 60));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "%");
    }

    @Test
    public void drawPowerUpWallTest() {
        gui.drawPowerUpWall(new Position(1, 1));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 215, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "#");
    }

    @Test
    public void drawBrickWallTest() {
        gui.drawBrickWall(new Position(1, 1));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(159, 0, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "#");
    }

    @Test
    public void drawFlameTest() {
        gui.drawFlame(new Position(1, 1));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 232, 8));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "&");
    }

    @Test
    public void drawAddBombTest() {
        gui.drawAddBomb(new Position(1, 1));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 215, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "+");
    }

    @Test
    public void drawIncreaseExplosionRadiusTest() {
        gui.drawIncreaseExplosionRadius(new Position(1, 1));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 215, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, ";");
    }

    @Test
    public void drawDecreaseTimerTest() {
        gui.drawDecreaseTimer(new Position(1, 1));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 215, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "$");
    }

    @Test
    public void drawPushBombTest() {
        gui.drawPushBomb(new Position(1, 1));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 215, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "}");
    }

    @Test
    public void drawDetonateBombTest() {
        gui.drawDetonateBomb(new Position(1, 1));
        Mockito.verify(tg, Mockito.times(1)).setForegroundColor(new TextColor.RGB(255, 215, 0));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "_");
    }

    @Test
    public void drawTimerTest() {
        gui.drawTimer(new Position(1, 1), 1, 20);
        Mockito.verify(tg, Mockito.times(5)).setForegroundColor(new TextColor.RGB(255, 255, 255));
        Mockito.verify(tg, Mockito.times(1)).putString(2, 2, String.valueOf(Character.forDigit(1, 10)));
        Mockito.verify(tg, Mockito.times(1)).putString(4, 2, String.valueOf(Character.forDigit(20/10, 10)));
        Mockito.verify(tg, Mockito.times(1)).putString(5, 2, String.valueOf(Character.forDigit(20%10, 10)));
        Mockito.verify(tg, Mockito.times(1)).putString(1, 2, "{");
        Mockito.verify(tg, Mockito.times(1)).putString(3, 2, ":");
    }

    @Test
    public void clearTest() {
        gui.clear();
        Mockito.verify(screen, Mockito.times(1)).clear();
    }

    @Test
    public void refreshTest() throws IOException {
        gui.refresh();
        Mockito.verify(screen, Mockito.times(1)).refresh();
    }

    @Test
    public void closeTest() throws IOException {
        gui.close();
        Mockito.verify(screen, Mockito.times(1)).close();
    }
}