import java.util.*;

public class MazeGenerator {

  public static boolean safe(char[][] maze, int startrow, int startcol) {
    int counter = 0;
    int rowLen = maze.length;
    int colLen = maze[0].length;

    if (startrow == rowLen-1 || startcol == 0 || startrow == 0 || startcol == colLen -1) {
      return false;
    }

    if ((startrow + 1 < rowLen-1) && maze[startrow+1][startcol] == ' ') {
      counter++;
    }
    if ((startcol + 1 < colLen-1) && maze[startrow][startcol+1] == ' ') {
      counter++;
    }
    if ((startrow - 1 > 0) && maze[startrow-1][startcol] == ' ') {
      counter++;
    }
    if ((startcol - 1 > 0) && maze[startrow][startcol-1] == ' ') {
      counter++;
    }
    return (counter < 2);
  }

  // Wrapper method
  public static void generate(char[][]maze,int startrow,int startcol) {
    generate(maze, startrow, startcol, 1);
    maze[startrow][startcol] = 'S';
  }

  public static void generate(char[][]maze, int startrow, int startcol, int regular) {
    int rowLen = maze.length;
    int colLen = maze[0].length;
    int counter = 0;

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
    int x = coords.get(0)[0];
    int y = coords.get(0)[1];
    System.out.println(coords.get(0)[0]);
    System.out.println(coords.get(0)[1]);
    System.out.println(coords.get(1)[0]);
    System.out.println(coords.get(1)[1]);
    System.out.println(coords.get(2)[0]);
    System.out.println(coords.get(2)[1]);
    System.out.println(coords.get(3)[0]);
    System.out.println(coords.get(3)[1]);

    if (safe(maze, startrow+x, startcol+y)) {
      maze[startrow][startcol] = ' ';
      generate(maze, startrow+x, startcol+y, 1);
    }
  }

}
