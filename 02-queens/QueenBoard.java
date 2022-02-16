public class QueenBoard {
  private int[][] board;
  private boolean animated = false;
  private int delay = 1000;

  public QueenBoard(int size){
    board = new int[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        board[i][j] = 0;
      }
    }
  }

  public void setAnimate(boolean newValue) {
    animated = newValue;
  }

  public void setDelay(int newValue) {
    delay = newValue;
  }
   /**
   *@return The output string formatted as follows:
   *All numbers that represent queens are replaced with 'Q'
   *all others are displayed as underscores '_'
   *There are spaces between each symbol:
   *_ _ Q _
   *Q _ _ _
   *_ _ _ Q
   *_ Q _ _
   *excludes the characters up to the comment(*)
   */
   public String toString(){
     int size = board.length;
     String output = "";
     for (int i = 0; i < size; i++) {
       for (int j = 0; j < size; j++) {
         if (board[i][j] == -1) {
           output += "Q" + " ";
           // output += "-1" + " ";   // Used for testing
         } else {
           // output += board[i][j] + " ";  // Used for testing
           output += "_" + " ";
         }
       }
       output += "\n";
     }
     return output;
    }

   /**
   *@return true when the queen added correctly, false Otherwise
   *@precondition r and c are valid indices of the board array
   *@postcondition the board is only changed when the function returns true
   * in which case the queen is added and all it's threatened positions are incremented
   */
   private boolean addQueen(int r, int c){
     int size = board.length;
     if (board[r][c] == 0) {
       board[r][c] = -1;

       // Add 1 downward
       for (int i = 1; i < size; i++) {
         if (r+i < size) {
           board[r+i][c] += 1;
         }
       }

       // Add 1 Left horizontal
       for (int i = 1; i < size; i++) {
         if (c-i >= 0 && r+i < size) {
           board[r+i][c-i] += 1;
         }
       }

       // Add 1 Right horizontal
       for (int i = 1; i < size; i++) {
         if (c+i < size && r+i < size) {
           board[r+i][c+i] += 1;
         }
       }

       return true;
     } else {
       return false;
     }
   }

   /**Remove the queen that was added to r,c
   *@precondition r and c are valid indices of the board array and there is a queen at position r,c
   *@postcondition the board is modified to remove that queen and all it's
   *threatened positions are decremented
   */
   private void removeQueen(int r, int c){
     int size = board.length;
     board[r][c] = 0;

     // Add 1 downward
     for (int i = 1; i < size; i++) {
      if (r+i < size) {
        board[r+i][c] += -1;
      }
     }

     // Add 1 Left horizontal
     for (int i = 1; i < size; i++) {
       if (c-i >= 0 && r+i < size) {
         board[r+i][c-i] += -1;
       }
     }

     // Add 1 Right horizontal
     for (int i = 1; i < size; i++) {
       if (c+i < size && r+i < size) {
         board[r+i][c+i] += -1;
       }
     }
   }

   // General function that combines Add and Remove queen methods
   // -1  =  ADD Queen
   //  1  =  REMOVE Queen
   private boolean placeQueen(int r, int c, int mode) {
     if (mode == -1) {
       return addQueen(r, c);
     }

     else if (mode == 1) {
       removeQueen(r,c);
       return true;
     }

     else {
       throw new IllegalArgumentException("Error! Mode can only be -1 or 1");
     }
   }



   /**Find the first solution configuration possible for this size board. Start by placing
   *  the 1st queen in the top left corner, and each new queen in the next ROW. When backtracking
   *  move the previous queen to the next valid space. This means everyone will generate the same
   *  first solution.
   *@postcondition: the board remains in a solved state.
   *@return false when the board is not solveable and leaves the board filled with zeros;
   *        returns true when the board is solveable, and leaves the board in a solved state
   *@throws IllegalStateException when the board starts with any non-zero value (e.g. you solved a 2nd time.)
   */
   public boolean solve(){
     int size = board.length;
     for (int i = 0; i < size; i++) {
       for (int j = 0; j < size; j++) {
         if (board[i][j] != 0) {
           throw new IllegalStateException("The board must be empty!");
         }
       }
     }
     return solve(0);
   }

   public boolean solve(int row) {
     if (row == board.length) {
       return true;
     } else {
       for (int i = 0; i < board.length; i++) {
         if (placeQueen(row,i,-1)) {
           if(animated){
            System.out.println(Text.go(1,1));
            System.out.println(this);//can modify here
            Text.wait(delay);
           }
           if (solve(row+1)) {
             return true;
           } else {
             placeQueen(row,i,1);
             if(animated){
              System.out.println(Text.go(1,1));
              System.out.println(this);//can modify here
              Text.wait(delay);
             }
           }
         }
       }
       return false;
     }
   }


   /**Find all possible solutions to this size board.
   *@return the number of solutions found, and leaves the board filled with only 0's
   *@throws IllegalStateException when the board starts with any non-zero value (e.g. you ran solve() before this method)
   */
   // public int countSolutions(){
   //
   // }

   public static void main(String[] args) {
      int SIZE = 8;
      if(args.length > 0){
        SIZE = Integer.parseInt(args[0]);
      }
      QueenBoard b = new QueenBoard(SIZE);
      if(args.length > 1){
        b.setAnimate(true);
        b.setDelay(Integer.parseInt(args[1]));
      }
      System.out.println(Text.CLEAR_SCREEN);
      System.out.println(Text.HIDE_CURSOR);
      System.out.println(Text.go(1,1));
      b.solve();
      System.out.println(Text.RESET);
      System.out.println(Text.go(1,1));
      System.out.println(b);
   }

}
