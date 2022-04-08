import java.util.*;
public class BurnTrees{
  private int[][]map;
  private int ticks;
  private Queue<int[]> frontier;
  private static final int TREE = 2;
  private static final int FIRE = 1;
  private static final int ASH = 3;
  private static final int SPACE = 0;


  /*Determine if the simulation is still burning
   *@return false if any fires are still burning, true otherwise
   */
  public boolean done(){
    //YOU MUST IMPLEMENT THIS METHOD
    //(BEFORE WRITING ANY CODE READ ALL OF THE CODE AND SEE HOW IT FITS TOGETHER)
    //HINT: do not check the board for fire which is an n^2 operation
    if (frontier.size() < 1) {
      return true;
    }
    return false;//placeholder for compilation purposes
  }

  private static boolean bounds(int[][] grid, int a, int b) {
    return ((0 <= a && a <= grid.length-1) && (0 <= b && b <= grid[a].length-1));
  }

  /*This is the core of the simulation. All of the logic for advancing to the next round goes here.
   *All existing fires spread new fires, and turn to ash
   *new fires should remain fire, and not spread.
   */
  public void tick(){
    ticks++;//leave this here.
    //YOU MUST IMPLEMENT THE REST OF THIS METHOD
    //(BEFORE WRITING ANY CODE READ ALL OF THE CODE AND SEE HOW IT FITS TOGETHER)
    int[][] DIRECTIONS = {{1,0}, {0,1}, {-1,0}, {0,-1}};
    int size = frontier.size();
    for (int i = 0; i < size; i++) {
      int[] fireCoords = frontier.remove();
      int a = fireCoords[0];
      int b = fireCoords[1];
      map[a][b] = ASH;
      for (int[]dir : DIRECTIONS) {
        if ((bounds(map, a+dir[0], b+dir[1])) &&  map[a+dir[0]][b+dir[1]] != -1) {
          if (map[a+dir[0]][b+dir[1]] == TREE) {
            int[] second = {a+dir[0], b+dir[1]};
            map[a+dir[0]][b+dir[1]] = FIRE;
            frontier.add(second);
          }
        }
      }
    }
  }

  /***********************YOU MIGHT UPDATE THIS**************************/

  /*Initialize the simulation.
   *If you add more instance variables you can add more here,
   *otherwise it is complete
   */
  public BurnTrees(int width,int height, double density){
    map = new int[height][width];
    for(int r=0; r<map.length; r++ ){
      for(int c=0; c<map[r].length; c++ ){
        if(Math.random() < density){
           map[r][c]=TREE;
         }
       }
     }
     frontier = new ArrayDeque<int[]>();
     start();//set the left column on fire.
  }


  /*
   *Sets the trees in the left column of the forest on fire
   */
  public void start(){
    //If you add more instance variables you can add more here,
    //otherwise it is complete.
    for(int i = 0; i < map.length; i++){
      if(map[i][0]==TREE){
        map[i][0]=FIRE;
        int[] coords = {i, 0};
        frontier.add(coords); // add the burning coords to the frontier
      }
    }
  }

  public static double averageOfNRuns(int n, int size, double density) {

    // Gets average of N runs for SIZE * SIZE array with DENSITY
    double sum = 0;
    for (int i = 0; i < n; i++) {
      BurnTrees test = new BurnTrees(size, size, density);
      sum += test.run();
    }
    return (sum / n);
  }


