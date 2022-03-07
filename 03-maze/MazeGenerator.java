import java.util.*;

public class MazeGenerator {

  public static boolean safe(char[][] maze, int startrow, int startcol) {
    int counter = 0;
    int rowLen = maze.length;
    int colLen = maze[0].length;

    if (startrow == rowLen-1 || startcol == 0 || startrow == 0 || startcol == colLen -1) {
      return false;
    }

    if (maze[startrow+1][startcol] == ' ') {
      counter++;
    }
    if (maze[startrow][startcol+1] == ' ') {
      counter++;
    }
    if (maze[startrow-1][startcol] == ' ') {
      counter++;
    }
    if (maze[startrow][startcol-1] == ' ') {
      counter++;
    }
    return (counter < 2);
  }

  // Wrapper method
  public static void generate(char[][]maze,int startrow,int startcol) {
    generate(maze, startrow, startcol, 1);
    int rowLen = maze.length;
    int colLen = maze[0].length;
    boolean placed = false;
    maze[startrow][startcol] = 'S';
    while (!placed) {
      int row = (int)(Math.random()*(rowLen));
      int col = (int)(Math.random()*(colLen));
      if (maze[row][col] == ' ') {
        placed = true;
        maze[row][col] = 'E';
      }
    }
  }

  public static void generate(char[][]maze, int startrow, int startcol, int regular) {
    if (safe(maze, startrow, startcol)) {
      maze[startrow][startcol] = ' ';
      ArrayList<int[]> coords = new ArrayList<int[]>();
      int[] up = {0, -1};
      int[] down = {0, 1};
      int[] left = {-1, 0};
      int[] right = {1,0};
      coords.add(up);
      coords.add(down);
      coords.add(left);
      coords.add(right);
      Collections.shuffle(coords);

      for (int i = 0; i < 4; i++) {
        int x = coords.get(i)[0];
        int y = coords.get(i)[1];
        generate(maze, startrow+x, startcol+y, 1);
      }
    }
  }

}
