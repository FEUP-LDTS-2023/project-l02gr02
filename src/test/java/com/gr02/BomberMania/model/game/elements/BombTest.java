package com.gr02.BomberMania.model.game.elements;

import com.gr02.BomberMania.model.Position;
import com.gr02.BomberMania.model.game.arena.Arena;
import com.gr02.BomberMania.model.game.elements.Walls.BrickWall;
import com.gr02.BomberMania.model.game.elements.Walls.IndestructibleWall;
import com.gr02.BomberMania.model.game.powerUps.AddBomb;
import com.gr02.BomberMania.model.game.powerUps.PowerUp;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static com.gr02.BomberMania.Game.FPS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

public class BombTest {

    @Test
    void reduceTimerTest() {
        BombInfo info = Mockito.mock(BombInfo.class);

        Bomb bomb = new Bomb(0, 0, info);

        bomb.reduceTimer();

        Mockito.verify(info, Mockito.times(1)).reduceTimer();
    }

    @Test
    void propagatingTest() {
        Arena arena = Mockito.mock(Arena.class);
        Bomb bomb = new Bomb(0, 0, new BombInfo());

        List<Flame> receiver = new ArrayList<>();

        // Setting up dummy brickWall
        Position brickWall = new Position(0, 0);
        Mockito.when(arena.isNotIndestructible(brickWall)).thenReturn(true);
        Mockito.doAnswer((i) -> {
            Object[] args = i.getArguments();
            receiver.add((Flame) args[0]);
            return null;
        }).when(arena).addFlame(any(Flame.class));
        Mockito.when(arena.destruct(brickWall)).thenReturn(true);

        // Checking if bomb stopped spreading and if flame was added at right position
        assertEquals(false, bomb.propagating(arena, brickWall));
        assertEquals(true, receiver.get(0).getPosition().equals(new Position(0, 0)));

        // Setting up dummy empty space
        Position emptySpace = new Position(1, 1);
        Mockito.when(arena.isNotIndestructible(emptySpace)).thenReturn(true);
        Mockito.when(arena.destruct(emptySpace)).thenReturn(false);

        // Checking if bomb didn't stop spreading and if flame was added at right position
        assertEquals(true, bomb.propagating(arena, emptySpace));
        assertEquals(true, receiver.get(1).getPosition().equals(new Position(1, 1)));

        // Setting up indestructible wall
        Position steelWall = new Position(2, 2);
        Mockito.when(arena.isNotIndestructible(steelWall)).thenReturn(false);

        // Checking if bomb stopped spreading and if flame wasn't added at right position
        assertEquals(false, bomb.propagating(arena, steelWall));
        assertEquals(2, receiver.size());
    }

