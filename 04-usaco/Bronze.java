import java.io*;
import java.util*;

public class Bronze {



  public static void stomp(int[][] grid, int R, int C, int D) {
    int one = grid[R][C];
    int two = grid[R+1][C];
    int three = grid[R+2][C];
    int four = grid[R][C+1];
    int five = grid[R+1][C+1];
    int six = grid[R+2][C+2];
    int seven = grid[R][C+3];
    int eight = grid[R+1][C+3];
    int nine = grid[R+2][C+3];
    int[] stomped = {one, two, three, four, five, six, seven, eight, nine};


    // Max value
    int max = one;
    for (int i = 0; i < stomped.length; i++) {
      if (stomped[i] > max) {
        max = stomped[i];
      }
    }




  }


  public static long solve(String filename) throws FileNotFoundException {
    File file = new File(filename);
    Scanner input = new Scanner(file);
    int row = input.nextInt()
    int col = input.nextInt()
    int[][]board = new char[row][col];
    int elevation = input.nextInt();
    int numberOfStomps = input.nextInt();
    int sum = 0;

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        board[i][j] = input.nextInt();
      }
    }

    // Calculates total aggregated depth
    for (int[] array : board) {
      for (int number : array) {
        sum += number;
      }
    }
    // Stomp will have a for loop that will be a counter until N
  }
}
