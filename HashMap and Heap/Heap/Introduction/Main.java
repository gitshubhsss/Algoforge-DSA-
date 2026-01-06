import java.util.*;

class Main {

  public static void main(String[] args) {
    ///minPq
    // PriorityQueue<Integer> minPQ = new PriorityQueue<Integer>();

    // minPQ.add(50);
    // minPQ.add(10);
    // minPQ.add(11);

    // System.out.println(minPQ.remove());
    // System.out.println(minPQ.remove());

    PriorityQueue<Integer> maxPQ = new PriorityQueue<Integer>();

    maxPQ.add(50);
    maxPQ.add(10);
    maxPQ.add(11);

    System.out.println(maxPQ.remove());
    System.out.println(maxPQ.remove());
  }
}
