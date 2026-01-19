import java.util.Collections;
import java.util.PriorityQueue;

//Heap/PriorityQueue
public class Main {

  public static void main(String[] args) {
    // PriorityQueue<Integer> minPQ = new PriorityQueue<>();

    // minPQ.add(10);
    // minPQ.add(1);
    // System.out.println(minPQ.peek());

    // PriorityQueue<Integer> maxPQ = new PriorityQueue<>(
    //   Collections.reverseOrder()
    // );

    // maxPQ.add(50);
    // maxPQ.add(20);

    // System.out.println(maxPQ.poll());

    int len = Math.round(5);

    String name = "sdf";

    int hashCCo = name.hashCode();

    int index = Math.abs(hashCCo) % 5;

    System.out.println(index);
  }
}
