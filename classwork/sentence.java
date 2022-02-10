public class sentence {
  public static void permute(String[][]lists, String sentence, int current){
    if (current == lists.length) {
      System.out.println(sentence);
    } else {
      int length = lists[current].length;
      for (int i = 0; i < length; i++) {
        permute(lists, sentence + lists[current][i] + " ", current + 1);
      }
    }
  }

  public static void main(String[] args) {
    String[][]wordlist = {
      {"The dog", "The pro skater"},
      {"plays" , "empathises with" },
      {"chess", "ball", "the voiceless masses"}
    };
    permute(wordlist,"",0);
  }
}
