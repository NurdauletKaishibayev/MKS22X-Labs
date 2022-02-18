import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
public class Maze {

  public static char[][] readMaze(String filename) throws FileNotFoundException {
    File text = new File(filename);
    Scanner input = new Scanner(text);
    ArrayList<String> temp = new ArrayList<String>();
    while (input.hasNextLine()) {
      String line = input.nextLine();
      temp.add(line);
    }
    int rows = temp.size();
    int cols = (temp.get(0)).length();
    char[][] maze = new char[rows][cols];
    for (int i = 0; i < rows; i++) {
      maze[i] = (temp.get(i)).toCharArray();
    }
    input.close();
    return maze;
  }

  public static String printMaze(char[][] maze) {
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

  public static void main(String args[]){
    try{
      System.out.println(printMaze(readMaze("Maze1.txt")));
    }catch(FileNotFoundException e){
      System.out.println(e);
      System.out.println("Error! No file found");
      System.exit(1);
    }
  }
}
