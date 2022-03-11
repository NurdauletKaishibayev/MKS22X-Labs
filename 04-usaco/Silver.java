import java.io.*
import java.util.*
public class Silver {

  public static long solve(String filename) throws FileNotFoundException {
    File file = new File(filename);
    Scanner input = new Scanner(file);
    int row = input.nextInt();
    int col = input.nextInt();
    int time = input.nextInt();
    int[][]board = new int[row][col];


    // Makes a board that converts periods and stars into -1 and 0;
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (input.nextChar() = '.') {
          board[i][j] = 0;
        } else {
          board[i][j] = -1;
        }
      }
    }
  }

}
