import java.util.*;
import java.io.*;
public class Maze{

  private char[][]maze;
  private boolean animate;//false by default
  private int startRow,startCol;


  /*Constructor loads a maze text file, and sets animate to false by default.
  When the file is not found then:
  throw a FileNotFoundException

  You may assume the file contains a rectangular ascii maze, made with the following 4 characters:
  '#' - Walls - locations that cannot be moved onto
  ' ' - Empty Space - locations that can be moved onto
  'E' - the location of the goal if any (0 or more per file)
  'S' - the location of the start(exactly 1 per file)

  You may also assume the maze has a border of '#' around the edges.
  So you don't have to check for out of bounds!
  Some text editors always include a newline at the end of a file, but that is not always present.
  Make sure your file reading is able to handle this.
  */
  public Maze(String filename) throws FileNotFoundException{
    animate = false;
    File text = new File(filename);
    Scanner input = new Scanner(text);
    ArrayList<String> temp = new ArrayList<String>();
    while (input.hasNextLine()) {
      String line = input.nextLine();
      temp.add(line);
    }
    int rows = temp.size();
    int cols = (temp.get(0)).length();
    maze = new char[rows][cols];
    for (int i = 0; i < rows; i++) {
      maze[i] = (temp.get(i)).toCharArray();
    }
    input.close();
  }

  private void wait(int millis){
    try {
      Thread.sleep(millis);
    }
    catch (InterruptedException e) {
    }
  }

  public void setAnimate(boolean b){
    animate = b;
  }

  public static void clearTerminal(){
    //erase terminal
    System.out.println("\033[2J");
  }
  public static void gotoTop(){
    //go to top left of screen
    System.out.println("\033[1;1H");
  }

  /*Return the string that represents the maze.
  It should look like the text file
  */
  public String toString(){
    int rows = maze.length;
    int cols = maze[0].length;
    String out = "";
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        out += maze[i][j];
      }
      out += "\n";
    }
    return out;
  }

  /*Wrapper Solve Function returns the helper function
  Note the helper function has the same name, but different parameters.
  Since the constructor exits when the file is not found or is missing an E or S, we can assume it exists.
  */
  public int solve(){
    //only clear the terminal if you are running animation
    if(animate){
      clearTerminal();
    }
    //start solving at the location of the s.
    return solve(startRow,startCol, 0);
  }

  /*
  Recursive Solve function:

  A solved maze has a path marked with '@' from S to E.

  Returns the number of @ symbols from S to E when the maze is solved,
  Returns -1 when the maze has no solution.

  Postcondition:
  The 'S' is replaced with '@'
  The 'E' remain the same
  All visited spots that were not part of the solution are changed to '.'
  All visited spots that are part of the solution are changed to '@'
  */
  private int solve(int row, int col, int out){ //you can add more parameters since this is private
    //automatic animation! You are welcome.
    if(animate){
      gotoTop();
      System.out.println(this);
      wait(50);
    }
    int rowLen = maze.length;
    int colLen = maze[0].length;

    // Position of S
    sFinder:
    for (int i = 0; i < rowLen; i++) {
      for (int j = 0; j < colLen; j++) {
        if (maze[i][j] == 'S') {
          row = i;
          col = j;
          break sFinder;
        }
      }
    }

    if (maze[row][col] == '#' || maze[row][col] == '.' || maze[row][col] == '@') {
      return -1;
    }

    if (maze[row][col] == 'E') {
      return out;
    }

    else {
      maze[row][col] = '@';
      for (int i = -1; i < 2; i++) {
        for (int j = -1; j < 2; j++) {
          if (Math.abs(i) != Math.abs(j)) {
            int var = solve(row + i, col + j, out + 1);
            if (var != -1) {
              return var;
            }
          }
        }
      }
      maze[row][col] = '.';
      if(animate){
        gotoTop();
        System.out.println(this);
        wait(50);
      }
      return -1;
    }
  }
}
