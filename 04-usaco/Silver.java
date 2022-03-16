import java.io.*;
import java.util.*;
public class Silver {

  public static void copyArray(int[][] grid, int [][] grid2) {
    int rlen = grid.length;
    int clen = grid[0].length;
    for (int i = 0; i < rlen; i++) {
      for (int j = 0; j < clen; j++) {
        grid2[i][j] = grid[i][j];
      }
    }
  }

  private static boolean bounds(int[][] grid, int a, int b) {
    return ((0 <= a && a <= grid.length-1) && (0 <= b && b <= grid[a].length-1));
  }
  public static long calcWays(int[][] grid, int[][] gridCopy, int r1, int c1, int r2, int c2, int time) {
    int rlen = grid.length;
    int clen = grid[0].length;
    int[][] DIRECTIONS = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    grid[r1][c1] = 1;
    for (int z = 0; z < time; z++) {
      for (int i = 0; i < rlen; i++) {
        for (int j = 0; j < clen; j++) {
          if (grid[i][j] != -1) {
            int steps = 0;
            for (int[]dir : DIRECTIONS) {
              if ((bounds(grid, i+dir[0], j+dir[1])) && grid[i+dir[0]][j+dir[1]] != -1) {
                steps += grid[i+dir[0]][j+dir[1]];
              }
            }
            gridCopy[i][j] = steps;
          }
        }
      }
      copyArray(gridCopy, grid);
    }
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
          if (list[j] == '*') {
            board[i][j] = -1;
          } else {
            board[i][j] = 0;
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
      int[][] boardCopy = new int[row][col];
      copyArray(board, boardCopy);

      return calcWays(board, boardCopy, r1, c1, r2, c2, time);

    } catch (FileNotFoundException e) {
      System.out.println("ERROR: File not Found!");
      return -1;
    }
  }

  // public static void main(String[] args) {
  //   System.out.println(solve("ctravel.2.in"));
  // }

}
