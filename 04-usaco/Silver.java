import java.io.*;
import java.util.*;
public class Silver {


  public static long calcWays(int[][] grid, int[][] gridCopy, int r1, int c1, int r2, int c2, int time) {
    int rlen = grid.length;
    int clen = grid[0].length;
    int sum = 0;
    grid[r1][c1] = 1;
    for (int z = 0; z < time; z++) {
      for (int i = 0; i < rlen; i++) {
        for (int j = 0; j < clen; j++) {

          // Top Row
          if (i == 0 ) {

            // Top left corner
            if (j == 0) {
              sum = 0;
              if (gridCopy[i+1][j] != -1) {
                sum += gridCopy[i+1][j];
              }
              if (gridCopy[i][j+1] != -1) {
                sum += gridCopy[i][j+1];
              }
              grid[i][j] = sum;

              // Top right corner
            } else if (j == clen-1) {
              sum = 0;
              if (gridCopy[i+1][j] != -1) {
                sum += gridCopy[i+1][j];
              }
              if (gridCopy[i][j-1] != -1) {
                sum += gridCopy[i][j-1];
              }
              grid[i][j] = sum;

              // Top row (excl. left right corner)
            } else {
              sum = 0;
              if (gridCopy[i+1][j] != -1) {
                sum += gridCopy[i+1][j];
              }
              if (gridCopy[i][j+1] != -1) {
                sum += gridCopy[i][j+1];
              }
              if (gridCopy[i][j-1] != -1) {
                sum += gridCopy[i][j-1];
              }
              grid[i][j] = sum;
            }


          // Bottom Row
          } else if (i == rlen-1) {
            // Bottom left corner
            if (j == 0) {
              sum = 0;
              if (gridCopy[i-1][j] != -1) {
                sum += gridCopy[i-1][j];
              }
              if (gridCopy[i][j+1] != -1) {
                sum += gridCopy[i][j+1];
              }
              grid[i][j] = sum;

              // Bottom right corner
            } else if (j == clen-1) {
              sum = 0;
              if (gridCopy[i-1][j] != -1) {
                sum += gridCopy[i-1][j];
              }
              if (gridCopy[i][j-1] != -1) {
                sum += gridCopy[i][j-1];
              }
              grid[i][j] = sum;

              // Bottom row (excl. left right corner)
            } else {
              sum = 0;
              if (gridCopy[i-1][j] != -1) {
                sum += gridCopy[i-1][j];
              }
              if (gridCopy[i][j+1] != -1) {
                sum += gridCopy[i][j+1];
              }
              if (gridCopy[i][j-1] != -1) {
                sum += gridCopy[i][j-1];
              }
              grid[i][j] = sum;
            }
          }

          // LEFT COL
          else if (j == 0) {
            sum = 0;
            if (gridCopy[i-1][j] != -1) {
              sum += gridCopy[i-1][j];
            }
            if (gridCopy[i+1][j] != -1) {
              sum += gridCopy[i+1][j];
            }
            if (gridCopy[i][j+1] != -1) {
              sum += gridCopy[i][j+1];
            }
            grid[i][j] = sum;
          }

          // Right COL
          else if (j == clen-1) {
            sum = 0;
            if (gridCopy[i-1][j] != -1) {
              sum += gridCopy[i-1][j];
            }
            if (gridCopy[i+1][j] != -1) {
              sum += gridCopy[i+1][j];
            }
            if (gridCopy[i][j-1] != -1) {
              sum += gridCopy[i][j-1];
            }
            grid[i][j] = sum;
          }
          else {
            sum = 0;
            if (gridCopy[i-1][j] != -1) {
              sum += gridCopy[i-1][j];
            }
            if (gridCopy[i+1][j] != -1) {
              sum += gridCopy[i+1][j];
            }
            if (gridCopy[i][j-1] != -1) {
              sum += gridCopy[i][j-1];
            }
            if (gridCopy[i][j+1] != -1) {
              sum += gridCopy[i][j+1];
            }
            grid[i][j] = sum;
          }
        }
      }
      // String out = "";
      // for (int i = 0; i < rlen; i++) {
      //   for (int j = 0; j < clen; j++) {
      //     out += grid[i][j] + " ";
      //   }
      //   out += "\n";
      // }
      gridCopy = grid.clone();
    }


    // String out2 = "";
    // for (int i = 0; i < rlen; i++) {
    //   for (int j = 0; j < clen; j++) {
    //     out2 += gridCopy[i][j] + " ";
    //   }
    //   out2 += "\n";
    // }
    // System.out.println(out2);

    return (long)grid[r2][c2];
  }

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
      int r1 = input.nextInt()-1;
      int c1 = input.nextInt()-1;
      int r2 = input.nextInt()-1;
      int c2 = input.nextInt()-1;


      // String out = "";
      // for (int i = 0; i < row; i++) {
      //   for (int j = 0; j < col; j++) {
      //     out += board[i][j] + " ";
      //   }
      //   out += "\n";
      // }
      // System.out.println(out);
      int[][] boardCopy = board.clone();


      return calcWays(board, boardCopy, r1, c1, r2, c2, time);

    } catch (FileNotFoundException e) {
      System.out.println("ERROR: File not Found!");
      return -1;
    }
  }

  public static void main(String[] args) {
    System.out.println(solve("ctravel.1.in"));
  }

}
