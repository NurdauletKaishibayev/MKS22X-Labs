public class MazeGenerator {


  public static boolean safe(char[][] maze, int startrow, int startcol) {
    int counter = 0;
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
    if (counter < 2) {
      return true;
    }
    return false;
  }


  public static void generate(char[][]maze,int startrow,int startcol) {
    int rowLen = maze.length;
    int colLen = maze[0].length;
    int counter = 0;

    maze[startrow][startcol] = ' ';
    int x = (int)(Math.random() * (3) + 0)-1;
    int y = (int)(Math.random() * (3) + 0)-1;

    if ((startrow + x > 0 && startrow + x < rowLen-1) && (startcol + y > 0 && startcol + y < colLen-1)) {
      if (safe(maze, startrow+x, startcol+y)) {
        generate(maze, startrow + x, startcol + y);
      }
    }
  }

}
