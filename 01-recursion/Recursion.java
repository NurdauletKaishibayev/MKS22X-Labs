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

  /*
  *@param length how long the words must be
  *param word the variable to store the partial solution (should start at "")
  *@return the number of words that have no adjacent matching letters using the letters a-z.
  *Repetition allowed except when letters are adjacent.
  */
  public static long countNoDoubleLetterWords(int length,String word){
    if (word.length() == length) {
      return 1l;
    } else {
      long counter = 0l;
      for (char c = 'a'; c <= 'z'; c++) {
        if (word.length() == 0) {
          counter += countNoDoubleLetterWords(length, word + c);
        } else if (word.charAt(word.length()-1) != c) {
          counter += countNoDoubleLetterWords(length, word + c);
        }
      }
      return counter;
    }
  }

  /*
  *@param n any non-negative value
  *@return the nth term of the fibonacci sequence. 0, 1, 1, 2, 3, 5 etc.
  */
  public static int fibIter(int n, int f1, int f2){
    if (n == 0) {
      return f2;
    }
    if (n == 1) {
      return f1;
    }
    return fibIter(n-1, f2 + f1, f1);
  }





  public static void main(String[] args) {
    // printAllWords(2);
    // char[] chars = {'a', 'b', 'z'};
    // printNoDoubleLetterWords(3, chars);
    // System.out.println(reverse("hello"));
    // System.out.println(reverse("YeY"));
    // System.out.println(reverse("BYE"));
    // System.out.println(reverse("racecar"));
    // System.out.println(sqrt(100));
    // System.out.println(sqrt(0));
    // System.out.println(sqrt(1));
    // System.out.println(sqrt(10000));
    // System.out.println(sqrt(49));
    // System.out.println(sqrt(2));
    // System.out.println(sqrt(6));
    // System.out.println(countNoDoubleLetterWords(1,""));
    // System.out.println(countNoDoubleLetterWords(2,""));
    // System.out.println(countNoDoubleLetterWords(3,""));
    // System.out.println(countNoDoubleLetterWords(4,""));
    // System.out.println(fibIter(0,1,0));
    // System.out.println(fibIter(1,1,0));
    // System.out.println(fibIter(2,1,0));
    // System.out.println(fibIter(3,1,0));
    // System.out.println(fibIter(4,1,0));
    // System.out.println(fibIter(5,1,0));
    // System.out.println(fibIter(6,1,0));
  }
}