    @Test
    void explodeTest() {
        // Setting up Arena, player
        Arena arena = new Arena(15, 15);
        PlayableCharacter player = Mockito.mock(PlayableCharacter.class);
        List<Bomb> bombs = new ArrayList<Bomb>();
        List<IndestructibleWall> indestructibleWalls = new ArrayList<IndestructibleWall>();
        List<BrickWall> brickWalls = new ArrayList<BrickWall>();
        List<Flame> correctPlacement = new ArrayList<Flame>();

        // Setting up Test Bombs
        Bomb bomb1 = new Bomb(10, 10, new BombInfo(5, 1, player));
        bombs.add(bomb1);
        Bomb bomb2 = new Bomb(5, 5, new BombInfo(5, 1, player));
        bombs.add(bomb2);
        Bomb bomb3 = new Bomb(8, 4, new BombInfo(5, 4, player));
        arena.setBombs(bombs);

        // Setting up Walls
        IndestructibleWall indestructibleWall1 = new IndestructibleWall(5, 4);
        indestructibleWalls.add(indestructibleWall1);
        IndestructibleWall indestructibleWall2 = new IndestructibleWall(8, 1);
        indestructibleWalls.add(indestructibleWall2);
        arena.setIndestructibleWalls(indestructibleWalls);

        BrickWall brickWall1 = new BrickWall(6, 5);
        brickWalls.add(brickWall1);
        BrickWall brickWall2 = new BrickWall(8, 5);
        brickWalls.add(brickWall2);
        arena.setBrickWalls(brickWalls);

        // Testing first bomb
        bomb1.explode(arena);

        assertEquals(false, arena.getBombs().contains(bomb1));
        Mockito.verify(player, Mockito.times(1)).removeObserver(bomb1);
        assertEquals(5, arena.getFlames().size());
        correctPlacement.add(new Flame(10, 10));
        correctPlacement.add(new Flame(10, 11));
        correctPlacement.add(new Flame(10, 9));
        correctPlacement.add(new Flame(9, 10));
        correctPlacement.add(new Flame(11, 10));
        for (Flame correct : correctPlacement) {
            boolean found = false;
            for (Flame temp : arena.getFlames()) {
                if (temp.getPosition().equals(correct.getPosition())) {
                    found = true;
                    break;
                }
            }
            assertEquals(true, found);
        }
        Mockito.verify(player, Mockito.times(1)).increaseNumberOfBombs();

        // Testing second bomb
        arena.setFlames(new ArrayList<Flame>());
        bomb2.explode(arena);

        assertEquals(false, arena.getBombs().contains(bomb2));
        Mockito.verify(player, Mockito.times(1)).removeObserver(bomb2);
        assertEquals(4, arena.getFlames().size());
        correctPlacement.clear();
        correctPlacement.add(new Flame(5, 5));
        correctPlacement.add(new Flame(4, 5));
        correctPlacement.add(new Flame(6, 5));
        correctPlacement.add(new Flame(5, 6));
        for (Flame correct : correctPlacement) {
            boolean found = false;
            for (Flame temp : arena.getFlames()) {
                if (temp.getPosition().equals(correct.getPosition())) {
                    found = true;
                    break;
                }
            }
            assertEquals(true, found);
        }
        Mockito.verify(player, Mockito.times(2)).increaseNumberOfBombs();

        // Testing third bomb
        arena.setFlames(new ArrayList<Flame>());
        bomb3.explode(arena);

        assertEquals(false, arena.getBombs().contains(bomb3));
        Mockito.verify(player, Mockito.times(1)).removeObserver(bomb3);
        assertEquals(10, arena.getFlames().size());
        correctPlacement.clear();
        correctPlacement.add(new Flame(8, 4));
        correctPlacement.add(new Flame(9, 4));
        correctPlacement.add(new Flame(10, 4));
        correctPlacement.add(new Flame(11, 4));
        correctPlacement.add(new Flame(12, 4));
        correctPlacement.add(new Flame(6, 4));
        correctPlacement.add(new Flame(7, 4));
        correctPlacement.add(new Flame(8, 5));
        correctPlacement.add(new Flame(8, 3));
        correctPlacement.add(new Flame(8, 2));
        for (Flame correct : correctPlacement) {
            boolean found = false;
            for (Flame temp : arena.getFlames()) {
                if (temp.getPosition().equals(correct.getPosition())) {
                    found = true;
                    break;
                }
            }
            assertEquals(true, found);
        }
        Mockito.verify(player, Mockito.times(3)).increaseNumberOfBombs();
    }

