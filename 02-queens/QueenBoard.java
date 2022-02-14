public class QueenBoard {
  private int[][] board;

  public QueenBoard(int size){
    board = new int[size][size];
    for (int i = 0; i < size; i++) {
      for (int j = 0; j < size; j++) {
        board[i][j] = 0;
      }
    }
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
           // output += "Q" + " ";
           output += "-1" + " ";   // Used for testing
         } else {
           output += board[i][j] + " ";  // Used for testing
           // output += "_" + " ";
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
       for (int i = r + 1; i < size; i++) {
         board[i][c] += 1;
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
     for (int i = r + 1; i < size; i++) {
       board[i][c] += -1;
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
   // public boolean solve(){
   //
   // }

   /**Find all possible solutions to this size board.
   *@return the number of solutions found, and leaves the board filled with only 0's
   *@throws IllegalStateException when the board starts with any non-zero value (e.g. you ran solve() before this method)
   */
   // public int countSolutions(){
   //
   // }
   public static void main(String[] args) {
     QueenBoard board = new QueenBoard(8);
     System.out.println(board);
     board.placeQueen(2,2,-1);
     System.out.println(board.placeQueen(2,2,-1));
     System.out.println(board);
     board.placeQueen(2,2,1);
     System.out.println(board);
     board.placeQueen(2,2,-1);
     System.out.println(board);
     board.placeQueen(4,3,-1);
     System.out.println(board);
     board.placeQueen(5,7,-1);
     System.out.println(board);
     System.out.println(board.placeQueen(6,6,-1));
     // board.placeQueen(5,7,1);
     // board.placeQueen(4,3,1);
     // System.out.println(board);

   }

}
