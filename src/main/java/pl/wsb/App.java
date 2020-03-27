package pl.wsb;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    // up right down left
    private static int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public static char[][] mazeboard = new char[9][8];
    public final static int boardMaxX = mazeboard.length-1;
    public final static int boardMaxY = mazeboard[0].length-1;
    private boolean[][] isVisitedBoard = new boolean[9][8];
    private Coordinate start;
    private Coordinate end = new Coordinate(8,6);;
    public App(){
        drawMaze();
    }
    private char[][] drawMaze(){
         for(char[] row : mazeboard){
             Arrays.fill(row, '#');
         }
         // the correct way
         mazeboard[0][0] = 's';mazeboard[1][0] =' ';mazeboard[2][0] =' ';mazeboard[3][0] =' ';mazeboard[3][1] =' ';mazeboard[4][1] =' ';mazeboard[4][2] =' ';mazeboard[5][2] =' ';
        mazeboard[5][3] =' ';mazeboard[5][4] =' ';mazeboard[5][5] =' ';mazeboard[5][6] =' ';mazeboard[6][6] =' ';mazeboard[7][6] =' ';mazeboard[8][6] ='w';
        // dead end
        mazeboard[1][1] =' ';mazeboard[1][2] =' ';mazeboard[1][3] =' ';mazeboard[1][4] =' ';mazeboard[1][5] =' ';
        // another dead end
        mazeboard[2][3] =' ';mazeboard[3][3] =' ';mazeboard[3][4] =' ';mazeboard[3][5] =' ';mazeboard[3][6] =' ';mazeboard[3][7] =' ';mazeboard[4][7] =' ';
        // last dead end
        mazeboard[6][2] =' ';mazeboard[7][2] =' ';mazeboard[8][2] =' ';mazeboard[8][1] =' ';
        return mazeboard;
     }
    public Coordinate getStart(){
        start = new Coordinate(0,0);
        return start;
    }
  /* public Coordinate getEnd(){
        end = new Coordinate(8,6);
        return end;
    }*/
    public boolean isExit(int x, int y) {
        return x == end.getX() && y == end.getY();
    }

    public boolean isStart(int x, int y) {
        return x == start.getX() && y == start.getY();
    }

    public boolean isExplored(int row, int col) {
        return isVisitedBoard[row][col];
    }

    public boolean isWall(int row, int col) {
        return mazeboard[row][col] == '#';
    }

    public void setVisited(int row, int col, boolean value) {
        isVisitedBoard[row][col] = value;
    }

    public boolean isValidLocation(int row, int col) {
        if (row < 0 || row >= boardMaxY || col < 0 || col >= boardMaxY) {
            return false;
        }
        return true;
    }

}