    public static void main(String[]args){
      int WIDTH = 20;
      int HEIGHT = 20;
      int DELAY = 200;
      double DENSITY = 0.7;
      if(args.length > 1){
        WIDTH = Integer.parseInt(args[0]);
        HEIGHT = Integer.parseInt(args[1]);
        DENSITY = Double.parseDouble(args[2]);
      }
      if(args.length > 3){
        DELAY = Integer.parseInt(args[3]);
      }
      BurnTrees b = new BurnTrees(WIDTH,HEIGHT,DENSITY);


      // int ans = b.animate(DELAY);//animate all screens
      // System.out.println(ans);//print the final answer

      // int ans = b.outputAll();//print all screens one after another
      // System.out.println(ans);//print the final answer

      // System.out.println(b.run()); // print the answer BUT Not the board

      // Prints the averages for 100 runs with density increments of 0.05



      System.out.println("\nBoard Size: 100x100 w/ 100 repetions");
      System.out.println("-------------------");
      System.out.println("| Density | Burn time  |");
      System.out.println("|-----------------|");
      for (double i = 0.05; i <= 1.000; i += 0.05) {
        double runs = averageOfNRuns(100, 100, i);
        System.out.println("| " + (int)(i*100) + "%"+ "   | " + runs + "   |");
        // System.out.println("Average for 100 runs, size 20x20, for density = " + i);

      }
      System.out.println("--------------------");
      // System.out.println(averageOfNRuns(100, WIDTH, DENSITY)); // print the average ticks of N runs, Board is NOT printed

      /** SECOND TABLE **/
      System.out.println("\n\nBoard Size: 100x100 w/ 100 repetions");
      System.out.println("-------------------");
      System.out.println("| Density | Burn time  |");
      System.out.println("|-----------------|");
      for (double i = 0.55; i <= 0.66; i += 0.01) {
        double runs = averageOfNRuns(100, 100, i);
        System.out.println("| " + (int)(i*100) + "%"+ "   | " + runs + "   |");
        // System.out.println("Average for 100 runs, size 20x20, for density = " + i);

      }
      System.out.println("--------------------");




      // System.out.println("\n\nBoard Size: 100x100 w/ 100 repetions");
      // System.out.println("-------------------");
      // System.out.println("| Density | Burn time  |");
      // System.out.println("|-----------------|");
      // for (double i = 0.00; i <= 1.000; i += 0.01) {
      //   double runs = averageOfNRuns(100, 25, i);
      //   System.out.println("| " + (int)(i*100) + "%"+ "   | " + runs + "   |");
      //   // System.out.println("Average for 100 runs, size 20x20, for density = " + i);
      //
      // }
      // System.out.println("--------------------");
    }







  /***********************DO NOT UPDATE THINGS BELOW HERE**************************/

  /*DO NOT UPDATE THIS
   *PLEASE READ SO YOU SEE HOW THE SIMULATION IS SUPPOSED TO WORK!!!
   */
  public int run(){
    while(!done()){
      tick();
    }
    return getTicks();
  }


  /*DO NOT UPDATE THIS*/
  public int getTicks(){
    return ticks;
  }

  /*DO NOT UPDATE THIS*/
  public String toString(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==SPACE)
          builder.append(" ");
        else if(map[i][c]==TREE)
          builder.append("@");
        else if(map[i][c]==FIRE)
          builder.append("w");
        else if(map[i][c]==ASH)
          builder.append(".");
      }
      builder.append("\n");
    }
    return builder.toString();
  }

  /*DO NOT UPDATE THIS*/
  public String toStringColor(){
    StringBuilder builder = new StringBuilder();
    for (int i = 0; i < map.length; i++) {
      for (int c = 0; c < map[i].length; c++) {
        if(map[i][c]==0)
          builder.append(" ");
        else if(map[i][c]==2)
          builder.append(Text.color(Text.GREEN)+"@");
        else if(map[i][c]==1)
          builder.append(Text.color(Text.RED)+"w");
        else if(map[i][c]==3)
          builder.append(Text.color(Text.DARK)+".");
      }
      builder.append("\n"+Text.RESET);
    }
    return builder.toString()+ticks+"\n";
  }

  /*DO NOT UPDATE THIS*/
  public int animate(int delay) {
    System.out.print(Text.CLEAR_SCREEN);
    System.out.println(Text.go(1,1)+toStringColor());
    Text.wait(delay);
    while(!done()){
      tick();
      System.out.println(Text.go(1,1)+toStringColor());
      Text.wait(delay);
    }
    return getTicks();
  }

  /*DO NOT UPDATE THIS*/
  public int outputAll(){
    System.out.println(toString());
    while(!done()){
      tick();
      System.out.println(toString());
    }
    return getTicks();
  }


}
