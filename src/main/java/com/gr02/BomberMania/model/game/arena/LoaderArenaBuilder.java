package com.gr02.BomberMania.model.game.arena;

import com.gr02.BomberMania.model.game.*;
import com.gr02.BomberMania.model.game.Elements.PlayableCharacter;
import com.gr02.BomberMania.model.game.Elements.Walls.BrickWall;
import com.gr02.BomberMania.model.game.Elements.Walls.IndestructibleWall;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoaderArenaBuilder extends ArenaBuilder {

    private final List<String> lines;

    public LoaderArenaBuilder() throws IOException {
        URL resource = LoaderArenaBuilder.class.getResource("/levels/mapa");
        BufferedReader br = new BufferedReader(new FileReader(resource.getFile()));

        lines = readLines(br);
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
                if (line.charAt(x) == 'H') return new PlayableCharacter(x, y, new BombInfo());
        }
        return null;
    }
    @Override
    protected PlayableCharacter createPlayer2() {
        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'F') return new PlayableCharacter(x, y, new BombInfo());
        }
        return null;
    }
    @Override
    protected List<IndestructibleWall> createIndestructibleWalls() {
        List<IndestructibleWall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#') walls.add(new IndestructibleWall(x, y));
        }

        return walls;
    }

    @Override
    protected List<BrickWall> createBrickWalls() {
        List<BrickWall> walls = new ArrayList<>();

        for (int y = 0; y < lines.size(); y++) {
            String line = lines.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'B') walls.add(new BrickWall(x, y));
        }

        return walls;
    }
}
