import java.io*;
import java.util*;

public class Bronze {



  public static void stomp(int[][] grid, int R, int C, int D) {


    // Max value
    int max =
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
    // Stomp will have a for loop that will be a counter until N
    int counter = 0;
    while (counter < numberOfStomps) {
      
    }

    // Calculates total aggregated depth
    for (int[] array : board) {
      for (int number : array) {
        sum += number;
      }
    }

    return (sum * 72 * 72);



  }
}
