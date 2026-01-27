//recursion on the way up
public class Main {

  //Print all subsequences of a string

  public static void printSubSequence(String str, String asf) {
    if (str.isEmpty()) {
      System.out.println(asf);
      return;
    }

    String smallerString = str.substring(1);
    char firstChar = str.charAt(0);
    printSubSequence(smallerString, asf + firstChar); //String
    printSubSequence(smallerString, asf);
  }

  static String[] lettersArray = {
    ",:",
    "<;",
    "abc",
    "def",
    "ghi",
    "jkl",
    "mno",
    "pqrs",
    "tuv",
    "wxyz",
  };

  //Print all keypad combinations 2,3
  //abc,def==>ad,ae,af,bd,be,bf,cd,ce,cf

  public static void getKeypadCombinations(String str, String asf) {
    if (str.length() == 0) {
      System.out.println(asf);
      return;
    }

    String smallerString = str.substring(1);

    char firstChar = str.charAt(0);

    int letterIndex = firstChar - '0'; //

    String letters = lettersArray[letterIndex];

    for (int i = 0; i < letters.length(); i++) {
      char letter = letters.charAt(i);

      getKeypadCombinations(smallerString, letter + asf);
    }
  }

  //4
  public static void printStairsPath(int n, String asf) {
    if (n < 0) {
      return;
    }
    if (n == 0) {
      System.out.println(asf);
      return;
    }

    printStairsPath(n - 1, asf + "1");
    printStairsPath(n - 2, asf + "2");
    printStairsPath(n - 3, asf + "3");
  }

  //Print all maze paths if only right and down step allowed
  public static void printAllMazePath(
    int sr,
    int sc,
    int dr,
    int dc,
    String asf
  ) {
    if (sc > dc || sr > dr) {
      return;
    }

    if (sc == dc && sr == dr) {
      System.out.println(asf);
      return;
    }

    printAllMazePath(sr, sc + 1, dr, dc, asf + "h");
    printAllMazePath(sr + 1, sc, dr, dc, asf + "v");
  }

  //Print all maze paths if only right and down step with jumps allowed

  public static void printAllMazePathWithJumpsAllowed(
    int sr,
    int sc,
    int dr,
    int dc,
    String asf
  ) {
    if (sc > dc || sr > dr) {
      return;
    }

    if (sc == dc && sr == dr) {
      System.out.println(asf);
      return;
    }

    //horizonatal jumps
    for (int jump = 1; jump <= dc - sc; jump++) {
      printAllMazePathWithJumpsAllowed(sr, jump + sc, dr, dc, asf + "h" + jump);
    }

    //vertical jumps
    for (int jump = 1; jump <= dr - sr; jump++) {
      printAllMazePathWithJumpsAllowed(jump + sr, sc, dr, dc, asf + "v" + jump);
    }
  }

  public static void printAllMazePathWithDiagonalJumpsAllowed(
    int sr,
    int sc,
    int dr,
    int dc,
    String asf
  ) {
    if (sc > dc || sr > dr) {
      return;
    }

    if (sc == dc && sr == dr) {
      System.out.println(asf);
      return;
    }

    //horizonatal jumps
    for (int jump = 1; jump <= dc - sc; jump++) {
      printAllMazePathWithDiagonalJumpsAllowed(
        sr,
        jump + sc,
        dr,
        dc,
        asf + "h" + jump
      );
    }

    //vertical jumps
    for (int jump = 1; jump <= dr - sr; jump++) {
      printAllMazePathWithDiagonalJumpsAllowed(
        jump + sr,
        sc,
        dr,
        dc,
        asf + "v" + jump
      );
    }

    //diagonal jumps allowed
    for (int jump = 1; jump <= dr - sr; jump++) {
      printAllMazePathWithDiagonalJumpsAllowed(
        jump + sr,
        sc,
        dr,
        dc,
        asf + "d" + jump
      );
    }
  }

  public static void main(String[] args) {
    String str = "abc";
    // printSubSequence(str, "");

    //getKeypadCombinations("23", "");

    // printStairsPath(4, "");
    // printAllMazePath(0, 0, 2, 2, "");
    printAllMazePathWithJumpsAllowed(0, 0, 2, 2, "");
  }
}
