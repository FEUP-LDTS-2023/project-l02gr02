import maze.*;

/*
    Maze generation source code from
    https://github.com/oppenheimj/maze-generator/tree/master
*/

public class Application {
    public static void main(String[] args) {
        MazeGenerator maze = new MazeGenerator(20);
        maze.generateMaze();
        System.out.println(maze.getSymbolicMaze());
    }
}