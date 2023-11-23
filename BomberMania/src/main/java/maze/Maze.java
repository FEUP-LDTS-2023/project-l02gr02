package maze;

/*
    Maze generation source code from
    https://github.com/oppenheimj/maze-generator/tree/master
*/

public class Maze {
    public Maze(int dim){
        MazeGenerator maze = new MazeGenerator(dim);
        maze.generateMaze();
        System.out.println(maze.getSymbolicMaze());
    }
}