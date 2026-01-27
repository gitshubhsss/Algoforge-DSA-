import java.util.ArrayList;

class Main {

  //Print all subsequences of a string using ArrayList
  //abc
  public static ArrayList<String> getSubSequence(String str) {
    if (str.isEmpty()) {
      ArrayList<String> baseAns = new ArrayList<>();
      baseAns.add("");
      return baseAns;
    }

    char firstChar = str.charAt(0);

    String smallerString = str.substring(1);

    ArrayList<String> smallerAns = getSubSequence(smallerString); //bc,c,""

    ArrayList<String> myAns = new ArrayList<>();

    for (String s : smallerAns) {
      myAns.add(s);
    }

    for (String s : smallerAns) {
      myAns.add(firstChar + s);
    }

    return myAns;
  }

  public static ArrayList<String> getKeypadCombinations(String str) {
    if (str.length() == 0) {
      //create the base ans
      ArrayList<String> baseAns = new ArrayList<>();
      baseAns.add("");
      return baseAns;
    }

    String smallerString = str.substring(1);

    char firstChar = str.charAt(0);

    int letterIndex = firstChar - '0';
    System.out.println("letter index is " + letterIndex);

    String letters = lettersArray[letterIndex];

    ArrayList<String> smallerAns = getKeypadCombinations(smallerString);

    ArrayList<String> myAns = new ArrayList<String>();

    for (int i = 0; i < letters.length(); i++) {
      char letter = letters.charAt(i);
      for (String s : smallerAns) {
        myAns.add(letter + s);
      }
    }

    return myAns;
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

  public static ArrayList<String> getStairPaths(int n) {
    if (n < 0) {
      //return the empty ans
      ArrayList<String> baseAns = new ArrayList<String>();
      return baseAns;
    }

    if (n == 0) {
      ArrayList<String> baseAns = new ArrayList<String>();
      baseAns.add("");
      return baseAns;
    }

    ArrayList<String> pathpathsAfterOneStep = getStairPaths(n - 1);
    ArrayList<String> pathpathsAfterTwoStep = getStairPaths(n - 2);
    ArrayList<String> pathpathsAfterThreeStep = getStairPaths(n - 3);

    ArrayList<String> myAns = new ArrayList<>();

    //add 1 for path1
    for (String s : pathpathsAfterOneStep) {
      myAns.add(s + "1");
    }
    //add 2 for path1
    for (String s : pathpathsAfterTwoStep) {
      myAns.add(s + "2");
    }
    //add 3 for path1
    for (String s : pathpathsAfterThreeStep) {
      myAns.add(s + "3");
    }

    return myAns;
  }

  //Get all maze paths if only right and down step allowed
  public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
    //find the invalid indexes
    if (sr > dr || sc > dc) {
      return new ArrayList<>();
    }

    if (sc == dc && sr == dr) {
      //create a base ans and return it
      ArrayList<String> baseAns = new ArrayList<String>();
      baseAns.add("");
      return baseAns;
    }

    //horizontal path
    ArrayList<String> horizontalPath = getMazePaths(sr, sc + 1, dr, dc);
    //vertical path
    ArrayList<String> verticalPath = getMazePaths(sr + 1, sc, dr, dc);

    //create your own ans

    ArrayList<String> myAns = new ArrayList<>();

    for (String s : horizontalPath) {
      myAns.add(s + "h");
    }

    for (String s : verticalPath) {
      myAns.add(s + "v");
    }

    return myAns;
  }

  //Get all maze paths if only right and down step with jumps allowed
  public static ArrayList<String> getMazePathWithJumps(
    int sr,
    int sc,
    int dr,
    int dc
  ) {
    ///chekc the invalid indexx over here
    if (sc > dc || sr > dr) {
      return new ArrayList<>();
    }
    if (sc == dc && sr == dr) {
      ArrayList<String> baseAns = new ArrayList<String>();
      baseAns.add("");
      return baseAns;
    }

    ArrayList<String> ansPath = new ArrayList<>();

    //horizontal jumps
    for (int jump = 1; jump <= dc - sc; jump++) {
      ArrayList<String> horizontalPath = getMazePathWithJumps(
        sr,
        sc + jump,
        dr,
        dc
      );

      for (String s : horizontalPath) {
        ansPath.add(s + "h" + jump);
      }
    }

    for (int jump = 1; jump <= dr - sr; jump++) {
      ArrayList<String> verticalPath = getMazePathWithJumps(
        sr + jump,
        sc,
        dr,
        dc
      );

      for (String s : verticalPath) {
        ansPath.add(s + "v" + jump);
      }
    }

    return ansPath;
  }

  public static void main(String[] args) {
    // String str = "23";
    // System.out.println(getSubSequence(str));
    //System.out.println(getKeypadCombinations(str));
    // System.out.println(getStairPaths(4));
    // System.out.println(getMazePaths(0, 0, 2, 2));

    System.out.println(getMazePathWithJumps(0, 0, 2, 2));
  }
}
