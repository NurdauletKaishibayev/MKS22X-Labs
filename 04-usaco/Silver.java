import java.io.*;
import java.util.*;
public class Silver {

  public static long solve(String filename) {
    try{
      File file = new File(filename);
      Scanner input = new Scanner(file);
      int row = input.nextInt();
      int col = input.nextInt();
      int time = input.nextInt();
      int[][]board = new int[row][col];
      String line;

      input.nextLine();

      // Makes a board that converts dots and stars into -1 and 0;
      for (int i = 0; i < row; i++) {
        line = input.nextLine();
        char[] list = line.toCharArray();
        for (int j = 0; j < col; j++) {
          if (list[j] == '.') {
            board[i][j] = 0;
          } else {
            board[i][j] = -1;
          }
        }
      }

      String out = "";
      for (int i = 0; i < row; i++) {
        for (int j = 0; j < col; j++) {
          out += board[i][j] + " ";
        }
        out += "\n";
      }
      System.out.println(out);



    } catch (FileNotFoundException e) {
      System.out.println("ERROR: File not Found!");
      return -1;
    }

    return 1;
  }

  public static void main(String[] args) {
    System.out.println(solve("ctravel.1.in"));
  }

}
