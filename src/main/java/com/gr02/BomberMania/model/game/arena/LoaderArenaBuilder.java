package com.gr02.BomberMania.model.game.arena;

import com.gr02.BomberMania.model.game.elements.BombInfo;
import com.gr02.BomberMania.model.game.elements.PlayableCharacter;
import com.gr02.BomberMania.model.game.elements.Timer;
import com.gr02.BomberMania.model.game.elements.Walls.BrickWall;
import com.gr02.BomberMania.model.game.elements.Walls.IndestructibleWall;
import com.gr02.BomberMania.model.game.elements.Walls.PowerUpWall;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.gr02.BomberMania.Game.height;
import static com.gr02.BomberMania.Game.width;

public class LoaderArenaBuilder extends ArenaBuilder {

    private int widthShift, heightShift;
    private final List<String> lines;

    private String getRandomLevel(String... levels) {
        if (levels == null || levels.length == 0) {
            throw new IllegalArgumentException("Pelo menos um nível deve ser fornecido.");
        }

        Random random = new Random();
        int randomIndex = random.nextInt(levels.length);
        return levels[randomIndex];
    }

    public LoaderArenaBuilder() throws IOException {
        String randomLevel = getRandomLevel("mapa1", "mapa2", "mapa3");
        String levelPath = "/levels/" + randomLevel;

        try (InputStream inputStream = LoaderArenaBuilder.class.getResourceAsStream(levelPath);
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader br = new BufferedReader(inputStreamReader)) {

            lines = readLines(br);
        } catch (NullPointerException e) {
            throw new IOException("Nível não encontrado: " + levelPath, e);
        }
        widthShift = width/2 - getWidth()/2;
        heightShift = height/2 - getHeight()/2;
    }

    public LoaderArenaBuilder(String level) throws IOException {
        URL resource = LoaderArenaBuilder.class.getResource("/levels/" + level);
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);
        widthShift = width/2 - getWidth()/2;
        heightShift = height/2 - getHeight()/2;
    }


    private List<String> readLines(BufferedReader br) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = br.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    @Override
    protected int getWidth() {
        int width = 0;
        for (String line : lines)
            width = Math.max(width, line.length());
        return width;
    }

    @Override
    protected int getHeight() {
        return lines.size();
    }

    @Override
    protected PlayableCharacter createPlayer1() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'H') return new PlayableCharacter(x + widthShift, y + heightShift, new BombInfo(), 1);
        }
        return null;
    }
    @Override
    protected PlayableCharacter createPlayer2() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'F') return new PlayableCharacter(x + widthShift, y + heightShift, new BombInfo(), 2);
        }
        return null;
    }
    @Override
    protected List<IndestructibleWall> createIndestructibleWalls() {
        List<IndestructibleWall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#') walls.add(new IndestructibleWall(x + widthShift, y + heightShift));
        }

        return walls;
    }

    @Override
    protected List<BrickWall> createBrickWalls() {
        List<BrickWall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'B') walls.add(new BrickWall(x + widthShift, y + heightShift));
        }

        return walls;
    }
    @Override
    protected List<PowerUpWall> createPowerUpWalls() {
        List<PowerUpWall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'V') walls.add(new PowerUpWall(x + widthShift, y + heightShift));
        }

        return walls;
    }

    @Override
    protected Timer createTimer() {
        return new Timer(width/2 - 2, 1, 3 * 60 * 60);
    }
}
