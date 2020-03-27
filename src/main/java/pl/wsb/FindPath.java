package pl.wsb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindPath {
    private static final int[][] DIRECTIONS = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public List<Coordinate> solve(App maze) {
        List<Coordinate> path = new ArrayList<>();
        if (explore(maze, maze.getStart().getX(), maze.getStart().getY(), path)) {
            return path;
        }
        return Collections.emptyList();
    }

    private boolean explore(App maze, int row, int col, List<Coordinate> path) {
        if (!maze.isValidLocation(row, col) || maze.isWall(row, col) || maze.isExplored(row, col)) {
            return false;
        }

        path.add(new Coordinate(row, col));
        maze.setVisited(row, col, true);

        if (maze.isExit(row, col)) {
            return true;
        }

        for (int[] direction : DIRECTIONS) {
            Coordinate coordinate = nextCoordinate(row, col, direction[0], direction[1]);
            if (explore(maze, coordinate.getX(), coordinate.getY(), path)) {
                return true;
            }
        }

        path.remove(path.size() - 1);
        return false;
    }

    private Coordinate nextCoordinate(int row, int col, int i, int j) {
        return new Coordinate(row + i, col + j);
    }
}


