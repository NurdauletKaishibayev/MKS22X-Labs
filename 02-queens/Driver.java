public class Driver {

  public static void main(String[] args) {
   // System.out.println(Text.CLEAR_SCREEN);
   // System.out.println(Text.HIDE_CURSOR);
   // System.out.println(Text.go(1,1));
   QueenBoard board = new QueenBoard(8);
   QueenBoard board1 = new QueenBoard(8);
   QueenBoard board2 = new QueenBoard(7);
   QueenBoard board3 = new QueenBoard(6);
   QueenBoard board4 = new QueenBoard(5);
   QueenBoard board5 = new QueenBoard(4);
   QueenBoard board6 = new QueenBoard(3);
   QueenBoard board7 = new QueenBoard(2);
   QueenBoard board8 = new QueenBoard(1);

   System.out.println(board);
   board.solve();
   System.out.println(board);
   System.out.println(board1.countSolutions());
   System.out.println(board2.countSolutions());
   System.out.println(board3.countSolutions());
   System.out.println(board4.countSolutions());
   System.out.println(board5.countSolutions());
   System.out.println(board6.countSolutions());
   System.out.println(board7.countSolutions());
   System.out.println(board8.countSolutions());

   // System.out.println(Text.RESET);
  }
}
