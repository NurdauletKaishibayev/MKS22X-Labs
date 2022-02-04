public class Recursion {
  /*Print all words that are made of the letters a-e inclusive.
  *@param length : the length of the words that are to be printed
  */
  public static void printAllWords(int length){
    printAllWords(length,"");
  }

  /*Print all words that are made of the letters a-e inclusive.
  *@param length : either how many more letters or the total length depending on implementation
  *@param word   : the partial word so far.
  */
  public static void printAllWords(int length,String word){
    if (length == 0) {
      System.out.println(word);
    } else {
      for (char c = 'a'; c <= 'e'; c++) {
        printAllWords(length - 1, word + c);
      }
    }
  }

  /*Print all words that are made of the characters in the array of letters.
  *There may not be consecutive equal letters, so:
  *aax is not allowed, but axa is allowed.
  *@param length : the length of the words that are to be printed
  *@param letters: the letters you should be using,
  *@precondition: letters contains at least 2 characters, and has no duplicates.
  */
  public static void printNoDoubleLetterWords(int length,char[] letters){
    printNoDoubleLetterWords(length,"",letters);
  }

  /*Print all words that are made of the characters in letters. There may not be consecutive equal letters,
  *aax is not allowed, but axa is allowed.
  *@param length : either how many more letters need to be
  *@param word   : the partial word so far.
  *@param letters: the letters you should be using
  */
  public static void printNoDoubleLetterWords(int length,String word,char[]letters){
    if (length == 0) {
      System.out.println(word);
    } else {
      int size = letters.length;
      for (char c = 0; c < size; c++) {
        if (word.length() == 0) {
          printNoDoubleLetterWords(length-1, word + letters[c], letters);
        } else if (word.charAt(word.length()-1) != letters[c]) {
          printNoDoubleLetterWords(length-1, word + letters[c], letters);
        }
      }
    }
  }

  /*
  *@param s any string
  *@return a string that is the reversed version of s, do NOT use built in methods to do so, use recursion.
  */
  public static String reverse(String s){
    if (s.length() == 0) {
      return s;
    } else {
      return reverse(s.substring(1)) + s.charAt(0);
    }
  }


  /*
  *@param n any non-negative value you want to take the sqrt of
  *@return the approximate sqrt of n within a tolerance of 0.001%
  */
  public static double sqrt(double n){
    return sqrt(n, (long)1);
  }

  public static double sqrt(double n, double guess) {
    if (n == 0) {
      return 0;
    }
    if (((Math.abs(n - Math.pow(guess, 2)) / n)) <= 0.00001) {
      return guess;
    } else {
      return sqrt(n, ((n/guess + guess)/2));
    }
  }



  public static void main(String[] args) {
    //printAllWords(2);
    //char[] chars = {'a', 'b', 'z'};
    //printNoDoubleLetterWords(3, chars);
    // System.out.println(reverse("hello"));
    // System.out.println(reverse("YeY"));
    // System.out.println(reverse("BYE"));
    // System.out.println(reverse("racecar"));
    System.out.println(sqrt(100));
    System.out.println(sqrt(0));
    System.out.println(sqrt(1));
    System.out.println(sqrt(10000));
    System.out.println(sqrt(49));
    System.out.println(sqrt(2));
    System.out.println(sqrt(6));
  }
}
