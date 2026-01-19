public class Main {

  ///Recursion common problems

  //Print decreasing numbers from n to 1

  public static void printDec(int n) {
    if (n == 0) {
      return;
    }
    System.out.println(n);
    printDec(n - 1);
  }

  //Print increasing numbers from 1 to n
  public static void printInc(int n) {
    if (n == 0) {
      return;
    }
    printInc(n - 1);
    System.out.println(n);
  }

  //Print decreasing from n to 1, then 1 to n in one recursive function

  public static void printDecInc(int n) {
    if (n == 0) {
      return;
    }
    System.out.println(n);
    printDecInc(n - 1);
    if (n > 1) {
      System.out.println(n);
    }
  }

  //Finf factorial of a number

  public static int findFact(int n) {
    if (n == 0) {
      return 1;
    }

    int fact = findFact(n - 1) * n;
    return fact;
  }

  //n=2-->211121112
  //n=3--> 321112111232111211123
  public static void printZicZac(int n) {
    if (n == 0) {
      return;
    }
    System.out.print(n + " ");
    printZicZac(n - 1);
    System.out.print(n + " ");
    printZicZac(n - 1);
    System.out.print(n + " ");
  }

  public static void main(String args[]) {
    //System.out.println("Everything is fine !!");
    // printDec(10);
    //printInc(10);
    // printDecInc(3);
    //  System.out.println(findFact(5));

    printZicZac(2);
  }
}
