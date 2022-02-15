public class Driver {

  public static void main(String[] args) {
   // System.out.println(Text.CLEAR_SCREEN);
   // System.out.println(Text.HIDE_CURSOR);
   // System.out.println(Text.go(1,1));
   QueenBoard board = new QueenBoard(8);
   System.out.println(board);
   board.solve();
   System.out.println(board);
   // System.out.println(Text.RESET);
  }
}