    @Test
    void pushBombTest() {
        Arena arena = Mockito.mock(Arena.class);
        Bomb bomb1 = new Bomb(3, 3, new BombInfo());

        Mockito.when(arena.isEmpty(bomb1.getPosition().getDown())).thenReturn(true);
        Mockito.when(arena.isEmpty(bomb1.getPosition().getUp())).thenReturn(true);
        Mockito.when(arena.isEmpty(bomb1.getPosition().getRight())).thenReturn(true);
        Mockito.when(arena.isEmpty(bomb1.getPosition().getLeft())).thenReturn(true);
        assertEquals(true, bomb1.push(arena, bomb1.getPosition().getUp()));
        assertEquals(true, bomb1.getPosition().equals(new Position(3, 4)));
        Mockito.when(arena.isEmpty(bomb1.getPosition().getDown())).thenReturn(true);
        Mockito.when(arena.isEmpty(bomb1.getPosition().getUp())).thenReturn(true);
        Mockito.when(arena.isEmpty(bomb1.getPosition().getRight())).thenReturn(true);
        Mockito.when(arena.isEmpty(bomb1.getPosition().getLeft())).thenReturn(true);
        assertEquals(true, bomb1.push(arena, bomb1.getPosition().getDown()));
        assertEquals(true, bomb1.getPosition().equals(new Position(3, 3)));
        Mockito.when(arena.isEmpty(bomb1.getPosition().getDown())).thenReturn(true);
        Mockito.when(arena.isEmpty(bomb1.getPosition().getUp())).thenReturn(true);
        Mockito.when(arena.isEmpty(bomb1.getPosition().getRight())).thenReturn(true);
        Mockito.when(arena.isEmpty(bomb1.getPosition().getLeft())).thenReturn(true);
        assertEquals(true,bomb1.push(arena, bomb1.getPosition().getLeft()));
        assertEquals(true, bomb1.getPosition().equals(new Position(4, 3)));
        Mockito.when(arena.isEmpty(bomb1.getPosition().getDown())).thenReturn(true);
        Mockito.when(arena.isEmpty(bomb1.getPosition().getUp())).thenReturn(true);
        Mockito.when(arena.isEmpty(bomb1.getPosition().getRight())).thenReturn(true);
        Mockito.when(arena.isEmpty(bomb1.getPosition().getLeft())).thenReturn(true);
        assertEquals(true, bomb1.push(arena, bomb1.getPosition().getRight()));
        assertEquals(true, bomb1.getPosition().equals(new Position(3, 3)));

        Mockito.when(arena.isEmpty(bomb1.getPosition().getDown())).thenReturn(false);
        Mockito.when(arena.isEmpty(bomb1.getPosition().getUp())).thenReturn(false);
        Mockito.when(arena.isEmpty(bomb1.getPosition().getRight())).thenReturn(false);
        Mockito.when(arena.isEmpty(bomb1.getPosition().getLeft())).thenReturn(false);
        assertEquals(false,bomb1.push(arena, bomb1.getPosition().getUp()));
        assertEquals(true, bomb1.getPosition().equals(new Position(3, 3)));
        Mockito.when(arena.isEmpty(bomb1.getPosition().getDown())).thenReturn(false);
        Mockito.when(arena.isEmpty(bomb1.getPosition().getUp())).thenReturn(false);
        Mockito.when(arena.isEmpty(bomb1.getPosition().getRight())).thenReturn(false);
        Mockito.when(arena.isEmpty(bomb1.getPosition().getLeft())).thenReturn(false);
        assertEquals(false,bomb1.push(arena, bomb1.getPosition().getDown()));
        assertEquals(true, bomb1.getPosition().equals(new Position(3, 3)));
        Mockito.when(arena.isEmpty(bomb1.getPosition().getDown())).thenReturn(false);
        Mockito.when(arena.isEmpty(bomb1.getPosition().getUp())).thenReturn(false);
        Mockito.when(arena.isEmpty(bomb1.getPosition().getRight())).thenReturn(false);
        Mockito.when(arena.isEmpty(bomb1.getPosition().getLeft())).thenReturn(false);
        assertEquals(false,bomb1.push(arena, bomb1.getPosition().getLeft()));
        assertEquals(true, bomb1.getPosition().equals(new Position(3, 3)));
        Mockito.when(arena.isEmpty(bomb1.getPosition().getDown())).thenReturn(false);
        Mockito.when(arena.isEmpty(bomb1.getPosition().getUp())).thenReturn(false);
        Mockito.when(arena.isEmpty(bomb1.getPosition().getRight())).thenReturn(false);
        Mockito.when(arena.isEmpty(bomb1.getPosition().getLeft())).thenReturn(false);
        assertEquals(false,bomb1.push(arena, bomb1.getPosition().getRight()));
        assertEquals(true, bomb1.getPosition().equals(new Position(3, 3)));

        Mockito.when(arena.isEmpty(bomb1.getPosition().getDown())).thenReturn(true);
        Mockito.when(arena.isEmpty(bomb1.getPosition().getUp())).thenReturn(true);
        Mockito.when(arena.isEmpty(bomb1.getPosition().getRight())).thenReturn(true);
        Mockito.when(arena.isEmpty(bomb1.getPosition().getLeft())).thenReturn(true);
        assertEquals(false,bomb1.push(arena, bomb1.getPosition()));
        assertEquals(true, bomb1.getPosition().equals(new Position(3, 3)));
    }
}
