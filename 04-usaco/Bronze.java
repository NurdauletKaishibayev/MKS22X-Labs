import java.io.*;
import java.util.*;

public class Bronze {

  public static void stomp(int[][] stomped, int R, int C, int D) {
    int[] maxVal =  new int[2];
    int max = stomped[R][C];
    int decremented;

    // Gets coordinates of the maximum
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (stomped[R+i][C+j] >= max) {
          max = stomped[R+i][C+j];
          maxVal[0] = R+i;
          maxVal[1] = C+j;
        }
      }
    }

    decremented = stomped[maxVal[0]][maxVal[1]] - D;



    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (stomped[R+i][C+j] > decremented) {
          stomped[R+i][C+j] = decremented;
        }
      }
    }
  }


  public static long solve(String filename) throws FileNotFoundException {
    File file = new File(filename);
    Scanner input = new Scanner(file);
    int row = input.nextInt();
    int col = input.nextInt();
    int[][]board = new int[row][col];
    int elevation = input.nextInt();
    int numberOfStomps = input.nextInt();
    int sum = 0;

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        board[i][j] = input.nextInt();
      }
    }
    // String out = "";
    // for (int i = 0; i < row; i++) {
    //   for (int j = 0; j < col; j++) {
    //     out += board[i][j] + " ";
    //   }
    //   out += "\n";
    // }
    // System.out.println(out);

    // Stomp will have a for loop that will be a counter until N
    int counter = 0;
    while (counter < numberOfStomps) {
      stomp(board, input.nextInt()-1, input.nextInt()-1, input.nextInt());
      counter++;
    }
    // String out1 = "";
    // for (int i = 0; i < row; i++) {
    //   for (int j = 0; j < col; j++) {
    //     out1 += board[i][j] + " ";
    //   }
    //   out1 += "\n";
    // }
    // System.out.println(out1);
    // Calculates total aggregated depth

    for (int i = 0; i < row; i++) {
      for (int j = 0; j < col; j++) {
        if (elevation - board[i][j] < 0) {
          board[i][j] = 0;
        } else {
          board[i][j] = elevation - board[i][j];
        }
      }
    }

    for (int[] array : board) {
      for (int number : array) {
        sum += number;
      }
    }

    return (sum * 72 * 72);

  }

  // public static void main(String[] args) {
  //   try {
  //     System.out.println(solve("makelake.2.in"));
  //   } catch (FileNotFoundException e) {
  //       System.out.println("File not found");
  //     }
  //   }
  }
