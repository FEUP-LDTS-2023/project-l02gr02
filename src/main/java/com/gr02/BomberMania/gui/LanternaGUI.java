package com.gr02.BomberMania.gui;

import com.gr02.BomberMania.model.Position;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI {
    private final Screen screen;

    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadSquareFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    private AWTTerminalFontConfiguration loadSquareFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/bombermania.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);

        Font loadedFont = font.deriveFont(Font.PLAIN, 25);
        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    @Override
    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'q') return ACTION.BACKTOMENU;

        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.LEFT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'p') return ACTION.BOMB;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'ç') return ACTION.DETONATE;

        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'w') return ACTION.UP2;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'd') return ACTION.RIGHT2;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 's') return ACTION.DOWN2;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'a') return ACTION.LEFT2;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'f') return ACTION.BOMB2;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'e') return ACTION.DETONATE2;

        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }

    @Override
    public void drawPlayer1(Position position) {
        drawCharacter(position.getX(), position.getY(), '?', "#88DAD4");
    }

    @Override
    public void drawPlayer2(Position position) {
        drawCharacter(position.getX(), position.getY(), '?', "#FCE97D");
    }

    @Override
    public void drawBomb(Position position) {
        drawCharacter(position.getX(), position.getY(), '+', "#FFFFFF");
    }

    private void drawCharacter(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + c);
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    @Override
    public void drawIndestructibleWall(Position position) {
        drawCharacter(position.getX(), position.getY(), '%', "#BC4A3C");
    }
    @Override
    public void drawPowerUpWall(Position position) {
        drawCharacter(position.getX(), position.getY(), 'V', "#BC4A3C");
    }

    @Override
    public void drawBrickWall(Position position) {
        drawCharacter(position.getX(), position.getY(), '#', "#9F0000");
    }

    @Override
    public void drawFlame(Position position) { drawCharacter(position.getX(), position.getY(), '&', "#ffe808");}

    @Override
    public void drawAddBomb(Position position) {
        drawCharacter(position.getX(), position.getY(), 'X', "#FF0000");
    }
    @Override
    public void drawIncreaseExplosionRadius(Position position) {
        drawCharacter(position.getX(), position.getY(), 'Z', "#FF0000");
    }
    @Override
    public void drawDecreaseTimer(Position position) {
        drawCharacter(position.getX(), position.getY(), 'C', "#FF0000");
    }
    @Override
    public void drawPushBomb(Position position) {
        drawCharacter(position.getX(), position.getY(), 'N', "#FF0000");
    }

    @Override
    public void drawDetonateBomb(Position position) {
        drawCharacter(position.getX(), position.getY(), 'D', "#FF0000");
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }
}